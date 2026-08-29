package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.engine.CodeExecutionEngine
import com.example.model.*
import com.example.ui.components.CodeEditorComponent
import com.example.ui.components.SyntaxHighlightedCode
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel
import kotlinx.coroutines.launch

/**
 * Coddy-Inspired Modern Interactive Single-Flow Lesson Experience
 * Cycle: Read -> View Code -> Understand Logic -> Mini Check -> Hands-On Code -> Console Output -> Reinforce
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

    val isInitiallyCompleted = remember(lesson.id, allProgress) {
        allProgress.any { it.lessonId == lesson.id && it.status == LessonStatus.COMPLETED.name }
    }
    var isLessonCompleted by remember(lesson.id, isInitiallyCompleted) { mutableStateOf(isInitiallyCompleted) }

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
    var isPracticalTaskPassed by remember(lesson.id, allProgress) {
        mutableStateOf(allProgress.any { it.lessonId == lesson.id && it.codingChallengeCompleted })
    }

    // Aşamalı İpucu Sistemi (Progressive Hints)
    var currentHintStage by remember(lesson.id) { mutableStateOf(0) }
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

    val listState = rememberLazyListState()

    LaunchedEffect(lesson.id) {
        miniQuestionSelectedOption = null
        isMiniQuestionChecked = false
        currentHintStage = 0
        isSolutionRevealed = false
        practicalTaskResult = null
        isPracticalTaskRunning = false
        listState.scrollToItem(0)
    }

    val allLessons = remember(lesson.courseId) { CourseCatalog.getLessonsForCourse(lesson.courseId) }
    val currentIdx = remember(lesson, allLessons) { allLessons.indexOfFirst { it.id == lesson.id } }
    val prevLesson = remember(currentIdx, allLessons) {
        if (currentIdx > 0) allLessons[currentIdx - 1] else null
    }
    val nextLesson = remember(currentIdx, allLessons) {
        if (currentIdx != -1 && currentIdx < allLessons.size - 1) allLessons[currentIdx + 1] else null
    }

    val courseProgressPercent = remember(allLessons, allProgress) {
        if (allLessons.isEmpty()) 0 else {
            val completedCount = allLessons.count { l ->
                allProgress.any { it.lessonId == l.id && it.status == LessonStatus.COMPLETED.name }
            }
            (completedCount * 100) / allLessons.size
        }
    }

    val isLocked = lesson.isPremium && !userProfile.isPremium

    // Expected Output derivation for the lesson's practical task
    val expectedOutputSnippet = remember(lesson.id, lesson.courseId) {
        deriveExpectedOutput(lesson.title, lesson.practicalTask ?: "", lesson.courseId)
    }

    Scaffold(
        topBar = {
            Surface(
                color = DarkBg,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = onBack, modifier = Modifier.testTag("back_button")) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Geri", tint = TextPrimary)
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = "${lesson.courseId.uppercase()} • ${currentIdx + 1}/${allLessons.size}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryIndigoLight
                            )
                            Text(
                                text = lesson.title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary,
                                maxLines = 1
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                            IconButton(
                                onClick = { viewModel.openAiAssistant(lesson = lesson) },
                                modifier = Modifier.testTag("lesson_open_ai_btn")
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = PrimarySubtle,
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("🤖", fontSize = 15.sp)
                                    }
                                }
                            }

                            IconButton(
                                onClick = { viewModel.openNoteDialog(lesson) },
                                modifier = Modifier.testTag("add_note_btn")
                            ) {
                                Icon(Icons.Default.EditNote, contentDescription = "Not Ekle", tint = PrimaryIndigoLight)
                            }
                        }
                    }

                    // Thin Top Progress Bar
                    LinearProgressIndicator(
                        progress = { (courseProgressPercent / 100f).coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.5.dp),
                        color = PrimaryIndigo,
                        trackColor = DarkCardBorder
                    )
                }
            }
        },
        bottomBar = {
            Surface(
                color = DarkSurface,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (prevLesson != null) {
                        OutlinedButton(
                            onClick = { onNextLesson(prevLesson) },
                            modifier = Modifier
                                .weight(1f)
                                .height(44.dp)
                                .testTag("bottom_prev_lesson_btn"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(if (isTr) "Önceki" else "Previous", fontSize = 12.sp, color = TextPrimary)
                        }
                    }

                    Button(
                        onClick = {
                            isLessonCompleted = true
                            viewModel.markLessonComplete(lesson)
                            if (nextLesson != null) {
                                onNextLesson(nextLesson)
                            }
                        },
                        modifier = Modifier
                            .weight(if (prevLesson != null) 1.4f else 1f)
                            .height(44.dp)
                            .testTag("bottom_complete_next_btn"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isLessonCompleted) AccentEmerald else PrimaryIndigo
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (nextLesson != null) {
                                if (isTr) "Tamamla & Sonraki →" else "Complete & Next →"
                            } else {
                                if (isTr) "Dersi Bitir ✓" else "Finish Lesson ✓"
                            },
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        },
        containerColor = DarkBg
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            // Responsive width container for tablet and mobile
            val contentWidth = if (maxWidth > 680.dp) 640.dp else maxWidth

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .width(contentWidth)
                    .fillMaxHeight()
                    .padding(horizontal = 14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp)
            ) {
                // 1. DERS BAŞLIĞI & KISA GİRİŞ
                item {
                    LessonHeaderCard(
                        lesson = lesson,
                        isTr = isTr,
                        isLocked = isLocked,
                        userIsPremium = userProfile.isPremium
                    )
                }

                // 2. KİLİTLİ PRO İÇERİK BANNERI (Eğer Kilitliyse)
                if (isLocked) {
                    item {
                        LockedContentCard(
                            onUnlock = { viewModel.activatePremiumPlan() },
                            isTr = isTr
                        )
                    }
                } else {
                    // 3. KAVRAMLAR & ADIM ADIM AKIŞ (Konu Anlatımı -> Küçük Kod -> Açıklama -> İpucu)
                    items(lesson.detailedExplanation.size) { idx ->
                        val block = lesson.detailedExplanation[idx]
                        ConceptBlockCard(
                            blockIndex = idx + 1,
                            totalBlocks = lesson.detailedExplanation.size,
                            block = block,
                            courseId = lesson.courseId,
                            isTr = isTr,
                            onAskAi = { sentence ->
                                viewModel.openAiAssistant(
                                    lesson = lesson,
                                    initialShortcut = AiShortcut.EXPLAIN_SENTENCE,
                                    targetSentence = sentence
                                )
                            }
                        )
                    }

                    // 4. "NASIL ÇALIŞIYOR?" / MANTIK GÖRSELLEŞTİRMESİ
                    item {
                        HowItWorksCard(
                            lesson = lesson,
                            isTr = isTr
                        )
                    }

                    // 5. MİNİ KONTROL SORUSU (Ders Ortası Hızlı Pekiştirme)
                    if (lesson.miniQuestion != null) {
                        item {
                            MiniCheckQuestionCard(
                                miniQ = lesson.miniQuestion,
                                courseId = lesson.courseId,
                                isTr = isTr,
                                selectedOption = miniQuestionSelectedOption,
                                isChecked = isMiniQuestionChecked,
                                onSelectOption = { miniQuestionSelectedOption = it },
                                onCheckAnswer = { isMiniQuestionChecked = true }
                            )
                        }
                    }

                    // 6. UYGULAMALI GÖREV & ENTEGRE KOD EDİTÖRÜ & CONSOLE
                    if (!lesson.practicalTask.isNullOrBlank()) {
                        item {
                            InteractiveExerciseCard(
                                lesson = lesson,
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

                                        // Persist to Room ExerciseAttempt
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
                                            "Uygulamalı Görev: ${lesson.practicalTask}\nYazdığım Kod:\n```${lesson.courseId}\n$code\n```\nLütfen yazdığım kodu kontrol et. Doğrudan tam cevabı vermeden hatamı anlamam için ipucu ver."
                                        } else {
                                            "Practical Task: ${lesson.practicalTask}\nMy Code:\n```${lesson.courseId}\n$code\n```\nPlease check my code and provide guidance without giving the direct answer."
                                        }
                                    )
                                }
                            )
                        }
                    }

                    // 7. GERÇEK DÜNYA & MİMARİ NOTLARI (Opsiyonel Bilgi)
                    if (!lesson.realWorldExample.isNullOrBlank()) {
                        item {
                            RealWorldArchitectureCard(
                                example = lesson.realWorldExample,
                                isTr = isTr
                            )
                        }
                    }

                    // 8. DERSİ TAMAMLA & SIRADAKİ ADIMLAR KARTI
                    item {
                        LessonCompletionSummaryCard(
                            lesson = lesson,
                            isCompleted = isLessonCompleted,
                            isTr = isTr,
                            onCompleteLesson = {
                                isLessonCompleted = true
                                viewModel.markLessonComplete(lesson)
                                Toast.makeText(
                                    context,
                                    if (isTr) "Tebrikler! Ders tamamlandı (+20 XP)" else "Lesson completed (+20 XP)",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            nextLesson = nextLesson,
                            onNextLesson = onNextLesson
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// UI KOMPONENTLERİ: ŞIK, MODER VE AKICI DERS ELEMANLARI
// -------------------------------------------------------------------------------------------------

@Composable
private fun LessonHeaderCard(
    lesson: Lesson,
    isTr: Boolean,
    isLocked: Boolean,
    userIsPremium: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = PrimaryIndigo.copy(alpha = 0.18f)
                ) {
                    Text(
                        text = lesson.level.displayName,
                        color = PrimaryIndigoLight,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "⏱ 6-8 dk",
                        fontSize = 11.sp,
                        color = TextMuted,
                        fontWeight = FontWeight.Medium
                    )

                    if (isLocked) {
                        Surface(shape = RoundedCornerShape(6.dp), color = AccentAmberSubtle) {
                            Text(
                                text = "🔒 PRO",
                                color = AccentAmber,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    } else {
                        Surface(shape = RoundedCornerShape(6.dp), color = AccentEmeraldSubtle) {
                            Text(
                                text = "✓ Aktif",
                                color = AccentEmeraldLight,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = lesson.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = lesson.shortDesc,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 19.sp
            )
        }
    }
}

@Composable
private fun ConceptBlockCard(
    blockIndex: Int,
    totalBlocks: Int,
    block: LessonContentBlock,
    courseId: String,
    isTr: Boolean,
    onAskAi: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Başlık & AI Açıkla Butonu
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(22.dp)
                            .clip(CircleShape)
                            .background(PrimaryIndigo.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$blockIndex",
                            color = PrimaryIndigoLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = block.subtitle,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = PrimarySubtle,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onAskAi("${block.subtitle}: ${block.body}") }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text("🤖", fontSize = 11.sp)
                        Text(
                            text = if (isTr) "AI Açıkla" else "Explain",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigoLight
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Kısa, öz ve anlaşılır konu anlatımı
            Text(
                text = block.body,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 20.sp
            )

            // Küçük Kod Parçası (Varsa)
            if (block.codeSnippet != null && block.codeSnippet.isNotBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                SyntaxHighlightedCode(
                    code = block.codeSnippet,
                    language = courseId,
                    showLineNumbers = block.codeSnippet.lines().size > 1
                )

                // Otomatik Satır / Kod Çözümlemesi
                CodeBreakdownHelper(code = block.codeSnippet, courseId = courseId, isTr = isTr)
            }

            // Görsel Bilgi / İpucu Kutusu
            if (block.tip != null && block.tip.isNotBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = AccentAmberSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("💡", fontSize = 14.sp)
                        Text(
                            text = block.tip,
                            fontSize = 12.sp,
                            color = AccentAmber,
                            lineHeight = 17.sp
                        )
                    }
                }
            }
        }
    }
}

/**
 * Kod satırının kritik kısımlarını gösteren sade açıklama kartı
 */
@Composable
private fun CodeBreakdownHelper(code: String, courseId: String, isTr: Boolean) {
    val firstLine = code.lines().firstOrNull { it.trim().isNotEmpty() && !it.trim().startsWith("//") && !it.trim().startsWith("#") } ?: return
    val breakdown = parseCodeLineBreakdown(firstLine, courseId, isTr) ?: return

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = DarkSurfaceVariant,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(
                text = if (isTr) "🔍 Kod Çözümlemesi:" else "🔍 Code Breakdown:",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryIndigoLight
            )
            breakdown.forEach { (keyword, desc) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = keyword,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        color = AccentEmeraldLight
                    )
                    Text("→", fontSize = 11.sp, color = TextMuted)
                    Text(
                        text = desc,
                        fontSize = 11.sp,
                        color = TextSecondary
                    )
                }
            }
        }
    }
}

private fun parseCodeLineBreakdown(line: String, lang: String, isTr: Boolean): List<Pair<String, String>>? {
    val clean = line.trim()
    return when {
        clean.startsWith("int ") || clean.startsWith("val ") || clean.startsWith("let ") || clean.startsWith("var ") -> {
            val parts = clean.split("=", " ", ";").filter { it.isNotBlank() }
            if (parts.size >= 2) {
                listOf(
                    parts[0] to if (isTr) "Tür / Değişken anahtarı" else "Type / Declaration keyword",
                    parts[1] to if (isTr) "Değişken ismi" else "Variable identifier",
                    if (parts.size > 2) parts.last() to if (isTr) "Atanan başlangıç değeri" else "Assigned value" else "" to ""
                ).filter { it.first.isNotBlank() }
            } else null
        }
        clean.contains("cout") || clean.contains("println") || clean.contains("print") || clean.contains("console.log") -> {
            listOf(
                (if (clean.contains("cout")) "cout" else "print") to if (isTr) "Ekrana yazdırma komutu" else "Output print command",
                "<<" to if (isTr) "Veri akış operatörü" else "Stream redirection operator"
            )
        }
        else -> null
    }
}

@Composable
private fun HowItWorksCard(lesson: Lesson, isTr: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("🧩", fontSize = 16.sp)
                Text(
                    text = if (isTr) "Nasıl Çalışıyor? (Mantık & Bellek)" else "How It Works? (Memory & Flow)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                color = DarkBg,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = generateMemoryVisualizer(lesson.title, lesson.courseId, isTr),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = TextPrimary,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

private fun generateMemoryVisualizer(title: String, courseId: String, isTr: Boolean): String {
    val lowTitle = title.lowercase()
    return when {
        lowTitle.contains("pointer") || lowTitle.contains("işaretçi") || lowTitle.contains("adres") -> {
            """
            sayi (Bellek Bloğu)
             ↓
            [  10  ]  ← 0x7ffd9a (Adres)

            ptr (İşaretçi Değişkeni)
             ↓
            [ 0x7ffd9a ] ──→ sayi'nin değerini okur (*ptr)
            """.trimIndent()
        }
        lowTitle.contains("değişken") || lowTitle.contains("variable") || lowTitle.contains("veri") -> {
            """
            RAM (Bellek)
            ┌──────────────┬──────────────┐
            │ İsim: yas    │ Değer: 25    │
            │ Tür: int (4B)│ Adres: 0x10A │
            └──────────────┴──────────────┘
            → Kod 'yas' dediğinde doğrudan 25 okunur.
            """.trimIndent()
        }
        lowTitle.contains("döngü") || lowTitle.contains("loop") || lowTitle.contains("for") || lowTitle.contains("while") -> {
            """
            Başlangıç (i = 0)
                   │
                   ▼
            [ Koşul: i < 5 ? ] ──(Hayır)──→ [ Döngüden Çık ]
                   │ (Evet)
                   ▼
            [ Gövdeyi Çalıştır ] ──→ [ i++ ] ──→ Tekrar Kontrol Et
            """.trimIndent()
        }
        lowTitle.contains("koşul") || lowTitle.contains("if") || lowTitle.contains("karar") -> {
            """
            Giriş Değeri
                 │
                 ▼
            < Şart Doğru mu? >
             ├─ (DOĞRU)  ──→ [ if Bloğu Çalışır ]
             └─ (YANLIŞ) ──→ [ else Bloğu Çalışır ]
            """.trimIndent()
        }
        else -> {
            """
            Girdi / Kod
               │
               ▼
            [ 1. Satır: Tanımlama ]
               │
               ▼
            [ 2. Satır: İşlem & Mantık ]
               │
               ▼
            [ 3. Satır: Çıktı / Terminal ]
            """.trimIndent()
        }
    }
}

@Composable
private fun MiniCheckQuestionCard(
    miniQ: MiniQuestion,
    courseId: String,
    isTr: Boolean,
    selectedOption: Int?,
    isChecked: Boolean,
    onSelectOption: (Int) -> Unit,
    onCheckAnswer: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("🎯", fontSize = 16.sp)
                Text(
                    text = if (isTr) "Mini Kontrol Sorusu" else "Quick Check",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryIndigoLight
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = miniQ.question,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                lineHeight = 18.sp
            )

            if (miniQ.codeSnippet != null && miniQ.codeSnippet.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                SyntaxHighlightedCode(
                    code = miniQ.codeSnippet,
                    language = courseId,
                    showLineNumbers = false
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            miniQ.options.forEachIndexed { optIdx, optText ->
                val isSelected = selectedOption == optIdx
                val isCorrect = optIdx == miniQ.correctIndex

                val borderColor = when {
                    !isChecked -> if (isSelected) PrimaryIndigo else DarkCardBorder
                    isCorrect -> AccentEmerald
                    isSelected -> AccentRose
                    else -> DarkCardBorder
                }

                val bgColor = when {
                    !isChecked -> if (isSelected) PrimarySubtle else DarkSurfaceVariant
                    isCorrect -> AccentEmeraldSubtle
                    isSelected -> AccentRoseSubtle
                    else -> DarkSurfaceVariant
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(bgColor)
                        .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                        .clickable(enabled = !isChecked) { onSelectOption(optIdx) }
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = optText,
                        fontSize = 12.sp,
                        color = TextPrimary
                    )

                    if (isChecked) {
                        if (isCorrect) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmerald, modifier = Modifier.size(16.dp))
                        } else if (isSelected) {
                            Icon(Icons.Default.Cancel, contentDescription = null, tint = AccentRose, modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (!isChecked) {
                Button(
                    onClick = onCheckAnswer,
                    enabled = selectedOption != null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                        .testTag("check_mini_q_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(if (isTr) "Cevabı Kontrol Et" else "Check Answer", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            } else {
                val isCorrect = selectedOption == miniQ.correctIndex
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isCorrect) AccentEmeraldSubtle else AccentRoseSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = SolidColor(if (isCorrect) AccentEmeraldBorder else AccentRoseBorder)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (isCorrect) {
                            "✓ ${if (isTr) "Harika! Doğru anladın." else "Great! You got it right."} ${miniQ.explanation}"
                        } else {
                            "💡 ${miniQ.explanation}"
                        },
                        color = if (isCorrect) AccentEmeraldLight else AccentRose,
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun InteractiveExerciseCard(
    lesson: Lesson,
    practicalTaskCode: String,
    onCodeChange: (String) -> Unit,
    expectedOutput: String,
    practicalTaskResult: ExecutionResult?,
    isRunning: Boolean,
    isPassed: Boolean,
    currentHintStage: Int,
    isSolutionRevealed: Boolean,
    isTr: Boolean,
    onRunCode: () -> Unit,
    onResetCode: () -> Unit,
    onNextHint: () -> Unit,
    onRevealSolution: () -> Unit,
    onAskAi: (String) -> Unit
) {
    val hintsList = remember(lesson.id, lesson.practicalTask) {
        generateProgressiveHints(lesson.practicalTask ?: "", lesson.courseId, isTr)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                if (isPassed) AccentEmerald.copy(alpha = 0.8f) else DarkCardBorder,
                RoundedCornerShape(16.dp)
            )
            .testTag("lesson_practical_task_card"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Başlık & XP Rozeti
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("🛠️", fontSize = 18.sp)
                    Column {
                        Text(
                            text = if (isTr) "Uygulamalı Görev" else "Hands-On Exercise",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentEmeraldLight
                        )
                        Text(
                            text = if (isTr) "Kodu yaz, çalıştır ve çıktısını gör" else "Write code, run and see output",
                            fontSize = 11.sp,
                            color = TextMuted
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isPassed) AccentEmerald.copy(alpha = 0.2f) else AccentAmber.copy(alpha = 0.2f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        if (isPassed) {
                            Text("✓ Tamamlandı", color = AccentEmerald, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        } else {
                            Text("+20 XP", color = AccentAmber, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Görev Yönergesi Kutusu
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = DarkSurfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = if (isTr) "GÖREV:" else "TASK:",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigoLight,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = lesson.practicalTask ?: "",
                        fontSize = 13.sp,
                        color = TextPrimary,
                        lineHeight = 19.sp
                    )
                }
            }

            // Beklenen Çıktı Kutusu (Expected Output)
            if (expectedOutput.isNotBlank()) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = DarkBg,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text("🎯", fontSize = 12.sp)
                            Text(
                                text = if (isTr) "Beklenen Çıktı:" else "Expected Output:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextMuted
                            )
                        }
                        Text(
                            text = expectedOutput,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentEmeraldLight
                        )
                    }
                }
            }

            // Gömülü Kod Editörü
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

            // ▶ Çalıştır & Test Et Butonu
            Button(
                onClick = onRunCode,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .testTag("verify_practical_task_btn"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPassed) AccentEmerald else PrimaryIndigo,
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

            // Terminal / Console Çıktısı
            if (practicalTaskResult != null) {
                val res = practicalTaskResult
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = DarkBg,
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = SolidColor(if (res.isSuccess) AccentEmeraldBorder else AccentRoseBorder)
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
                                        .background(if (res.isSuccess) AccentEmerald else AccentRose)
                                )
                                Text(
                                    text = if (res.isSuccess) "KONSOL ÇIKTISI" else "ÇALIŞTIRMA / DERLEME HATASI",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (res.isSuccess) AccentEmeraldLight else AccentRose
                                )
                            }

                            if (res.executionTimeMs > 0) {
                                Text(
                                    text = "${res.executionTimeMs} ms",
                                    fontSize = 10.sp,
                                    fontFamily = FontFamily.Monospace,
                                    color = TextMuted
                                )
                            }
                        }

                        Text(
                            text = res.output,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Monospace,
                            color = if (res.isSuccess) TextPrimary else AccentRose,
                            lineHeight = 17.sp
                        )

                        if (!res.isSuccess && res.error != null && res.error != res.output) {
                            Text(
                                text = "💡 ${res.error}",
                                fontSize = 11.sp,
                                color = AccentAmber,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }

            // Başarılı Görev İnline Kartı
            if (isPassed) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = AccentEmeraldSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentEmeraldBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmerald, modifier = Modifier.size(20.dp))
                        Column {
                            Text(
                                text = if (isTr) "Tebrikler! Görev tamamlandı." else "Congratulations! Task completed.",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = AccentEmeraldLight
                            )
                            Text(
                                text = if (isTr) "Doğru çıktıyı başarıyla elde ettin." else "You successfully produced the right output.",
                                fontSize = 11.sp,
                                color = TextSecondary
                            )
                        }
                    }
                }
            }

            // Aşamalı İpucu ve Çözüm Butonları
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
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
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
                        color = PrimaryIndigoLight
                    )
                }

                OutlinedButton(
                    onClick = { onAskAi(practicalTaskCode) },
                    modifier = Modifier
                        .weight(1f)
                        .height(36.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentEmerald.copy(alpha = 0.4f)))
                ) {
                    Text("🤖", fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(if (isTr) "AI Desteği" else "AI Help", fontSize = 11.sp, color = AccentEmeraldLight)
                }
            }

            // Aşamalı İpucu Gösterimi
            if (currentHintStage > 0 && hintsList.isNotEmpty()) {
                val activeHint = hintsList.getOrNull(currentHintStage - 1) ?: hintsList.last()
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = AccentAmberSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "💡 İpucu $currentHintStage:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentAmber
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = activeHint,
                            fontSize = 11.sp,
                            color = TextPrimary,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

private fun deriveExpectedOutput(title: String, task: String, lang: String): String {
    val lowTask = task.lowercase()
    val lowTitle = title.lowercase()
    return when {
        lowTask.contains("merhaba") || lowTask.contains("hello") -> "Merhaba Dünya"
        lowTask.contains("25") || lowTitle.contains("değişken") -> "25"
        lowTask.contains("1'den 5'e") || lowTask.contains("1 2 3 4 5") -> "1\n2\n3\n4\n5"
        lowTask.contains("çift sayılar") -> "2\n4\n6\n8\n10"
        lowTask.contains("toplam") || lowTask.contains("sum") -> "15"
        lowTask.contains("kare") -> "100"
        else -> "Başarılı Çıktı"
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
private fun RealWorldArchitectureCard(example: String, isTr: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text("🌍", fontSize = 16.sp)
                Text(
                    text = if (isTr) "Gerçek Dünya Mimarisi & Kullanım Alanı" else "Real-World Architecture & Use Case",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = example,
                fontSize = 12.sp,
                color = TextSecondary,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
private fun LessonCompletionSummaryCard(
    lesson: Lesson,
    isCompleted: Boolean,
    isTr: Boolean,
    onCompleteLesson: () -> Unit,
    nextLesson: Lesson?,
    onNextLesson: (Lesson) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = if (isTr) "Ders Tamamlama & İlerleme" else "Lesson Completion & Progress",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Button(
                onClick = onCompleteLesson,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .testTag("complete_lesson_btn"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isCompleted) AccentEmerald else PrimaryIndigo
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (isCompleted) {
                        if (isTr) "Ders Tamamlandı (+20 XP)" else "Lesson Completed (+20 XP)"
                    } else {
                        if (isTr) "Konuyu Tamamla Olarak İşaretle" else "Mark Topic as Completed"
                    },
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.White
                )
            }

            if (nextLesson != null) {
                OutlinedButton(
                    onClick = { onNextLesson(nextLesson) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .testTag("next_lesson_btn"),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = if (isTr) "Sonraki Konu: ${nextLesson.title} →" else "Next Topic: ${nextLesson.title} →",
                        fontSize = 12.sp,
                        color = PrimaryIndigoLight
                    )
                }
            }
        }
    }
}

@Composable
private fun LockedContentCard(onUnlock: () -> Unit, isTr: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                androidx.compose.ui.graphics.Brush.horizontalGradient(
                    listOf(AccentAmber.copy(alpha = 0.6f), PrimaryIndigo.copy(alpha = 0.6f))
                ),
                RoundedCornerShape(16.dp)
            )
            .testTag("premium_lock_card"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = AccentAmberSubtle,
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(Icons.Outlined.Lock, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(24.dp))
                }
            }

            Text(
                text = if (isTr) "İleri Düzey PRO Konu" else "Advanced PRO Topic",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Text(
                text = if (isTr) {
                    "Bu konu derinlemesine adım adım anlatımlar, canlı sandbox ve uygulamalı görevler içermektedir."
                } else {
                    "This topic contains in-depth step-by-step guides, live sandbox, and practical exercises."
                },
                fontSize = 12.sp,
                color = TextSecondary,
                lineHeight = 17.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = onUnlock,
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp)
                    .testTag("unlock_premium_btn")
            ) {
                Icon(Icons.Default.Star, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(16.dp))
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
