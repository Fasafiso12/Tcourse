package com.example.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.CourseLevel
import com.example.model.Lesson
import com.example.model.ProgrammingLanguage
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@Composable
fun CoursesScreen(
    viewModel: MainViewModel,
    onOpenLesson: (Lesson) -> Unit
) {
    val languages = CourseCatalog.languages
    var selectedLevelFilter by remember { mutableStateOf<CourseLevel?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Programlama Kursları",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Text(
            text = "Sıfırdan ileri seviyeye adım adım müfredat",
            fontSize = 13.sp,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Level Filter Chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedLevelFilter == null,
                onClick = { selectedLevelFilter = null },
                label = { Text("Tümü", fontSize = 12.sp) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = PrimaryIndigo,
                    selectedLabelColor = Color.White,
                    containerColor = DarkSurface,
                    labelColor = TextSecondary
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = selectedLevelFilter == null,
                    borderColor = if (selectedLevelFilter == null) PrimaryIndigo else DarkCardBorder
                )
            )

            listOf(CourseLevel.BEGINNER, CourseLevel.FUNDAMENTAL, CourseLevel.INTERMEDIATE, CourseLevel.ADVANCED).forEach { level ->
                FilterChip(
                    selected = selectedLevelFilter == level,
                    onClick = { selectedLevelFilter = if (selectedLevelFilter == level) null else level },
                    label = { Text(level.displayName, fontSize = 12.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = PrimaryIndigo,
                        selectedLabelColor = Color.White,
                        containerColor = DarkSurface,
                        labelColor = TextSecondary
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = selectedLevelFilter == level,
                        borderColor = if (selectedLevelFilter == level) PrimaryIndigo else DarkCardBorder
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            items(languages) { lang ->
                CourseExpandedCard(
                    language = lang,
                    onOpenLesson = onOpenLesson,
                    onSelectLanguage = { viewModel.selectLanguage(lang.id) }
                )
            }
        }
    }
}

@Composable
private fun CourseExpandedCard(
    language: ProgrammingLanguage,
    onOpenLesson: (Lesson) -> Unit,
    onSelectLanguage: () -> Unit
) {
    val lessons = CourseCatalog.getLessonsForCourse(language.id)
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    val brandColor = Color(language.colorHex)
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(brandColor.copy(alpha = 0.12f))
                            .border(1.dp, brandColor.copy(alpha = 0.35f), RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (language.drawableRes != null) {
                            Image(
                                painter = painterResource(id = language.drawableRes),
                                contentDescription = "${language.name} logo",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Fit
                            )
                        } else {
                            Text(language.iconEmoji, fontSize = 24.sp)
                        }
                    }

                    Column {
                        Text(
                            text = language.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = language.tag,
                            fontSize = 12.sp,
                            color = PrimaryIndigo
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = AccentEmeraldSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
                ) {
                    Text(
                        text = "3 Konu Ücretsiz",
                        color = AccentEmeraldLight,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = language.shortDescription,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Level Progression Pills
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                LevelPill("Başlangıç", true)
                Text("→", color = TextMuted, fontSize = 11.sp)
                LevelPill("Temel", true)
                Text("→", color = TextMuted, fontSize = 11.sp)
                LevelPill("Orta", true)
                Text("→", color = TextMuted, fontSize = 11.sp)
                LevelPill("İleri", false)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Sample topics preview (Showing first 4 topics with lock/unlock states)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(DarkSurfaceVariant)
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val previewList = if (isExpanded) lessons else lessons.take(4)
                previewList.forEachIndexed { idx, lesson ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                onSelectLanguage()
                                onOpenLesson(lesson)
                            }
                            .padding(horizontal = 6.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(
                                text = if (!lesson.isPremium) "🟢" else "🔒",
                                fontSize = 12.sp
                            )
                            Text(
                                text = "${idx + 1}. ${lesson.title}",
                                fontSize = 12.sp,
                                color = if (!lesson.isPremium) TextPrimary else TextMuted,
                                maxLines = 1
                            )
                        }

                        Text(
                            text = if (!lesson.isPremium) "Ücretsiz" else "Premium",
                            fontSize = 10.sp,
                            color = if (!lesson.isPremium) AccentEmeraldLight else AccentAmber
                        )
                    }
                }

                if (lessons.size > 4) {
                    Text(
                        text = if (isExpanded) "Daha Az Göster ▲" else "+${lessons.size - 4} konu daha (Genişlet ▼)",
                        color = PrimaryIndigo,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .clickable { isExpanded = !isExpanded }
                            .padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        onSelectLanguage()
                        lessons.firstOrNull()?.let { onOpenLesson(it) }
                    },
                    modifier = Modifier.weight(1f).height(44.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Kursa Başla", color = TextPrimary, fontSize = 13.sp)
                }

                Button(
                    onClick = {
                        onSelectLanguage()
                        lessons.firstOrNull()?.let { onOpenLesson(it) }
                    },
                    modifier = Modifier.weight(1f).height(44.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Öğrenmeye Başla →", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun LevelPill(text: String, isUnlocked: Boolean) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = if (isUnlocked) PrimarySubtle else DarkSurfaceVariant,
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(if (isUnlocked) PrimarySubtleBorder else DarkCardBorder))
    ) {
        Text(
            text = text,
            color = if (isUnlocked) PrimaryIndigo else TextMuted,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}
