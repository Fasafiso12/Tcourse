package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.data.catalog.CourseCatalog
import com.example.model.CodingChallenge
import com.example.model.ProjectItem
import com.example.ui.components.SyntaxHighlightedCode
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@Composable
fun PracticeScreen(
    viewModel: MainViewModel,
    onStartChallenge: (CodingChallenge) -> Unit
) {
    var selectedSubTab by remember { mutableStateOf(0) } // 0: Sandbox, 1: Challenges, 2: Applied Projects
    val selectedLangId by viewModel.selectedLanguageId.collectAsState()
    val playgroundCode by viewModel.playgroundCode.collectAsState()
    val isRunning by viewModel.isPlaygroundRunning.collectAsState()
    val playgroundResult by viewModel.playgroundResult.collectAsState()

    val projects = CourseCatalog.projects

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Pratik & Kodlama Laboratuvarı",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Text(
            text = "Canlı Sandbox, Algoritma Egzersizleri ve Projeler",
            fontSize = 13.sp,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Sub-tabs
        TabRow(
            selectedTabIndex = selectedSubTab,
            containerColor = DarkSurface,
            contentColor = PrimaryIndigo,
            modifier = Modifier
                .clip(RoundedCornerShape(14.dp))
                .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp))
        ) {
            Tab(
                selected = selectedSubTab == 0,
                onClick = { selectedSubTab = 0 },
                text = { Text("Sandbox", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (selectedSubTab == 0) PrimaryIndigo else TextSecondary) }
            )
            Tab(
                selected = selectedSubTab == 1,
                onClick = { selectedSubTab = 1 },
                text = { Text("Egzersizler", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (selectedSubTab == 1) PrimaryIndigo else TextSecondary) }
            )
            Tab(
                selected = selectedSubTab == 2,
                onClick = { selectedSubTab = 2 },
                text = { Text("Projeler", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (selectedSubTab == 2) PrimaryIndigo else TextSecondary) }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        when (selectedSubTab) {
            0 -> {
                // Interactive IDE Sandbox
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
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
                                    Text(
                                        text = "Aktif Dil: ${selectedLangId.uppercase()}",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryIndigo
                                    )

                                    Button(
                                        onClick = { viewModel.runPlaygroundCode(selectedLangId) },
                                        enabled = !isRunning,
                                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                        shape = RoundedCornerShape(8.dp),
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                                        modifier = Modifier.testTag("run_global_sandbox_btn")
                                    ) {
                                        if (isRunning) {
                                            CircularProgressIndicator(modifier = Modifier.size(14.dp), color = Color.White, strokeWidth = 2.dp)
                                        } else {
                                            Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text("Çalıştır", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                val defaultCode = if (playgroundCode.isEmpty()) {
                                    when (selectedLangId) {
                                        "python" -> "def topla(a, b):\n    return a + b\n\nprint(topla(15, 25))"
                                        "dart" -> "void main() {\n  var isim = 'Kod Akademi';\n  print('Merhaba ' + isim);\n}"
                                        "cpp" -> "#include <iostream>\nusing namespace std;\nint main() {\n  cout << \"Kod Akademi C++\" << endl;\n  return 0;\n}"
                                        else -> "void main() {\n  print('Kod Akademi Sandbox');\n}"
                                    }
                                } else playgroundCode

                                OutlinedTextField(
                                    value = defaultCode,
                                    onValueChange = { viewModel.updatePlaygroundCode(it) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(160.dp)
                                        .testTag("global_sandbox_input"),
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
                                                Text("KONSOL ÇIKTISI", fontSize = 10.sp, color = Color(0xFF94A3B8), fontWeight = FontWeight.Bold)
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
                }
            }

            1 -> {
                // Coding Challenges List
                val challenges = CourseCatalog.getLessonsForCourse(selectedLangId).mapNotNull { it.codingChallenge }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    items(challenges) { challenge ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp))
                                .clickable { onStartChallenge(challenge) }
                                .testTag("challenge_list_item_${challenge.id}"),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = challenge.title,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = AccentAmberSubtle,
                                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
                                    ) {
                                        Text("+30 XP", color = AccentAmber, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                    }
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = challenge.instructions,
                                    fontSize = 12.sp,
                                    color = TextSecondary,
                                    lineHeight = 16.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = { onStartChallenge(challenge) },
                                    modifier = Modifier.fillMaxWidth().height(40.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text("Egzersizi Çöz", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            2 -> {
                // Applied Projects List
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    items(projects) { project ->
                        ProjectCardItem(project)
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectCardItem(project: ProjectItem) {
    var isExpanded by remember { mutableStateOf(false) }

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
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(project.iconEmoji, fontSize = 24.sp)
                    Column {
                        Text(
                            text = project.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = "${project.courseId.uppercase()} • ${project.level.displayName}",
                            fontSize = 11.sp,
                            color = PrimaryIndigo
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = AccentAmberSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
                ) {
                    Text(
                        text = "+${project.xpReward} XP",
                        color = AccentAmber,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.description,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Proje Kazanımları:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            for (req in project.learningObjectives) {
                Text(
                    text = "• $req",
                    fontSize = 11.sp,
                    color = TextMuted,
                    modifier = Modifier.padding(vertical = 1.dp)
                )
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(10.dp))
                Text("Başlangıç İskeleti:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = PrimaryIndigo)
                Spacer(modifier = Modifier.height(4.dp))
                SyntaxHighlightedCode(code = project.starterCode, language = project.courseId)
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = { isExpanded = !isExpanded },
                modifier = Modifier.fillMaxWidth().height(42.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(if (isExpanded) "Projeyi Daralt ▲" else "Proje Kodunu ve İskeletini Gör ▼", fontSize = 12.sp, color = PrimaryIndigo)
            }
        }
    }
}
