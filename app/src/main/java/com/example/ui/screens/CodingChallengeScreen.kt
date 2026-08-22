package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CodingChallenge
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

            // 2. Code Editor Field
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Kod Editörü", fontSize = 12.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                    Text("${selectedLangId.uppercase()}", fontSize = 11.sp, color = PrimaryIndigo, fontFamily = FontFamily.Monospace)
                }

                OutlinedTextField(
                    value = challengeState.userCode,
                    onValueChange = { viewModel.updateChallengeCode(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .testTag("challenge_code_input"),
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

                // Quick Symbol Shortcuts Toolbar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val symbols = listOf("{}", "()", "[]", "\"", ";", ":", "=>", "=", "==", "+", "-", "print()", "cout")
                    symbols.forEach { sym ->
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = DarkSurface,
                            border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder)),
                            modifier = Modifier
                                .clickable {
                                    viewModel.updateChallengeCode(challengeState.userCode + sym)
                                }
                                .padding(vertical = 2.dp)
                        ) {
                            Text(
                                text = sym,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Monospace,
                                color = TextPrimary,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }

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

            // 4. Action Buttons (Test Et & Çözümü Kontrol Et)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { viewModel.testChallenge() },
                    enabled = !challengeState.isRunning,
                    modifier = Modifier.weight(1f).height(48.dp).testTag("run_test_challenge_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    if (challengeState.isRunning) {
                        CircularProgressIndicator(modifier = Modifier.size(16.dp), color = Color.White, strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Kodu Test Et", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // 5. Test Execution Results Card
            if (challengeState.executionResult != null) {
                val res = challengeState.executionResult
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .border(
                            1.dp,
                            if (res.isSuccess) AccentEmeraldBorder else AccentRoseBorder,
                            RoundedCornerShape(14.dp)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = if (res.isSuccess) AccentEmeraldSubtle else AccentRoseSubtle
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (res.isSuccess) "✓ BAŞARILI! Testler Geçti" else "✗ TEST BAŞARISIZ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = if (res.isSuccess) AccentEmeraldLight else AccentRose
                            )
                            Text("${res.executionTimeMs}ms", fontSize = 11.sp, color = TextMuted)
                        }

                        Text(
                            text = res.output,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Monospace,
                            color = TextPrimary
                        )

                        if (res.error != null) {
                            Text(
                                text = res.error,
                                fontSize = 11.sp,
                                color = AccentRose
                            )
                        }
                    }
                }
            }

            if (challengeState.isCompleted) {
                Button(
                    onClick = onClose,
                    modifier = Modifier.fillMaxWidth().height(46.dp).testTag("challenge_done_btn"),
                    colors = ButtonDefaults.buttonColors(containerColor = AccentEmerald),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Tebrikler! Derse Geri Dön", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
