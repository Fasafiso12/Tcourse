package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.*
import com.example.ui.theme.*
import com.example.viewmodel.AppNavTab
import com.example.viewmodel.MainViewModel

enum class LanguageCategoryFilter(val label: String) {
    ALL("Tümü (7)"),
    MOBILE_UI("Mobil & UI"),
    AI_DATA("Yapay Zeka & Veri"),
    SYSTEMS("Sistem & Donanım"),
    WEB_FULLSTACK("Web & Fullstack"),
    IN_PROGRESS("Devam Edenler")
}

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
    val allProgressMap by viewModel.allLanguagesProgress.collectAsState()
    val favorites by viewModel.allFavorites.collectAsState()
    val activeLang = languages.firstOrNull { it.id == selectedLanguageId } ?: languages.first()
    val allLessons = CourseCatalog.getLessonsForCourse(selectedLanguageId)
    val nextLesson = allLessons.firstOrNull { it.id == activeCourseProgress.nextLessonId } ?: allLessons.firstOrNull()

    var selectedCategoryFilter by remember { mutableStateOf(LanguageCategoryFilter.ALL) }
    var expandedLanguageId by remember { mutableStateOf<String?>(null) }

    // Filter languages based on category
    val filteredLanguages = remember(selectedCategoryFilter, allProgressMap) {
        when (selectedCategoryFilter) {
            LanguageCategoryFilter.ALL -> languages
            LanguageCategoryFilter.MOBILE_UI -> languages.filter { it.id in listOf("dart", "flutter", "kotlin") }
            LanguageCategoryFilter.AI_DATA -> languages.filter { it.id in listOf("python") }
            LanguageCategoryFilter.SYSTEMS -> languages.filter { it.id in listOf("cpp", "rust") }
            LanguageCategoryFilter.WEB_FULLSTACK -> languages.filter { it.id in listOf("javascript") }
            LanguageCategoryFilter.IN_PROGRESS -> languages.filter {
                val progress = allProgressMap[it.id]
                (progress?.completedLessonsCount ?: 0) > 0
            }.ifEmpty { languages }
        }
    }

    // Aggregate statistics across all 7 languages
    val totalLessonsAcrossAll = remember(languages) {
        languages.sumOf { CourseCatalog.getLessonsForCourse(it.id).size }
    }
    val totalCompletedAcrossAll = remember(allProgressMap) {
        allProgressMap.values.sumOf { it.completedLessonsCount }
    }
    val overallCompletionRate = if (totalLessonsAcrossAll > 0) {
        (totalCompletedAcrossAll.toFloat() / totalLessonsAcrossAll.toFloat()).coerceIn(0f, 1f)
    } else 0f

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 32.dp)
    ) {
        // 1. User Header Banner & XP Level Status
        item {
            UserHeroDashboardCard(
                userProfile = userProfile,
                onNavigateToProfile = { onNavigateToTab(AppNavTab.PROFILE) }
            )
        }

        // 2. Active Course Spotlight (Kaldığın Yerden Devam Et)
        item {
            ActiveCourseSpotlightCard(
                activeLanguage = activeLang,
                progressInfo = activeCourseProgress,
                nextLesson = nextLesson,
                onContinue = {
                    nextLesson?.let { onOpenLesson(it) }
                },
                onViewRoadmap = {
                    onNavigateToTab(AppNavTab.ROADMAP)
                }
            )
        }

        // 3. 7 Programming Languages Section Header & Interactive Filter Chips
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Programlama Dilleri",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = PrimarySubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder))
                        ) {
                            Text(
                                text = "7 Dil",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryIndigo,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }

                    TextButton(onClick = { onNavigateToTab(AppNavTab.COURSES) }) {
                        Text(
                            text = "Müfredat",
                            color = PrimaryIndigo,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Filter Chips Row
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 2.dp)
                ) {
                    items(LanguageCategoryFilter.values()) { filter ->
                        val isSelected = selectedCategoryFilter == filter
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedCategoryFilter = filter },
                            label = {
                                Text(
                                    text = filter.label,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PrimaryIndigo,
                                selectedLabelColor = Color.White,
                                containerColor = DarkSurface,
                                labelColor = TextSecondary
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = isSelected,
                                borderColor = if (isSelected) PrimaryIndigo else DarkCardBorder
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )
                    }
                }
            }
        }

        // 4. Interactive Cards for Each of the 7 Programming Languages
        items(filteredLanguages, key = { it.id }) { language ->
            val progressInfo = allProgressMap[language.id] ?: CourseProgressInfo(
                courseId = language.id,
                completedLessonsCount = 0,
                totalLessonsCount = CourseCatalog.getLessonsForCourse(language.id).size,
                progressPercentage = 0f
            )
            val isSelected = language.id == selectedLanguageId
            val isExpanded = expandedLanguageId == language.id
            val isFavorite = favorites.any { it.id == language.id }

            LanguageInteractiveCard(
                language = language,
                progressInfo = progressInfo,
                isSelected = isSelected,
                isExpanded = isExpanded,
                isFavorite = isFavorite,
                onCardClick = {
                    viewModel.selectLanguage(language.id)
                },
                onToggleExpand = {
                    expandedLanguageId = if (isExpanded) null else language.id
                },
                onToggleFavorite = {
                    viewModel.toggleFavorite(
                        id = language.id,
                        type = "language",
                        courseId = language.id,
                        title = language.name,
                        subtitle = language.tag,
                        currentFav = isFavorite
                    )
                },
                onStartLearning = {
                    viewModel.selectLanguage(language.id)
                    val lessons = CourseCatalog.getLessonsForCourse(language.id)
                    val target = lessons.firstOrNull { it.id == progressInfo.nextLessonId } ?: lessons.firstOrNull()
                    target?.let { onOpenLesson(it) }
                },
                onOpenLesson = { lesson ->
                    viewModel.selectLanguage(language.id)
                    onOpenLesson(lesson)
                },
                onOpenRoadmap = {
                    viewModel.selectLanguage(language.id)
                    onNavigateToTab(AppNavTab.ROADMAP)
                }
            )
        }

        // 5. Global Mastery & Multi-Language Progress Breakdown Card
        item {
            AllLanguagesMasterySummaryCard(
                languages = languages,
                allProgressMap = allProgressMap,
                totalCompleted = totalCompletedAcrossAll,
                totalLessons = totalLessonsAcrossAll,
                overallProgress = overallCompletionRate,
                onStartPractice = { onNavigateToTab(AppNavTab.PRACTICE) }
            )
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component 1: User Hero Dashboard Card
// -----------------------------------------------------------------------------------------
@Composable
private fun UserHeroDashboardCard(
    userProfile: UserProfileData,
    onNavigateToProfile: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(22.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(PrimarySubtle)
                            .border(1.5.dp, PrimaryIndigo, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("👨‍💻", fontSize = 22.sp)
                    }

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "Merhaba, ${userProfile.username}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = AccentEmeraldSubtle
                            ) {
                                Text(
                                    text = "Lvl ${userProfile.level}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = AccentEmeraldLight,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = userProfile.levelTitle,
                            fontSize = 12.sp,
                            color = TextSecondary
                        )
                    }
                }

                // Streak Flame Pill
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = AccentOrangeSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentOrangeBorder)),
                    modifier = Modifier.clickable { onNavigateToProfile() }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("🔥", fontSize = 14.sp)
                        Text(
                            text = "${userProfile.streakDays} Gün",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentOrange
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // XP Progress to next Level
            val xpProgress = (userProfile.currentXp.toFloat() / userProfile.xpForNextLevel.toFloat()).coerceIn(0f, 1f)
            val animatedXp by animateFloatAsState(targetValue = xpProgress, animationSpec = tween(600), label = "xpAnim")

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("⚡", fontSize = 12.sp)
                        Text(
                            text = "Seviye İlerlemesi",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextSecondary
                        )
                    }
                    Text(
                        text = "${userProfile.currentXp} / ${userProfile.xpForNextLevel} XP",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigo
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = { animatedXp },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = PrimaryIndigo,
                    trackColor = DarkSurfaceVariant
                )
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component 2: Active Course Spotlight Card
// -----------------------------------------------------------------------------------------
@Composable
private fun ActiveCourseSpotlightCard(
    activeLanguage: ProgrammingLanguage,
    progressInfo: CourseProgressInfo,
    nextLesson: Lesson?,
    onContinue: () -> Unit,
    onViewRoadmap: () -> Unit
) {
    val langBrandColor = Color(activeLanguage.colorHex)
    val pct = progressInfo.progressPercentage
    val animatedProgress by animateFloatAsState(targetValue = pct, animationSpec = tween(600), label = "spotlightProg")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .border(1.5.dp, langBrandColor.copy(alpha = 0.35f), RoundedCornerShape(22.dp))
            .testTag("resume_active_course_card"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(AccentEmeraldLight)
                    )
                    Text(
                        text = "AKTİF ÖĞRENİM",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted,
                        letterSpacing = 0.8.sp
                    )
                }

                TextButton(
                    onClick = onViewRoadmap,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Tüm Yol Haritası →",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigo
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(langBrandColor.copy(alpha = 0.12f))
                        .border(1.dp, langBrandColor.copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    if (activeLanguage.drawableRes != null) {
                        Image(
                            painter = painterResource(id = activeLanguage.drawableRes),
                            contentDescription = "${activeLanguage.name} logo",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Fit
                        )
                    } else {
                        Text(activeLanguage.iconEmoji, fontSize = 28.sp)
                    }
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${activeLanguage.name} Programlama",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = nextLesson?.let { "Sıradaki: ${it.title}" } ?: "Müfredatı Keşfet",
                        fontSize = 13.sp,
                        color = TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Progress Dial / Percent
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = langBrandColor.copy(alpha = 0.1f),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(langBrandColor.copy(alpha = 0.3f)))
                ) {
                    Text(
                        text = "%${(pct * 100).toInt()}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = langBrandColor,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Progress Bar
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${progressInfo.completedLessonsCount} / ${progressInfo.totalLessonsCount} Ders Tamamlandı",
                        fontSize = 12.sp,
                        color = TextMuted,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = if (pct >= 1f) "Tamamlandı 🏆" else "Devam Ediyor",
                        fontSize = 11.sp,
                        color = if (pct >= 1f) AccentEmeraldLight else TextSecondary,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = langBrandColor,
                    trackColor = DarkSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .testTag("continue_learning_button"),
                colors = ButtonDefaults.buttonColors(containerColor = langBrandColor),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if (progressInfo.completedLessonsCount == 0) "Kursa Başla" else "Kaldığın Yerden Devam Et",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component 3: Interactive Language Card with Progress Bar for Each Language
// -----------------------------------------------------------------------------------------
@Composable
private fun LanguageInteractiveCard(
    language: ProgrammingLanguage,
    progressInfo: CourseProgressInfo,
    isSelected: Boolean,
    isExpanded: Boolean,
    isFavorite: Boolean,
    onCardClick: () -> Unit,
    onToggleExpand: () -> Unit,
    onToggleFavorite: () -> Unit,
    onStartLearning: () -> Unit,
    onOpenLesson: (Lesson) -> Unit,
    onOpenRoadmap: () -> Unit
) {
    val brandColor = Color(language.colorHex)
    val lessons = remember(language.id) { CourseCatalog.getLessonsForCourse(language.id) }
    val pct = progressInfo.progressPercentage
    val animatedProgress by animateFloatAsState(targetValue = pct, animationSpec = tween(500), label = "cardProg_${language.id}")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) brandColor else DarkCardBorder,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onCardClick() }
            .animateContentSize()
            .testTag("course_card_${language.id}"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header Row: Emoji icon + Name & Tag + Actions (Favorite + Active pill)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(brandColor.copy(alpha = 0.12f))
                            .border(1.dp, brandColor.copy(alpha = 0.35f), RoundedCornerShape(15.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (language.drawableRes != null) {
                            Image(
                                painter = painterResource(id = language.drawableRes),
                                contentDescription = "${language.name} logo",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp)
                                    .clip(RoundedCornerShape(11.dp)),
                                contentScale = ContentScale.Fit
                            )
                        } else {
                            Text(language.iconEmoji, fontSize = 26.sp)
                        }
                    }

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = language.name,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )

                            if (language.isPopular) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = AccentOrangeSubtle
                                ) {
                                    Text(
                                        text = "Popüler 🔥",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AccentOrange,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = language.tag,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = brandColor
                        )
                    }
                }

                // Right Header Controls: Favorite + Active Badge
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    IconButton(
                        onClick = onToggleFavorite,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Favoriye Ekle",
                            tint = if (isFavorite) AccentAmber else TextMuted,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    if (isSelected) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = brandColor.copy(alpha = 0.12f),
                            border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(brandColor.copy(alpha = 0.4f)))
                        ) {
                            Text(
                                text = "Seçili",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = brandColor,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Short Description
            Text(
                text = language.shortDescription,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 18.sp,
                maxLines = if (isExpanded) 4 else 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Popular Uses Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                language.popularUses.take(3).forEach { useTag ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = DarkSurfaceVariant,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder))
                    ) {
                        Text(
                            text = useTag,
                            fontSize = 10.sp,
                            color = TextSecondary,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Interactive Progress Bar Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(DarkSurfaceVariant)
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "İlerleme Durumu",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimary
                        )
                        Text(
                            text = "• ${progressInfo.completedLessonsCount}/${progressInfo.totalLessonsCount} Ders",
                            fontSize = 11.sp,
                            color = TextMuted
                        )
                    }

                    // Percentage Badge
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (pct > 0f) brandColor.copy(alpha = 0.15f) else DarkBg,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(if (pct > 0f) brandColor.copy(alpha = 0.3f) else DarkCardBorder))
                    ) {
                        Text(
                            text = "%${(pct * 100).toInt()}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (pct > 0f) brandColor else TextMuted,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // The Progress Bar
                LinearProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = brandColor,
                    trackColor = DarkCardBorder
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Interactive Action Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Secondary: Expand / View Curriculum Button
                OutlinedButton(
                    onClick = onToggleExpand,
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder)),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPrimary),
                    contentPadding = PaddingValues(horizontal = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (isExpanded) "Gizle" else "Dersler (${lessons.size})",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                // Primary: Start / Continue Button
                Button(
                    onClick = onStartLearning,
                    modifier = Modifier
                        .weight(1.3f)
                        .height(42.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = brandColor),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (progressInfo.completedLessonsCount == 0) "Kursa Başla" else "Devam Et",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Accordion: Expanded Lessons Preview
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(DarkSurfaceVariant)
                        .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp))
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Müfredat Konuları",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )

                    lessons.forEachIndexed { idx, lesson ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { onOpenLesson(lesson) }
                                .padding(horizontal = 8.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "${idx + 1}.",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = brandColor
                                )
                                Text(
                                    text = lesson.title,
                                    fontSize = 12.sp,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            if (lesson.isPremium) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = AccentAmberSubtle
                                ) {
                                    Text(
                                        text = "🔒 Premium",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AccentAmber,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            } else {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = AccentEmeraldSubtle
                                ) {
                                    Text(
                                        text = "Ücretsiz",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AccentEmeraldLight,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    TextButton(
                        onClick = onOpenRoadmap,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Tüm Müfredatı Yol Haritasında Aç →",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigo
                        )
                    }
                }
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component 4: All Languages Mastery Spectrum Summary Card
// -----------------------------------------------------------------------------------------
@Composable
private fun AllLanguagesMasterySummaryCard(
    languages: List<ProgrammingLanguage>,
    allProgressMap: Map<String, CourseProgressInfo>,
    totalCompleted: Int,
    totalLessons: Int,
    overallProgress: Float,
    onStartPractice: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(22.dp)),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Genel Programlama Hakimiyeti",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "7 Dilde toplam ${totalCompleted} / ${totalLessons} ders tamamlandı",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = AccentEmeraldSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
                ) {
                    Text(
                        text = "%${(overallProgress * 100).toInt()}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = AccentEmeraldLight,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Multi-segment Mini Language Bars
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(DarkSurfaceVariant),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                languages.forEach { lang ->
                    val prog = allProgressMap[lang.id]
                    val pct = prog?.progressPercentage ?: 0f
                    val brandColor = Color(lang.colorHex)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(if (pct > 0f) brandColor else DarkCardBorder)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Mini legend row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                languages.forEach { lang ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(2.dp)
                    ) {
                        if (lang.drawableRes != null) {
                            Image(
                                painter = painterResource(id = lang.drawableRes),
                                contentDescription = "${lang.name} icon",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(RoundedCornerShape(5.dp)),
                                contentScale = ContentScale.Fit
                            )
                        } else {
                            Text(lang.iconEmoji, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = lang.name,
                            fontSize = 9.sp,
                            color = TextMuted,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedButton(
                onClick = onStartPractice,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                shape = RoundedCornerShape(12.dp),
                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder)),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = PrimarySubtle)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("💡", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Kodlama & Quiz Pratiği Yap",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigo
                    )
                }
            }
        }
    }
}
