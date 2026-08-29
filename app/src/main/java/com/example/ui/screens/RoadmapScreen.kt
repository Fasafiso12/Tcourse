package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.db.UserProgressEntity
import com.example.model.*
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

enum class RoadmapViewMode(val title: String) {
    SKILL_TREE("Beceri Ağacı (Skill Tree)"),
    COURSE_JOURNEY("Kurs Haritası (Journey)")
}

@Composable
fun RoadmapScreen(
    viewModel: MainViewModel,
    selectedLanguageId: String,
    allProgress: List<UserProgressEntity>,
    isUserPremium: Boolean,
    onOpenLesson: (Lesson) -> Unit
) {
    val languages = CourseCatalog.languages
    val activeLang = languages.firstOrNull { it.id == selectedLanguageId } ?: languages.first()
    val allLessons = CourseCatalog.getLessonsForCourse(selectedLanguageId)

    val skillTreeNodes by viewModel.skillTreeNodes.collectAsState()
    val courseJourneySteps by viewModel.courseJourneySteps.collectAsState()
    val selectedSkillDetail by viewModel.selectedSkillNodeDetail.collectAsState()

    var viewMode by remember { mutableStateOf(RoadmapViewMode.SKILL_TREE) }

    if (selectedSkillDetail != null) {
        SkillNodeDetailDialog(
            node = selectedSkillDetail,
            onOpenLesson = { lessonId ->
                val targetLesson = allLessons.firstOrNull { it.id == lessonId }
                targetLesson?.let { onOpenLesson(it) }
            },
            onDismiss = { viewModel.closeSkillNodeDetail() }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // Header with Course Selector
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                LanguageLogoBox(
                    language = activeLang,
                    size = 44.dp,
                    shapeRadius = 14.dp,
                    padding = 6.dp,
                    fallbackEmojiSize = 24.sp
                )
                Column {
                    Text(
                        text = "${activeLang.name} Haritası",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "İnteraktif Öğrenme Yolu",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Language Selector Chips
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(languages) { lang ->
                val isSelected = lang.id == selectedLanguageId
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) PrimarySubtle else DarkSurface,
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = SolidColor(if (isSelected) PrimaryIndigo else DarkCardBorder)
                    ),
                    modifier = Modifier.clickable { viewModel.selectLanguage(lang.id) }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        LanguageLogoBox(
                            language = lang,
                            size = 20.dp,
                            shapeRadius = 5.dp,
                            padding = 2.dp,
                            fallbackEmojiSize = 12.sp
                        )
                        Text(
                            text = lang.name,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) PrimaryIndigo else TextPrimary
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // View Mode Switcher Tab
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = DarkSurface,
            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(4.dp)) {
                RoadmapViewMode.values().forEach { mode ->
                    val isSelected = viewMode == mode
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isSelected) PrimaryIndigo else Color.Transparent)
                            .clickable { viewMode = mode }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = mode.title,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) Color.White else TextSecondary
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Content
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(AppSpacing.sm),
            contentPadding = PaddingValues(bottom = AppSpacing.xxxl)
        ) {
            if (viewMode == RoadmapViewMode.SKILL_TREE) {
                // ==========================================
                // SKILL TREE NODES
                // ==========================================
                items(skillTreeNodes) { node ->
                    AppCard(
                        modifier = Modifier.testTag("skill_node_${node.id}"),
                        containerColor = when (node.status) {
                            SkillNodeStatus.COMPLETED -> DarkSurface
                            SkillNodeStatus.AVAILABLE -> DarkSurfaceVariant
                            else -> DarkSurface
                        },
                        borderColor = when (node.status) {
                            SkillNodeStatus.COMPLETED -> AccentEmeraldBorder
                            SkillNodeStatus.AVAILABLE -> PrimarySubtleBorder
                            SkillNodeStatus.IN_PROGRESS -> AccentAmberBorder
                            else -> DarkCardBorder
                        },
                        onClick = { viewModel.openSkillNodeDetail(node) }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.md)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when (node.status) {
                                            SkillNodeStatus.COMPLETED -> AccentEmeraldSubtle
                                            SkillNodeStatus.AVAILABLE -> PrimarySubtle
                                            else -> DarkBg
                                        }
                                    )
                                    .border(
                                        1.dp,
                                        when (node.status) {
                                            SkillNodeStatus.COMPLETED -> AccentEmeraldBorder
                                            SkillNodeStatus.AVAILABLE -> PrimarySubtleBorder
                                            else -> DarkCardBorder
                                        },
                                        CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (node.status == SkillNodeStatus.LOCKED) "🔒" else node.iconEmoji,
                                    fontSize = 20.sp
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = node.title,
                                    style = AppTypography.title,
                                    color = if (node.status == SkillNodeStatus.LOCKED) TextMuted else TextPrimary
                                )
                                Text(
                                    text = node.description,
                                    style = AppTypography.caption,
                                    color = TextSecondary,
                                    maxLines = 1
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(AppRadius.xs),
                                color = when (node.status) {
                                    SkillNodeStatus.COMPLETED -> AccentEmeraldSubtle
                                    SkillNodeStatus.AVAILABLE -> PrimarySubtle
                                    else -> DarkBg
                                },
                                border = CardDefaults.outlinedCardBorder().copy(
                                    brush = SolidColor(
                                        when (node.status) {
                                            SkillNodeStatus.COMPLETED -> AccentEmeraldBorder
                                            SkillNodeStatus.AVAILABLE -> PrimarySubtleBorder
                                            else -> DarkCardBorder
                                        }
                                    )
                                )
                            ) {
                                Text(
                                    text = when (node.status) {
                                        SkillNodeStatus.COMPLETED -> "✓ Tamamlandı"
                                        SkillNodeStatus.AVAILABLE -> "⚡ Başla"
                                        SkillNodeStatus.IN_PROGRESS -> "● Devam Ediyor"
                                        SkillNodeStatus.LOCKED -> "🔒 Kilitli"
                                        SkillNodeStatus.MASTERED -> "👑 Mastered"
                                    },
                                    style = AppTypography.badge,
                                    color = when (node.status) {
                                        SkillNodeStatus.COMPLETED -> AccentEmeraldLight
                                        SkillNodeStatus.AVAILABLE -> PrimaryIndigoLight
                                        else -> TextMuted
                                    },
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            } else {
                // ==========================================
                // COURSE JOURNEY MAP (START -> ... -> FINISH)
                // ==========================================
                items(courseJourneySteps) { step ->
                    AppCard(
                        modifier = Modifier.testTag("journey_step_${step.id}"),
                        containerColor = if (step.isCurrent) DarkSurfaceVariant else DarkSurface,
                        borderColor = when {
                            step.isCompleted -> AccentEmeraldBorder
                            step.isCurrent -> AccentAmberBorder
                            else -> DarkCardBorder
                        },
                        onClick = if (!step.isLocked) {
                            {
                                step.relatedLessonId?.let { id ->
                                    val lesson = allLessons.firstOrNull { it.id == id }
                                    lesson?.let { onOpenLesson(it) }
                                }
                            }
                        } else null
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.md)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when {
                                            step.isCompleted -> AccentEmeraldSubtle
                                            step.isCurrent -> AccentAmberSubtle
                                            else -> DarkBg
                                        }
                                    )
                                    .border(
                                        1.dp,
                                        when {
                                            step.isCompleted -> AccentEmeraldBorder
                                            step.isCurrent -> AccentAmberBorder
                                            else -> DarkCardBorder
                                        },
                                        CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (step.isLocked) "🔒" else step.iconEmoji,
                                    fontSize = 20.sp
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                if (step.isCurrent) {
                                    Text(
                                        text = "● ŞU ANDA BURADASIN",
                                        style = AppTypography.badge,
                                        color = AccentAmber
                                    )
                                }
                                Text(
                                    text = step.title,
                                    style = AppTypography.title,
                                    color = if (step.isLocked) TextMuted else TextPrimary
                                )
                                Text(
                                    text = "+${step.xpReward} XP Ödülü",
                                    style = AppTypography.caption,
                                    color = TextSecondary
                                )
                            }

                            if (step.isCompleted) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmeraldLight, modifier = Modifier.size(22.dp))
                            } else if (step.isCurrent) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = AccentAmber, modifier = Modifier.size(24.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
