package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.AiShortcut
import com.example.model.Lesson
import com.example.ui.components.SyntaxHighlightedCode
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@Composable
fun LessonDetailScreen(
    viewModel: MainViewModel,
    lesson: Lesson,
    onBack: () -> Unit,
    onStartQuiz: () -> Unit,
    onStartCodingChallenge: () -> Unit,
    onNextLesson: (Lesson) -> Unit
) {
    val allProgress by viewModel.allProgress.collectAsState()
    val isInitiallyCompleted = remember(lesson.id, allProgress) {
        allProgress.any { it.lessonId == lesson.id && it.status == com.example.model.LessonStatus.COMPLETED.name }
    }
    var isLessonCompleted by remember(lesson.id, isInitiallyCompleted) { mutableStateOf(isInitiallyCompleted) }
    var miniQuestionSelectedOption by remember(lesson.id) { mutableStateOf<Int?>(null) }
    var isMiniQuestionChecked by remember(lesson.id) { mutableStateOf(false) }
    var expandedQaIndex by remember(lesson.id) { mutableStateOf<Int?>(null) }

    LaunchedEffect(lesson.id) {
        miniQuestionSelectedOption = null
        isMiniQuestionChecked = false
        expandedQaIndex = null
    }

    val userProfile by viewModel.userProfile.collectAsState()

    val allLessons = remember(lesson.courseId) { CourseCatalog.getLessonsForCourse(lesson.courseId) }
    val nextLesson = remember(lesson) {
        val idx = allLessons.indexOfFirst { it.id == lesson.id }
        if (idx != -1 && idx < allLessons.size - 1) allLessons[idx + 1] else null
    }

    val isLocked = lesson.isPremium && !userProfile.isPremium

    Scaffold(
        topBar = {
            Surface(
                color = DarkBg,
                modifier = Modifier.fillMaxWidth().statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("back_button")) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri", tint = TextPrimary)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = lesson.courseId.uppercase(),
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

                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
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
                                    Text("🤖", fontSize = 16.sp)
                                }
                            }
                        }

                        IconButton(
                            onClick = {
                                viewModel.toggleFavorite(
                                    id = "fav_${lesson.id}",
                                    type = "LESSON",
                                    courseId = lesson.courseId,
                                    title = lesson.title,
                                    subtitle = lesson.shortDesc,
                                    currentFav = false
                                )
                            },
                            modifier = Modifier.testTag("favorite_lesson_btn")
                        ) {
                            Icon(Icons.Outlined.BookmarkBorder, contentDescription = "Favori", tint = TextSecondary)
                        }

                        IconButton(
                            onClick = { viewModel.openNoteDialog(lesson) },
                            modifier = Modifier.testTag("add_note_btn")
                        ) {
                            Icon(Icons.Default.EditNote, contentDescription = "Not Ekle", tint = PrimaryIndigoLight)
                        }
                    }
                }
            }
        },
        bottomBar = {
            Surface(
                color = DarkSurface,
                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder)),
                modifier = Modifier.fillMaxWidth().navigationBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (lesson.codingChallenge != null) {
                        OutlinedButton(
                            onClick = onStartCodingChallenge,
                            modifier = Modifier.weight(1f).height(46.dp).testTag("bottom_code_challenge_btn"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Default.Terminal, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Kod Yaz", fontSize = 12.sp, color = TextPrimary)
                        }
                    }

                    Button(
                        onClick = onStartQuiz,
                        modifier = Modifier.weight(1.2f).height(46.dp).testTag("bottom_quiz_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Psychology, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Quiz'e Başla", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        },
        containerColor = DarkBg
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(top = 10.dp, bottom = 24.dp)
        ) {
            // 1. Topic Title & Short Intro
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .border(1.dp, DarkCardBorder, RoundedCornerShape(18.dp)),
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
                                color = PrimaryIndigo.copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = lesson.level.displayName,
                                    color = PrimaryIndigoLight,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }

                            if (!lesson.isPremium) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = AccentEmeraldSubtle
                                ) {
                                    Text(
                                        text = "🟢 Ücretsiz Konu",
                                        color = AccentEmeraldLight,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            } else {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = AccentAmberSubtle
                                ) {
                                    Text(
                                        text = if (userProfile.isPremium) "✨ PRO Açık" else "🔒 PRO Konu",
                                        color = AccentAmber,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
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

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = lesson.shortDesc,
                            fontSize = 13.sp,
                            color = TextSecondary,
                            lineHeight = 19.sp
                        )
                    }
                }
            }

            // 2. Learning Objectives & Subtopics (Always visible for curriculum transparency)
            if (lesson.learningObjectives.isNotEmpty() || lesson.subtopics.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            // Learning Objectives
                            if (lesson.learningObjectives.isNotEmpty()) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Text("🎯", fontSize = 14.sp)
                                        Text("Öğrenme Hedefleri", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    lesson.learningObjectives.forEach { obj ->
                                        Row(
                                            verticalAlignment = Alignment.Top,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                                            modifier = Modifier.padding(vertical = 2.dp)
                                        ) {
                                            Text("✓", color = AccentEmerald, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                            Text(obj, fontSize = 12.sp, color = TextPrimary, lineHeight = 16.sp)
                                        }
                                    }
                                }
                            }

                            // Subtopics
                            if (lesson.subtopics.isNotEmpty()) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Text("📑", fontSize = 14.sp)
                                        Text("Alt Konular & Müfredat Akışı", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = PrimaryIndigoLight)
                                    }
                                    Spacer(modifier = Modifier.height(6.dp))
                                    lesson.subtopics.forEachIndexed { i, sub ->
                                        Text(
                                            text = "${i + 1}. $sub",
                                            fontSize = 12.sp,
                                            color = TextSecondary,
                                            modifier = Modifier.padding(vertical = 1.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 3. Locked Premium Paywall Banner (if content is locked)
            if (isLocked) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .border(
                                1.dp,
                                androidx.compose.ui.graphics.Brush.horizontalGradient(
                                    listOf(AccentAmber.copy(alpha = 0.6f), PrimaryIndigo.copy(alpha = 0.6f))
                                ),
                                RoundedCornerShape(18.dp)
                            )
                            .testTag("premium_lock_card"),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = AccentAmberSubtle,
                                modifier = Modifier.size(52.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(Icons.Outlined.Lock, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(28.dp))
                                }
                            }

                            Text(
                                text = "İleri Düzey PRO Müfredat",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )

                            Text(
                                text = "Her kursta başlangıç seviyesindeki ilk 3 konu ücretsizdir. Bu ileri düzey konu derinlemesine adım adım anlatımlar, gerçek dünya mimarisi, canlı sandbox ve konu sonu mini projeleri içermektedir.",
                                fontSize = 13.sp,
                                color = TextSecondary,
                                lineHeight = 18.sp,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )

                            Button(
                                onClick = { viewModel.activatePremiumPlan() },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.fillMaxWidth().height(46.dp).testTag("unlock_premium_btn")
                            ) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("✨ Tüm Müfredatın Kilidini Aç (PRO)", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }
                        }
                    }
                }
            } else {
                // UNLOCKED CONTENT

                // AI Assistant In-Lesson Banner with 4 Ready Shortcuts
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .border(
                                1.dp,
                                androidx.compose.ui.graphics.Brush.horizontalGradient(
                                    listOf(PrimaryIndigo.copy(alpha = 0.6f), DarkCardBorder)
                                ),
                                RoundedCornerShape(18.dp)
                            )
                            .testTag("lesson_ai_assistant_banner"),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text("🤖", fontSize = 22.sp)
                                    Column {
                                        Text(
                                            text = "Anlamadığın Bir Yer Mi Var?",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = TextPrimary
                                        )
                                        Text(
                                            text = "Yapay Zeka bu konu için hazır bekliyor",
                                            fontSize = 11.sp,
                                            color = TextSecondary
                                        )
                                    }
                                }

                                TextButton(
                                    onClick = { viewModel.openAiAssistant(lesson = lesson) },
                                    modifier = Modifier.testTag("lesson_ai_chat_btn")
                                ) {
                                    Text("Soru Sor", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = PrimaryIndigoLight)
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // 4 Ready Shortcuts
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                listOf(
                                    Triple(AiShortcut.STEP_BY_STEP, "🪜", "Adım Adım"),
                                    Triple(AiShortcut.DEEP_DIVE, "🔬", "Derinlemesine"),
                                    Triple(AiShortcut.SUMMARIZE, "📝", "Özetle"),
                                    Triple(AiShortcut.EXPLAIN_SENTENCE, "🔍", "Açıkla")
                                ).forEach { (shortcut, emoji, label) ->
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = DarkSurfaceVariant,
                                        border = CardDefaults.outlinedCardBorder().copy(
                                            brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder)
                                        ),
                                        modifier = Modifier
                                            .weight(1f)
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable { viewModel.openAiAssistant(lesson = lesson, initialShortcut = shortcut) }
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(6.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text(emoji, fontSize = 14.sp)
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = TextPrimary, maxLines = 1)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Step-by-Step Detailed Lessons (Adım Adım Dersler & Detaylı Anlatım)
                items(lesson.detailedExplanation.size) { idx ->
                    val block = lesson.detailedExplanation[idx]
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
                                Text(
                                    text = block.subtitle,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryIndigoLight
                                )

                                TextButton(
                                    onClick = {
                                        viewModel.openAiAssistant(
                                            lesson = lesson,
                                            initialShortcut = AiShortcut.EXPLAIN_SENTENCE,
                                            targetSentence = "${block.subtitle}: ${block.body}"
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("🤖 AI Açıkla", fontSize = 11.sp, color = PrimaryIndigoLight)
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = block.body,
                                fontSize = 13.sp,
                                color = TextPrimary,
                                lineHeight = 19.sp
                            )

                            if (block.codeSnippet != null) {
                                Spacer(modifier = Modifier.height(10.dp))
                                SyntaxHighlightedCode(code = block.codeSnippet, language = lesson.courseId)
                            }

                            if (block.tip != null) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = AccentAmberSubtle,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text("💡", fontSize = 16.sp)
                                        Text(
                                            text = block.tip,
                                            fontSize = 12.sp,
                                            color = AccentAmber,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Real Code Example & Line Explanations
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Kapsamlı Kod Örneği",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )

                            TextButton(
                                onClick = {
                                    viewModel.openAiAssistant(
                                        lesson = lesson,
                                        initialShortcut = AiShortcut.EXPLAIN_SENTENCE,
                                        targetSentence = "Şu koddaki mantığı satır satır analiz eder misin?\n```${lesson.courseId}\n${lesson.codeExample}\n```"
                                    )
                                },
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text("🤖 Kodu AI'ya Sor", fontSize = 11.sp, color = PrimaryIndigoLight)
                            }
                        }

                        SyntaxHighlightedCode(
                            code = lesson.codeExample,
                            language = lesson.courseId
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(12.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurfaceVariant)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Kod Satırlarının Açıklaması:",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryIndigoLight
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = lesson.codeExplanation,
                                    fontSize = 12.sp,
                                    color = TextSecondary,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                }

                // Real-World Example & Architecture Use Case
                if (!lesson.realWorldExample.isNullOrBlank()) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("🌍", fontSize = 16.sp)
                                    Text("Gerçek Dünya Mimarisi & Kullanımı", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = lesson.realWorldExample,
                                    fontSize = 13.sp,
                                    color = TextSecondary,
                                    lineHeight = 19.sp
                                )
                            }
                        }
                    }
                }

                // Practical Task / Uygulamalı Görev
                if (!lesson.practicalTask.isNullOrBlank()) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, AccentEmeraldBorder, RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("🛠️", fontSize = 16.sp)
                                    Text("Uygulamalı Görev", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = lesson.practicalTask,
                                    fontSize = 13.sp,
                                    color = TextPrimary,
                                    lineHeight = 19.sp
                                )
                            }
                        }
                    }
                }


                // Soru-Cevap / Q&A Section
                if (lesson.qaItems.isNotEmpty()) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("❓", fontSize = 16.sp)
                                    Text("Soru & Cevap (Sıkça Karşılaşılanlar)", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                }
                                Spacer(modifier = Modifier.height(4.dp))

                                lesson.qaItems.forEachIndexed { qIdx, qa ->
                                    val isExpanded = expandedQaIndex == qIdx
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = DarkSurfaceVariant,
                                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder)),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { expandedQaIndex = if (isExpanded) null else qIdx }
                                    ) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "S: ${qa.question}",
                                                    fontSize = 13.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = TextPrimary,
                                                    modifier = Modifier.weight(1f)
                                                )
                                                Text(if (isExpanded) "▲" else "▼", color = TextSecondary, fontSize = 11.sp)
                                            }

                                            AnimatedVisibility(visible = isExpanded) {
                                                Column(modifier = Modifier.padding(top = 8.dp)) {
                                                    Text(
                                                        text = "C: ${qa.answer}",
                                                        fontSize = 12.sp,
                                                        color = PrimaryIndigoLight,
                                                        lineHeight = 17.sp
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Mini Project at End of Topic
                if (lesson.miniProject != null) {
                    item {
                        val proj = lesson.miniProject
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("🚀", fontSize = 16.sp)
                                    Text("Konu Sonu Mini Projesi", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                }

                                Text(
                                    text = proj.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryIndigoLight
                                )

                                Text(
                                    text = proj.description,
                                    fontSize = 12.sp,
                                    color = TextSecondary,
                                    lineHeight = 17.sp
                                )

                                if (proj.solutionCode.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    SyntaxHighlightedCode(code = proj.solutionCode, language = lesson.courseId)
                                }
                            }
                        }
                    }
                }


                // In-Lesson Mini Question
                if (lesson.miniQuestion != null) {
                    item {
                        val miniQ = lesson.miniQuestion
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(18.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("🎯", fontSize = 18.sp)
                                    Text(
                                        text = "Ders İçi Hızlı Soru",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = miniQ.question,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = TextPrimary
                                )

                                if (miniQ.codeSnippet != null) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    SyntaxHighlightedCode(code = miniQ.codeSnippet, language = lesson.courseId)
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                miniQ.options.forEachIndexed { optIdx, optText ->
                                    val isSelected = miniQuestionSelectedOption == optIdx
                                    val isCorrect = optIdx == miniQ.correctIndex

                                    val optionBorderColor = when {
                                        !isMiniQuestionChecked -> if (isSelected) PrimaryIndigo else DarkCardBorder
                                        isCorrect -> AccentEmerald
                                        isSelected -> AccentRose
                                        else -> DarkCardBorder
                                    }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(if (isSelected) PrimarySubtle else DarkSurfaceVariant)
                                            .border(1.dp, optionBorderColor, RoundedCornerShape(10.dp))
                                            .clickable(enabled = !isMiniQuestionChecked) {
                                                miniQuestionSelectedOption = optIdx
                                            }
                                            .padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = optText,
                                            fontSize = 13.sp,
                                            color = TextPrimary
                                        )

                                        if (isMiniQuestionChecked) {
                                            if (isCorrect) {
                                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmerald, modifier = Modifier.size(18.dp))
                                            } else if (isSelected) {
                                                Icon(Icons.Default.Cancel, contentDescription = null, tint = AccentRose, modifier = Modifier.size(18.dp))
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                if (!isMiniQuestionChecked) {
                                    Button(
                                        onClick = { isMiniQuestionChecked = true },
                                        enabled = miniQuestionSelectedOption != null,
                                        modifier = Modifier.fillMaxWidth().height(42.dp).testTag("check_mini_q_btn"),
                                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text("Cevabı Kontrol Et", fontWeight = FontWeight.Bold)
                                    }
                                } else {
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = if (miniQuestionSelectedOption == miniQ.correctIndex) AccentEmeraldSubtle else AccentRoseSubtle,
                                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(if (miniQuestionSelectedOption == miniQ.correctIndex) AccentEmeraldBorder else AccentRoseBorder)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = if (miniQuestionSelectedOption == miniQ.correctIndex) "✓ Doğru! ${miniQ.explanation}" else "✗ Yanlış. Doğru cevap: ${miniQ.options[miniQ.correctIndex]}. ${miniQ.explanation}",
                                            color = if (miniQuestionSelectedOption == miniQ.correctIndex) AccentEmeraldLight else AccentRose,
                                            fontSize = 12.sp,
                                            modifier = Modifier.padding(10.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Completion & Action Buttons
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .border(1.dp, DarkCardBorder, RoundedCornerShape(18.dp)),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            Text(
                                text = "Ders Tamamlama & Sıradaki Adımlar",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )

                            Button(
                                onClick = {
                                    isLessonCompleted = true
                                    viewModel.markLessonComplete(lesson)
                                },
                                modifier = Modifier.fillMaxWidth().height(46.dp).testTag("complete_lesson_btn"),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isLessonCompleted) AccentEmerald else PrimaryIndigo
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(
                                    imageVector = if (isLessonCompleted) Icons.Default.CheckCircle else Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (isLessonCompleted) "Ders Tamamlandı (+20 XP)" else "Konuyu Tamamla Olarak İşaretle",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            if (nextLesson != null) {
                                OutlinedButton(
                                    onClick = { onNextLesson(nextLesson) },
                                    modifier = Modifier.fillMaxWidth().height(46.dp).testTag("next_lesson_btn"),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text("Sonraki Konu: ${nextLesson.title} →", fontSize = 13.sp, color = PrimaryIndigoLight)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
