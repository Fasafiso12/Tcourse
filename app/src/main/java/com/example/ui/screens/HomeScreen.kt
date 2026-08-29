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
            // 3. DAILY CHALLENGE (1-3 min Quick Task)
            // ====================================================
            item {
                AppCard(
                    modifier = Modifier
                        .clickable { viewModel.openDailyChallenge() }
                        .testTag("daily_challenge_card"),
                    containerColor = DarkSurface,
                    borderColor = if (dailyChallenge.isCompletedToday) AccentEmeraldBorder else AccentAmberBorder
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(AppSpacing.md)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(if (dailyChallenge.isCompletedToday) AccentEmeraldSubtle else AccentAmberSubtle)
                                .border(1.dp, if (dailyChallenge.isCompletedToday) AccentEmeraldBorder else AccentAmberBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (dailyChallenge.isCompletedToday) "✓" else "⚡",
                                fontSize = 20.sp,
                                color = if (dailyChallenge.isCompletedToday) AccentEmeraldLight else AccentAmber
                            )
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "GÜNÜN GÖREVİ",
                                    style = AppTypography.badge,
                                    color = if (dailyChallenge.isCompletedToday) AccentEmeraldLight else AccentAmber
                                )
                                if (dailyChallenge.isCompletedToday) {
                                    Text(
                                        text = "• Tamamlandı",
                                        style = AppTypography.caption,
                                        color = AccentEmeraldLight,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Text(
                                text = dailyChallenge.title,
                                style = AppTypography.title,
                                color = TextPrimary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (dailyChallenge.isCompletedToday) "+50 XP kazanıldı. Yarın yeni meydan okuma gelecek!" else "Hızlı soru ile +50 XP kazan ve serini koru.",
                                style = AppTypography.bodySmall,
                                color = TextSecondary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Icon(
                            Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = TextMuted,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // ====================================================
            // 4. PROGRESS DASHBOARD: D3-INSPIRED LESSON COMPLETION
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
            // 5. TOPIC MASTERY & INTERACTIVE ROADMAP PREVIEW
            // ====================================================
            item {
                Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)) {
                    SectionHeader(
                        title = "Konu Hakimiyeti",
                        iconEmoji = "🎯",
                        actionText = "Yol Haritası →",
                        onActionClick = { onNavigateToTab(AppNavTab.ROADMAP) }
                    )

                    AppCard(
                        modifier = Modifier.testTag("topic_mastery_card"),
                        containerColor = DarkSurface,
                        borderColor = DarkCardBorder
                    ) {
                        if (topicMasteryList.isEmpty()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = AppSpacing.xs),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                            ) {
                                Text("🌱", fontSize = 24.sp)
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Henüz Konu İlerlemesi Yok",
                                        style = AppTypography.title,
                                        color = TextPrimary
                                    )
                                    Text(
                                        text = "İlk dersini tamamlayarak konu hakimiyeti skorunu oluştur.",
                                        style = AppTypography.caption,
                                        color = TextSecondary
                                    )
                                }
                            }
                        } else {
                            topicMasteryList.take(4).forEach { topic ->
                                val targetLesson = remember(topic.topicId, allLessons) {
                                    allLessons.firstOrNull { it.id == topic.topicId }
                                }

                                Surface(
                                    shape = RoundedCornerShape(AppRadius.sm),
                                    color = DarkSurfaceVariant,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                        .then(
                                            if (targetLesson != null) Modifier.clickable { onOpenLesson(targetLesson) } else Modifier
                                        )
                                ) {
                                    Column(
                                        modifier = Modifier.padding(AppSpacing.sm),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(
                                                modifier = Modifier.weight(1f, fill = false),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                Text("📖", fontSize = 13.sp)
                                                Text(
                                                    text = topic.topicName,
                                                    style = AppTypography.body,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = TextPrimary,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }

                                            Surface(
                                                shape = RoundedCornerShape(AppRadius.xs),
                                                color = if (topic.totalPercentage >= 80) AccentEmeraldSubtle else PrimarySubtle,
                                                border = CardDefaults.outlinedCardBorder().copy(
                                                    brush = SolidColor(if (topic.totalPercentage >= 80) AccentEmeraldBorder else PrimarySubtleBorder)
                                                )
                                            ) {
                                                Text(
                                                    text = "%${topic.totalPercentage} • ${topic.masteryLevelTitle}",
                                                    style = AppTypography.badge,
                                                    color = if (topic.totalPercentage >= 80) AccentEmeraldLight else PrimaryIndigoLight,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        }

                                        AppProgressBar(
                                            progress = (topic.totalPercentage / 100f).coerceIn(0f, 1f),
                                            color = if (topic.totalPercentage >= 80) AccentEmerald else PrimaryIndigo,
                                            height = 4.dp
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(AppSpacing.xs))

                        // Quick Interactive Map Banner
                        Surface(
                            shape = RoundedCornerShape(AppRadius.sm),
                            color = PrimarySubtle.copy(alpha = 0.5f),
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onNavigateToTab(AppNavTab.ROADMAP) }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = AppSpacing.sm, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("🗺️", fontSize = 16.sp)
                                    Column {
                                        Text(
                                            text = "${activeLang.name} İnteraktif Yol Haritası",
                                            style = AppTypography.body,
                                            fontWeight = FontWeight.Bold,
                                            color = TextPrimary
                                        )
                                        Text(
                                            text = "Beceri ağacı ve adım adım öğrenme yolculuğu",
                                            style = AppTypography.caption,
                                            color = TextSecondary
                                        )
                                    }
                                }
                                Icon(
                                    Icons.Default.ChevronRight,
                                    contentDescription = null,
                                    tint = PrimaryIndigoLight,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }

            // ====================================================
            // 5. SMART REVIEW (Weak Areas / Repetition)
            // ====================================================
            if (smartReviews.isNotEmpty()) {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)) {
                        SectionHeader(
                            title = "Akıllı Tekrar",
                            subtitle = "Zayıf hissettiğin konuları pekiştir",
                            iconEmoji = "🧠"
                        )

                        smartReviews.forEach { review ->
                            SmartReviewCard(
                                topicTitle = review.topicName,
                                accuracyPct = (100 - review.mistakeCount * 15).coerceIn(20, 85),
                                mistakesCount = review.mistakeCount,
                                onReviewClick = {
                                    val lesson = CourseCatalog.getLessonsForCourse(review.courseId).firstOrNull { it.id == review.lessonId }
                                    lesson?.let { onOpenLesson(it) }
                                },
                                modifier = Modifier.testTag("smart_review_card_${review.lessonId}")
                            )
                        }
                    }
                }
            }

            // ====================================================
            // 6. ACHIEVEMENTS PREVIEW
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
            // 7. WEEKLY ACTIVITY SUMMARY
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

            // ====================================================
            // 8. ALL LANGUAGES BROWSER
            // ====================================================
            item {
                Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)) {
                    Text(
                        text = "Tüm Kurslar (${languages.size} Dil)",
                        style = AppTypography.heading3,
                        color = TextPrimary
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
                    ) {
                        items(languages) { lang ->
                            val isSelected = lang.id == selectedLanguageId
                            Surface(
                                shape = RoundedCornerShape(AppRadius.md),
                                color = if (isSelected) PrimarySubtle else DarkSurface,
                                border = CardDefaults.outlinedCardBorder().copy(
                                    brush = SolidColor(if (isSelected) PrimaryIndigo else DarkCardBorder)
                                ),
                                modifier = Modifier
                                    .clickable { viewModel.selectLanguage(lang.id) }
                                    .testTag("course_chip_${lang.id}")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    LanguageLogoBox(
                                        language = lang,
                                        size = 22.dp,
                                        shapeRadius = 6.dp,
                                        padding = 2.dp,
                                        fallbackEmojiSize = 13.sp
                                    )
                                    Text(
                                        text = lang.name,
                                        style = AppTypography.body,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) PrimaryIndigoLight else TextPrimary
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
