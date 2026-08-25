package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.QuestionType
import com.example.ui.components.SyntaxHighlightedCode
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel
import com.example.viewmodel.QuizSessionState

@Composable
fun QuizScreen(
    viewModel: MainViewModel,
    quizState: QuizSessionState,
    onClose: () -> Unit
) {
    val currentQuestion = quizState.questions.getOrNull(quizState.currentIndex)
    val totalCount = quizState.questions.size
    val currentNumber = quizState.currentIndex + 1
    val scrollState = rememberScrollState()

    androidx.compose.runtime.LaunchedEffect(quizState.currentIndex) {
        scrollState.scrollTo(0)
    }

    Scaffold(
        topBar = {
            Surface(
                color = DarkBg,
                modifier = Modifier.fillMaxWidth().statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onClose, modifier = Modifier.testTag("close_quiz_btn")) {
                        Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextPrimary)
                    }

                    // Progress bar & counter
                    Column(
                        modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Soru $currentNumber / $totalCount",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigoLight
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        LinearProgressIndicator(
                            progress = { if (totalCount > 0) currentNumber.toFloat() / totalCount.toFloat() else 0f },
                            modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                            color = PrimaryIndigoLight,
                            trackColor = DarkSurfaceVariant
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = AccentEmeraldSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
                    ) {
                        Text(
                            text = "${quizState.correctAnswersCount} Doğru",
                            color = AccentEmeraldLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        },
        containerColor = DarkBg
    ) { innerPadding ->
        if (quizState.isQuizCompleted) {
            // Quiz Summary Completion Screen
            QuizCompletionView(
                quizState = quizState,
                onRestart = { quizState.lesson?.let { viewModel.startQuiz(it) } },
                onClose = onClose
            )
        } else if (currentQuestion != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Question Type Badge
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = PrimarySubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder))
                ) {
                    Text(
                        text = when (currentQuestion.questionType) {
                            QuestionType.MULTIPLE_CHOICE -> "Çoktan Seçmeli"
                            QuestionType.TRUE_FALSE -> "Doğru / Yanlış"
                            QuestionType.GUESS_OUTPUT -> "Kod Çıktısını Tahmin Et"
                            QuestionType.FIND_BUG -> "Hatalı Satırı Bul"
                            QuestionType.FILL_BLANK -> "Boşluk Doldurma"
                            QuestionType.CODE_MATCH -> "Kod Eşleştirme"
                        },
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryIndigo,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                // Question Text
                Text(
                    text = currentQuestion.questionText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    lineHeight = 24.sp
                )

                // Optional Code Snippet for question
                if (currentQuestion.codeSnippet != null) {
                    SyntaxHighlightedCode(
                        code = currentQuestion.codeSnippet,
                        language = quizState.lesson?.courseId ?: "code",
                        showLineNumbers = true
                    )
                }

                // Options List
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    currentQuestion.options.forEachIndexed { optIndex, optionText ->
                        val isSelected = quizState.selectedOptionIndex == optIndex
                        val isCorrect = optIndex == currentQuestion.correctOptionIndex

                        val borderColor = when {
                            !quizState.isAnswerChecked -> if (isSelected) PrimaryIndigo else DarkCardBorder
                            isCorrect -> AccentEmerald
                            isSelected -> AccentRose
                            else -> DarkCardBorder
                        }

                        val bgColor = when {
                            !quizState.isAnswerChecked -> if (isSelected) PrimarySubtle else DarkSurface
                            isCorrect -> AccentEmeraldSubtle
                            isSelected -> AccentRoseSubtle
                            else -> DarkSurface
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(bgColor)
                                .border(if (isSelected || (quizState.isAnswerChecked && isCorrect)) 1.5.dp else 1.dp, borderColor, RoundedCornerShape(14.dp))
                                .clickable(enabled = !quizState.isAnswerChecked) {
                                    viewModel.selectQuizOption(optIndex)
                                }
                                .padding(14.dp)
                                .testTag("quiz_option_$optIndex"),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.weight(1f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(if (isSelected) PrimaryIndigo else DarkSurfaceVariant),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = ('A' + optIndex).toString(),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) Color.White else TextSecondary
                                    )
                                }

                                Text(
                                    text = optionText,
                                    fontSize = 14.sp,
                                    color = TextPrimary,
                                    lineHeight = 20.sp
                                )
                            }

                            if (quizState.isAnswerChecked) {
                                if (isCorrect) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmerald, modifier = Modifier.size(20.dp))
                                } else if (isSelected) {
                                    Icon(Icons.Default.Cancel, contentDescription = null, tint = AccentRose, modifier = Modifier.size(20.dp))
                                }
                            }
                        }
                    }
                }

                // Explanation Banner on Submit
                if (quizState.isAnswerChecked) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .border(
                                1.dp,
                                if (quizState.isAnswerCorrect) AccentEmeraldBorder else AccentRoseBorder,
                                RoundedCornerShape(14.dp)
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = if (quizState.isAnswerCorrect) AccentEmeraldSubtle else AccentRoseSubtle
                        )
                    ) {
                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(if (quizState.isAnswerCorrect) "✓" else "✗", fontSize = 16.sp, color = if (quizState.isAnswerCorrect) AccentEmeraldLight else AccentRose)
                                Text(
                                    text = if (quizState.isAnswerCorrect) "Tebrikler! Doğru Cevap" else "Yanlış Cevap",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (quizState.isAnswerCorrect) AccentEmeraldLight else AccentRose
                                )
                            }

                            Text(
                                text = if (quizState.isAnswerCorrect) currentQuestion.explanationRight else currentQuestion.explanationWrong,
                                fontSize = 12.sp,
                                color = TextPrimary,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Action button: "Kontrol Et" or "Sonraki Soru"
                if (!quizState.isAnswerChecked) {
                    Button(
                        onClick = { viewModel.checkQuizAnswer() },
                        enabled = quizState.selectedOptionIndex != null,
                        modifier = Modifier.fillMaxWidth().height(48.dp).testTag("check_quiz_answer_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Cevabı Kontrol Et", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                } else {
                    Button(
                        onClick = { viewModel.nextQuizQuestion() },
                        modifier = Modifier.fillMaxWidth().height(48.dp).testTag("next_quiz_q_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = if (quizState.isAnswerCorrect) AccentEmerald else PrimaryIndigo),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (currentNumber < totalCount) "Sonraki Soru →" else "Sonuçları Gör 🎉",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun QuizCompletionView(
    quizState: QuizSessionState,
    onRestart: () -> Unit,
    onClose: () -> Unit
) {
    val total = quizState.questions.size
    val correct = quizState.correctAnswersCount
    val percentage = if (total > 0) (correct.toFloat() / total.toFloat() * 100).toInt() else 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(AccentAmber, Color(0xFFD97706))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.EmojiEvents, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Quiz Tamamlandı! 🎉",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "${quizState.lesson?.title ?: "Konu"} testini bitirdiniz.",
            fontSize = 14.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Result Score Box
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .border(1.dp, DarkCardBorder, RoundedCornerShape(18.dp)),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Doğru", fontSize = 11.sp, color = TextMuted)
                    Text("$correct / $total", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Başarı", fontSize = 11.sp, color = TextMuted)
                    Text("%$percentage", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = PrimaryIndigoLight)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Kazanılan XP", fontSize = 11.sp, color = TextMuted)
                    Text("+${quizState.xpEarned} XP", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = AccentAmber)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClose,
            modifier = Modifier.fillMaxWidth().height(48.dp).testTag("quiz_finish_return_btn"),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Derse Geri Dön", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth().height(46.dp).testTag("quiz_restart_btn"),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Quizi Tekrar Çöz", color = TextSecondary)
        }
    }
}
