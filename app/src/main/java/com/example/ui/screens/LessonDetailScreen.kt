package com.example.ui.screens

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
    var isLessonCompleted by remember { mutableStateOf(false) }
    var miniQuestionSelectedOption by remember { mutableStateOf<Int?>(null) }
    var isMiniQuestionChecked by remember { mutableStateOf(false) }

    val isPlaygroundRunning by viewModel.isPlaygroundRunning.collectAsState()
    val playgroundResult by viewModel.playgroundResult.collectAsState()
    val playgroundCode by viewModel.playgroundCode.collectAsState()

    val allLessons = remember(lesson.courseId) { CourseCatalog.getLessonsForCourse(lesson.courseId) }
    val nextLesson = remember(lesson) {
        val idx = allLessons.indexOfFirst { it.id == lesson.id }
        if (idx != -1 && idx < allLessons.size - 1) allLessons[idx + 1] else null
    }

    Scaffold(
        topBar = {
            Surface(
                color = DarkBg,
                modifier = Modifier.fillMaxWidth().statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("back_button")) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri", tint = TextPrimary)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                                Text("🟢 Ücretsiz Konu", color = AccentEmeraldLight, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = lesson.title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = lesson.shortDesc,
                            fontSize = 14.sp,
                            color = TextSecondary,
                            lineHeight = 20.sp
                        )
                    }
                }
            }

            // 2. Detailed Step-by-Step Breakdown (Ayrıntılı Anlatım)
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
                        Text(
                            text = block.subtitle,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigoLight
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = block.body,
                            fontSize = 13.sp,
                            color = TextPrimary,
                            lineHeight = 20.sp
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

            // 3. Real Code Example & Line Explanation
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Gerçek Kod Örneği",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )

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
                                color = PrimaryIndigo
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

            // 4. Interactive Sandbox (Kullanıcının Kendisinin Denemesi)
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
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(Icons.Default.Terminal, contentDescription = null, tint = PrimaryIndigo, modifier = Modifier.size(20.dp))
                                Text(
                                    text = "Kendin Dene (Canlı Sandbox)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                            }

                            Button(
                                onClick = { viewModel.runPlaygroundCode(lesson.courseId) },
                                enabled = !isPlaygroundRunning,
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.testTag("run_sandbox_code_btn")
                            ) {
                                if (isPlaygroundRunning) {
                                    CircularProgressIndicator(modifier = Modifier.size(14.dp), color = Color.White, strokeWidth = 2.dp)
                                } else {
                                    Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Çalıştır", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Editable code text field
                        OutlinedTextField(
                            value = playgroundCode,
                            onValueChange = { viewModel.updatePlaygroundCode(it) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .testTag("sandbox_code_editor"),
                            textStyle = androidx.compose.ui.text.TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontSize = 13.sp,
                                color = Color(0xFFF8FAFC)
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = CodeBg,
                                unfocusedContainerColor = CodeBg,
                                focusedBorderColor = PrimaryIndigo,
                                unfocusedBorderColor = DarkCardBorder
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )

                        // Output Terminal View
                        if (playgroundResult != null) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                color = CodeBg,
                                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder))
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text("KONSOL ÇIKTISI (STDOUT)", fontSize = 10.sp, color = Color(0xFF94A3B8), fontWeight = FontWeight.Bold)
                                        Text("${playgroundResult?.executionTimeMs}ms", fontSize = 10.sp, color = AccentEmerald)
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = playgroundResult?.output ?: "",
                                        color = if (playgroundResult?.isSuccess == true) AccentEmerald else AccentRose,
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 5. In-Lesson Mini Question
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

            // 6. Lesson Completion & Action Buttons (Konuyu Tamamla, Quiz, Kod Egzersizi, Sonraki Konu)
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
                            fontSize = 16.sp,
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
                                Text("Sonraki Konu: ${nextLesson.title} →", fontSize = 13.sp, color = PrimaryIndigo)
                            }
                        }
                    }
                }
            }
        }
    }
}
