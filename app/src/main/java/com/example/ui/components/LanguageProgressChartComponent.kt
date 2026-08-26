package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.CourseProgressInfo
import com.example.model.ProgrammingLanguage
import com.example.ui.theme.*
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sqrt

/**
 * Chart display modes for multi-language progress visualization.
 */
enum class ProgressChartViewMode(val title: String, val shortLabel: String) {
    COMPLETION_PERCENTAGE("Ders Tamamlama Oranı (%)", "Tamamlama %"),
    COMPLETED_LESSONS("Tamamlanan Ders Sayısı", "Ders Sayısı"),
    RADIAL_BARS("Dil Karşılaştırma", "Karşılaştırma")
}

/**
 * Data slice representation for the D3-inspired interactive chart.
 */
data class LanguageProgressSlice(
    val language: ProgrammingLanguage,
    val value: Float,
    val percentageOfTotal: Float,
    val completionPercentage: Float,
    val completedCount: Int,
    val totalCount: Int,
    val startAngle: Float,
    val sweepAngle: Float,
    val color: Color
)

/**
 * D3-inspired interactive Dashboard Card visualizing lesson completion percentage ("Ders Tamamlama")
 * across all programming languages with animated charts, touch-interactive slices, and telemetry.
 */
@Composable
fun LanguageProgressChartComponent(
    languages: List<ProgrammingLanguage> = CourseCatalog.languages,
    progressMap: Map<String, CourseProgressInfo> = emptyMap(),
    streakDays: Int = 7,
    modifier: Modifier = Modifier,
    onLanguageClick: ((ProgrammingLanguage) -> Unit)? = null,
    title: String = "Ders Tamamlama & Öğrenim İlerlemesi"
) {
    var selectedLanguageId by remember { mutableStateOf<String?>(null) }
    var viewMode by remember { mutableStateOf(ProgressChartViewMode.COMPLETION_PERCENTAGE) }

    // Aggregate statistics across all curriculum
    val totalLessons = remember(languages) {
        languages.sumOf { CourseCatalog.getLessonsForCourse(it.id).size.coerceAtLeast(1) }
    }
    val totalCompleted = remember(progressMap) {
        progressMap.values.sumOf { it.completedLessonsCount }
    }
    val overallPercentage = remember(totalLessons, totalCompleted) {
        if (totalLessons > 0) ((totalCompleted.toFloat() / totalLessons.toFloat()) * 100f).coerceIn(0f, 100f) else 0f
    }

    // Build chart slices with calculated angles and color mappings
    val slices = remember(languages, progressMap, viewMode) {
        buildAllLanguageSlices(languages, progressMap, viewMode)
    }

    val selectedSlice = remember(selectedLanguageId, slices) {
        slices.firstOrNull { it.language.id == selectedLanguageId }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppRadius.lg))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(AppRadius.lg))
            .testTag("language_progress_dashboard_card"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.md)
        ) {
            val isCompact = maxWidth < 560.dp

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
            ) {
                // 1. Dashboard Header: Responsive Layout
                if (isCompact) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .background(PrimarySubtle)
                                    .border(1.dp, PrimarySubtleBorder, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("📊", fontSize = 18.sp)
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = title,
                                    style = AppTypography.heading3,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "${languages.size} Programlama Dili Analizi",
                                    style = AppTypography.caption,
                                    color = TextMuted
                                )
                            }
                        }

                        // Full-Width Segmented View Mode Selector
                        Surface(
                            shape = RoundedCornerShape(AppRadius.sm),
                            color = DarkSurfaceVariant,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(2.dp)
                            ) {
                                ProgressChartViewMode.values().forEach { mode ->
                                    val isSelected = viewMode == mode
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clip(RoundedCornerShape(AppRadius.xs))
                                            .background(if (isSelected) PrimaryIndigo else Color.Transparent)
                                            .clickable { viewMode = mode }
                                            .padding(vertical = 6.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = mode.shortLabel,
                                            style = AppTypography.badge,
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
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm),
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .background(PrimarySubtle)
                                    .border(1.dp, PrimarySubtleBorder, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("📊", fontSize = 18.sp)
                            }

                            Column {
                                Text(
                                    text = title,
                                    style = AppTypography.heading3,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "${languages.size} Programlama Dili Analizi",
                                    style = AppTypography.caption,
                                    color = TextMuted
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(AppRadius.sm),
                            color = DarkSurfaceVariant,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder))
                        ) {
                            Row(modifier = Modifier.padding(2.dp)) {
                                ProgressChartViewMode.values().forEach { mode ->
                                    val isSelected = viewMode == mode
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(AppRadius.xs))
                                            .background(if (isSelected) PrimaryIndigo else Color.Transparent)
                                            .clickable { viewMode = mode }
                                            .padding(horizontal = 10.dp, vertical = 6.dp)
                                            .testTag("chart_mode_${mode.name.lowercase()}"),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = mode.shortLabel,
                                            style = AppTypography.badge,
                                            color = if (isSelected) Color.White else TextSecondary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // 2. Active Learning Disciplinary Streak Strip
                LearningStreakStrip(streakDays = streakDays)

                // 3. D3-Inspired Interactive Donut / Radial Arc Canvas + Center Telemetry
                if (viewMode == ProgressChartViewMode.RADIAL_BARS) {
                    RadialProgressBarsView(
                        slices = slices,
                        selectedLanguageId = selectedLanguageId,
                        onSelectLanguage = { langId ->
                            selectedLanguageId = if (selectedLanguageId == langId) null else langId
                        }
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        InteractiveD3DonutCanvas(
                            slices = slices,
                            selectedLanguageId = selectedLanguageId,
                            onSliceSelected = { langId ->
                                selectedLanguageId = if (selectedLanguageId == langId) null else langId
                            },
                            modifier = Modifier.size(220.dp)
                        )

                        DonutTelemetryCenter(
                            selectedSlice = selectedSlice,
                            totalCompleted = totalCompleted,
                            totalLessons = totalLessons,
                            overallPercentage = overallPercentage,
                            streakDays = streakDays,
                            onClearSelection = { selectedLanguageId = null }
                        )
                    }
                }

                // Quick Guidance Tip
                Text(
                    text = if (selectedSlice != null) "💡 Seçili dili kapatmak için tekrar dokun veya kursa git." else "👆 Herhangi bir programlama dilinin detayını görmek için dokunun.",
                    style = AppTypography.caption,
                    color = TextMuted,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                // Selected Language Action Banner if active
                selectedSlice?.let { slice ->
                    Surface(
                        shape = RoundedCornerShape(AppRadius.md),
                        color = slice.color.copy(alpha = 0.12f),
                        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(slice.color.copy(alpha = 0.5f))),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(AppRadius.md))
                            .clickable { onLanguageClick?.invoke(slice.language) }
                            .testTag("selected_lang_action_banner")
                    ) {
                        Row(
                            modifier = Modifier.padding(AppSpacing.sm),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(slice.language.iconEmoji, fontSize = 20.sp)
                                Column {
                                    Text(
                                        text = "${slice.language.name} Kursuna Git",
                                        style = AppTypography.body,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    Text(
                                        text = "%${(slice.completionPercentage * 100).toInt()} tamamlandı • ${slice.completedCount}/${slice.totalCount} Ders",
                                        style = AppTypography.caption,
                                        color = slice.color
                                    )
                                }
                            }
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = slice.color,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                Divider(color = DarkCardBorder.copy(alpha = 0.6f), thickness = 1.dp)

                // 4. "Ders Tamamlama" Percentage Breakdown for Every Single Language
                Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.xs)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Tüm Dillerde Ders Tamamlama Yüzdesi",
                            style = AppTypography.title,
                            color = TextPrimary,
                            modifier = Modifier.weight(1f, fill = false)
                        )

                        Surface(
                            shape = RoundedCornerShape(AppRadius.xs),
                            color = PrimarySubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
                        ) {
                            Text(
                                text = "${slices.count { it.completedCount > 0 }}/${languages.size} Başlandı",
                                style = AppTypography.badge,
                                color = PrimaryIndigoLight,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                            )
                        }
                    }

                    // Responsive List/Grid based on available container width
                    if (isCompact) {
                        // High-legibility full-width rows for mobile screens
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            slices.forEach { slice ->
                                val isSelected = slice.language.id == selectedLanguageId
                                LanguageCompletionRow(
                                    slice = slice,
                                    isSelected = isSelected,
                                    onClick = {
                                        selectedLanguageId = if (isSelected) null else slice.language.id
                                        onLanguageClick?.invoke(slice.language)
                                    }
                                )
                            }
                        }
                    } else {
                        // Multi-column cards for wider screens
                        Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.xs)) {
                            slices.chunked(2).forEach { rowSlices ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
                                ) {
                                    rowSlices.forEach { slice ->
                                        val isSelected = slice.language.id == selectedLanguageId
                                        LanguageCompletionCard(
                                            slice = slice,
                                            isSelected = isSelected,
                                            onClick = {
                                                selectedLanguageId = if (isSelected) null else slice.language.id
                                                onLanguageClick?.invoke(slice.language)
                                            },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    if (rowSlices.size == 1) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
                        }
                    }
                }

                // 5. Total Metrics Summary Footer
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(AppRadius.md))
                        .background(DarkSurfaceVariant)
                        .border(1.dp, DarkCardBorder, RoundedCornerShape(AppRadius.md))
                        .padding(horizontal = AppSpacing.sm, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MetricColumn(
                        emoji = "📚",
                        title = "Dersler",
                        value = "$totalCompleted / $totalLessons"
                    )
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(DarkCardBorder))
                    MetricColumn(
                        emoji = "🎯",
                        title = "Genel Başarı",
                        value = "%${overallPercentage.toInt()}"
                    )
                    Box(modifier = Modifier.width(1.dp).height(24.dp).background(DarkCardBorder))
                    MetricColumn(
                        emoji = "🔥",
                        title = "Seri",
                        value = "$streakDays Gün"
                    )
                }
            }
        }
    }
}

/**
 * Animated Canvas drawing D3-inspired Donut arcs with smooth tap detection.
 */
@Composable
private fun InteractiveD3DonutCanvas(
    slices: List<LanguageProgressSlice>,
    selectedLanguageId: String?,
    onSliceSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(slices) {
        animationProgress.snapTo(0f)
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 850, easing = FastOutSlowInEasing)
        )
    }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Canvas(
        modifier = modifier
            .testTag("d3_donut_canvas")
            .pointerInput(slices) {
                detectTapGestures { tapOffset ->
                    val canvasWidth = size.width.toFloat()
                    val canvasHeight = size.height.toFloat()
                    val center = Offset(canvasWidth / 2f, canvasHeight / 2f)
                    val radius = (minOf(canvasWidth, canvasHeight) / 2f) * 0.9f
                    val innerRadius = radius * 0.58f

                    val dx = tapOffset.x - center.x
                    val dy = tapOffset.y - center.y
                    val distance = sqrt((dx * dx) + (dy * dy))

                    if (distance in innerRadius..radius * 1.15f) {
                        var angle = (atan2(dy, dx) * 180f / PI.toFloat())
                        if (angle < 0) angle += 360f

                        val clickedSlice = slices.firstOrNull { slice ->
                            val start = slice.startAngle
                            val end = slice.startAngle + slice.sweepAngle
                            if (end > 360f) {
                                (angle in start..360f) || (angle in 0f..(end - 360f))
                            } else {
                                angle in start..end
                            }
                        }
                        if (clickedSlice != null) {
                            onSliceSelected(clickedSlice.language.id)
                        }
                    } else if (distance < innerRadius) {
                        onSliceSelected("")
                    }
                }
            }
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val center = Offset(canvasWidth / 2f, canvasHeight / 2f)
        val outerRadius = (minOf(canvasWidth, canvasHeight) / 2f) * 0.88f
        val strokeWidth = outerRadius * 0.38f

        val currentProgress = animationProgress.value

        // Draw background base ring
        drawCircle(
            color = Color(0xFF1E293B).copy(alpha = 0.5f),
            radius = outerRadius - strokeWidth / 2f,
            center = center,
            style = Stroke(width = strokeWidth)
        )

        // Draw each language slice
        slices.forEach { slice ->
            val isSelected = slice.language.id == selectedLanguageId
            val sweep = slice.sweepAngle * currentProgress
            if (sweep > 0.5f) {
                val effectiveStroke = if (isSelected) strokeWidth * pulseScale else strokeWidth
                val radiusOffset = if (isSelected) 4.dp.toPx() else 0f

                drawArc(
                    color = slice.color,
                    startAngle = slice.startAngle,
                    sweepAngle = (sweep - 1.2f).coerceAtLeast(0.5f),
                    useCenter = false,
                    topLeft = Offset(
                        center.x - (outerRadius - strokeWidth / 2f + radiusOffset),
                        center.y - (outerRadius - strokeWidth / 2f + radiusOffset)
                    ),
                    size = Size(
                        (outerRadius - strokeWidth / 2f + radiusOffset) * 2f,
                        (outerRadius - strokeWidth / 2f + radiusOffset) * 2f
                    ),
                    style = Stroke(width = effectiveStroke, cap = StrokeCap.Round)
                )
            }
        }
    }
}

/**
 * Radial multi-bar alternative chart view
 */
@Composable
private fun RadialProgressBarsView(
    slices: List<LanguageProgressSlice>,
    selectedLanguageId: String?,
    onSelectLanguage: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = AppSpacing.xs),
        verticalArrangement = Arrangement.spacedBy(AppSpacing.xs)
    ) {
        slices.forEach { slice ->
            val isSelected = slice.language.id == selectedLanguageId
            val percentage = (slice.completionPercentage * 100).toInt()

            Surface(
                shape = RoundedCornerShape(AppRadius.sm),
                color = if (isSelected) slice.color.copy(alpha = 0.12f) else DarkSurfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = SolidColor(if (isSelected) slice.color else DarkCardBorder)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(AppRadius.sm))
                    .clickable { onSelectLanguage(slice.language.id) }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = AppSpacing.sm, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)
                ) {
                    Text(slice.language.iconEmoji, fontSize = 16.sp)
                    Text(
                        text = slice.language.name,
                        style = AppTypography.body,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary,
                        modifier = Modifier.widthIn(min = 60.dp, max = 100.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    LinearProgressIndicator(
                        progress = { slice.completionPercentage },
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = slice.color,
                        trackColor = DarkCardBorder.copy(alpha = 0.5f)
                    )

                    Text(
                        text = "%$percentage",
                        style = AppTypography.caption,
                        fontWeight = FontWeight.Bold,
                        color = slice.color,
                        modifier = Modifier.widthIn(min = 36.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

/**
 * Mobile-optimized full-width row for Language Progress
 */
@Composable
private fun LanguageCompletionRow(
    slice: LanguageProgressSlice,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) slice.color else DarkCardBorder,
        label = "rowBorderAnim"
    )
    val bgColor by animateColorAsState(
        targetValue = if (isSelected) slice.color.copy(alpha = 0.12f) else DarkSurfaceVariant,
        label = "rowBgAnim"
    )

    Surface(
        shape = RoundedCornerShape(AppRadius.md),
        color = bgColor,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(borderColor)),
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppRadius.md))
            .clickable { onClick() }
            .testTag("lang_completion_row_${slice.language.id}")
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(slice.color)
                    )
                    Text(
                        text = "${slice.language.iconEmoji} ${slice.language.name}",
                        style = AppTypography.body,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "${slice.completedCount}/${slice.totalCount} Ders",
                        style = AppTypography.caption,
                        color = TextMuted
                    )
                    Surface(
                        shape = RoundedCornerShape(AppRadius.pill),
                        color = slice.color.copy(alpha = 0.18f)
                    ) {
                        Text(
                            text = "%${(slice.completionPercentage * 100).toInt()}",
                            style = AppTypography.badge,
                            fontWeight = FontWeight.Bold,
                            color = slice.color,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            // Clean Linear Progress Bar
            LinearProgressIndicator(
                progress = { slice.completionPercentage },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp)),
                color = slice.color,
                trackColor = DarkCardBorder.copy(alpha = 0.5f)
            )
        }
    }
}

/**
 * Center Display Telemetry for Donut Chart
 */
@Composable
private fun DonutTelemetryCenter(
    selectedSlice: LanguageProgressSlice?,
    totalCompleted: Int,
    totalLessons: Int,
    overallPercentage: Float,
    streakDays: Int,
    onClearSelection: () -> Unit
) {
    AnimatedContent(
        targetState = selectedSlice,
        transitionSpec = {
            fadeIn(animationSpec = tween(200)) togetherWith fadeOut(animationSpec = tween(200))
        },
        label = "donutCenterAnim"
    ) { slice ->
        if (slice != null) {
            Column(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .clickable { onClearSelection() }
                    .padding(AppSpacing.xs),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(slice.language.iconEmoji, fontSize = 22.sp)
                Text(
                    text = slice.language.name,
                    style = AppTypography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    maxLines = 1
                )
                Text(
                    text = "%${(slice.completionPercentage * 100).toInt()}",
                    style = AppTypography.heading2,
                    fontWeight = FontWeight.ExtraBold,
                    color = slice.color
                )
                Text(
                    text = "${slice.completedCount}/${slice.totalCount} Ders",
                    style = AppTypography.badge,
                    color = TextMuted
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .size(110.dp)
                    .padding(AppSpacing.xs),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text("🔥", fontSize = 12.sp)
                    Text(
                        text = "$streakDays Gün",
                        style = AppTypography.badge,
                        fontWeight = FontWeight.Bold,
                        color = AccentOrange
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "%${overallPercentage.toInt()}",
                    style = AppTypography.heading1,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimary
                )

                Text(
                    text = "Ders Tamamlama",
                    style = AppTypography.badge,
                    color = TextMuted
                )
            }
        }
    }
}

/**
 * Compact Learning Streak Strip
 */
@Composable
private fun LearningStreakStrip(streakDays: Int) {
    Surface(
        shape = RoundedCornerShape(AppRadius.sm),
        color = AccentOrangeSubtle,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentOrangeBorder))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppSpacing.sm, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
            ) {
                Text("🔥", fontSize = 16.sp)
                Column {
                    Text(
                        text = "$streakDays Günlük Öğrenme Serisi",
                        style = AppTypography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Düzenli çalışma disiplini aktif",
                        style = AppTypography.caption,
                        color = TextSecondary
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(AppRadius.pill),
                color = AccentOrange
            ) {
                Text(
                    text = "AKTİF",
                    style = AppTypography.badge,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        }
    }
}

/**
 * Language Progress Card Item displaying "Ders Tamamlama" % and Mini-Progress Bar
 */
@Composable
private fun LanguageCompletionCard(
    slice: LanguageProgressSlice,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) slice.color else DarkCardBorder,
        label = "legendBorderAnim"
    )
    val bgColor by animateColorAsState(
        targetValue = if (isSelected) slice.color.copy(alpha = 0.12f) else DarkSurfaceVariant,
        label = "legendBgAnim"
    )

    Surface(
        shape = RoundedCornerShape(AppRadius.md),
        color = bgColor,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(borderColor)),
        modifier = modifier
            .clip(RoundedCornerShape(AppRadius.md))
            .clickable { onClick() }
            .testTag("lang_completion_card_${slice.language.id}")
    ) {
        Column(modifier = Modifier.padding(AppSpacing.sm)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(slice.color)
                    )
                    Text(
                        text = "${slice.language.iconEmoji} ${slice.language.name}",
                        style = AppTypography.bodySmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = "%${(slice.completionPercentage * 100).toInt()}",
                    style = AppTypography.badge,
                    fontWeight = FontWeight.Bold,
                    color = slice.color
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Mini Progress Bar
            LinearProgressIndicator(
                progress = { slice.completionPercentage },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp)),
                color = slice.color,
                trackColor = DarkCardBorder.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${slice.completedCount}/${slice.totalCount} ders tamamlandı",
                style = AppTypography.caption,
                color = TextMuted
            )
        }
    }
}

/**
 * Metric column item for footer summary.
 */
@Composable
private fun MetricColumn(
    emoji: String,
    title: String,
    value: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(emoji, fontSize = 12.sp)
            Text(text = title, style = AppTypography.caption, color = TextMuted)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            style = AppTypography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
    }
}

/**
 * Helper to build slices across all available programming languages.
 */
private fun buildAllLanguageSlices(
    languages: List<ProgrammingLanguage>,
    progressMap: Map<String, CourseProgressInfo>,
    viewMode: ProgressChartViewMode
): List<LanguageProgressSlice> {
    val languageColors = mapOf(
        "dart" to Color(0xFF00B4AB),
        "flutter" to Color(0xFF02569B),
        "python" to Color(0xFF38BDF8),
        "cpp" to Color(0xFF3B82F6),
        "c" to Color(0xFFA8B9CC),
        "kotlin" to Color(0xFFA855F7),
        "rust" to Color(0xFFF97316),
        "javascript" to Color(0xFFFBBF24),
        "lua" to Color(0xFF5C7CFA),
        "go" to Color(0xFF00ADD8),
        "elixir" to Color(0xFF9B59B6)
    )

    val rawValues = languages.map { lang ->
        val progress = progressMap[lang.id]
        val total = CourseCatalog.getLessonsForCourse(lang.id).size.coerceAtLeast(1)
        val completed = progress?.completedLessonsCount ?: 0
        val compRatio = (completed.toFloat() / total.toFloat()).coerceIn(0f, 1f)

        val chartValue = when (viewMode) {
            ProgressChartViewMode.COMPLETED_LESSONS -> completed.toFloat()
            ProgressChartViewMode.COMPLETION_PERCENTAGE, ProgressChartViewMode.RADIAL_BARS -> compRatio * 100f
        }
        Triple(lang, chartValue, compRatio to (completed to total))
    }

    val totalValue = rawValues.sumOf { it.second.toDouble() }.toFloat()

    // If no progress yet across all languages, give equal distribution slices
    val effectiveValues = if (totalValue == 0f) {
        rawValues.map { (lang, _, compData) ->
            Triple(lang, 1f, compData)
        }
    } else {
        rawValues
    }

    val effectiveTotal = effectiveValues.sumOf { it.second.toDouble() }.toFloat()

    var currentAngle = -90f // Start from 12 o'clock
    return effectiveValues.map { (lang, value, compData) ->
        val (compRatio, counts) = compData
        val sweepAngle = if (effectiveTotal > 0f) (value / effectiveTotal) * 360f else (360f / languages.size)
        val sliceColor = languageColors[lang.id] ?: Color(lang.colorHex)

        val slice = LanguageProgressSlice(
            language = lang,
            value = value,
            percentageOfTotal = if (effectiveTotal > 0f) (value / effectiveTotal) * 100f else (100f / languages.size),
            completionPercentage = compRatio,
            completedCount = counts.first,
            totalCount = counts.second,
            startAngle = currentAngle,
            sweepAngle = sweepAngle,
            color = sliceColor
        )
        currentAngle += sweepAngle
        slice
    }
}
