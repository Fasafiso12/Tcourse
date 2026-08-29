package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.engine.CodeExecutionEngine
import com.example.model.AiShortcut
import com.example.model.CodingChallenge
import com.example.ui.components.CodeEditorComponent
import com.example.ui.theme.*
import com.example.viewmodel.ChallengeSessionState
import com.example.viewmodel.MainViewModel

@Composable
fun CodingChallengeScreen(
    viewModel: MainViewModel,
    challengeState: ChallengeSessionState,
    onClose: () -> Unit
) {
    val challenge = challengeState.challenge ?: return
    val selectedLangId by viewModel.selectedLanguageId.collectAsState()

    BackHandler(enabled = true) {
        onClose()
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
                    IconButton(onClick = onClose, modifier = Modifier.testTag("close_challenge_btn")) {
                        Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextPrimary)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "KODLAMA GÖREVİ",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentAmber,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = challenge.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            maxLines = 1
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = AccentAmber.copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = "+30 XP",
                            color = AccentAmber,
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. Problem Description & Requirements
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "Görev Tanımı:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigo
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = challenge.instructions,
                        fontSize = 13.sp,
                        color = TextPrimary,
                        lineHeight = 19.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Beklenen Çıktı:", fontSize = 11.sp, color = TextMuted)
                            Text(challenge.exampleOutput, fontSize = 12.sp, fontFamily = FontFamily.Monospace, color = AccentEmeraldLight, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // 2. Full-featured Interactive Code Editor
            CodeEditorComponent(
                code = challengeState.userCode,
                onCodeChange = { viewModel.updateChallengeCode(it) },
                language = selectedLangId,
                initialOutput = challengeState.executionResult,
                title = challenge.title,
                minEditorHeight = 180,
                showSymbolsToolbar = true,
                onExecuteCode = { userCode, lang ->
                    viewModel.testChallenge()
                    challengeState.executionResult ?: CodeExecutionEngine.testCodingChallenge(userCode, challenge, lang)
                },
                onResetCode = {
                    viewModel.updateChallengeCode(challenge.starterCode)
                },
                onAskAi = { userCode ->
                    viewModel.openAiAssistant(
                        initialShortcut = AiShortcut.CHECK_CODE,
                        targetSentence = "Görev: ${challenge.title}\nYazdığım Kod:\n```$selectedLangId\n$userCode\n```\nNeden beklenen çıktıyı alamıyorum veya nerede hata yapıyorum? Lütfen cevabı doğrudan vermeden ipucu ver."
                    )
                },
                testTagPrefix = "challenge"
            )

            // 3. Multi-tier Progressive Hint System
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .border(1.dp, AccentAmberBorder, RoundedCornerShape(14.dp)),
                colors = CardDefaults.cardColors(containerColor = AccentAmberSubtle)
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("💡", fontSize = 14.sp)
                            Text("Kademeli İpucu Sistemi", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = AccentAmber)
                        }

                        if (challengeState.currentHintIndex < 3) {
                            TextButton(
                                onClick = { viewModel.revealNextHint() },
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                modifier = Modifier.testTag("reveal_hint_btn")
                            ) {
                                Text("İpucu Aç (${challengeState.currentHintIndex + 1}/3)", fontSize = 11.sp, color = AccentAmber, fontWeight = FontWeight.Bold)
                            }
                        } else if (challengeState.currentHintIndex == 3) {
                            TextButton(
                                onClick = { viewModel.showSolution() },
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                modifier = Modifier.testTag("show_solution_btn")
                            ) {
                                Text("Çözümü Göster 🔓", fontSize = 11.sp, color = AccentRose, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    if (challengeState.currentHintIndex >= 1) {
                        Text(
                            text = "İpucu 1: ${challenge.hints.getOrElse(0) { "Değişkeni doğru veri tipinde tanımladığından emin ol." }}",
                            fontSize = 11.sp,
                            color = TextPrimary,
                            lineHeight = 15.sp
                        )
                    }

                    if (challengeState.currentHintIndex >= 2) {
                        Text(
                            text = "İpucu 2: ${challenge.hints.getOrElse(1) { "Ekrana yazdırmak için print / cout fonksiyonunu kullan." }}",
                            fontSize = 11.sp,
                            color = TextPrimary,
                            lineHeight = 15.sp
                        )
                    }

                    if (challengeState.currentHintIndex >= 3) {
                        Text(
                            text = "İpucu 3: ${challenge.hints.getOrElse(2) { "Sonucu doğrudan print(değişken) ile yazdır." }}",
                            fontSize = 11.sp,
                            color = TextPrimary,
                            lineHeight = 15.sp
                        )
                    }
                }
            }

            // 4. Submit & Done Button
            if (challengeState.isCompleted) {
                Button(
                    onClick = onClose,
                    modifier = Modifier.fillMaxWidth().height(48.dp).testTag("challenge_done_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = AccentEmerald),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Tebrikler! Derse Geri Dön", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

