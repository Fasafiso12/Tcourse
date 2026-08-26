package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.util.AppStrings
import com.example.model.*
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

enum class CoursesScreenMode(val titleTr: String, val titleEn: String, val icon: String) {
    LANGUAGES_MENU("Diller Menüsü", "Languages Menu", "🏛️"),
    LESSON_LIST("Ders Listesi", "Lesson List", "📖")
}

enum class CourseCategoryFilter(val id: String, val labelTr: String, val labelEn: String, val icon: String) {
    ALL("all", "Tümü (11)", "All (11)", "⚡"),
    MOBILE("mobile", "Mobil & UI", "Mobile & UI", "📱"),
    AI_DATA("ai_data", "Yapay Zeka & Veri", "AI & Data", "🧠"),
    SYSTEMS("systems", "Sistem & Bulut", "Systems & Cloud", "⚙️"),
    WEB("web", "Web & Dağıtık", "Web & Distributed", "🌐")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoursesScreen(
    viewModel: MainViewModel,
    onOpenLesson: (Lesson) -> Unit
) {
    val languages = CourseCatalog.languages
    val selectedLanguageId by viewModel.selectedLanguageId.collectAsState()
    val allProgressMap by viewModel.allLanguagesProgress.collectAsState()
    val allProgressList by viewModel.allProgress.collectAsState()
    val userProfile by viewModel.userProfile.collectAsState()
    val appLanguage by viewModel.appLanguage.collectAsState()
    val isTr = appLanguage == AppLanguage.TR
    val strings = remember(appLanguage) { AppStrings.get(appLanguage) }

    var screenMode by remember { mutableStateOf(CoursesScreenMode.LANGUAGES_MENU) }
    var selectedCategory by remember { mutableStateOf(CourseCategoryFilter.ALL) }
    var selectedLevelFilter by remember { mutableStateOf<CourseLevel?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    val activeLanguage = remember(selectedLanguageId, languages) {
        languages.firstOrNull { it.id == selectedLanguageId } ?: languages.first()
    }

    val activeLessons = remember(selectedLanguageId) {
        CourseCatalog.getLessonsForCourse(selectedLanguageId)
    }

    val completedLessonIdsForActiveLang = remember(allProgressList, selectedLanguageId) {
        allProgressList
            .filter { it.courseId == selectedLanguageId && it.status == LessonStatus.COMPLETED.name }
            .map { it.lessonId }
            .toSet()
    }

    // Filter languages for the main menu
    val filteredLanguages = remember(selectedCategory, searchQuery, languages) {
        languages.filter { lang ->
            val matchesCategory = when (selectedCategory) {
                CourseCategoryFilter.ALL -> true
                CourseCategoryFilter.MOBILE -> lang.id in listOf("dart", "flutter", "kotlin")
                CourseCategoryFilter.AI_DATA -> lang.id in listOf("python")
                CourseCategoryFilter.SYSTEMS -> lang.id in listOf("c", "cpp", "rust", "go")
                CourseCategoryFilter.WEB -> lang.id in listOf("javascript", "lua", "elixir", "go")
            }

            val matchesSearch = if (searchQuery.isBlank()) {
                true
            } else {
                lang.name.contains(searchQuery, ignoreCase = true) ||
                        lang.tag.contains(searchQuery, ignoreCase = true) ||
                        lang.shortDescription.contains(searchQuery, ignoreCase = true)
            }

            matchesCategory && matchesSearch
        }
    }

    // Filter lessons for the selected language
    val filteredLessons = remember(activeLessons, selectedLevelFilter, searchQuery, screenMode) {
        if (screenMode == CoursesScreenMode.LESSON_LIST && searchQuery.isNotBlank()) {
            activeLessons.filter { lesson ->
                val matchesLevel = selectedLevelFilter == null || lesson.level == selectedLevelFilter
                val matchesSearch = lesson.title.contains(searchQuery, ignoreCase = true) ||
                        lesson.shortDesc.contains(searchQuery, ignoreCase = true)
                matchesLevel && matchesSearch
            }
        } else if (selectedLevelFilter != null) {
            activeLessons.filter { it.level == selectedLevelFilter }
        } else {
            activeLessons
        }
    }

    val totalLessonsAcrossAll = remember(languages) {
        languages.sumOf { CourseCatalog.getLessonsForCourse(it.id).size }
    }
    val totalCompletedAcrossAll = remember(allProgressMap) {
        allProgressMap.values.sumOf { it.completedLessonsCount }
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
    ) {
        val isWideScreen = maxWidth >= 840.dp

        if (isWideScreen) {
            // =========================================================================
            // TABLET / WIDE SCREEN: MASTER-DETAIL SIDE-BY-SIDE CANONICAL LAYOUT
            // =========================================================================
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Left Pane: Languages Main Menu
                Box(modifier = Modifier.weight(0.45f)) {
                    LanguagesMenuContent(
                        languages = filteredLanguages,
                        selectedLanguageId = selectedLanguageId,
                        allProgressMap = allProgressMap,
                        selectedCategory = selectedCategory,
                        searchQuery = searchQuery,
                        totalLessonsAcrossAll = totalLessonsAcrossAll,
                        totalCompletedAcrossAll = totalCompletedAcrossAll,
                        isTr = isTr,
                        onCategorySelected = { selectedCategory = it },
                        onSearchQueryChanged = { searchQuery = it },
                        onSelectLanguage = { langId ->
                            viewModel.selectLanguage(langId)
                        },
                        onViewLessonList = { langId ->
                            viewModel.selectLanguage(langId)
                        }
                    )
                }

                // Divider
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    color = DarkCardBorder
                )

                // Right Pane: Selectable Lesson List for Active Language
                Box(modifier = Modifier.weight(0.55f)) {
                    SelectableLessonListContent(
                        language = activeLanguage,
                        lessons = filteredLessons,
                        completedLessonIds = completedLessonIdsForActiveLang,
                        selectedLevelFilter = selectedLevelFilter,
                        allLanguages = languages,
                        allProgressMap = allProgressMap,
                        isUserPremium = userProfile.isPremium,
                        isTr = isTr,
                        onLevelFilterSelected = { selectedLevelFilter = it },
                        onSelectLanguage = { langId ->
                            viewModel.selectLanguage(langId)
                        },
                        onOpenLesson = onOpenLesson,
                        onBackToMenu = null // Not needed on tablet side-by-side
                    )
                }
            }
        } else {
            // =========================================================================
            // MOBILE SCREEN: TOP SEGMENTED SWITCHER (LANGUAGES MENU vs LESSON LIST)
            // =========================================================================
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                // Top View Switcher Header (Diller Menüsü vs Ders Listesi)
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = DarkSurface,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        CoursesScreenMode.values().forEach { mode ->
                            val isSelected = screenMode == mode
                            val label = if (mode == CoursesScreenMode.LANGUAGES_MENU) {
                                if (isTr) "Diller Ana Menüsü (${languages.size})" else "Languages Menu (${languages.size})"
                            } else {
                                "${activeLanguage.iconEmoji} ${activeLanguage.name} Dersleri (${activeLessons.size})"
                            }

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(if (isSelected) PrimaryIndigo else Color.Transparent)
                                    .clickable { screenMode = mode }
                                    .padding(vertical = 10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = if (mode == CoursesScreenMode.LANGUAGES_MENU) mode.icon else activeLanguage.iconEmoji,
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = label,
                                        fontSize = 12.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color.White else TextSecondary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Animated Transition between Menu & Lesson List
                AnimatedContent(
                    targetState = screenMode,
                    transitionSpec = {
                        if (targetState == CoursesScreenMode.LESSON_LIST) {
                            (fadeIn(animationSpec = tween(220)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left))
                                .togetherWith(fadeOut(animationSpec = tween(200)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left))
                        } else {
                            (fadeIn(animationSpec = tween(220)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right))
                                .togetherWith(fadeOut(animationSpec = tween(200)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right))
                        }
                    },
                    label = "courses_screen_mode_transition"
                ) { currentMode ->
                    when (currentMode) {
                        CoursesScreenMode.LANGUAGES_MENU -> {
                            LanguagesMenuContent(
                                languages = filteredLanguages,
                                selectedLanguageId = selectedLanguageId,
                                allProgressMap = allProgressMap,
                                selectedCategory = selectedCategory,
                                searchQuery = searchQuery,
                                totalLessonsAcrossAll = totalLessonsAcrossAll,
                                totalCompletedAcrossAll = totalCompletedAcrossAll,
                                isTr = isTr,
                                onCategorySelected = { selectedCategory = it },
                                onSearchQueryChanged = { searchQuery = it },
                                onSelectLanguage = { langId ->
                                    viewModel.selectLanguage(langId)
                                },
                                onViewLessonList = { langId ->
                                    viewModel.selectLanguage(langId)
                                    screenMode = CoursesScreenMode.LESSON_LIST
                                }
                            )
                        }
                        CoursesScreenMode.LESSON_LIST -> {
                            SelectableLessonListContent(
                                language = activeLanguage,
                                lessons = filteredLessons,
                                completedLessonIds = completedLessonIdsForActiveLang,
                                selectedLevelFilter = selectedLevelFilter,
                                allLanguages = languages,
                                allProgressMap = allProgressMap,
                                isUserPremium = userProfile.isPremium,
                                isTr = isTr,
                                onLevelFilterSelected = { selectedLevelFilter = it },
                                onSelectLanguage = { langId ->
                                    viewModel.selectLanguage(langId)
                                },
                                onOpenLesson = onOpenLesson,
                                onBackToMenu = { screenMode = CoursesScreenMode.LANGUAGES_MENU }
                            )
                        }
                    }
                }
            }
        }
    }
}

// =============================================================================
// COMPONENT 1: PROGRAMMING LANGUAGES MAIN MENU (DİLLER ANA MENÜSÜ)
// =============================================================================
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun LanguagesMenuContent(
    languages: List<ProgrammingLanguage>,
    selectedLanguageId: String,
    allProgressMap: Map<String, CourseProgressInfo>,
    selectedCategory: CourseCategoryFilter,
    searchQuery: String,
    totalLessonsAcrossAll: Int,
    totalCompletedAcrossAll: Int,
    isTr: Boolean,
    onCategorySelected: (CourseCategoryFilter) -> Unit,
    onSearchQueryChanged: (String) -> Unit,
    onSelectLanguage: (String) -> Unit,
    onViewLessonList: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(bottom = 36.dp)
    ) {
        // --- 1. Hero Overview & Academy Stats Card ---
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(22.dp))
                    .testTag("languages_academy_card"),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = PrimarySubtle,
                                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder)),
                                modifier = Modifier.padding(bottom = 6.dp)
                            ) {
                                Text(
                                    text = if (isTr) "${languages.size} PROGRAMLAMA DİLİ" else "${languages.size} FULL TRACKS",
                                    color = PrimaryIndigoLight,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                            Text(
                                text = if (isTr) "Yazılım Geliştirme Akademisi" else "Software Engineering Academy",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = if (isTr)
                                    "İstediğin dili seç, konuları incele ve interaktif derslerle uzmanlaş."
                                else
                                    "Choose any language track and explore comprehensive lesson modules.",
                                fontSize = 12.sp,
                                color = TextSecondary,
                                lineHeight = 16.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(PrimarySubtle)
                                .border(1.dp, PrimarySubtleBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "🎓", fontSize = 24.sp)
                        }
                    }

                    // Stat Highlights Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(DarkSurfaceVariant)
                            .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp))
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StatBadgeItem(label = if (isTr) "Diller" else "Tracks", value = "${languages.size} Dil", icon = "📚")
                        VerticalDivider()
                        StatBadgeItem(label = if (isTr) "Toplam Ders" else "Total Lessons", value = "$totalLessonsAcrossAll", icon = "📝")
                        VerticalDivider()
                        StatBadgeItem(label = if (isTr) "Tamamlanan" else "Completed", value = "$totalCompletedAcrossAll", icon = "✅")
                        VerticalDivider()
                        StatBadgeItem(label = if (isTr) "Sertifika" else "Certificates", value = "${languages.size} Adet", icon = "🏆")
                    }
                }
            }
        }

        // --- 2. Search & Category Filter Pills ---
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Search Input
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChanged,
                    placeholder = {
                        Text(
                            text = if (isTr) "Dil veya teknoloji ara (Python, Compose, Rust...)" else "Search languages or tags...",
                            fontSize = 12.sp,
                            color = TextMuted
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null, tint = TextMuted, modifier = Modifier.size(18.dp))
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { onSearchQueryChanged("") }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear", tint = TextMuted, modifier = Modifier.size(16.dp))
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = DarkSurface,
                        unfocusedContainerColor = DarkSurface,
                        focusedBorderColor = PrimaryIndigo,
                        unfocusedBorderColor = DarkCardBorder,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("languages_search_field")
                )

                // Category Filter Pills
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    CourseCategoryFilter.values().forEach { cat ->
                        val isSelected = cat == selectedCategory
                        FilterChip(
                            selected = isSelected,
                            onClick = { onCategorySelected(cat) },
                            leadingIcon = { Text(cat.icon, fontSize = 12.sp) },
                            label = {
                                Text(
                                    text = if (isTr) cat.labelTr else cat.labelEn,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
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
                            modifier = Modifier.testTag("category_filter_${cat.id}")
                        )
                    }
                }
            }
        }

        // --- 3. Language Cards List ---
        if (languages.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 36.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isTr) "Arama kriterine uygun dil bulunamadı." else "No languages match your search.",
                        color = TextMuted,
                        fontSize = 13.sp
                    )
                }
            }
        } else {
            items(languages, key = { it.id }) { lang ->
                val progress = allProgressMap[lang.id]
                val completedCount = progress?.completedLessonsCount ?: 0
                val totalCount = progress?.totalLessonsCount ?: lang.totalLessonsCount
                val isCurrentActive = lang.id == selectedLanguageId

                LanguageMenuCard(
                    language = lang,
                    completedCount = completedCount,
                    totalCount = totalCount,
                    isActive = isCurrentActive,
                    isTr = isTr,
                    onSelect = { onSelectLanguage(lang.id) },
                    onViewLessons = { onViewLessonList(lang.id) }
                )
            }
        }
    }
}

// =============================================================================
// COMPONENT 2: LANGUAGE CARD IN MAIN MENU
// =============================================================================
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun LanguageMenuCard(
    language: ProgrammingLanguage,
    completedCount: Int,
    totalCount: Int,
    isActive: Boolean,
    isTr: Boolean,
    onSelect: () -> Unit,
    onViewLessons: () -> Unit
) {
    val brandColor = Color(language.colorHex)
    val completionRatio = if (totalCount > 0) (completedCount.toFloat() / totalCount.toFloat()).coerceIn(0f, 1f) else 0f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                1.dp,
                if (isActive) PrimaryIndigo else DarkCardBorder,
                RoundedCornerShape(20.dp)
            )
            .clickable { onSelect() }
            .testTag("language_card_${language.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isActive) DarkSurfaceVariant else DarkSurface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            // Header Row: Logo, Name & Active Tag
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(brandColor.copy(alpha = 0.15f))
                            .border(1.dp, brandColor.copy(alpha = 0.4f), RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (language.drawableRes != null) {
                            Image(
                                painter = painterResource(id = language.drawableRes),
                                contentDescription = "${language.name} logo",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(6.dp)
                                    .clip(RoundedCornerShape(10.dp)),
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
                            if (isActive) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = PrimarySubtle,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
                                ) {
                                    Text(
                                        text = if (isTr) "Aktif Dil" else "Active",
                                        color = PrimaryIndigoLight,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                        Text(
                            text = language.tag,
                            fontSize = 11.sp,
                            color = PrimaryIndigoLight
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = AccentEmeraldSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentEmeraldBorder))
                ) {
                    Text(
                        text = "$totalCount Ders",
                        color = AccentEmeraldLight,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            // Description
            Text(
                text = language.shortDescription,
                fontSize = 12.sp,
                color = TextSecondary,
                lineHeight = 17.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Popular Uses Chips
            if (language.popularUses.isNotEmpty()) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    language.popularUses.forEach { useTag ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = DarkBg,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder))
                        ) {
                            Text(
                                text = "• $useTag",
                                fontSize = 10.sp,
                                color = TextMuted,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                            )
                        }
                    }
                }
            }

            // Progress Bar
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (isTr) "$completedCount / $totalCount Ders Tamamlandı" else "$completedCount of $totalCount Lessons",
                        fontSize = 11.sp,
                        color = TextMuted
                    )
                    Text(
                        text = "%${(completionRatio * 100).toInt()}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (completedCount > 0) brandColor else TextMuted
                    )
                }
                LinearProgressIndicator(
                    progress = { completionRatio },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = brandColor,
                    trackColor = DarkBg
                )
            }

            // Action Buttons Row: "Ders Listesini Gör" & "Kursa Başla"
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = { onViewLessons() },
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp)
                        .testTag("view_lessons_btn_${language.id}"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = PrimaryIndigoLight
                    ),
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimaryIndigo.copy(alpha = 0.5f)))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("📖", fontSize = 12.sp)
                        Text(
                            text = if (isTr) "Ders Listesi ($totalCount)" else "Lesson List ($totalCount)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Button(
                    onClick = { onViewLessons() },
                    modifier = Modifier
                        .weight(1f)
                        .height(42.dp)
                        .testTag("start_lang_btn_${language.id}"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = if (completedCount > 0)
                                (if (isTr) "Devam Et" else "Continue")
                            else
                                (if (isTr) "Kursa Başla" else "Start Track"),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                    }
                }
            }
        }
    }
}

// =============================================================================
// COMPONENT 3: SELECTABLE LESSON LIST FOR THE SELECTED LANGUAGE
// =============================================================================
@Composable
private fun SelectableLessonListContent(
    language: ProgrammingLanguage,
    lessons: List<Lesson>,
    completedLessonIds: Set<String>,
    selectedLevelFilter: CourseLevel?,
    allLanguages: List<ProgrammingLanguage>,
    allProgressMap: Map<String, CourseProgressInfo>,
    isUserPremium: Boolean,
    isTr: Boolean,
    onLevelFilterSelected: (CourseLevel?) -> Unit,
    onSelectLanguage: (String) -> Unit,
    onOpenLesson: (Lesson) -> Unit,
    onBackToMenu: (() -> Unit)?
) {
    val brandColor = Color(language.colorHex)
    val progress = allProgressMap[language.id]
    val completedCount = progress?.completedLessonsCount ?: 0
    val totalCount = lessons.size

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 36.dp)
    ) {
        // --- 1. Top Quick Language Switcher Strip ---
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isTr) "Programlama Dili Değiştir:" else "Switch Language Track:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextSecondary
                    )

                    if (onBackToMenu != null) {
                        TextButton(
                            onClick = onBackToMenu,
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = if (isTr) "← Diller Menüsü" else "← Languages Menu",
                                fontSize = 11.sp,
                                color = PrimaryIndigoLight,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Horizontal Strip of all 7 Languages
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(allLanguages) { lang ->
                        val isSelected = lang.id == language.id
                        val langProgress = allProgressMap[lang.id]
                        val langCompleted = langProgress?.completedLessonsCount ?: 0
                        val langColor = Color(lang.colorHex)

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) PrimarySubtle else DarkSurface,
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = SolidColor(if (isSelected) PrimaryIndigo else DarkCardBorder)
                            ),
                            modifier = Modifier
                                .clickable { onSelectLanguage(lang.id) }
                                .testTag("strip_lang_chip_${lang.id}")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(lang.iconEmoji, fontSize = 14.sp)
                                Text(
                                    text = lang.name,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) PrimaryIndigoLight else TextPrimary
                                )
                                if (langCompleted > 0) {
                                    Box(
                                        modifier = Modifier
                                            .size(6.dp)
                                            .clip(CircleShape)
                                            .background(AccentEmerald)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // --- 2. Active Language Hero Banner ---
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, brandColor.copy(alpha = 0.5f), RoundedCornerShape(20.dp))
                    .testTag("active_language_hero_card"),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(brandColor.copy(alpha = 0.2f))
                                    .border(1.dp, brandColor.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                if (language.drawableRes != null) {
                                    Image(
                                        painter = painterResource(id = language.drawableRes),
                                        contentDescription = "${language.name} logo",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(5.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                } else {
                                    Text(language.iconEmoji, fontSize = 24.sp)
                                }
                            }

                            Column(modifier = Modifier.weight(1f, fill = false)) {
                                Text(
                                    text = "${language.name} Ders Kataloğu",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = language.targetAudience,
                                    fontSize = 11.sp,
                                    color = TextSecondary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AccentAmberSubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder)),
                            modifier = Modifier.padding(start = 6.dp)
                        ) {
                            Text(
                                text = if (isTr) "🏆 Sertifikalı" else "🏆 Certified",
                                color = AccentAmber,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    // Progress Bar for this track
                    val ratio = if (totalCount > 0) (completedCount.toFloat() / totalCount.toFloat()).coerceIn(0f, 1f) else 0f
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = if (isTr) "$completedCount / $totalCount Ders Tamamlandı" else "$completedCount of $totalCount Completed",
                                fontSize = 11.sp,
                                color = TextMuted
                            )
                            Text(
                                text = "%${(ratio * 100).toInt()} Başarı",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (completedCount > 0) AccentEmeraldLight else PrimaryIndigoLight
                            )
                        }
                        LinearProgressIndicator(
                            progress = { ratio },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = AccentEmerald,
                            trackColor = DarkSurfaceVariant
                        )
                    }
                }
            }
        }

        // --- 3. Lesson Level Filter Pills ---
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    FilterChip(
                        selected = selectedLevelFilter == null,
                        onClick = { onLevelFilterSelected(null) },
                        label = { Text(if (isTr) "Tüm Dersler (${lessons.size})" else "All Lessons", fontSize = 11.sp) },
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
                }

                items(
                    listOf(
                        CourseLevel.BEGINNER to (if (isTr) "Başlangıç" else "Beginner"),
                        CourseLevel.INTERMEDIATE to (if (isTr) "Orta" else "Intermediate"),
                        CourseLevel.ADVANCED to (if (isTr) "İleri" else "Advanced")
                    )
                ) { (lvl, title) ->
                    val isLvlSelected = selectedLevelFilter == lvl
                    FilterChip(
                        selected = isLvlSelected,
                        onClick = {
                            onLevelFilterSelected(if (isLvlSelected) null else lvl)
                        },
                        label = { Text(title, fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PrimaryIndigo,
                            selectedLabelColor = Color.White,
                            containerColor = DarkSurface,
                            labelColor = TextSecondary
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            enabled = true,
                            selected = isLvlSelected,
                            borderColor = if (isLvlSelected) PrimaryIndigo else DarkCardBorder
                        )
                    )
                }
            }
        }

        // --- 4. Selectable Lesson Cards List ---
        if (lessons.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isTr) "Seçilen seviyede ders bulunamadı." else "No lessons match this level.",
                        color = TextMuted,
                        fontSize = 13.sp
                    )
                }
            }
        } else {
            itemsIndexed(lessons, key = { _, l -> l.id }) { index, lesson ->
                val isCompleted = completedLessonIds.contains(lesson.id)

                SelectableLessonItemCard(
                    index = index + 1,
                    lesson = lesson,
                    isCompleted = isCompleted,
                    isUserPremium = isUserPremium,
                    isTr = isTr,
                    onOpen = { onOpenLesson(lesson) }
                )
            }
        }
    }
}

// =============================================================================
// COMPONENT 4: INDIVIDUAL SELECTABLE LESSON CARD
// =============================================================================
@Composable
private fun SelectableLessonItemCard(
    index: Int,
    lesson: Lesson,
    isCompleted: Boolean,
    isUserPremium: Boolean,
    isTr: Boolean,
    onOpen: () -> Unit
) {
    val isLocked = lesson.isPremium && !isUserPremium

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                if (isCompleted) AccentEmeraldBorder else if (isLocked) DarkCardBorder else DarkCardBorder,
                RoundedCornerShape(16.dp)
            )
            .clickable { onOpen() }
            .testTag("selectable_lesson_item_${lesson.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isCompleted) DarkSurfaceVariant else DarkSurface
        )
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Index & Status Badge
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        if (isCompleted) AccentEmeraldSubtle
                        else if (isLocked) DarkBg
                        else PrimarySubtle
                    )
                    .border(
                        1.dp,
                        if (isCompleted) AccentEmeraldBorder
                        else if (isLocked) DarkCardBorder
                        else PrimarySubtleBorder,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isCompleted) {
                    Text("✓", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                } else if (isLocked) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Locked",
                        tint = TextMuted,
                        modifier = Modifier.size(18.dp)
                    )
                } else {
                    Text(
                        text = String.format("%02d", index),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigoLight
                    )
                }
            }

            // Lesson Details
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = lesson.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isLocked) TextSecondary else TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = lesson.shortDesc,
                    fontSize = 11.sp,
                    color = TextMuted,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 15.sp
                )

                // Mini Badges (Level, XP, Quiz, Premium status)
                Row(
                    modifier = Modifier.padding(top = 2.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (lesson.isPremium) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = if (isUserPremium) AccentEmeraldSubtle else AccentAmberSubtle
                        ) {
                            Text(
                                text = if (isUserPremium) (if (isTr) "👑 PRO Açık" else "👑 PRO Unlocked") else "🔒 PRO",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isUserPremium) AccentEmeraldLight else AccentAmber,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = DarkBg
                    ) {
                        Text(
                            text = lesson.level.displayName.substringBefore(" ("),
                            fontSize = 9.sp,
                            color = TextMuted,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = AccentAmberSubtle
                    ) {
                        Text(
                            text = "+20 XP",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentAmber,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                        )
                    }

                    if (lesson.quizQuestions.isNotEmpty()) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = PrimarySubtle
                        ) {
                            Text(
                                text = "🧪 Quiz",
                                fontSize = 9.sp,
                                color = PrimaryIndigoLight,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            // Action Chevron / Arrow
            Icon(
                imageVector = if (isLocked) Icons.Default.Lock else Icons.Default.ChevronRight,
                contentDescription = "Open Lesson",
                tint = if (isCompleted) AccentEmeraldLight else if (isLocked) TextMuted else PrimaryIndigoLight,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

// =============================================================================
// HELPER STAT ITEMS
// =============================================================================
@Composable
private fun StatBadgeItem(label: String, value: String, icon: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(icon, fontSize = 11.sp)
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        }
        Text(
            text = label,
            fontSize = 9.sp,
            color = TextMuted
        )
    }
}

@Composable
private fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .height(22.dp)
            .width(1.dp),
        color = DarkCardBorder
    )
}
