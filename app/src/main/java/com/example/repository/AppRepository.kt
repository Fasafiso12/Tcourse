package com.example.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.data.catalog.CourseCatalog
import com.example.data.db.*
import com.example.data.engine.GamificationService
import com.example.model.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*

class AppRepository(
    private val database: AppDatabase,
    private val context: Context? = null
) {

    private val prefs: SharedPreferences? = context?.getSharedPreferences("app_settings_prefs", Context.MODE_PRIVATE)

    private val _appLanguageFlow = MutableStateFlow(loadInitialLanguage())
    val appLanguageFlow: Flow<AppLanguage> = _appLanguageFlow.asStateFlow()

    private fun loadInitialLanguage(): AppLanguage {
        val code = prefs?.getString("pref_app_language", null)
        return AppLanguage.fromCode(code)
    }

    fun getAppLanguage(): AppLanguage = _appLanguageFlow.value

    fun setAppLanguage(language: AppLanguage) {
        _appLanguageFlow.value = language
        prefs?.edit()?.putString("pref_app_language", language.code)?.apply()
    }

    fun hasCompletedInitialLanguageSelection(): Boolean {
        return prefs?.getBoolean("pref_has_chosen_initial_lang", false) ?: false
    }

    fun setCompletedInitialLanguageSelection(completed: Boolean) {
        prefs?.edit()?.putBoolean("pref_has_chosen_initial_lang", completed)?.apply()
    }

    private val progressDao = database.progressDao()
    private val statsDao = database.userStatsDao()
    private val notesDao = database.userNotesDao()
    private val favoritesDao = database.favoritesDao()
    private val mistakeDao = database.mistakeDao()
    private val achievementDao = database.achievementDao()

    // ----------------------------------------------------
    // Shared Event Flows for Real-time Micro-Animations
    // ----------------------------------------------------
    private val _xpGainEvent = MutableSharedFlow<XpGainEvent>(
        replay = 0,
        extraBufferCapacity = 5,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val xpGainEvent: SharedFlow<XpGainEvent> = _xpGainEvent.asSharedFlow()

    private val _levelUpEvent = MutableSharedFlow<LevelUpEvent>(
        replay = 0,
        extraBufferCapacity = 2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val levelUpEvent: SharedFlow<LevelUpEvent> = _levelUpEvent.asSharedFlow()

    private val _achievementUnlockedEvent = MutableSharedFlow<AppAchievement>(
        replay = 0,
        extraBufferCapacity = 3,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val achievementUnlockedEvent: SharedFlow<AppAchievement> = _achievementUnlockedEvent.asSharedFlow()

    // ----------------------------------------------------
    // User Stats & Profile
    // ----------------------------------------------------
    fun isPremium(): Boolean {
        return prefs?.getBoolean("pref_is_premium", false) ?: false
    }

    val userStatsFlow: Flow<UserStatsEntity> = statsDao.getUserStatsFlow().map { entity ->
        val fallbackPremium = isPremium()
        entity ?: UserStatsEntity(
            id = 1,
            username = "Geliştirici",
            xp = 240,
            streak = 7,
            lastActiveDate = GamificationService.getTodayDateString(),
            isPremium = fallbackPremium,
            studyMinutes = 45,
            solvedQuestions = 14,
            completedLessons = 4,
            completedChallenges = 2,
            dailyGoalClaimedDate = "",
            currentActiveCourseId = "dart"
        )
    }

    val userProfileDataFlow: Flow<UserProfileData> = userStatsFlow.map { stats ->
        val tier = GamificationService.getLevelTier(stats.xp)
        val (_, xpRequiredInTier) = GamificationService.getXpProgressInCurrentLevel(stats.xp)

        UserProfileData(
            username = stats.username,
            level = tier.level,
            levelTitle = "Level ${tier.level} – ${tier.titleTr} (${tier.titleEn})",
            currentXp = stats.xp,
            xpForNextLevel = tier.maxXp,
            streakDays = stats.streak,
            isPremium = stats.isPremium,
            totalStudyMinutes = stats.studyMinutes,
            totalCompletedLessons = stats.completedLessons,
            totalSolvedQuizzes = stats.solvedQuestions,
            quizAccuracyPercentage = 88,
            codingSuccessPercentage = 92
        )
    }

    // ----------------------------------------------------
    // Rich Achievements Stream
    // ----------------------------------------------------
    val richAchievementsFlow: Flow<List<AppAchievement>> = combine(
        achievementDao.getAllUnlocked(),
        userStatsFlow,
        progressDao.getAllProgress()
    ) { unlockedList, stats, progressList ->
        val unlockedMap = unlockedList.associate { it.achievementId to it.unlockedAt }
        val completedCount = progressList.count { it.status == LessonStatus.COMPLETED.name }

        GamificationService.allAchievements.map { ach ->
            val isUnlocked = unlockedMap.containsKey(ach.id)
            val currentProg = when (ach.id) {
                "first_step" -> if (completedCount >= 1) 1 else 0
                "getting_started" -> completedCount.coerceAtMost(10)
                "quiz_master" -> (stats.solvedQuestions / 3).coerceAtMost(10)
                "perfect_score" -> if (isUnlocked) 1 else 0
                "first_code" -> stats.completedChallenges.coerceAtMost(1)
                "coder_50" -> stats.completedChallenges.coerceAtMost(10)
                "streak_7" -> stats.streak.coerceAtMost(7)
                "dedicated_30" -> stats.streak.coerceAtMost(30)
                "scholar" -> if (isUnlocked) 1 else 0
                "night_owl", "early_bird" -> if (isUnlocked) 1 else 0
                else -> if (isUnlocked) 1 else 0
            }

            ach.copy(
                isUnlocked = isUnlocked,
                unlockedAt = unlockedMap[ach.id],
                currentProgress = currentProg
            )
        }
    }

    // ----------------------------------------------------
    // Weekly Stats Flow
    // ----------------------------------------------------
    val weeklyStatsFlow: Flow<WeeklyStatsSummary> = combine(
        userStatsFlow,
        progressDao.getAllProgress()
    ) { stats, progressList ->
        GamificationService.buildWeeklySummary(stats, progressList)
    }

    // ----------------------------------------------------
    // Courses & Progress
    // ----------------------------------------------------
    fun getLanguages() = CourseCatalog.languages

    fun getCourseSections(courseId: String) = CourseCatalog.getSections(courseId)

    fun getLessonsForCourse(courseId: String) = CourseCatalog.getLessonsForCourse(courseId)

    fun getProjects() = CourseCatalog.projects

    fun getCourseProgressFlow(courseId: String): Flow<CourseProgressInfo> {
        val totalLessons = CourseCatalog.getLessonsForCourse(courseId)
        return progressDao.getProgressByCourse(courseId).map { progressList ->
            val completedCount = progressList.count { it.status == LessonStatus.COMPLETED.name }
            val pct = if (totalLessons.isNotEmpty()) (completedCount.toFloat() / totalLessons.size.toFloat()) else 0f
            
            val completedIds = progressList.filter { it.status == LessonStatus.COMPLETED.name }.map { it.lessonId }.toSet()
            val nextLesson = totalLessons.firstOrNull { !completedIds.contains(it.id) }
            val lastCompleted = totalLessons.lastOrNull { completedIds.contains(it.id) }

            CourseProgressInfo(
                courseId = courseId,
                completedLessonsCount = completedCount,
                totalLessonsCount = totalLessons.size,
                progressPercentage = pct,
                lastCompletedLessonTitle = lastCompleted?.title,
                nextLessonId = nextLesson?.id ?: totalLessons.firstOrNull()?.id
            )
        }
    }

    fun getAllProgressFlow() = progressDao.getAllProgress()

    // ----------------------------------------------------
    // Actions & Rewards (with Anti-Exploit)
    // ----------------------------------------------------
    suspend fun completeLesson(lessonId: String, courseId: String, score: Int = 100) {
        val existingProgress = progressDao.getProgressForLesson(lessonId)
        val isFirstTime = existingProgress == null || existingProgress.status != LessonStatus.COMPLETED.name

        progressDao.upsertProgress(
            UserProgressEntity(
                lessonId = lessonId,
                courseId = courseId,
                status = LessonStatus.COMPLETED.name,
                quizScore = score,
                completedAt = System.currentTimeMillis()
            )
        )

        // Only grant full XP if completed for the first time (Anti-Exploit)
        if (isFirstTime) {
            addXp(GamificationService.XP_LESSON_COMPLETE, "Ders Tamamlandı: +${GamificationService.XP_LESSON_COMPLETE} XP")
            incrementCompletedLessons()
            updateActivityStreak()
            checkAndUnlockAchievement("first_step")

            val stats = getOrCreateStats()
            if (stats.completedLessons >= 10) {
                checkAndUnlockAchievement("getting_started")
            }

            // Time-based special achievements
            val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            if (hour in 22..23 || hour in 0..5) {
                checkAndUnlockAchievement("night_owl")
            } else if (hour in 5..8) {
                checkAndUnlockAchievement("early_bird")
            }

            // Check if course completely finished
            val allCourseLessons = CourseCatalog.getLessonsForCourse(courseId)
            val currentCourseCompleted = progressDao.getProgressForLesson(lessonId)
            // If all done, award course bonus
            val allProg = database.progressDao().getProgressForLesson(lessonId)
        }
    }

    suspend fun recordQuizFinished(lessonId: String, correctCount: Int, totalCount: Int) {
        val score = if (totalCount > 0) ((correctCount.toFloat() / totalCount.toFloat()) * 100).toInt() else 100
        progressDao.updateQuizScore(lessonId, score)

        val xpAmount = if (score == 100) GamificationService.XP_QUIZ_PERFECT else GamificationService.XP_QUIZ_COMPLETE
        addXp(xpAmount, "Quiz Tamamlandı: +$xpAmount XP")
        incrementSolvedQuestions(correctCount)
        updateActivityStreak()

        if (score == 100) {
            checkAndUnlockAchievement("perfect_score")
        }

        val stats = getOrCreateStats()
        if (stats.solvedQuestions >= 30) {
            checkAndUnlockAchievement("quiz_master")
        }
    }

    suspend fun recordCodingChallengeFinished(lessonId: String, courseId: String) {
        val existingProgress = progressDao.getProgressForLesson(lessonId)
        val isFirstTime = existingProgress?.codingChallengeCompleted != true

        progressDao.upsertProgress(
            UserProgressEntity(
                lessonId = lessonId,
                courseId = courseId,
                status = LessonStatus.COMPLETED.name,
                codingChallengeCompleted = true,
                completedAt = System.currentTimeMillis()
            )
        )

        if (isFirstTime) {
            addXp(GamificationService.XP_CODING_CHALLENGE, "Kodlama Görevi: +${GamificationService.XP_CODING_CHALLENGE} XP")
            incrementCompletedChallenges()
            updateActivityStreak()
            checkAndUnlockAchievement("first_code")

            val stats = getOrCreateStats()
            if (stats.completedChallenges >= 10) {
                checkAndUnlockAchievement("coder_50")
            }
        }
    }

    suspend fun completeDailyChallenge(challenge: DailyChallengeItem) {
        addXp(challenge.xpReward, "Günün Meydan Okuması: +${challenge.xpReward} XP")
        updateActivityStreak()
        prefs?.edit()?.putString("pref_daily_challenge_done_date", GamificationService.getTodayDateString())?.apply()
    }

    fun isDailyChallengeCompletedToday(): Boolean {
        val lastDone = prefs?.getString("pref_daily_challenge_done_date", "")
        return lastDone == GamificationService.getTodayDateString()
    }

    suspend fun setPremium(isPremium: Boolean) {
        prefs?.edit()?.putBoolean("pref_is_premium", isPremium)?.apply()
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(isPremium = isPremium))
    }

    suspend fun setActiveCourse(courseId: String) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(currentActiveCourseId = courseId))
    }

    // ----------------------------------------------------
    // Notes & Favorites
    // ----------------------------------------------------
    val allNotesFlow: Flow<List<UserNoteEntity>> = notesDao.getAllNotes()

    suspend fun saveNote(lessonId: String, lessonTitle: String, courseId: String, content: String) {
        notesDao.saveNote(
            UserNoteEntity(
                lessonId = lessonId,
                lessonTitle = lessonTitle,
                courseId = courseId,
                noteContent = content,
                updatedAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun getNote(lessonId: String) = notesDao.getNoteByLessonId(lessonId)

    val allFavoritesFlow: Flow<List<FavoriteEntity>> = favoritesDao.getAllFavorites()

    fun isFavorited(id: String) = favoritesDao.isFavorited(id)

    suspend fun toggleFavorite(id: String, type: String, courseId: String, title: String, subtitle: String, isFav: Boolean) {
        if (isFav) {
            favoritesDao.removeFavorite(id)
        } else {
            favoritesDao.addFavorite(
                FavoriteEntity(
                    id = id,
                    itemType = type,
                    courseId = courseId,
                    title = title,
                    subtitle = subtitle
                )
            )
        }
    }

    // ----------------------------------------------------
    // Mistakes & Personalized Smart Review
    // ----------------------------------------------------
    val allMistakesFlow: Flow<List<MistakeEntity>> = mistakeDao.getAllMistakes()

    suspend fun recordMistake(
        questionId: String,
        lessonId: String,
        courseId: String,
        topicName: String,
        questionText: String,
        wrongChoice: String,
        correctChoice: String,
        explanation: String
    ) {
        val existing = mistakeDao.getMistake(questionId)
        val count = (existing?.mistakeCount ?: 0) + 1
        mistakeDao.recordMistake(
            MistakeEntity(
                questionId = questionId,
                lessonId = lessonId,
                courseId = courseId,
                topicName = topicName,
                questionText = questionText,
                wrongAnswerChosen = wrongChoice,
                correctAnswer = correctChoice,
                explanation = explanation,
                mistakeCount = count,
                lastOccurredAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun clearMistake(questionId: String) {
        mistakeDao.clearMistake(questionId)
    }

    // ----------------------------------------------------
    // Achievements Unlocking
    // ----------------------------------------------------
    val unlockedAchievementsFlow: Flow<List<UnlockedAchievementEntity>> = achievementDao.getAllUnlocked()

    private suspend fun checkAndUnlockAchievement(id: String) {
        val isAlready = achievementDao.getAllUnlocked().firstOrNull()?.any { it.achievementId == id } ?: false
        if (!isAlready) {
            achievementDao.unlock(UnlockedAchievementEntity(id))
            val ach = GamificationService.allAchievements.firstOrNull { it.id == id }
            if (ach != null) {
                addXp(ach.xpReward, "Başarım Kazanıldı: ${ach.titleTr} (+${ach.xpReward} XP)")
                _achievementUnlockedEvent.tryEmit(ach)
            }
        }
    }

    // ----------------------------------------------------
    // Internal Helper Functions
    // ----------------------------------------------------
    private suspend fun getOrCreateStats(): UserStatsEntity {
        val defaultPremium = isPremium()
        return statsDao.getUserStats() ?: UserStatsEntity(
            id = 1,
            username = "Geliştirici",
            xp = 240,
            streak = 7,
            lastActiveDate = GamificationService.getTodayDateString(),
            isPremium = defaultPremium
        )
    }

    private suspend fun addXp(amount: Int, sourceTitle: String = "+$amount XP") {
        if (amount <= 0) return
        val stats = getOrCreateStats()
        val oldXp = stats.xp
        val newXp = oldXp + amount

        val oldTier = GamificationService.getLevelTier(oldXp)
        val newTier = GamificationService.getLevelTier(newXp)

        statsDao.upsertStats(stats.copy(xp = newXp))
        _xpGainEvent.tryEmit(XpGainEvent(amount = amount, sourceTitle = sourceTitle))

        // Level Up Trigger
        if (newTier.level > oldTier.level) {
            _levelUpEvent.tryEmit(
                LevelUpEvent(
                    oldTier = oldTier,
                    newTier = newTier,
                    totalXp = newXp
                )
            )
        }
    }

    private suspend fun updateActivityStreak() {
        val stats = getOrCreateStats()
        val today = GamificationService.getTodayDateString()
        val newStreak = GamificationService.calculateUpdatedStreak(stats.streak, stats.lastActiveDate, today)
        statsDao.upsertStats(stats.copy(streak = newStreak, lastActiveDate = today))

        if (newStreak >= 7) {
            checkAndUnlockAchievement("streak_7")
        }
        if (newStreak >= 30) {
            checkAndUnlockAchievement("dedicated_30")
        }
    }

    private suspend fun incrementCompletedLessons() {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(completedLessons = stats.completedLessons + 1))
    }

    private suspend fun incrementSolvedQuestions(count: Int) {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(solvedQuestions = stats.solvedQuestions + count))
    }

    private suspend fun incrementCompletedChallenges() {
        val stats = getOrCreateStats()
        statsDao.upsertStats(stats.copy(completedChallenges = stats.completedChallenges + 1))
    }
}
