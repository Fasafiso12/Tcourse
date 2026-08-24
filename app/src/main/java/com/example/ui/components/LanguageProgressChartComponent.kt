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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.model.CourseProgressInfo
import com.example.model.ProgrammingLanguage
import com.example.ui.theme.*
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Chart display modes for multi-language progress visualization.
 */
enum class PieChartViewMode(val title: String, val shortLabel: String) {
    COMPLETED_LESSONS("Tamamlanan Dersler", "Ders Dağılımı"),
    COMPLETION_PERCENTAGE("Tamamlanma Oranı (%)", "Başarı Oranı")
}

/**
 * Data slice representation for the pie/donut chart.
 */
data class LanguagePieSlice(
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
 * A modern data visualization component featuring an interactive Pie/Donut Chart,
 * dynamic language progress distribution, and active learning streak telemetry.
 */
@Composable
fun LanguageProgressChartComponent(
    languages: List<ProgrammingLanguage> = CourseCatalog.languages,
    progressMap: Map<String, CourseProgressInfo> = emptyMap(),
    streakDays: Int = 7,
    modifier: Modifier = Modifier,
    onLanguageClick: ((ProgrammingLanguage) -> Unit)? = null,
    title: String = "Öğrenme İlerlemesi & Seri Grafiği"
) {
    var selectedLanguageId by remember { mutableStateOf<String?>(null) }
    var viewMode by remember { mutableStateOf(PieChartViewMode.COMPLETED_LESSONS) }
    var isDonutStyle by remember { mutableStateOf(true) }

    // Aggregate statistics
    val totalLessons = remember(languages) {
        languages.sumOf { CourseCatalog.getLessonsForCourse(it.id).size }
    }
    val totalCompleted = remember(progressMap) {
        progressMap.values.sumOf { it.completedLessonsCount }
    }
    val overallPercentage = remember(totalLessons, totalCompleted) {
        if (totalLessons > 0) ((totalCompleted.toFloat() / totalLessons.toFloat()) * 100f).coerceIn(0f, 100f) else 0f
    }

    // Build chart slices with calculated angles
    val slices = remember(languages, progressMap, viewMode) {
        buildLanguageSlices(languages, progressMap, viewMode)
    }

    val selectedSlice = remember(selectedLanguageId, slices) {
        slices.firstOrNull { it.language.id == selectedLanguageId }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .border(1.dp, DarkCardBorder, RoundedCornerShape(24.dp))
            .testTag("language_progress_pie_chart_card"),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Component Header: Title, Icon, View Mode Switcher
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
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
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = "7 Programlama Dili Analizi",
                            fontSize = 11.sp,
                            color = TextMuted
                        )
                    }
                }

                // Mode toggle pills
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = DarkSurfaceVariant,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder))
                ) {
                    Row(modifier = Modifier.padding(2.dp)) {
                        PieChartViewMode.values().forEach { mode ->
                            val isSelected = viewMode == mode
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isSelected) PrimaryIndigo else Color.Transparent)
                                    .clickable { viewMode = mode }
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = mode.shortLabel,
                                    fontSize = 10.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) Color.White else TextSecondary
                                )
                            }
                        }
                    }
                }
            }

            // 2. Learning Streak Badge & Weekly Consistency Row
            LearningStreakBanner(streakDays = streakDays)

            // 3. Interactive Pie/Donut Chart Canvas + Center Telemetry
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                contentAlignment = Alignment.Center
            ) {
                InteractivePieCanvas(
                    slices = slices,
                    selectedLanguageId = selectedLanguageId,
                    isDonut = isDonutStyle,
                    onSliceSelected = { langId ->
                        selectedLanguageId = if (selectedLanguageId == langId) null else langId
                    },
                    modifier = Modifier.size(220.dp)
                )

                // Center Donut Content (Displays overall progress or selected language breakdown)
                if (isDonutStyle) {
                    DonutCenterContent(
                        selectedSlice = selectedSlice,
                        totalCompleted = totalCompleted,
                        totalLessons = totalLessons,
                        overallPercentage = overallPercentage,
                        streakDays = streakDays,
                        onClearSelection = { selectedLanguageId = null }
                    )
                }
            }

            // Quick Info Caption under chart
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (selectedSlice != null) "💡 Detayları kapatmak için dil dilimine tekrar dokunun." else "👆 Dil detaylarını görmek için pasta dilimlerine dokunun.",
                    fontSize = 11.sp,
                    color = TextMuted,
                    textAlign = TextAlign.Center
                )
            }

            Divider(color = DarkCardBorder.copy(alpha = 0.6f), thickness = 1.dp)

            // 4. Multi-Language Progress Breakdown & Interactive Legend
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Diller & Tamamlanma Durumu",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )

                    Text(
                        text = "${slices.count { it.completedCount > 0 }}/${languages.size} Aktif Dil",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryIndigoLight
                    )
                }

                // Grid/List of Language Progress Legend Items
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    slices.chunked(2).forEach { rowSlices ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowSlices.forEach { slice ->
                                val isSelected = slice.language.id == selectedLanguageId
                                LanguageLegendItem(
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

            // 5. Total Metrics Summary Footer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(DarkSurfaceVariant)
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(14.dp))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MetricColumnItem(
                    emoji = "📚",
                    title = "Tamamlanan",
                    value = "$totalCompleted / $totalLessons Ders"
                )
                Box(modifier = Modifier.width(1.dp).height(28.dp).background(DarkCardBorder))
                MetricColumnItem(
                    emoji = "🎯",
                    title = "Genel Başarı",
                    value = "%${overallPercentage.toInt()}"
                )
                Box(modifier = Modifier.width(1.dp).height(28.dp).background(DarkCardBorder))
                MetricColumnItem(
                    emoji = "🔥",
                    title = "Öğrenme Serisi",
                    value = "$streakDays Gün"
                )
            }
        }
    }
}

/**
 * Animated Canvas that draws the Pie / Donut slices and handles tap geometry.
 */
@Composable
private fun InteractivePieCanvas(
    slices: List<LanguagePieSlice>,
    selectedLanguageId: String?,
    isDonut: Boolean,
    onSliceSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Smooth initial entry animation for the chart sweep
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 900, easing = FastOutSlowInEasing)
        )
    }

    // Infinite subtle pulse for active selected slice
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.04f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    Canvas(
        modifier = modifier
            .testTag("pie_chart_canvas")
            .pointerInput(slices) {
                detectTapGestures { tapOffset ->
                    val canvasWidth = size.width.toFloat()
                    val canvasHeight = size.height.toFloat()
                    val center = Offset(canvasWidth / 2f, canvasHeight / 2f)
                    val radius = (minOf(canvasWidth, canvasHeight) / 2f) * 0.9f
                    val innerRadius = if (isDonut) radius * 0.58f else 0f

                    val dx = tapOffset.x - center.x
                    val dy = tapOffset.y - center.y
                    val distance = sqrt((dx * dx) + (dy * dy))

                    // Check if tap falls within the doughnut ring
                    if (distance in innerRadius..radius * 1.15f) {
                        var angle = (atan2(dy, dx) * 180f / PI.toFloat())
                        if (angle < 0) angle += 360f

                        // Find matching slice
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
                        // Tapped inside center hole -> clear selection
                        onSliceSelected("")
                    }
                }
            }
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val center = Offset(canvasWidth / 2f, canvasHeight / 2f)
        val outerRadius = (minOf(canvasWidth, canvasHeight) / 2f) * 0.88f
        val strokeWidth = if (isDonut) outerRadius * 0.38f else outerRadius

        val currentProgress = animationProgress.value

        // Draw background base ring if no progress yet
        if (slices.all { it.sweepAngle == 0f }) {
            drawCircle(
                color = Color(0xFF1E293B),
                radius = outerRadius,
                center = center,
                style = if (isDonut) Stroke(width = strokeWidth) else Fill
            )
            return@Canvas
        }

        // Draw each language slice
        slices.forEach { slice ->
            val isSelected = slice.language.id == selectedLanguageId
            val sweep = slice.sweepAngle * currentProgress
            if (sweep > 0.5f) {
                val effectiveStroke = if (isSelected) strokeWidth * pulseScale else strokeWidth
                val sliceRadius = if (isSelected) outerRadius + 6.dp.toPx() else outerRadius

                val arcSize = Size(sliceRadius * 2f, sliceRadius * 2f)
                val arcTopLeft = Offset(center.x - sliceRadius, center.y - sliceRadius)

                if (isDonut) {
                    drawArc(
                        color = slice.color,
                        startAngle = slice.startAngle,
                        sweepAngle = (sweep - 1.5f).coerceAtLeast(0.5f), // 1.5 deg gap between slices
                        useCenter = false,
                        topLeft = Offset(center.x - (outerRadius - strokeWidth / 2f), center.y - (outerRadius - strokeWidth / 2f)),
                        size = Size((outerRadius - strokeWidth / 2f) * 2f, (outerRadius - strokeWidth / 2f) * 2f),
                        style = Stroke(width = effectiveStroke, cap = StrokeCap.Round)
                    )
                } else {
                    drawArc(
                        color = slice.color,
                        startAngle = slice.startAngle,
                        sweepAngle = (sweep - 1f).coerceAtLeast(0.5f),
                        useCenter = true,
                        topLeft = arcTopLeft,
                        size = arcSize,
                        style = Fill
                    )
                }
            }
        }
    }
}

/**
 * Center display area for the Donut chart showing overall metrics or selected language stats.
 */
@Composable
private fun DonutCenterContent(
    selectedSlice: LanguagePieSlice?,
    totalCompleted: Int,
    totalLessons: Int,
    overallPercentage: Float,
    streakDays: Int,
    onClearSelection: () -> Unit
) {
    AnimatedContent(
        targetState = selectedSlice,
        transitionSpec = {
            fadeIn(animationSpec = tween(220)) togetherWith fadeOut(animationSpec = tween(220))
        },
        label = "donutCenterAnim"
    ) { slice ->
        if (slice != null) {
            // Selected Language Telemetry
            Column(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .clickable { onClearSelection() }
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = slice.language.iconEmoji,
                    fontSize = 22.sp
                )
                Text(
                    text = slice.language.name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    maxLines = 1
                )
                Text(
                    text = "%${(slice.completionPercentage * 100).toInt()}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = slice.color
                )
                Text(
                    text = "${slice.completedCount}/${slice.totalCount} Ders",
                    fontSize = 10.sp,
                    color = TextMuted
                )
            }
        } else {
            // Default Overview & Streak Telemetry
            Column(
                modifier = Modifier
                    .size(110.dp)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text("🔥", fontSize = 14.sp)
                    Text(
                        text = "$streakDays Gün",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = AccentOrange
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "%${overallPercentage.toInt()}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimary
                )

                Text(
                    text = "Genel Başarı",
                    fontSize = 10.sp,
                    color = TextMuted,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

/**
 * Dedicated visualizer banner for the user's active learning streak.
 */
@Composable
private fun LearningStreakBanner(
    streakDays: Int
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = AccentOrangeSubtle,
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentOrangeBorder))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(AccentOrange.copy(alpha = 0.2f))
                            .border(1.dp, AccentOrange, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🔥", fontSize = 16.sp)
                    }

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "$streakDays Günlük Öğrenme Serisi",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = AccentOrange
                            ) {
                                Text(
                                    text = "AKTİF",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = "Tebrikler! Kodlama disiplininiz zirvede.",
                            fontSize = 11.sp,
                            color = TextSecondary
                        )
                    }
                }
            }

            // 7 Days Weekday Consistency Tracker Pills (Pzt -> Paz)
            val weekDays = listOf("Pzt", "Sal", "Çar", "Per", "Cum", "Cmt", "Paz")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                weekDays.forEachIndexed { index, day ->
                    val isActive = index < streakDays.coerceAtMost(7)
                    val isToday = index == (streakDays.coerceAtMost(7) - 1).coerceAtLeast(0)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text(
                            text = day,
                            fontSize = 10.sp,
                            color = if (isActive) TextPrimary else TextMuted,
                            fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal
                        )

                        Box(
                            modifier = Modifier
                                .size(26.dp)
                                .clip(CircleShape)
                                .background(if (isActive) AccentOrange else DarkSurfaceVariant)
                                .border(
                                    1.dp,
                                    if (isToday) Color.White else if (isActive) AccentOrangeBorder else DarkCardBorder,
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isActive) {
                                if (isToday) {
                                    Text("🔥", fontSize = 12.sp)
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(13.dp)
                                    )
                                }
                            } else {
                                Box(modifier = Modifier.size(5.dp).clip(CircleShape).background(TextMuted.copy(alpha = 0.5f)))
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Interactive Language Legend Card with Mini-Progress Bar.
 */
@Composable
private fun LanguageLegendItem(
    slice: LanguagePieSlice,
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
        shape = RoundedCornerShape(12.dp),
        color = bgColor,
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(borderColor)),
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
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
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(slice.color)
                    )
                    Text(
                        text = "${slice.language.iconEmoji} ${slice.language.name}",
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = "%${(slice.completionPercentage * 100).toInt()}",
                    fontSize = 11.sp,
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
                fontSize = 9.5.sp,
                color = TextMuted
            )
        }
    }
}

/**
 * Metric column item for footer summary.
 */
@Composable
private fun MetricColumnItem(
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
            Text(text = title, fontSize = 11.sp, color = TextMuted)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
    }
}

/**
 * Helper function to calculate pie slice angles and values across all languages.
 */
private fun buildLanguageSlices(
    languages: List<ProgrammingLanguage>,
    progressMap: Map<String, CourseProgressInfo>,
    viewMode: PieChartViewMode
): List<LanguagePieSlice> {
    // Distinct brand colors for 7 languages
    val languageColors = mapOf(
        "dart" to Color(0xFF00B4AB),
        "flutter" to Color(0xFF02569B),
        "python" to Color(0xFF38BDF8),
        "cpp" to Color(0xFF3B82F6),
        "kotlin" to Color(0xFFA855F7),
        "rust" to Color(0xFFF97316),
        "javascript" to Color(0xFFFBBF24)
    )

    val rawValues = languages.map { lang ->
        val progress = progressMap[lang.id]
        val total = CourseCatalog.getLessonsForCourse(lang.id).size.coerceAtLeast(1)
        val completed = progress?.completedLessonsCount ?: 0
        val compRatio = (completed.toFloat() / total.toFloat()).coerceIn(0f, 1f)

        val chartValue = when (viewMode) {
            PieChartViewMode.COMPLETED_LESSONS -> completed.toFloat()
            PieChartViewMode.COMPLETION_PERCENTAGE -> compRatio * 100f
        }
        Triple(lang, chartValue, compRatio to (completed to total))
    }

    val totalValue = rawValues.sumOf { it.second.toDouble() }.toFloat()

    // If no lessons are completed anywhere, provide a balanced starter preview representation
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

        val slice = LanguagePieSlice(
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
