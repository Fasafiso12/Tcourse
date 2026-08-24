package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.data.catalog.CourseCatalog
import com.example.model.CodingChallenge
import com.example.model.ProjectItem
import com.example.ui.components.CodeEditorComponent
import com.example.ui.components.SyntaxHighlightedCode
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@Composable
fun PracticeScreen(
    viewModel: MainViewModel,
    onStartChallenge: (CodingChallenge) -> Unit
) {
    var selectedSubTab by remember { mutableStateOf(0) } // 0: Sandbox, 1: Challenges, 2: Applied Projects
    val globalSelectedLangId by viewModel.selectedLanguageId.collectAsState()
    var currentEditorLang by remember(globalSelectedLangId) { mutableStateOf(globalSelectedLangId) }
    
    val playgroundCode by viewModel.playgroundCode.collectAsState()
    val playgroundResult by viewModel.playgroundResult.collectAsState()

    val projects = CourseCatalog.projects

    fun getBoilerplateFor(lang: String, type: String = "hello"): String {
        return when (lang.lowercase()) {
            "python" -> when (type) {
                "loop" -> "sayilar = [10, 20, 30, 40, 50]\ntoplam = 0\n\nfor s in sayilar:\n    print(s)\n    toplam = toplam + s\n\nprint('Toplam Sonuc:')\nprint(toplam)"
                "func" -> "def kare_al(sayi):\n    return sayi * sayi\n\nprint('5 in karesi:')\nprint(kare_al(5))\nprint('9 un karesi:')\nprint(kare_al(9))"
                else -> "# Python 3 Canlı Editör\nisim = 'Kod Akademi'\nprint('Merhaba ' + isim)\n\na = 25\nb = 75\nprint('Toplam:')\nprint(a + b)"
            }
            "cpp" -> when (type) {
                "loop" -> "#include <iostream>\nusing namespace std;\n\nint main() {\n    for (int i = 1; i <= 5; i++) {\n        cout << \"Dongu Adimi: \" << i << endl;\n    }\n    return 0;\n}"
                "func" -> "#include <iostream>\nusing namespace std;\n\nint topla(int a, int b) {\n    return a + b;\n}\n\nint main() {\n    cout << \"Sonuc: \" << topla(14, 26) << endl;\n    return 0;\n}"
                else -> "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Merhaba C++ Dunyasi!\" << endl;\n    int x = 42;\n    cout << \"Deger: \" << x << endl;\n    return 0;\n}"
            }
            "dart" -> when (type) {
                "loop" -> "void main() {\n  var diller = ['Dart', 'Kotlin', 'Python'];\n  for (var d in diller) {\n    print('Ogreniliyor: ' + d);\n  }\n}"
                "func" -> "int carp(int a, int b) => a * b;\n\nvoid main() {\n  var sonuc = carp(6, 7);\n  print('Carpim: ' + sonuc.toString());\n}"
                else -> "void main() {\n  var platform = 'Kod Akademi';\n  print('Merhaba ' + platform);\n  var puan = 100;\n  print('Baslangic Puani: ' + puan.toString());\n}"
            }
            "rust" -> when (type) {
                "loop" -> "fn main() {\n    for i in 1..6 {\n        println!(\"Rust Sayac: {}\", i);\n    }\n}"
                else -> "fn main() {\n    let isim = \"Rustacean\";\n    println!(\"Merhaba {}\", isim);\n    let a = 15;\n    let b = 35;\n    println!(\"Toplam: {}\", a + b);\n}"
            }
            "javascript" -> when (type) {
                "loop" -> "const items = ['React', 'Vue', 'Compose'];\nitems.forEach(item => {\n  console.log('Framework: ' + item);\n});"
                else -> "function selamla(isim) {\n  return 'Hosgeldin ' + isim;\n}\n\nconsole.log(selamla('JavaScript Ogrencisi'));\nlet x = 50;\nlet y = 50;\nconsole.log(x + y);"
            }
            "kotlin" -> when (type) {
                "loop" -> "fun main() {\n    for (i in 1..5) {\n        println(\"Kotlin Adim: \" + i)\n    }\n}"
                else -> "fun main() {\n    val dil = \"Kotlin\"\n    println(\"Merhaba, \" + dil)\n    val a = 30\n    val b = 20\n    println(a + b)\n}"
            }
            "flutter" -> "import 'package:flutter/material.dart';\n\nvoid main() {\n  runApp(\n    MaterialApp(\n      home: Scaffold(\n        body: Center(\n          child: Text('Merhaba Kod Akademi Flutter!'),\n        ),\n      ),\n    ),\n  );\n}"
            else -> "void main() {\n  print('Kod Akademi Canlı Sandbox');\n}"
        }
    }

    // Initialize code if empty
    LaunchedEffect(currentEditorLang) {
        if (playgroundCode.isEmpty()) {
            viewModel.updatePlaygroundCode(getBoilerplateFor(currentEditorLang, "hello"))
        }
    }

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
            text = "Canlı Kod Editörü, Algoritma Egzersizleri ve Projeler",
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
                text = { Text("Canlı Editör", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = if (selectedSubTab == 0) PrimaryIndigo else TextSecondary) }
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
                // Interactive Live Code Editor Sandbox
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    // Language Switcher & Template selector
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            // Language Selector Horizontal Scroll
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                CourseCatalog.languages.forEach { lang ->
                                    val isSelected = currentEditorLang.equals(lang.id, ignoreCase = true)
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = if (isSelected) PrimaryIndigo else DarkSurface,
                                        border = CardDefaults.outlinedCardBorder().copy(
                                            brush = SolidColor(if (isSelected) PrimaryIndigoLight else DarkCardBorder)
                                        ),
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable {
                                                currentEditorLang = lang.id
                                                viewModel.updatePlaygroundCode(getBoilerplateFor(lang.id, "hello"))
                                            }
                                            .testTag("sandbox_lang_chip_${lang.id}")
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text(lang.iconEmoji, fontSize = 14.sp)
                                            Text(
                                                text = lang.name,
                                                fontSize = 12.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                                color = if (isSelected) Color.White else TextSecondary
                                            )
                                        }
                                    }
                                }
                            }

                            // Quick Templates (Merhaba Dünya, Döngü, Fonksiyon)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("Şablonlar:", fontSize = 11.sp, color = TextMuted, fontWeight = FontWeight.Bold)

                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = DarkSurfaceVariant,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .clickable {
                                            viewModel.updatePlaygroundCode(getBoilerplateFor(currentEditorLang, "hello"))
                                        }
                                ) {
                                    Text("👋 Merhaba Dünya", fontSize = 10.sp, color = TextPrimary, modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp))
                                }

                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = DarkSurfaceVariant,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .clickable {
                                            viewModel.updatePlaygroundCode(getBoilerplateFor(currentEditorLang, "loop"))
                                        }
                                ) {
                                    Text("🔄 Döngü & Liste", fontSize = 10.sp, color = TextPrimary, modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp))
                                }

                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = DarkSurfaceVariant,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .clickable {
                                            viewModel.updatePlaygroundCode(getBoilerplateFor(currentEditorLang, "func"))
                                        }
                                ) {
                                    Text("⚡ Fonksiyon", fontSize = 10.sp, color = TextPrimary, modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp))
                                }
                            }
                        }
                    }

                    // The Core Interactive Code Editor Component
                    item {
                        val activeCode = if (playgroundCode.isEmpty()) getBoilerplateFor(currentEditorLang, "hello") else playgroundCode

                        CodeEditorComponent(
                            code = activeCode,
                            onCodeChange = { viewModel.updatePlaygroundCode(it) },
                            language = currentEditorLang,
                            initialOutput = playgroundResult,
                            title = "Canlı Kod Alanı",
                            minEditorHeight = 220,
                            showSymbolsToolbar = true,
                            showConsoleInitially = true,
                            onResetCode = {
                                viewModel.updatePlaygroundCode(getBoilerplateFor(currentEditorLang, "hello"))
                            },
                            onAskAi = { codeToAsk ->
                                viewModel.openAiAssistant(
                                    targetSentence = "Şu $currentEditorLang kodunu inceler misin? Mantığı ve varsa hataları açıkla:\n```$currentEditorLang\n$codeToAsk\n```"
                                )
                            },
                            testTagPrefix = "sandbox"
                        )
                    }

                    // Feature Guide Card
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text("💡", fontSize = 14.sp)
                                    Text("Editör Özellikleri", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                }
                                Text("• Canlı Sözdizimi Vurgulama (Keywords, Types, Strings, Comments, Numbers)", fontSize = 11.sp, color = TextSecondary)
                                Text("• Satır Numaralandırma & Otomatik Kaydırma", fontSize = 11.sp, color = TextSecondary)
                                Text("• Hızlı Sembol Çubuğu ile mobil klavyede zor yazılan parantez ve noktalı virgülleri tek dokunuşla ekleme", fontSize = 11.sp, color = TextSecondary)
                                Text("• Çift tırnak, parantez veya noktalı virgül hatalarında akıllı teşhis ve hata ayıklama mesajları", fontSize = 11.sp, color = TextSecondary)
                            }
                        }
                    }
                }
            }

            1 -> {
                // Coding Challenges List
                val challenges = CourseCatalog.getLessonsForCourse(currentEditorLang).mapNotNull { it.codingChallenge }

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
                                        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder))
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
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder))
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
