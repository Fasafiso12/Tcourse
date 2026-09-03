package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.engine.GamificationService
import com.example.model.*
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.AppNavTab
import com.example.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    userProfile: UserProfileData,
    activeCourseProgress: CourseProgressInfo,
    selectedLanguageId: String,
    onNavigateToTab: (AppNavTab) -> Unit,
    onOpenLesson: (Lesson) -> Unit
) {
    val languages = CourseCatalog.languages
    val activeLang = languages.firstOrNull { it.id == selectedLanguageId } ?: languages.first()
    val allLessons = CourseCatalog.getLessonsForCourse(selectedLanguageId)
    val nextLesson = allLessons.firstOrNull { it.id == activeCourseProgress.nextLessonId } ?: allLessons.firstOrNull()

    val dailyChallenge by viewModel.dailyChallengeState.collectAsState()
    val showDailyChallengeDialog by viewModel.showDailyChallengeDialog.collectAsState()
    val smartReviews by viewModel.smartReviewRecommendations.collectAsState()
    val richAchievements by viewModel.richAchievements.collectAsState()
    val weeklyStats by viewModel.weeklyStats.collectAsState()
    val topicMasteryList by viewModel.courseTopicMasteryList.collectAsState()
    val allLanguagesProgress by viewModel.allLanguagesProgress.collectAsState()

    val levelTier = remember(userProfile.currentXp) {
        GamificationService.getLevelTier(userProfile.currentXp)
    }
    val levelProgress = remember(userProfile.currentXp) {
        GamificationService.getLevelProgressRatio(userProfile.currentXp)
    }

    if (showDailyChallengeDialog) {
        DailyChallengeModal(
            challenge = dailyChallenge,
            onSolve = { selectedIdx ->
                viewModel.solveDailyChallenge(selectedIdx)
            },
            onDismiss = { viewModel.closeDailyChallenge() }
        )
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
    ) {
        val isWideScreen = maxWidth >= 600.dp

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 760.dp)
                .align(Alignment.TopCenter)
                .padding(horizontal = if (isWideScreen) AppSpacing.xl else AppSpacing.md),
            verticalArrangement = Arrangement.spacedBy(AppSpacing.md),
            contentPadding = PaddingValues(top = AppSpacing.sm, bottom = AppSpacing.xxxl)
        ) {
            // ====================================================
            // 1. HEADER: User Identity, Level Tier & Glowing Streak
            // ====================================================
            item {
                AppCard(
                    modifier = Modifier.testTag("home_header_card"),
                    containerColor = DarkSurface,
                    borderColor = DarkCardBorder
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                            modifier = Modifier
                                .weight(1f, fill = false)
                                .clickable { onNavigateToTab(AppNavTab.PROFILE) }
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(PrimarySubtle)
                                    .border(1.dp, PrimarySubtleBorder, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(levelTier.badgeEmoji, fontSize = 22.sp)
                            }

                            Column {
                                Text(
                                    text = userProfile.username,
                                    style = AppTypography.heading3,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "SEVİYE ${levelTier.level} • ${levelTier.titleTr}",
                                    style = AppTypography.caption,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryIndigoLight,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        // Glowing Streak Pill
                        StreakBadge(
                            streakDays = userProfile.streakDays,
                            modifier = Modifier.testTag("streak_header_pill")
                        )
                    }

                    Spacer(modifier = Modifier.height(AppSpacing.sm))

                    // XP Progress Indicator
                    AppProgressBar(
                        progress = levelProgress,
                        color = PrimaryIndigo,
                        trackColor = DarkSurfaceVariant,
                        label = "${userProfile.currentXp} / ${levelTier.maxXp} XP",
                        trailingText = "%${(levelProgress * 100).toInt()}"
                    )
                }
            }

            // ====================================================
            // 2. CONTINUE LEARNING HERO CARD
            // ====================================================
            item {
                AppCard(
                    modifier = Modifier.testTag("continue_learning_card"),
                    containerColor = DarkSurfaceVariant,
                    borderColor = PrimarySubtleBorder
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            LanguageLogoBox(
                                language = activeLang,
                                size = 36.dp,
                                shapeRadius = 10.dp,
                                padding = 4.dp
                            )
                            Text(
                                text = "${activeLang.name} Kursu",
                                style = AppTypography.heading3,
                                color = TextPrimary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(AppRadius.sm),
                            color = PrimarySubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
                        ) {
                            Text(
                                text = "${activeCourseProgress.completedLessonsCount}/${activeCourseProgress.totalLessonsCount} Ders",
                                style = AppTypography.caption,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryIndigoLight,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(AppSpacing.xs))

                    nextLesson?.let { lesson ->
                        Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.xxs)) {
                            Text(
                                text = "SIRADAKİ DERS",
                                style = AppTypography.badge,
                                color = TextMuted
                            )
                            Text(
                                text = lesson.title,
                                style = AppTypography.heading3,
                                color = TextPrimary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = lesson.shortDesc,
                                style = AppTypography.bodySmall,
                                color = TextSecondary,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Spacer(modifier = Modifier.height(AppSpacing.sm))

                        PrimaryButton(
                            text = "Öğrenmeye Devam Et",
                            icon = Icons.Default.ArrowForward,
                            onClick = { onOpenLesson(lesson) },
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "continue_lesson_button"
                        )
                    }
                }
            }

            // ====================================================
            // 3. PROGRESS DASHBOARD: D3-INSPIRED LESSON COMPLETION
            // ====================================================
            item {
                LanguageProgressChartComponent(
                    languages = languages,
                    progressMap = allLanguagesProgress,
                    streakDays = userProfile.streakDays,
                    onLanguageClick = { lang ->
                        viewModel.selectLanguage(lang.id)
                    },
                    modifier = Modifier.testTag("home_language_progress_chart")
                )
            }

            // ====================================================
            // 4. ACHIEVEMENTS PREVIEW
            // ====================================================
            item {
                Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)) {
                    SectionHeader(
                        title = "Başarımlar & Rozetler",
                        iconEmoji = "🏆",
                        actionText = "Tümü (${richAchievements.count { it.isUnlocked }}/${richAchievements.size}) →",
                        onActionClick = { onNavigateToTab(AppNavTab.PROFILE) }
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                    ) {
                        items(richAchievements.take(6)) { ach ->
                            Surface(
                                shape = RoundedCornerShape(AppRadius.md),
                                color = if (ach.isUnlocked) DarkSurfaceVariant else DarkSurface,
                                border = CardDefaults.outlinedCardBorder().copy(
                                    brush = SolidColor(if (ach.isUnlocked) AccentAmberBorder else DarkCardBorder)
                                ),
                                modifier = Modifier.width(150.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(AppSpacing.sm),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(if (ach.isUnlocked) AccentAmberSubtle else DarkSurfaceVariant)
                                            .border(1.dp, if (ach.isUnlocked) AccentAmberBorder else DarkCardBorder, CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(if (ach.isUnlocked) ach.iconEmoji else "🔒", fontSize = 16.sp)
                                    }

                                    Text(
                                        text = ach.titleTr,
                                        style = AppTypography.title,
                                        color = TextPrimary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                    Text(
                                        text = "+${ach.xpReward} XP",
                                        style = AppTypography.caption,
                                        fontWeight = FontWeight.Bold,
                                        color = if (ach.isUnlocked) AccentAmber else TextMuted
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // ====================================================
            // 5. WEEKLY ACTIVITY SUMMARY
            // ====================================================
            item {
                AppCard(
                    modifier = Modifier.testTag("weekly_stats_card"),
                    containerColor = DarkSurface,
                    borderColor = DarkCardBorder
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "HAFTALIK ÖĞRENME ÖZETİ",
                                style = AppTypography.badge,
                                color = TextMuted
                            )
                            Text(
                                text = "${weeklyStats.activeDaysCount} Gün Aktif • ${weeklyStats.totalStudyMinutes} Dk",
                                style = AppTypography.heading3,
                                color = TextPrimary
                            )
                        }

                        weeklyStats.growthComparisonPercentage?.let { growth ->
                            Surface(
                                shape = RoundedCornerShape(AppRadius.xs),
                                color = AccentEmeraldSubtle,
                                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentEmeraldBorder))
                            ) {
                                Text(
                                    text = "+%$growth Artış",
                                    color = AccentEmeraldLight,
                                    style = AppTypography.badge,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(AppSpacing.md))

                    // Weekly Activity Bars
                    WeeklyActivityChart(
                        days = weeklyStats.daysBreakdown.map { it.dayNameTr to it.studyMinutes }
                    )
                }
            }
        }
    }
}
