package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.GeminiApiClient
import com.example.data.catalog.CourseCatalog
import com.example.data.db.*
import com.example.data.engine.CodeExecutionEngine
import com.example.data.engine.GamificationService
import com.example.model.*
import com.example.repository.AppRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID

enum class AppNavTab(val title: String, val iconTag: String) {
    HOME("Ana Sayfa", "home"),
    COURSES("Kurslar", "school"),
    ROADMAP("Öğren", "map"),
    PRACTICE("Pratik", "code"),
    PROFILE("Profil", "person")
}

data class QuizSessionState(
    val lesson: Lesson? = null,
    val questions: List<QuizQuestion> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isAnswerChecked: Boolean = false,
    val isAnswerCorrect: Boolean = false,
    val correctAnswersCount: Int = 0,
    val isQuizCompleted: Boolean = false,
    val xpEarned: Int = 0
)

data class ChallengeSessionState(
    val challenge: CodingChallenge? = null,
    val userCode: String = "",
    val isRunning: Boolean = false,
    val executionResult: ExecutionResult? = null,
    val currentHintIndex: Int = 0, // 0 = no hint, 1 = hint 1, 2 = hint 2, 3 = hint 3, 4 = solution shown
    val isCompleted: Boolean = false
)

class MainViewModel(private val repository: AppRepository) : ViewModel() {

    private val _currentTab = MutableStateFlow(AppNavTab.HOME)
    val currentTab: StateFlow<AppNavTab> = _currentTab.asStateFlow()

    private val _selectedLanguageId = MutableStateFlow("dart")
    val selectedLanguageId: StateFlow<String> = _selectedLanguageId.asStateFlow()

    private val _activeLesson = MutableStateFlow<Lesson?>(null)
    val activeLesson: StateFlow<Lesson?> = _activeLesson.asStateFlow()

    val userProfile: StateFlow<UserProfileData> = repository.userProfileDataFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, UserProfileData(isPremium = repository.isPremium()))

    val userStats: StateFlow<UserStatsEntity> = repository.userStatsFlow
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            UserStatsEntity(id = 1, currentActiveCourseId = "dart", isPremium = repository.isPremium())
        )

    val allProgress: StateFlow<List<UserProgressEntity>> = repository.getAllProgressFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allLanguagesProgress: StateFlow<Map<String, CourseProgressInfo>> = repository.getAllProgressFlow().map { progressList ->
        val progressByCourse = progressList.groupBy { it.courseId }
        CourseCatalog.languages.associate { lang ->
            val langProgress = progressByCourse[lang.id] ?: emptyList()
            val completedCount = langProgress.count { it.status == LessonStatus.COMPLETED.name }
            val lessons = CourseCatalog.getLessonsForCourse(lang.id)
            val total = lessons.size
            val pct = if (total > 0) (completedCount.toFloat() / total.toFloat()).coerceIn(0f, 1f) else 0f
            val completedIds = langProgress.filter { it.status == LessonStatus.COMPLETED.name }.map { it.lessonId }.toSet()
            val nextLesson = lessons.firstOrNull { !completedIds.contains(it.id) }
            val lastCompleted = lessons.lastOrNull { completedIds.contains(it.id) }
            lang.id to CourseProgressInfo(
                courseId = lang.id,
                completedLessonsCount = completedCount,
                totalLessonsCount = total,
                progressPercentage = pct,
                lastCompletedLessonTitle = lastCompleted?.title,
                nextLessonId = nextLesson?.id ?: lessons.firstOrNull()?.id
            )
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        CourseCatalog.languages.associate { lang ->
            val lessons = CourseCatalog.getLessonsForCourse(lang.id)
            lang.id to CourseProgressInfo(
                courseId = lang.id,
                completedLessonsCount = 0,
                totalLessonsCount = lessons.size,
                progressPercentage = 0f,
                lastCompletedLessonTitle = null,
                nextLessonId = lessons.firstOrNull()?.id
            )
        }
    )

    val activeCourseProgress: StateFlow<CourseProgressInfo> = _selectedLanguageId.flatMapLatest { langId ->
        repository.getCourseProgressFlow(langId)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        CourseProgressInfo(courseId = "dart", completedLessonsCount = 2, totalLessonsCount = 8, progressPercentage = 0.25f)
    )

    val allNotes: StateFlow<List<UserNoteEntity>> = repository.allNotesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allFavorites: StateFlow<List<FavoriteEntity>> = repository.allFavoritesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allMistakes: StateFlow<List<MistakeEntity>> = repository.allMistakesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val richAchievements: StateFlow<List<AppAchievement>> = repository.richAchievementsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), GamificationService.allAchievements)

    val weeklyStats: StateFlow<WeeklyStatsSummary> = repository.weeklyStatsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), WeeklyStatsSummary())

    // ----------------------------------------------------
    // Micro-Animation & Real-Time Event Notification State
    // ----------------------------------------------------
    private val _currentXpGain = MutableStateFlow<XpGainEvent?>(null)
    val currentXpGain: StateFlow<XpGainEvent?> = _currentXpGain.asStateFlow()

    private val _currentLevelUp = MutableStateFlow<LevelUpEvent?>(null)
    val currentLevelUp: StateFlow<LevelUpEvent?> = _currentLevelUp.asStateFlow()

    private val _unlockedAchievementBanner = MutableStateFlow<AppAchievement?>(null)
    val unlockedAchievementBanner: StateFlow<AppAchievement?> = _unlockedAchievementBanner.asStateFlow()

    init {
        viewModelScope.launch {
            repository.xpGainEvent.collect { event ->
                _currentXpGain.value = event
            }
        }
        viewModelScope.launch {
            repository.levelUpEvent.collect { event ->
                _currentLevelUp.value = event
            }
        }
        viewModelScope.launch {
            repository.achievementUnlockedEvent.collect { event ->
                _unlockedAchievementBanner.value = event
            }
        }
    }

    fun dismissXpGain() {
        _currentXpGain.value = null
    }

    fun dismissLevelUp() {
        _currentLevelUp.value = null
    }

    fun dismissAchievementBanner() {
        _unlockedAchievementBanner.value = null
    }

    // ----------------------------------------------------
    // Skill Tree & Course Journey Map
    // ----------------------------------------------------
    val skillTreeNodes: StateFlow<List<SkillNode>> = combine(
        _selectedLanguageId,
        allProgress
    ) { langId, progressList ->
        val completedIds = progressList.filter { it.courseId == langId && it.status == LessonStatus.COMPLETED.name }
            .map { it.lessonId }
            .toSet()
        GamificationService.buildSkillTree(langId, completedIds)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val courseJourneySteps: StateFlow<List<CourseJourneyStep>> = combine(
        _selectedLanguageId,
        allProgress
    ) { langId, progressList ->
        val completedIds = progressList.filter { it.courseId == langId && it.status == LessonStatus.COMPLETED.name }
            .map { it.lessonId }
            .toSet()
        GamificationService.buildCourseJourney(langId, completedIds)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedSkillNodeDetail = MutableStateFlow<SkillNode?>(null)
    val selectedSkillNodeDetail: StateFlow<SkillNode?> = _selectedSkillNodeDetail.asStateFlow()

    fun openSkillNodeDetail(node: SkillNode) {
        _selectedSkillNodeDetail.value = node
    }

    fun closeSkillNodeDetail() {
        _selectedSkillNodeDetail.value = null
    }

    // ----------------------------------------------------
    // Multi-factor Topic Mastery List
    // ----------------------------------------------------
    val courseTopicMasteryList: StateFlow<List<TopicMasteryInfo>> = combine(
        _selectedLanguageId,
        allProgress,
        allMistakes
    ) { langId, progressList, mistakes ->
        val lessons = CourseCatalog.getLessonsForCourse(langId)
        val progressMap = progressList.associateBy { it.lessonId }
        lessons.map { lesson ->
            GamificationService.computeTopicMastery(
                lesson = lesson,
                progress = progressMap[lesson.id],
                mistakes = mistakes
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // ----------------------------------------------------
    // Daily Challenge
    // ----------------------------------------------------
    private val _dailyChallengeState = MutableStateFlow(
        GamificationService.getDailyChallenge("dart", isCompleted = repository.isDailyChallengeCompletedToday())
    )
    val dailyChallengeState: StateFlow<DailyChallengeItem> = _dailyChallengeState.asStateFlow()

    private val _showDailyChallengeDialog = MutableStateFlow(false)
    val showDailyChallengeDialog: StateFlow<Boolean> = _showDailyChallengeDialog.asStateFlow()

    fun openDailyChallenge() {
        _dailyChallengeState.value = GamificationService.getDailyChallenge(
            _selectedLanguageId.value,
            isCompleted = repository.isDailyChallengeCompletedToday()
        )
        _showDailyChallengeDialog.value = true
    }

    fun closeDailyChallenge() {
        _showDailyChallengeDialog.value = false
    }

    fun solveDailyChallenge(optionIndex: Int) {
        val current = _dailyChallengeState.value
        if (optionIndex == current.correctOptionIndex && !current.isCompletedToday) {
            viewModelScope.launch {
                repository.completeDailyChallenge(current)
                _dailyChallengeState.value = current.copy(isCompletedToday = true)
            }
        }
    }

    // ----------------------------------------------------
    // Smart Review Recommendations
    // ----------------------------------------------------
    val smartReviewRecommendations: StateFlow<List<SmartReviewRecommendation>> = combine(
        _selectedLanguageId,
        allMistakes,
        allProgress
    ) { langId, mistakes, progressList ->
        GamificationService.getSmartReviewRecommendations(langId, mistakes, progressList)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // ----------------------------------------------------
    // Theme Mode & Editor Settings
    // ----------------------------------------------------
    private val _themeMode = MutableStateFlow(com.example.ui.theme.AppThemeMode.FLUTTER_DART_DARK)
    val themeMode: StateFlow<com.example.ui.theme.AppThemeMode> = _themeMode.asStateFlow()

    val isDarkTheme: StateFlow<Boolean> = _themeMode.map { it.isDark }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    private val _editorTheme = MutableStateFlow(com.example.ui.theme.EditorTheme.FLUTTER_STUDIO)
    val editorTheme: StateFlow<com.example.ui.theme.EditorTheme> = _editorTheme.asStateFlow()

    private val _editorFontSize = MutableStateFlow(13)
    val editorFontSize: StateFlow<Int> = _editorFontSize.asStateFlow()

    fun setThemeMode(mode: com.example.ui.theme.AppThemeMode) {
        _themeMode.value = mode
    }

    fun toggleTheme() {
        _themeMode.value = if (_themeMode.value.isDark) {
            com.example.ui.theme.AppThemeMode.LIGHT
        } else {
            com.example.ui.theme.AppThemeMode.OBSIDIAN_DARK
        }
    }

    fun toggleEyeCareMode() {
        _themeMode.value = if (_themeMode.value == com.example.ui.theme.AppThemeMode.WARM_AMBER_EYE_CARE) {
            com.example.ui.theme.AppThemeMode.OBSIDIAN_DARK
        } else {
            com.example.ui.theme.AppThemeMode.WARM_AMBER_EYE_CARE
        }
    }

    fun setDarkTheme(isDark: Boolean) {
        _themeMode.value = if (isDark) com.example.ui.theme.AppThemeMode.OBSIDIAN_DARK else com.example.ui.theme.AppThemeMode.LIGHT
    }

    fun setEditorTheme(theme: com.example.ui.theme.EditorTheme) {
        _editorTheme.value = theme
    }

    fun setEditorFontSize(sizeSp: Int) {
        _editorFontSize.value = sizeSp.coerceIn(10, 20)
    }

    // Search Query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val searchResults: StateFlow<List<Lesson>> = _searchQuery.map { q ->
        CourseCatalog.searchLessons(q)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // UI Dialogs
    val appLanguage: StateFlow<AppLanguage> = repository.appLanguageFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), repository.getAppLanguage())

    private val _showInitialLanguageDialog = MutableStateFlow(!repository.hasCompletedInitialLanguageSelection())
    val showInitialLanguageDialog: StateFlow<Boolean> = _showInitialLanguageDialog.asStateFlow()

    private val _showPremiumDialog = MutableStateFlow(false)
    val showPremiumDialog: StateFlow<Boolean> = _showPremiumDialog.asStateFlow()

    private val _showCertificateModal = MutableStateFlow<ProgrammingLanguage?>(null)
    val showCertificateModal: StateFlow<ProgrammingLanguage?> = _showCertificateModal.asStateFlow()

    private val _showNoteDialog = MutableStateFlow<Lesson?>(null)
    val showNoteDialog: StateFlow<Lesson?> = _showNoteDialog.asStateFlow()

    fun setAppLanguage(language: AppLanguage) {
        repository.setAppLanguage(language)
    }

    fun completeInitialLanguageSelection(language: AppLanguage) {
        repository.setAppLanguage(language)
        repository.setCompletedInitialLanguageSelection(true)
        _showInitialLanguageDialog.value = false
    }

    fun openInitialLanguageDialog() {
        _showInitialLanguageDialog.value = true
    }

    fun closeInitialLanguageDialog() {
        _showInitialLanguageDialog.value = false
    }

    // Quiz Session
    private val _quizState = MutableStateFlow(QuizSessionState())
    val quizState: StateFlow<QuizSessionState> = _quizState.asStateFlow()

    // Challenge & Sandbox Session
    private val _challengeState = MutableStateFlow(ChallengeSessionState())
    val challengeState: StateFlow<ChallengeSessionState> = _challengeState.asStateFlow()

    private val _playgroundCode = MutableStateFlow("")
    val playgroundCode: StateFlow<String> = _playgroundCode.asStateFlow()

    private val _playgroundResult = MutableStateFlow<ExecutionResult?>(null)
    val playgroundResult: StateFlow<ExecutionResult?> = _playgroundResult.asStateFlow()

    private val _isPlaygroundRunning = MutableStateFlow(false)
    val isPlaygroundRunning: StateFlow<Boolean> = _isPlaygroundRunning.asStateFlow()

    fun setTab(tab: AppNavTab) {
        _currentTab.value = tab
    }

    fun selectLanguage(langId: String) {
        _selectedLanguageId.value = langId
        viewModelScope.launch {
            repository.setActiveCourse(langId)
        }
    }

    fun setSearchQuery(q: String) {
        _searchQuery.value = q
    }

    // ----------------------------------------------------
    // Lesson Navigation & Freemium Gate
    // ----------------------------------------------------
    private var pendingLessonToOpen: Lesson? = null

    fun openLesson(lesson: Lesson): Boolean {
        val isUserPremium = repository.isPremium() || userStats.value.isPremium || userProfile.value.isPremium
        if (lesson.isPremium && !isUserPremium) {
            pendingLessonToOpen = lesson
            _showPremiumDialog.value = true
            return false
        }
        pendingLessonToOpen = null
        _activeLesson.value = lesson
        _playgroundCode.value = lesson.starterPlaygroundCode
        _playgroundResult.value = null
        return true
    }

    fun closeActiveLesson() {
        _activeLesson.value = null
    }

    fun markLessonComplete(lesson: Lesson) {
        viewModelScope.launch {
            repository.completeLesson(lesson.id, lesson.courseId)
        }
    }

    // ----------------------------------------------------
    // Quiz Operations
    // ----------------------------------------------------
    fun startQuiz(lesson: Lesson) {
        val questions = lesson.quizQuestions.ifEmpty {
            listOf(
                QuizQuestion(
                    id = "${lesson.id}_q_auto",
                    lessonId = lesson.id,
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "${lesson.title} konusunda öğrendiğiniz temel prensip hangisidir?",
                    options = listOf(
                        "Kodun hatasız ve amaca uygun çalışması",
                        "Sadece print kullanılması",
                        "Hiç değişken tanımlanmaması",
                        "Tüm kodların rastgele yazılması"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Temel amaç doğru sözdizimi ve hatasız algoritma kurmaktır.",
                    explanationWrong = "Programlama yapılarının amacı doğru ve sürdürülebilir mantık kurmaktır.",
                    reviewTopic = lesson.title
                )
            )
        }

        _quizState.value = QuizSessionState(
            lesson = lesson,
            questions = questions,
            currentIndex = 0,
            selectedOptionIndex = null,
            isAnswerChecked = false,
            isAnswerCorrect = false,
            correctAnswersCount = 0,
            isQuizCompleted = false,
            xpEarned = 0
        )
    }

    fun selectQuizOption(index: Int) {
        if (!_quizState.value.isAnswerChecked) {
            _quizState.value = _quizState.value.copy(selectedOptionIndex = index)
        }
    }

    fun checkQuizAnswer() {
        val state = _quizState.value
        val currentQ = state.questions.getOrNull(state.currentIndex) ?: return
        val userIdx = state.selectedOptionIndex ?: return

        val isCorrect = userIdx == currentQ.correctOptionIndex
        val newCorrectCount = if (isCorrect) state.correctAnswersCount + 1 else state.correctAnswersCount

        _quizState.value = state.copy(
            isAnswerChecked = true,
            isAnswerCorrect = isCorrect,
            correctAnswersCount = newCorrectCount
        )

        // Save mistake record if wrong
        if (!isCorrect) {
            viewModelScope.launch {
                val wrongAnswerText = currentQ.options.getOrNull(userIdx) ?: "Bilinmeyen"
                val correctAnswerText = currentQ.options.getOrNull(currentQ.correctOptionIndex) ?: ""
                repository.recordMistake(
                    questionId = currentQ.id,
                    lessonId = currentQ.lessonId,
                    courseId = state.lesson?.courseId ?: "dart",
                    topicName = currentQ.reviewTopic,
                    questionText = currentQ.questionText,
                    wrongChoice = wrongAnswerText,
                    correctChoice = correctAnswerText,
                    explanation = currentQ.explanationWrong
                )
            }
        }
    }

    fun nextQuizQuestion() {
        val state = _quizState.value
        val nextIdx = state.currentIndex + 1

        if (nextIdx < state.questions.size) {
            _quizState.value = state.copy(
                currentIndex = nextIdx,
                selectedOptionIndex = null,
                isAnswerChecked = false,
                isAnswerCorrect = false
            )
        } else {
            // Quiz finished
            val earnedXp = if (state.correctAnswersCount == state.questions.size) 50 else 30
            _quizState.value = state.copy(
                isQuizCompleted = true,
                xpEarned = earnedXp
            )
            viewModelScope.launch {
                state.lesson?.let { l ->
                    repository.recordQuizFinished(l.id, state.correctAnswersCount, state.questions.size)
                }
            }
        }
    }

    fun closeQuiz() {
        _quizState.value = QuizSessionState()
    }

    // ----------------------------------------------------
    // Coding Challenge & Sandbox
    // ----------------------------------------------------
    fun startChallenge(challenge: CodingChallenge) {
        _challengeState.value = ChallengeSessionState(
            challenge = challenge,
            userCode = challenge.starterCode,
            isRunning = false,
            executionResult = null,
            currentHintIndex = 0,
            isCompleted = false
        )
    }

    fun updateChallengeCode(newCode: String) {
        _challengeState.value = _challengeState.value.copy(userCode = newCode)
    }

    fun revealNextHint() {
        val current = _challengeState.value.currentHintIndex
        if (current < 4) {
            _challengeState.value = _challengeState.value.copy(currentHintIndex = current + 1)
        }
    }

    fun showSolution() {
        val challenge = _challengeState.value.challenge ?: return
        _challengeState.value = _challengeState.value.copy(
            userCode = challenge.solutionCode,
            currentHintIndex = 4
        )
    }

    fun testChallenge() {
        val state = _challengeState.value
        val challenge = state.challenge ?: return

        viewModelScope.launch {
            _challengeState.value = state.copy(isRunning = true)
            val result = CodeExecutionEngine.testCodingChallenge(
                state.userCode,
                challenge,
                _selectedLanguageId.value
            )
            _challengeState.value = _challengeState.value.copy(
                isRunning = false,
                executionResult = result,
                isCompleted = result.isSuccess
            )

            if (result.isSuccess) {
                repository.recordCodingChallengeFinished(challenge.lessonId, _selectedLanguageId.value)
            }
        }
    }

    fun closeChallenge() {
        _challengeState.value = ChallengeSessionState()
    }

    suspend fun verifyAndSubmitPracticalTask(
        lessonId: String,
        courseId: String,
        lessonTitle: String,
        taskDescription: String,
        userCode: String
    ): ExecutionResult {
        val result = CodeExecutionEngine.verifyPracticalTask(
            code = userCode,
            taskDescription = taskDescription,
            lessonTitle = lessonTitle,
            languageId = courseId
        )
        if (result.isSuccess) {
            repository.recordCodingChallengeFinished(lessonId, courseId)
        }
        return result
    }

    // Playground
    fun updatePlaygroundCode(code: String) {
        _playgroundCode.value = code
    }

    fun runPlaygroundCode(langId: String) {
        viewModelScope.launch {
            _isPlaygroundRunning.value = true
            val res = CodeExecutionEngine.executePlaygroundCode(_playgroundCode.value, langId)
            _playgroundResult.value = res
            _isPlaygroundRunning.value = false
        }
    }

    // ----------------------------------------------------
    // Premium Upgrade Actions
    // ----------------------------------------------------
    fun openPremiumDialog() {
        _showPremiumDialog.value = true
    }

    fun closePremiumDialog() {
        _showPremiumDialog.value = false
    }

    fun activatePremiumPlan() {
        viewModelScope.launch {
            repository.setPremium(true)
            _showPremiumDialog.value = false
            pendingLessonToOpen?.let { lesson ->
                _activeLesson.value = lesson
                _playgroundCode.value = lesson.starterPlaygroundCode
                _playgroundResult.value = null
                pendingLessonToOpen = null
            }
        }
    }

    fun cancelPremium() {
        viewModelScope.launch {
            repository.setPremium(false)
        }
    }

    fun setPremiumDevMode(enabled: Boolean) {
        viewModelScope.launch {
            repository.setPremium(enabled)
            _showPremiumDialog.value = false
            if (enabled) {
                pendingLessonToOpen?.let { lesson ->
                    _activeLesson.value = lesson
                    _playgroundCode.value = lesson.starterPlaygroundCode
                    _playgroundResult.value = null
                    pendingLessonToOpen = null
                }
            }
        }
    }

    fun togglePremiumDevMode() {
        viewModelScope.launch {
            val current = repository.isPremium() || userStats.value.isPremium || userProfile.value.isPremium
            setPremiumDevMode(!current)
        }
    }

    // ----------------------------------------------------
    // Notes & Favorites
    // ----------------------------------------------------
    fun openNoteDialog(lesson: Lesson) {
        _showNoteDialog.value = lesson
    }

    fun closeNoteDialog() {
        _showNoteDialog.value = null
    }

    fun saveLessonNote(lesson: Lesson, content: String) {
        viewModelScope.launch {
            repository.saveNote(lesson.id, lesson.title, lesson.courseId, content)
            _showNoteDialog.value = null
        }
    }

    fun toggleFavorite(id: String, type: String, courseId: String, title: String, subtitle: String, currentFav: Boolean) {
        viewModelScope.launch {
            repository.toggleFavorite(id, type, courseId, title, subtitle, currentFav)
        }
    }

    fun openCertificate(lang: ProgrammingLanguage) {
        _showCertificateModal.value = lang
    }

    fun closeCertificate() {
        _showCertificateModal.value = null
    }

    // ----------------------------------------------------
    // AI Assistant (Gemini & Pedagogical Shortcuts)
    // ----------------------------------------------------
    private val _aiAssistantState = MutableStateFlow(AiAssistantState())
    val aiAssistantState: StateFlow<AiAssistantState> = _aiAssistantState.asStateFlow()

    fun openAiAssistant(
        lesson: Lesson? = null,
        initialShortcut: AiShortcut? = null,
        targetSentence: String? = null
    ) {
        val currentLangId = lesson?.courseId ?: _selectedLanguageId.value
        val lang = CourseCatalog.languages.firstOrNull { it.id == currentLangId } ?: CourseCatalog.languages.first()

        val context = AiAssistantContext(
            languageId = lang.id,
            languageName = lang.name,
            lessonId = lesson?.id,
            lessonTitle = lesson?.title,
            lessonContentSnippet = lesson?.shortDesc ?: lesson?.detailedExplanation?.firstOrNull()?.body,
            lessonCodeSnippet = lesson?.codeExample
        )

        _aiAssistantState.value = _aiAssistantState.value.copy(
            isOpen = true,
            context = context,
            selectedShortcut = initialShortcut,
            confusingSentenceInput = targetSentence ?: "",
            errorMessage = null
        )

        if (initialShortcut != null && !targetSentence.isNullOrBlank()) {
            sendAiMessage(targetSentence, initialShortcut)
        } else if (initialShortcut != null && initialShortcut != AiShortcut.EXPLAIN_SENTENCE) {
            val topicName = lesson?.title ?: lang.name
            sendAiMessage("${initialShortcut.title}: $topicName konusunu açıkla.", initialShortcut)
        }
    }

    fun closeAiAssistant() {
        _aiAssistantState.value = _aiAssistantState.value.copy(isOpen = false)
    }

    fun selectAiShortcut(shortcut: AiShortcut) {
        _aiAssistantState.value = _aiAssistantState.value.copy(selectedShortcut = shortcut)
    }

    fun sendAiMessage(prompt: String, shortcut: AiShortcut? = null) {
        val cleanPrompt = prompt.trim()
        if (cleanPrompt.isEmpty()) return

        val userMessage = AiChatMessage(
            id = UUID.randomUUID().toString(),
            sender = AiMessageSender.USER,
            text = cleanPrompt,
            shortcutUsed = shortcut,
            relatedLessonId = _aiAssistantState.value.context.lessonId,
            relatedLanguageId = _aiAssistantState.value.context.languageId
        )

        val updatedMessages = _aiAssistantState.value.messages + userMessage
        _aiAssistantState.value = _aiAssistantState.value.copy(
            messages = updatedMessages,
            isLoading = true,
            selectedShortcut = shortcut
        )

        viewModelScope.launch {
            val responseText = GeminiApiClient.askTutor(
                userPrompt = cleanPrompt,
                shortcut = shortcut ?: _aiAssistantState.value.selectedShortcut,
                context = _aiAssistantState.value.context
            )

            val assistantMessage = AiChatMessage(
                id = UUID.randomUUID().toString(),
                sender = AiMessageSender.ASSISTANT,
                text = responseText,
                shortcutUsed = shortcut ?: _aiAssistantState.value.selectedShortcut,
                relatedLessonId = _aiAssistantState.value.context.lessonId,
                relatedLanguageId = _aiAssistantState.value.context.languageId
            )

            _aiAssistantState.value = _aiAssistantState.value.copy(
                messages = _aiAssistantState.value.messages + assistantMessage,
                isLoading = false
            )
        }
    }

    fun clearAiChat() {
        _aiAssistantState.value = _aiAssistantState.value.copy(
            messages = emptyList(),
            selectedShortcut = null,
            confusingSentenceInput = ""
        )
    }
}
