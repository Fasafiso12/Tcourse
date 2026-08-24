package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.db.AppDatabase
import com.example.repository.AppRepository
import com.example.ui.components.*
import com.example.ui.screens.*
import com.example.ui.theme.DarkBg
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PrimaryIndigo
import com.example.viewmodel.AppNavTab
import com.example.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getDatabase(applicationContext)
        val repository = AppRepository(database, applicationContext)
        val viewModel = MainViewModel(repository)

        setContent {
            val themeMode by viewModel.themeMode.collectAsState()
            val editorTheme by viewModel.editorTheme.collectAsState()
            val isDarkTheme by viewModel.isDarkTheme.collectAsState()
            val appLanguage by viewModel.appLanguage.collectAsState()
            val strings = remember(appLanguage) { com.example.data.util.AppStrings.get(appLanguage) }

            androidx.compose.runtime.CompositionLocalProvider(
                com.example.data.util.LocalAppLanguage provides appLanguage,
                com.example.data.util.LocalAppStrings provides strings
            ) {
                MyApplicationTheme(
                    themeMode = themeMode,
                    editorTheme = editorTheme
                ) {
                    AppRootContent(viewModel = viewModel, isDarkTheme = isDarkTheme)
                }
            }
        }
    }
}

@Composable
fun AppRootContent(viewModel: MainViewModel, isDarkTheme: Boolean) {
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedLanguageId by viewModel.selectedLanguageId.collectAsState()
    val activeLesson by viewModel.activeLesson.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val activeCourseProgress by viewModel.activeCourseProgress.collectAsState()
    val allProgress by viewModel.allProgress.collectAsState()
    val allNotes by viewModel.allNotes.collectAsState()
    val allFavorites by viewModel.allFavorites.collectAsState()
    val allMistakes by viewModel.allMistakes.collectAsState()
    val appLanguage by viewModel.appLanguage.collectAsState()
    val showInitialLanguageDialog by viewModel.showInitialLanguageDialog.collectAsState()
    val strings = com.example.data.util.LocalAppStrings.current

    // Dialog & overlay states
    val showPremiumDialog by viewModel.showPremiumDialog.collectAsState()
    val showCertificateModal by viewModel.showCertificateModal.collectAsState()
    val showNoteDialog by viewModel.showNoteDialog.collectAsState()
    val quizState by viewModel.quizState.collectAsState()
    val challengeState by viewModel.challengeState.collectAsState()
    val aiAssistantState by viewModel.aiAssistantState.collectAsState()

    // Gamification Micro-animation event states
    val currentXpGain by viewModel.currentXpGain.collectAsState()
    val currentLevelUp by viewModel.currentLevelUp.collectAsState()
    val unlockedAchievementBanner by viewModel.unlockedAchievementBanner.collectAsState()

    var isSearchOpen by remember { mutableStateOf(false) }

    val languages = remember { CourseCatalog.languages }

    Box(modifier = Modifier.fillMaxSize()) {
        // Main Tab Scaffold
        Scaffold(
            topBar = {
                if (activeLesson == null && quizState.questions.isEmpty() && challengeState.challenge == null && !isSearchOpen && !aiAssistantState.isOpen) {
                    val currentThemeMode by viewModel.themeMode.collectAsState()
                    TopAppBarHeader(
                        languages = languages,
                        selectedLanguageId = selectedLanguageId,
                        userProfile = userProfile,
                        isDarkTheme = isDarkTheme,
                        currentThemeMode = currentThemeMode,
                        appLanguage = appLanguage,
                        onToggleTheme = { viewModel.toggleTheme() },
                        onSelectThemeMode = { viewModel.setThemeMode(it) },
                        onToggleEyeCare = { viewModel.toggleEyeCareMode() },
                        onSelectAppLanguage = { viewModel.setAppLanguage(it) },
                        onLanguageSelected = { viewModel.selectLanguage(it) },
                        onSearchClick = { isSearchOpen = true },
                        onPremiumClick = { viewModel.openPremiumDialog() }
                    )
                }
            },
            bottomBar = {
                if (activeLesson == null && quizState.questions.isEmpty() && challengeState.challenge == null && !isSearchOpen && !aiAssistantState.isOpen) {
                    BottomNavBar(
                        currentTab = currentTab,
                        appLanguage = appLanguage,
                        onTabSelected = { viewModel.setTab(it) }
                    )
                }
            },
            floatingActionButton = {
                if (activeLesson == null && quizState.questions.isEmpty() && challengeState.challenge == null && !isSearchOpen && !aiAssistantState.isOpen) {
                    androidx.compose.material3.FloatingActionButton(
                        onClick = { viewModel.openAiAssistant() },
                        containerColor = PrimaryIndigo,
                        contentColor = androidx.compose.ui.graphics.Color.White,
                        shape = androidx.compose.foundation.shape.CircleShape,
                        modifier = Modifier.testTag("global_ai_assistant_fab")
                    ) {
                        androidx.compose.foundation.layout.Row(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(6.dp)
                        ) {
                            androidx.compose.material3.Text("🤖", fontSize = 20.sp)
                            androidx.compose.material3.Text("AI Asistan", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }
            },
            containerColor = DarkBg
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentTab) {
                    AppNavTab.HOME -> {
                        HomeScreen(
                            viewModel = viewModel,
                            userProfile = userProfile,
                            activeCourseProgress = activeCourseProgress,
                            selectedLanguageId = selectedLanguageId,
                            onNavigateToTab = { viewModel.setTab(it) },
                            onOpenLesson = { viewModel.openLesson(it) }
                        )
                    }
                    AppNavTab.COURSES -> {
                        CoursesScreen(
                            viewModel = viewModel,
                            onOpenLesson = { viewModel.openLesson(it) }
                        )
                    }
                    AppNavTab.ROADMAP -> {
                        RoadmapScreen(
                            viewModel = viewModel,
                            selectedLanguageId = selectedLanguageId,
                            allProgress = allProgress,
                            isUserPremium = userProfile.isPremium,
                            onOpenLesson = { viewModel.openLesson(it) }
                        )
                    }
                    AppNavTab.PRACTICE -> {
                        PracticeScreen(
                            viewModel = viewModel,
                            onStartChallenge = { viewModel.startChallenge(it) }
                        )
                    }
                    AppNavTab.PROFILE -> {
                        ProfileScreen(
                            viewModel = viewModel,
                            userProfile = userProfile,
                            notes = allNotes,
                            favorites = allFavorites,
                            mistakes = allMistakes,
                            onOpenCertificate = { viewModel.openCertificate(it) }
                        )
                    }
                }
            }
        }

        // Active Lesson Detail Overlay
        if (activeLesson != null && quizState.questions.isEmpty() && challengeState.challenge == null) {
            LessonDetailScreen(
                viewModel = viewModel,
                lesson = activeLesson!!,
                onBack = { viewModel.closeActiveLesson() },
                onStartQuiz = { activeLesson?.let { viewModel.startQuiz(it) } },
                onStartCodingChallenge = { activeLesson?.codingChallenge?.let { viewModel.startChallenge(it) } },
                onNextLesson = { next ->
                    viewModel.openLesson(next)
                }
            )
        }

        // Active Quiz Overlay
        if (quizState.questions.isNotEmpty()) {
            QuizScreen(
                viewModel = viewModel,
                quizState = quizState,
                onClose = { viewModel.closeQuiz() }
            )
        }

        // Active Coding Challenge Overlay
        if (challengeState.challenge != null) {
            CodingChallengeScreen(
                viewModel = viewModel,
                challengeState = challengeState,
                onClose = { viewModel.closeChallenge() }
            )
        }

        // Search Overlay
        if (isSearchOpen) {
            SearchScreen(
                viewModel = viewModel,
                onClose = {
                    isSearchOpen = false
                    viewModel.setSearchQuery("")
                },
                onOpenLesson = { lesson ->
                    viewModel.openLesson(lesson)
                }
            )
        }

        // Dialogs
        if (showInitialLanguageDialog) {
            InitialLanguageSelectionDialog(
                currentLanguage = appLanguage,
                onConfirmLanguage = { selectedLang ->
                    viewModel.completeInitialLanguageSelection(selectedLang)
                }
            )
        }

        if (showPremiumDialog) {
            PremiumPaywallDialog(
                appLanguage = appLanguage,
                onDismiss = { viewModel.closePremiumDialog() },
                onUpgradeSuccess = { viewModel.activatePremiumPlan() }
            )
        }

        if (showCertificateModal != null) {
            CertificateDialog(
                language = showCertificateModal!!,
                username = userProfile.username,
                onDismiss = { viewModel.closeCertificate() }
            )
        }

        if (showNoteDialog != null) {
            NoteEditorDialog(
                lesson = showNoteDialog!!,
                onDismiss = { viewModel.closeNoteDialog() },
                onSave = { content ->
                    viewModel.saveLessonNote(showNoteDialog!!, content)
                }
            )
        }

        // AI Assistant Overlay Sheet
        if (aiAssistantState.isOpen) {
            AiAssistantSheet(
                state = aiAssistantState,
                onClose = { viewModel.closeAiAssistant() },
                onSendMessage = { prompt, shortcut ->
                    viewModel.sendAiMessage(prompt, shortcut)
                },
                onSelectShortcut = { shortcut ->
                    viewModel.selectAiShortcut(shortcut)
                },
                onClearChat = { viewModel.clearAiChat() }
            )
        }

        // ==========================================
        // Real-Time Gamification Micro-Animations
        // ==========================================
        FloatingXpGainBadge(
            event = currentXpGain,
            onDismiss = { viewModel.dismissXpGain() }
        )

        AchievementUnlockedBanner(
            achievement = unlockedAchievementBanner,
            onDismiss = { viewModel.dismissAchievementBanner() }
        )

        LevelUpCelebrationDialog(
            event = currentLevelUp,
            onDismiss = { viewModel.dismissLevelUp() }
        )
    }
}
