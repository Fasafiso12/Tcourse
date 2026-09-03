package com.example.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.*
import com.example.ui.components.CodeBlock
import com.example.ui.components.CodeEditorComponent
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel
import kotlinx.coroutines.launch

/**
 * Modern, Bite-Sized, Interactive Mobile Lesson Learning Experience
 * Replaces long PDF/document scrolling with focused, digestible step-by-step screens.
 */
@Composable
fun LessonDetailScreen(
    viewModel: MainViewModel,
    lesson: Lesson,
    onBack: () -> Unit,
    onStartQuiz: () -> Unit,
    onStartCodingChallenge: () -> Unit,
    onNextLesson: (Lesson) -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val allProgress by viewModel.allProgress.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val appLanguage by viewModel.appLanguage.collectAsState()
    val isTr = appLanguage == AppLanguage.TR
    val appColors = LocalAppColors.current

    val isInitiallyCompleted = remember(lesson.id, allProgress) {
        allProgress.any { it.lessonId == lesson.id && it.status == LessonStatus.COMPLETED.name }
    }
    var isLessonCompleted by remember(lesson.id, isInitiallyCompleted) { mutableStateOf(isInitiallyCompleted) }

    // Step-by-Step Flow Construction
    val lessonSteps = remember(lesson.id, isTr) {
        buildLessonSteps(lesson, isTr)
    }
    var currentStepIndex by remember(lesson.id) { mutableIntStateOf(0) }

    // Mini Question state
    var miniQuestionSelectedOption by remember(lesson.id) { mutableStateOf<Int?>(null) }
    var isMiniQuestionChecked by remember(lesson.id) { mutableStateOf(false) }

    // Practical task / Exercise state with Room persistence
    val exerciseId = remember(lesson.id) { "ex_${lesson.id}" }
    val savedAttemptFlow = remember(exerciseId) { viewModel.getExerciseAttempt(exerciseId) }
    val savedAttempt by savedAttemptFlow.collectAsState(initial = null)

    val defaultTaskCode = remember(lesson.id, lesson.courseId, isTr) {
        getPracticalTaskStarterTemplate(lesson.courseId, lesson.title, isTr)
    }

    var practicalTaskCode by remember(lesson.id) { mutableStateOf(defaultTaskCode) }
    var practicalTaskResult by remember(lesson.id) { mutableStateOf<ExecutionResult?>(null) }
    var isPracticalTaskRunning by remember(lesson.id) { mutableStateOf(false) }
    var isPracticalTaskPassed by remember(lesson.id) {
        mutableStateOf(savedAttempt?.isCompleted == true)
    }

    // Aşamalı İpucu Sistemi (Progressive Hints)
    var currentHintStage by remember(lesson.id) { mutableIntStateOf(0) }
    var isSolutionRevealed by remember(lesson.id) { mutableStateOf(false) }

    // Load saved attempt code if exists
    LaunchedEffect(savedAttempt) {
        savedAttempt?.let { att ->
            if (att.savedCode.isNotBlank() && practicalTaskCode == defaultTaskCode) {
                practicalTaskCode = att.savedCode
            }
            if (att.isCompleted) {
                isPracticalTaskPassed = true
            }
        }
    }

    LaunchedEffect(lesson.id) {
        currentStepIndex = 0
        miniQuestionSelectedOption = null
        isMiniQuestionChecked = false
        currentHintStage = 0
        isSolutionRevealed = false
        practicalTaskResult = null
        isPracticalTaskRunning = false
        isPracticalTaskPassed = savedAttempt?.isCompleted == true
    }

    val allLessons = remember(lesson.courseId) { CourseCatalog.getLessonsForCourse(lesson.courseId) }
    val currentLessonIdx = remember(lesson, allLessons) { allLessons.indexOfFirst { it.id == lesson.id } }
    val prevLesson = remember(currentLessonIdx, allLessons) {
        if (currentLessonIdx > 0) allLessons[currentLessonIdx - 1] else null
    }
    val nextLesson = remember(currentLessonIdx, allLessons) {
        if (currentLessonIdx != -1 && currentLessonIdx < allLessons.size - 1) allLessons[currentLessonIdx + 1] else null
    }

    val isLocked = lesson.isPremium && !userProfile.isPremium

    val expectedOutputSnippet = remember(lesson.id, lesson.courseId) {
        deriveExpectedOutput(lesson.title, lesson.practicalTask ?: "", lesson.courseId)
    }

    val currentStep = lessonSteps.getOrNull(currentStepIndex) ?: lessonSteps.firstOrNull()
    val totalSteps = lessonSteps.size
    val isLastStep = currentStepIndex == totalSteps - 1

    Scaffold(
        topBar = {
            Surface(
                color = appColors.bg,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            ) {
                Column {
                    // Header Bar
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                if (currentStepIndex > 0) {
                                    currentStepIndex--
                                } else {
                                    onBack()
                                }
                            },
                            modifier = Modifier.testTag("back_button")
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = if (isTr) "Geri" else "Back",
                                tint = appColors.textPrimary
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = "${lesson.courseId.uppercase()} • ${currentLessonIdx + 1}/${allLessons.size}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = appColors.primaryIndigoLight,
                                letterSpacing = 0.8.sp
                            )
                            Text(
                                text = lesson.title,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = appColors.textPrimary,
                                letterSpacing = (-0.2).sp,
                                maxLines = 1
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = { viewModel.openAiAssistant(lesson = lesson) },
                                modifier = Modifier.testTag("lesson_open_ai_btn")
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = appColors.primaryIndigo.copy(alpha = 0.12f),
                                    modifier = Modifier.size(34.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("🤖", fontSize = 16.sp)
                                    }
                                }
                            }

                            IconButton(
                                onClick = { viewModel.openNoteDialog(lesson) },
                                modifier = Modifier.testTag("add_note_btn")
                            ) {
                                Icon(
                                    Icons.Default.EditNote,
                                    contentDescription = if (isTr) "Not Ekle" else "Add Note",
                                    tint = appColors.primaryIndigoLight,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }

                    // Modern Segmented Step Indicator
                    if (totalSteps > 1) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (stepIdx in 0 until totalSteps) {
                                val isPassed = stepIdx < currentStepIndex
                                val isCurrent = stepIdx == currentStepIndex

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(4.dp)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(
                                            when {
                                                isCurrent -> appColors.primaryIndigo
                                                isPassed -> appColors.accentEmerald.copy(alpha = 0.85f)
                                                else -> appColors.cardBorder
                                            }
                                        )
                                        .clickable { currentStepIndex = stepIdx }
                                )
                            }
                        }
                    }
                }
            }
        },
        bottomBar = {
            Surface(
                color = appColors.surface,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder)),
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Back / Previous Button
                    if (currentStepIndex > 0) {
                        OutlinedButton(
                            onClick = { currentStepIndex-- },
                            modifier = Modifier
                                .weight(0.9f)
                                .height(46.dp)
                                .testTag("bottom_prev_lesson_btn"),
                            shape = RoundedCornerShape(12.dp),
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder))
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(15.dp),
                                tint = appColors.textSecondary
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isTr) "Geri" else "Back",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = appColors.textPrimary
                            )
                        }
                    } else if (prevLesson != null) {
                        OutlinedButton(
                            onClick = { onNextLesson(prevLesson) },
                            modifier = Modifier
                                .weight(0.9f)
                                .height(46.dp)
                                .testTag("bottom_prev_lesson_btn"),
                            shape = RoundedCornerShape(12.dp),
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder))
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(15.dp),
                                tint = appColors.textSecondary
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isTr) "Önceki Ders" else "Prev Lesson",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = appColors.textPrimary
                            )
                        }
                    }

                    // Forward / Action Button
                    val isQuestionStep = currentStep is LessonStep.MiniQuestionStep
                    val isActionRequired = isQuestionStep && !isMiniQuestionChecked

                    Button(
                        onClick = {
                            if (isActionRequired) {
                                isMiniQuestionChecked = true
                            } else if (!isLastStep) {
                                currentStepIndex++
                            } else {
                                isLessonCompleted = true
                                viewModel.markLessonComplete(lesson)
                                if (nextLesson != null) {
                                    onNextLesson(nextLesson)
                                } else {
                                    onBack()
                                }
                            }
                        },
                        modifier = Modifier
                            .weight(if (currentStepIndex > 0 || prevLesson != null) 1.5f else 1f)
                            .height(46.dp)
                            .testTag("bottom_complete_next_btn"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when {
                                isActionRequired -> appColors.primaryIndigo
                                isLastStep -> appColors.accentEmerald
                                else -> appColors.primaryIndigo
                            }
                        ),
                        shape = RoundedCornerShape(12.dp),
                        enabled = !(isActionRequired && miniQuestionSelectedOption == null)
                    ) {
                        Text(
                            text = when {
                                isActionRequired -> if (isTr) "Cevabı Kontrol Et" else "Check Answer"
                                !isLastStep -> if (isTr) "Devam Et →" else "Continue →"
                                nextLesson != null -> if (isTr) "Tamamla & Sonraki →" else "Complete & Next →"
                                else -> if (isTr) "Dersi Bitir ✓" else "Finish Lesson ✓"
                            },
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        },
        containerColor = appColors.bg
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            val contentWidth = if (maxWidth > 680.dp) 640.dp else maxWidth

            if (isLocked) {
                Box(
                    modifier = Modifier
                        .width(contentWidth)
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LockedContentCard(
                        onUnlock = { viewModel.activatePremiumPlan() },
                        isTr = isTr,
                        appColors = appColors
                    )
                }
            } else if (currentStep != null) {
                AnimatedContent(
                    targetState = currentStepIndex,
                    transitionSpec = {
                        if (targetState > initialState) {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> (fullWidth * 0.35f).toInt() },
                                animationSpec = tween(220)
                            ) + fadeIn(animationSpec = tween(220)) togetherWith
                                    slideOutHorizontally(
                                        targetOffsetX = { fullWidth -> -(fullWidth * 0.35f).toInt() },
                                        animationSpec = tween(220)
                                    ) + fadeOut(animationSpec = tween(220))
                        } else {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> -(fullWidth * 0.35f).toInt() },
                                animationSpec = tween(220)
                            ) + fadeIn(animationSpec = tween(220)) togetherWith
                                    slideOutHorizontally(
                                        targetOffsetX = { fullWidth -> (fullWidth * 0.35f).toInt() },
                                        animationSpec = tween(220)
                                    ) + fadeOut(animationSpec = tween(220))
                        }
                    },
                    modifier = Modifier
                        .width(contentWidth)
                        .fillMaxSize(),
                    label = "LessonStepTransition"
                ) { stepIndex ->
                    val activeStep = lessonSteps.getOrNull(stepIndex) ?: lessonSteps.first()
                    val scrollState = rememberScrollState()

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(horizontal = 16.dp, vertical = 20.dp)
                    ) {
                        when (activeStep) {
                            is LessonStep.ConceptStep -> {
                                ConceptStepView(
                                    lesson = lesson,
                                    step = activeStep,
                                    courseId = lesson.courseId,
                                    isTr = isTr,
                                    appColors = appColors,
                                    onAskAi = { sentence ->
                                        viewModel.openAiAssistant(
                                            lesson = lesson,
                                            initialShortcut = AiShortcut.EXPLAIN_SENTENCE,
                                            targetSentence = sentence
                                        )
                                    }
                                )
                            }
                            is LessonStep.AnalogyStep -> {
                                AnalogyStepView(
                                    analogy = activeStep.analogy,
                                    isTr = isTr,
                                    appColors = appColors,
                                    onAskAi = {
                                        viewModel.openAiAssistant(
                                            lesson = lesson,
                                            initialShortcut = AiShortcut.ANALOGY_EXAMPLE,
                                            targetSentence = "${activeStep.analogy.headline}: ${activeStep.analogy.story}"
                                        )
                                    }
                                )
                            }
                            is LessonStep.CodeExampleStep -> {
                                CodeSummaryStepView(
                                    lesson = lesson,
                                    code = activeStep.code,
                                    explanation = activeStep.explanation,
                                    isTr = isTr,
                                    appColors = appColors
                                )
                            }
                            is LessonStep.MiniQuestionStep -> {
                                MiniQuestionStepView(
                                    miniQ = activeStep.question,
                                    courseId = lesson.courseId,
                                    isTr = isTr,
                                    appColors = appColors,
                                    selectedOption = miniQuestionSelectedOption,
                                    isChecked = isMiniQuestionChecked,
                                    onSelectOption = { miniQuestionSelectedOption = it }
                                )
                            }
                            is LessonStep.PracticalTaskStep -> {
                                PracticalExerciseStepView(
                                    lesson = lesson,
                                    taskDescription = activeStep.taskDescription,
                                    practicalTaskCode = practicalTaskCode,
                                    onCodeChange = { newCode ->
                                        practicalTaskCode = newCode
                                        if (practicalTaskResult != null) practicalTaskResult = null
                                    },
                                    expectedOutput = expectedOutputSnippet,
                                    practicalTaskResult = practicalTaskResult,
                                    isRunning = isPracticalTaskRunning,
                                    isPassed = isPracticalTaskPassed,
                                    currentHintStage = currentHintStage,
                                    isSolutionRevealed = isSolutionRevealed,
                                    isTr = isTr,
                                    appColors = appColors,
                                    onRunCode = {
                                        coroutineScope.launch {
                                            isPracticalTaskRunning = true
                                            val res = viewModel.verifyAndSubmitPracticalTask(
                                                lessonId = lesson.id,
                                                courseId = lesson.courseId,
                                                lessonTitle = lesson.title,
                                                taskDescription = lesson.practicalTask ?: "",
                                                userCode = practicalTaskCode
                                            )
                                            isPracticalTaskRunning = false
                                            practicalTaskResult = res
                                            isPracticalTaskPassed = res.isSuccess

                                            val exercise = Exercise(
                                                id = exerciseId,
                                                lessonId = lesson.id,
                                                title = lesson.title,
                                                description = lesson.practicalTask ?: "",
                                                starterCode = defaultTaskCode,
                                                expectedOutput = expectedOutputSnippet,
                                                language = lesson.courseId
                                            )
                                            viewModel.saveExerciseProgress(
                                                exercise = exercise,
                                                userCode = practicalTaskCode,
                                                output = res.output,
                                                isCompleted = res.isSuccess,
                                                hintsUsed = currentHintStage
                                            )
                                        }
                                    },
                                    onResetCode = {
                                        practicalTaskCode = defaultTaskCode
                                        practicalTaskResult = null
                                        isPracticalTaskPassed = false
                                    },
                                    onNextHint = {
                                        if (currentHintStage < 3) currentHintStage++
                                    },
                                    onRevealSolution = {
                                        isSolutionRevealed = true
                                    },
                                    onAskAi = { code ->
                                        viewModel.openAiAssistant(
                                            lesson = lesson,
                                            initialShortcut = AiShortcut.CHECK_CODE,
                                            targetSentence = if (isTr) {
                                                "Uygulamalı Görev: ${lesson.practicalTask}\nYazdığım Kod:\n```${lesson.courseId}\n$code\n```\nLütfen yazdığım kodu kontrol et. Küçük bir çocuğa anlatır gibi samimi ve sade bir dille ipucu ver."
                                            } else {
                                                "Practical Task: ${lesson.practicalTask}\nMy Code:\n```${lesson.courseId}\n$code\n```\nPlease check my code and explain like I'm 5 with simple guidance."
                                            }
                                        )
                                    }
                                )
                            }
                        }

                        // Extra bottom breathing room inside scroll
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// STEP SELECTION & BUILDER DATA STRUCTURE
// -------------------------------------------------------------------------------------------------

sealed class LessonStep {
    data class ConceptStep(
        val blockIndex: Int,
        val totalBlocks: Int,
        val block: LessonContentBlock,
        val isFirst: Boolean
    ) : LessonStep()

    data class AnalogyStep(
        val analogy: AnalogyInfo
    ) : LessonStep()

    data class CodeExampleStep(
        val code: String,
        val explanation: String
    ) : LessonStep()

    data class MiniQuestionStep(
        val question: MiniQuestion
    ) : LessonStep()

    data class PracticalTaskStep(
        val taskDescription: String
    ) : LessonStep()
}

private fun buildLessonSteps(lesson: Lesson, isTr: Boolean): List<LessonStep> {
    val steps = mutableListOf<LessonStep>()

    // 1. Concept / Explanation Blocks (Bite-sized screens)
    if (lesson.detailedExplanation.isNotEmpty()) {
        lesson.detailedExplanation.forEachIndexed { idx, block ->
            steps.add(
                LessonStep.ConceptStep(
                    blockIndex = idx + 1,
                    totalBlocks = lesson.detailedExplanation.size,
                    block = block,
                    isFirst = idx == 0
                )
            )
        }
    } else {
        // Fallback single block from shortDesc
        steps.add(
            LessonStep.ConceptStep(
                blockIndex = 1,
                totalBlocks = 1,
                block = LessonContentBlock(
                    subtitle = lesson.title,
                    body = lesson.shortDesc
                ),
                isFirst = true
            )
        )
    }

    // 2. "Explain Like I'm 5" / Real-life Analogy Step
    val analogy = getChildFriendlyAnalogy(lesson.title, lesson.courseId, isTr)
    steps.add(LessonStep.AnalogyStep(analogy))

    // 3. Mini Check Question Step
    if (lesson.miniQuestion != null) {
        steps.add(LessonStep.MiniQuestionStep(lesson.miniQuestion))
    }

    // 4. Topic Summary Code Step
    if (lesson.codeExample.isNotBlank()) {
        steps.add(LessonStep.CodeExampleStep(lesson.codeExample, lesson.codeExplanation))
    }

    // 5. Practical Task Step
    if (!lesson.practicalTask.isNullOrBlank()) {
        steps.add(LessonStep.PracticalTaskStep(lesson.practicalTask))
    }

    return steps
}

// -------------------------------------------------------------------------------------------------
// STEP 1: FOCUSED CONCEPT SCREEN (Bite-Sized Reading with High Hierarchy & Generous Whitespace)
// -------------------------------------------------------------------------------------------------

@Composable
private fun ConceptStepView(
    lesson: Lesson,
    step: LessonStep.ConceptStep,
    courseId: String,
    isTr: Boolean,
    appColors: AppColors,
    onAskAi: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Tag / Stage Badge Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.primaryIndigo.copy(alpha = 0.12f)
            ) {
                Text(
                    text = if (step.isFirst) {
                        "${lesson.level.displayName.uppercase()} • ${if (isTr) "GİRİŞ" else "INTRO"}"
                    } else {
                        if (isTr) "ADIM ${step.blockIndex}/${step.totalBlocks}" else "STEP ${step.blockIndex}/${step.totalBlocks}"
                    },
                    color = appColors.primaryIndigoLight,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.surfaceVariant,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onAskAi("${step.block.subtitle}: ${step.block.body}") }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text("🤖", fontSize = 12.sp)
                    Text(
                        text = if (isTr) "AI Açıkla" else "Explain",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = appColors.primaryIndigoLight
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Subtitle / Heading
        Text(
            text = step.block.subtitle,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = appColors.textPrimary,
            lineHeight = 30.sp,
            letterSpacing = (-0.3).sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Clear, readable, well-spaced paragraphs without boxing
        val paragraphs = remember(step.block.body) {
            step.block.body.split("\n\n").filter { it.isNotBlank() }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            paragraphs.forEachIndexed { index, paragraph ->
                if (index > 0) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Text(
                    text = paragraph.trim(),
                    fontSize = 16.sp,
                    color = appColors.textSecondary,
                    lineHeight = 26.sp,
                    letterSpacing = 0.15.sp
                )
            }
        }

        // Inline Code Snippet (if available)
        if (step.block.codeSnippet != null && step.block.codeSnippet.isNotBlank()) {
            Spacer(modifier = Modifier.height(20.dp))
            CodeBlock(
                code = step.block.codeSnippet,
                language = courseId,
                showLineNumbers = step.block.codeSnippet.lines().size > 1,
                title = step.block.subtitle
            )
        }

        // Child-friendly / Gentle Tip Banner
        if (step.block.tip != null && step.block.tip.isNotBlank()) {
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = appColors.accentAmberSubtle,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.accentAmberBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("💡", fontSize = 20.sp)
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = if (isTr) "Püf Noktası:" else "Key Idea:",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = appColors.accentAmber
                        )
                        Text(
                            text = step.block.tip,
                            fontSize = 14.5.sp,
                            color = appColors.textPrimary,
                            lineHeight = 22.sp
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// STEP 2: ANALOGY SCREEN (Explain Like I'm 5 with Metaphors)
// -------------------------------------------------------------------------------------------------

@Composable
private fun AnalogyStepView(
    analogy: AnalogyInfo,
    isTr: Boolean,
    appColors: AppColors,
    onAskAi: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Tag Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.accentEmerald.copy(alpha = 0.12f)
            ) {
                Text(
                    text = if (isTr) "GÜNLÜK HAYATTAN BENZETME" else "REAL-LIFE ANALOGY",
                    color = appColors.accentEmeraldLight,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.surfaceVariant,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onAskAi)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text("🤖", fontSize = 12.sp)
                    Text(
                        text = if (isTr) "Farklı Benzetme İste" else "More Analogies",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = appColors.primaryIndigoLight
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Metaphor Headline
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(analogy.emoji, fontSize = 30.sp)
            Text(
                text = analogy.headline,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = appColors.textPrimary,
                lineHeight = 29.sp,
                letterSpacing = (-0.2).sp
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Story Card
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = appColors.surfaceVariant,
            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp)
            ) {
                val storyParagraphs = remember(analogy.story) {
                    analogy.story.split("\n\n").filter { it.isNotBlank() }
                }

                storyParagraphs.forEachIndexed { index, p ->
                    if (index > 0) {
                        Spacer(modifier = Modifier.height(14.dp))
                    }
                    Text(
                        text = p.trim(),
                        fontSize = 16.sp,
                        color = appColors.textPrimary,
                        lineHeight = 26.sp,
                        letterSpacing = 0.15.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Takeaway Pill
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = appColors.accentEmeraldSubtle,
            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.accentEmeraldBorder)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text("✨", fontSize = 18.sp)
                Text(
                    text = analogy.takeaway,
                    fontSize = 14.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = appColors.accentEmeraldLight,
                    lineHeight = 22.sp
                )
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// STEP 3: CONSOLIDATED CODE SUMMARY SCREEN
// -------------------------------------------------------------------------------------------------

@Composable
private fun CodeSummaryStepView(
    lesson: Lesson,
    code: String,
    explanation: String,
    isTr: Boolean,
    appColors: AppColors
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Tag
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = appColors.primaryIndigo.copy(alpha = 0.12f)
        ) {
            Text(
                text = if (isTr) "KOD ÖRNEĞİ & ÖZET" else "CODE EXAMPLE & SUMMARY",
                color = appColors.primaryIndigoLight,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.6.sp,
                modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (isTr) "Konunun Örnek Kodu" else "Consolidated Code Example",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = appColors.textPrimary,
            lineHeight = 29.sp,
            letterSpacing = (-0.2).sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Code Block
        CodeBlock(
            code = code,
            language = lesson.courseId,
            showLineNumbers = code.lines().size > 1,
            title = lesson.title
        )

        // Explanation (if present)
        if (explanation.isNotBlank()) {
            Spacer(modifier = Modifier.height(18.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = appColors.surfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("📝", fontSize = 18.sp)
                    Text(
                        text = explanation,
                        fontSize = 15.sp,
                        color = appColors.textSecondary,
                        lineHeight = 24.sp,
                        letterSpacing = 0.1.sp
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// STEP 4: MINI CHECK QUESTION SCREEN (Focused & Interactive)
// -------------------------------------------------------------------------------------------------

@Composable
private fun MiniQuestionStepView(
    miniQ: MiniQuestion,
    courseId: String,
    isTr: Boolean,
    appColors: AppColors,
    selectedOption: Int?,
    isChecked: Boolean,
    onSelectOption: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = appColors.primaryIndigo.copy(alpha = 0.12f)
        ) {
            Text(
                text = if (isTr) "HIZLI KONTROL" else "QUICK CHECK",
                color = appColors.primaryIndigoLight,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.6.sp,
                modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = miniQ.question,
            fontSize = 18.5.sp,
            fontWeight = FontWeight.Bold,
            color = appColors.textPrimary,
            lineHeight = 27.sp,
            letterSpacing = (-0.1).sp
        )

        if (miniQ.codeSnippet != null && miniQ.codeSnippet.isNotBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            CodeBlock(
                code = miniQ.codeSnippet,
                language = courseId,
                showLineNumbers = miniQ.codeSnippet.lines().size > 1,
                showWindowDots = false
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            miniQ.options.forEachIndexed { optIdx, optText ->
                val isSelected = selectedOption == optIdx
                val isCorrect = optIdx == miniQ.correctIndex

                val borderColor = when {
                    !isChecked -> if (isSelected) appColors.primaryIndigo else appColors.cardBorder
                    isCorrect -> appColors.accentEmerald
                    isSelected -> appColors.accentRose
                    else -> appColors.cardBorder
                }

                val bgColor = when {
                    !isChecked -> if (isSelected) appColors.primarySubtle else appColors.surfaceVariant
                    isCorrect -> appColors.accentEmeraldSubtle
                    isSelected -> appColors.accentRoseSubtle
                    else -> appColors.surfaceVariant
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(bgColor)
                        .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
                        .clickable(enabled = !isChecked) { onSelectOption(optIdx) }
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = optText,
                        fontSize = 15.sp,
                        color = appColors.textPrimary,
                        lineHeight = 22.sp,
                        modifier = Modifier.weight(1f)
                    )

                    if (isChecked) {
                        if (isCorrect) {
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = appColors.accentEmerald,
                                modifier = Modifier.size(20.dp)
                            )
                        } else if (isSelected) {
                            Icon(
                                Icons.Default.Cancel,
                                contentDescription = null,
                                tint = appColors.accentRose,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }

        if (isChecked) {
            val isCorrect = selectedOption == miniQ.correctIndex
            Spacer(modifier = Modifier.height(18.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (isCorrect) appColors.accentEmeraldSubtle else appColors.accentRoseSubtle,
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = SolidColor(if (isCorrect) appColors.accentEmeraldBorder else appColors.accentRoseBorder)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isCorrect) {
                        "✓ ${if (isTr) "Harika! Doğru anladın." else "Great! You got it right."} ${miniQ.explanation}"
                    } else {
                        "💡 ${miniQ.explanation}"
                    },
                    color = if (isCorrect) appColors.accentEmeraldLight else appColors.accentRose,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    modifier = Modifier.padding(14.dp)
                )
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// STEP 5: HANDS-ON PRACTICAL TASK SCREEN (Interactive Coding & Console)
// -------------------------------------------------------------------------------------------------

@Composable
private fun PracticalExerciseStepView(
    lesson: Lesson,
    taskDescription: String,
    practicalTaskCode: String,
    onCodeChange: (String) -> Unit,
    expectedOutput: String,
    practicalTaskResult: ExecutionResult?,
    isRunning: Boolean,
    isPassed: Boolean,
    currentHintStage: Int,
    isSolutionRevealed: Boolean,
    isTr: Boolean,
    appColors: AppColors,
    onRunCode: () -> Unit,
    onResetCode: () -> Unit,
    onNextHint: () -> Unit,
    onRevealSolution: () -> Unit,
    onAskAi: (String) -> Unit
) {
    val hintsList = remember(lesson.id, taskDescription) {
        generateProgressiveHints(taskDescription, lesson.courseId, isTr)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("lesson_practical_task_card")
    ) {
        // Tag & XP Badge
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.accentEmerald.copy(alpha = 0.12f)
            ) {
                Text(
                    text = if (isTr) "UYGULAMALI GÖREV" else "HANDS-ON TASK",
                    color = appColors.accentEmeraldLight,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.6.sp,
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isPassed) appColors.accentEmerald.copy(alpha = 0.15f) else appColors.accentAmber.copy(alpha = 0.15f)
            ) {
                Text(
                    text = if (isPassed) "✓ Tamamlandı" else "+20 XP",
                    color = if (isPassed) appColors.accentEmerald else appColors.accentAmber,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Task Prompt
        Text(
            text = taskDescription,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = appColors.textPrimary,
            lineHeight = 25.sp,
            letterSpacing = 0.1.sp
        )

        // Expected Output Pill
        if (expectedOutput.isNotBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = appColors.surfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.cardBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (isTr) "🎯 Beklenen Çıktı:" else "🎯 Expected Output:",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = appColors.textMuted
                    )
                    Text(
                        text = expectedOutput,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = appColors.accentEmeraldLight
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Embedded Code Editor
        CodeEditorComponent(
            code = practicalTaskCode,
            onCodeChange = onCodeChange,
            language = lesson.courseId,
            title = lesson.title,
            minEditorHeight = 140,
            showSymbolsToolbar = true,
            showRunButton = false,
            showOutputTerminal = false,
            onResetCode = onResetCode,
            onAskAi = onAskAi,
            testTagPrefix = "lesson_practical_task"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Run Code Button
        Button(
            onClick = onRunCode,
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .testTag("verify_practical_task_btn"),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isPassed) appColors.accentEmerald else appColors.primaryIndigo,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            enabled = !isRunning
        ) {
            if (isRunning) {
                CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (isTr) "Kod Çalıştırılıyor..." else "Running...", fontSize = 13.sp)
            } else {
                Text(if (isPassed) "✓" else "▶", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (isPassed) {
                        if (isTr) "Tekrar Test Et & Çalıştır" else "Run & Test Again"
                    } else {
                        if (isTr) "Kodu Çalıştır & Çıktıyı Gör" else "Run Code & View Output"
                    },
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Console Output
        if (practicalTaskResult != null) {
            val res = practicalTaskResult
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = appColors.surfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = SolidColor(if (res.isSuccess) appColors.accentEmeraldBorder else appColors.accentRoseBorder)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(if (res.isSuccess) appColors.accentEmerald else appColors.accentRose)
                            )
                            Text(
                                text = if (res.isSuccess) "KONSOL ÇIKTISI" else "ÇALIŞTIRMA / DERLEME HATASI",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (res.isSuccess) appColors.accentEmeraldLight else appColors.accentRose
                            )
                        }

                        if (res.executionTimeMs > 0) {
                            Text(
                                text = "${res.executionTimeMs} ms",
                                fontSize = 10.sp,
                                fontFamily = FontFamily.Monospace,
                                color = appColors.textMuted
                            )
                        }
                    }

                    Text(
                        text = res.output,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace,
                        color = if (res.isSuccess) appColors.textPrimary else appColors.accentRose,
                        lineHeight = 17.sp
                    )

                    if (!res.isSuccess && res.error != null && res.error != res.output) {
                        Text(
                            text = "💡 ${res.error}",
                            fontSize = 11.sp,
                            color = appColors.accentAmber,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Hint & AI Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = onNextHint,
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.primarySubtleBorder))
            ) {
                Text("💡", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (currentHintStage == 0) {
                        if (isTr) "İpucu Al" else "Get Hint"
                    } else {
                        if (isTr) "Sıradaki İpucu ($currentHintStage/3)" else "Next Hint ($currentHintStage/3)"
                    },
                    fontSize = 11.sp,
                    color = appColors.primaryIndigoLight
                )
            }

            OutlinedButton(
                onClick = { onAskAi(practicalTaskCode) },
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.accentEmerald.copy(alpha = 0.4f)))
            ) {
                Text("🤖", fontSize = 11.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Text(if (isTr) "AI Desteği" else "AI Help", fontSize = 11.sp, color = appColors.accentEmeraldLight)
            }
        }

        // Active Hint Reveal
        if (currentHintStage > 0 && hintsList.isNotEmpty()) {
            val activeHint = hintsList.getOrNull(currentHintStage - 1) ?: hintsList.last()
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = appColors.accentAmberSubtle,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(appColors.accentAmberBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "💡 İpucu $currentHintStage:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = appColors.accentAmber
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = activeHint,
                        fontSize = 11.5.sp,
                        color = appColors.textPrimary,
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// METAPHOR DATA GENERATOR
// -------------------------------------------------------------------------------------------------

data class AnalogyInfo(
    val emoji: String,
    val headline: String,
    val story: String,
    val takeaway: String
)

private fun getChildFriendlyAnalogy(title: String, courseId: String, isTr: Boolean): AnalogyInfo {
    val low = title.lowercase()
    return when {
        low.contains("pointer") || low.contains("işaretçi") || low.contains("adres") || low.contains("bellek") -> {
            AnalogyInfo(
                emoji = "🗺️",
                headline = if (isTr) "Hazine Haritası ve Ev Adresi Benzetmesi" else "Treasure Map Metaphor",
                story = if (isTr) {
                    "Arkadaşına koca bir oyuncak dolabını sırtında taşıyıp götürmezsin değil mi? Sadece evinin adresini bir kağıda yazar verirsin. Arkadaşın o adrese gidip dolabın içindeki oyuncağı bulur.\n\nİşte 'İşaretçi (Pointer)' tam olarak budur: Verinin kendisini değil, bilgisayarın hafızasındaki adresini tutan küçük bir pusuladır."
                } else {
                    "Instead of carrying a giant toy box to your friend's house, you give them a piece of paper with your home address. They go there and find the toys.\nA pointer is just that: a small note containing the address in memory!"
                },
                takeaway = if (isTr) "Sonuç: Veriyi taşımak yerine adresini fısıldarız!" else "Takeaway: Share the address, not the heavy payload!"
            )
        }
        low.contains("değişken") || low.contains("variable") || low.contains("val") || low.contains("var") -> {
            AnalogyInfo(
                emoji = "📦",
                headline = if (isTr) "Etiketli Oyuncak Kutuları Benzetmesi" else "Labeled Toy Boxes Metaphor",
                story = if (isTr) {
                    "Odanı toplarken legolarını bir kutunun içine koyup üzerine 'Legolar' etiketi yapıştırdığını hayal et.\n\n• 'val' kutusu kilitli kumbaradır: İçine ne koyduysan hep öyle kalır, kimse değiştiremez.\n• 'var' kutusu ise kapağı açık kutudur: İstediğin zaman içindeki arabayı çıkarıp yerine top koyabilirsin."
                } else {
                    "Imagine putting toys in a box and sticking a name tag on it.\n• 'val' is a locked piggy bank: once placed, you cannot swap it.\n• 'var' is an open basket: you can replace the toy inside anytime!"
                },
                takeaway = if (isTr) "Sonuç: Kutunun içine ne koyarsan bilgisayar onu hatırlar!" else "Takeaway: Label your boxes and keep your room tidy!"
            )
        }
        low.contains("null") || low.contains("güvenlik") -> {
            AnalogyInfo(
                emoji = "🎁",
                headline = if (isTr) "Boş Hediye Paketi Benzetmesi" else "Empty Gift Box Metaphor",
                story = if (isTr) {
                    "Doğum gününde sana harika bir hediye kutusu geldiğini ama kapağını açtığında içinin bomboş olduğunu düşün. Elini daldırınca hiçbir şey bulamayıp şaşırırsın!\n\nProgramlamada 'null', bu boş kutudur. Kotlin, kutunun üzerine '?' işareti koyarak sana 'Dikkat et, bu kutunun içi boş olabilir!' uyarısı yapar."
                } else {
                    "Imagine receiving a shiny wrapped gift box, opening it, and finding nothing inside. That is 'null'.\nThe '?' symbol warns you before you reach inside!"
                },
                takeaway = if (isTr) "Sonuç: Boş kutulara önceden hazırlıklı oluruz, sürpriz yaşamayız!" else "Takeaway: Handle empty boxes safely before opening!"
            )
        }
        low.contains("koşul") || low.contains("if") || low.contains("else") || low.contains("karar") -> {
            AnalogyInfo(
                emoji = "🚦",
                headline = if (isTr) "Trafik Lambası ve Şemsiye Kuralı" else "Traffic Light & Umbrella Rule",
                story = if (isTr) {
                    "Sabah pencereden dışarı bakarsın: 'Eğer (if) hava yağmurluysa şemsiyemi alırım, yoksa (else) güneş gözlüğümü takarım.'\n\nBilgisayarlar da tıpkı senin gibi kararlar verir. Şart doğruysa bir yolu, yanlışsa diğer yolu seçer."
                } else {
                    "Look outside in the morning: 'If it rains, take an umbrella; else, wear sunglasses.'\nComputers make decisions the exact same way!"
                },
                takeaway = if (isTr) "Sonuç: Bilgisayar şartlara göre doğru yolu seçen akıllı bir yol ayrımıdır." else "Takeaway: Conditions guide the program down the right path."
            )
        }
        low.contains("döngü") || low.contains("loop") || low.contains("for") || low.contains("while") -> {
            AnalogyInfo(
                emoji = "🔁",
                headline = if (isTr) "Beden Dersinde Zıplama Sayacı Benzetmesi" else "Jumping Jacks Metaphor",
                story = if (isTr) {
                    "Öğretmenin sana '10 kere zıpla' dediğinde, her zıplayışında içinden 1, 2, 3... diye sayarsın ve 10 olunca durursun.\n\n'Döngüler' bilgisayarın zıplama sayacıdır. 'Şu işi 100 kere yap' dediğinde hiç sıkılmadan, yorulmadan ışık hızında 100 kere tekrarlar."
                } else {
                    "When asked to do 10 jumping jacks, you count 1, 2, 3... until 10.\nA loop does repetitive work at lightning speed without ever getting tired!"
                },
                takeaway = if (isTr) "Sonuç: Tekrar eden işleri tek komutla bilgisayara devrederiz!" else "Takeaway: Let the computer repeat boring chores instantly!"
            )
        }
        low.contains("fonksiyon") || low.contains("function") || low.contains("metot") -> {
            AnalogyInfo(
                emoji = "🍹",
                headline = if (isTr) "Sihirli Meyve Suyu Makinesi Benzetmesi" else "Magic Juice Blender Metaphor",
                story = if (isTr) {
                    "Mutfaktaki meyve sıkacağını düşün: İçine portakal atarsın (Girdi / Parametre), düğmesine basarsın (Çalıştırma) ve sana taptaze portakal suyu verir (Çıktı / Return).\n\nFonksiyonlar, istediğin zaman tekrar tekrar çalıştırabileceğin sihirli küçük makinelerdir."
                } else {
                    "Think of a juice blender: You put oranges in (Input), press the button, and delicious fresh juice comes out (Output).\nA function is a reusable magic machine!"
                },
                takeaway = if (isTr) "Sonuç: Bir kere tanımla, istediğin zaman düğmesine basıp çalıştır!" else "Takeaway: Define the recipe once, run it whenever you need!"
            )
        }
        low.contains("sınıf") || low.contains("class") || low.contains("nesne") || low.contains("object") -> {
            AnalogyInfo(
                emoji = "🍪",
                headline = if (isTr) "Kurabiye Kalıbı ve Kurabiyeler Benzetmesi" else "Cookie Cutter Metaphor",
                story = if (isTr) {
                    "Kurabiye kalıbını (Class) eline alırsın: Kalıp hamur değildir ama nasıl bir kurabiye çıkacağını belirler. O kalıbı hamura her bastığında yepyeni, lezzetli bir kurabiye (Object / Nesne) elde edersin.\n\nTek bir kalıpla istediğin kadar nesne üretebilirsin!"
                } else {
                    "A cookie cutter (Class) defines the shape. Every time you press it on the dough, you get an actual delicious cookie (Object)!"
                },
                takeaway = if (isTr) "Sonuç: Sınıf taslaktır, nesne ise o taslaktan doğan gerçek varlıktır." else "Takeaway: Class is the blueprint, object is the real thing."
            )
        }
        else -> {
            AnalogyInfo(
                emoji = "🧩",
                headline = if (isTr) "Lego Parçalarıyla İnşa Etme Mantığı" else "Building with Lego Bricks",
                story = if (isTr) {
                    "Büyük bir Lego kalesi yaparken her parçayı rastgele koymazsın. Önce sağlam temeli atar, sonra duvarları örer, en son bayrağı dikersin.\n\nProgramlama da böyledir: Her küçük kural, devasa harika uygulamaların birer Lego tuğlasıdır."
                } else {
                    "Building software is like building with Lego bricks: Step by step, pieces snap together to create wonderful creations!"
                },
                takeaway = if (isTr) "Sonuç: Adım adım ilerleyerek her şeyi kolayca yapabilirsin!" else "Takeaway: Every big app starts with simple small blocks!"
            )
        }
    }
}

private fun deriveExpectedOutput(title: String, task: String, lang: String): String {
    val lowTask = task.lowercase()
    val lowTitle = title.lowercase()
    return when {
        lowTask.contains("merhaba dünya") || lowTask.contains("hello world") -> "Merhaba Dünya"
        lowTask.contains("1'den 5'e") || lowTask.contains("1 2 3 4 5") -> "1\n2\n3\n4\n5"
        lowTask.contains("çift sayılar") -> "2\n4\n6\n8\n10"
        lowTask.contains("tek sayılar") -> "1\n3\n5\n7\n9"
        else -> ""
    }
}

private fun generateProgressiveHints(task: String, lang: String, isTr: Boolean): List<String> {
    return listOf(
        if (isTr) "Gerekli değişken veya fonksiyon yapısını dil kurallarına uygun oluşturduğundan emin ol."
        else "Make sure you declare variables or functions according to language syntax.",
        if (isTr) "Ekrana yazdırma komutunun (print, cout, println vb.) sözdizimini kontrol et."
        else "Check the print statement syntax (print, cout, println, etc.).",
        if (isTr) "Sonucu ekrana yazdırırken değişken ismini tırnak içerisine almadan doğrudan yazdır."
        else "Print the variable identifier directly without quotes around it."
    )
}

@Composable
private fun LockedContentCard(
    onUnlock: () -> Unit,
    isTr: Boolean,
    appColors: AppColors
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                Brush.horizontalGradient(
                    listOf(appColors.accentAmber.copy(alpha = 0.6f), appColors.primaryIndigo.copy(alpha = 0.6f))
                ),
                RoundedCornerShape(16.dp)
            )
            .testTag("premium_lock_card"),
        colors = CardDefaults.cardColors(containerColor = appColors.surface)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = appColors.accentAmberSubtle,
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(Icons.Outlined.Lock, contentDescription = null, tint = appColors.accentAmber, modifier = Modifier.size(24.dp))
                }
            }

            Text(
                text = if (isTr) "İleri Düzey PRO Konu" else "Advanced PRO Topic",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = appColors.textPrimary
            )

            Text(
                text = if (isTr) {
                    "Bu konu derinlemesine adım adım anlatımlar, canlı sandbox ve uygulamalı görevler içermektedir."
                } else {
                    "This topic contains in-depth step-by-step guides, live sandbox, and practical exercises."
                },
                fontSize = 12.sp,
                color = appColors.textSecondary,
                lineHeight = 17.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = onUnlock,
                colors = ButtonDefaults.buttonColors(containerColor = appColors.primaryIndigo),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .testTag("unlock_premium_btn")
            ) {
                Icon(Icons.Default.Star, contentDescription = null, tint = appColors.accentAmber, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(if (isTr) "PRO Üyeliğe Geç" else "Upgrade to PRO", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}

private fun getPracticalTaskStarterTemplate(courseId: String, lessonTitle: String, isTr: Boolean): String {
    val lang = courseId.lowercase()
    val comment = if (isTr) "Çözüm kodunuzu buraya yazın:" else "Write your solution here:"
    return when {
        lang.contains("kotlin") -> "// $lessonTitle\n// $comment\n\nfun main() {\n    \n}\n"
        lang.contains("python") -> "# $lessonTitle\n# $comment\n\n"
        lang.contains("javascript") || lang.contains("js") || lang.contains("typescript") || lang.contains("ts") -> "// $lessonTitle\n// $comment\n\n"
        lang.contains("c") || lang.contains("cpp") -> "// $lessonTitle\n// $comment\n#include <iostream>\n\nint main() {\n    \n    return 0;\n}\n"
        lang.contains("java") -> "// $lessonTitle\npublic class Solution {\n    public static void main(String[] args) {\n        // $comment\n    }\n}\n"
        lang.contains("dart") || lang.contains("flutter") -> "// $lessonTitle\nvoid main() {\n    // $comment\n}\n"
        lang.contains("go") -> "// $lessonTitle\npackage main\n\nimport \"fmt\"\n\nfunc main() {\n    // $comment\n}\n"
        lang.contains("csharp") || lang.contains("cs") -> "// $lessonTitle\nusing System;\n\nclass Program {\n    static void Main() {\n        // $comment\n    }\n}\n"
        lang.contains("swift") -> "// $lessonTitle\nimport Foundation\n\n// $comment\n"
        lang.contains("php") -> "<?php\n// $lessonTitle\n// $comment\n"
        lang.contains("ruby") -> "# $lessonTitle\n# $comment\n"
        lang.contains("rust") -> "// $lessonTitle\nfn main() {\n    // $comment\n}\n"
        lang.contains("sql") -> "-- $lessonTitle\n-- $comment\n"
        lang.contains("html") -> "<!-- $lessonTitle - $comment -->\n"
        lang.contains("css") -> "/* $lessonTitle - $comment */\n"
        else -> "// $lessonTitle\n// $comment\n"
    }
}
