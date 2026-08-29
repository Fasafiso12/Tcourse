package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CourseLevel
import com.example.model.ProgrammingLanguage
import com.example.ui.theme.*

/**
 * Modern High-Impact Primary Button with clean minimal styling
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    iconEmoji: String? = null,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    testTag: String = "primary_button"
) {
    Button(
        onClick = onClick,
        enabled = enabled && !isLoading,
        shape = RoundedCornerShape(AppRadius.md),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryIndigo,
            contentColor = Color.White,
            disabledContainerColor = DarkSurfaceVariant.copy(alpha = 0.5f),
            disabledContentColor = TextMuted
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        contentPadding = PaddingValues(horizontal = AppSpacing.lg, vertical = AppSpacing.sm),
        modifier = modifier
            .defaultMinSize(minHeight = 46.dp)
            .testTag(testTag)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
            ) {
                if (iconEmoji != null) {
                    Text(text = iconEmoji, fontSize = 16.sp)
                } else if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Text(
                    text = text,
                    style = AppTypography.title,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

/**
 * Secondary Elevated Surface Button with fine geometric border
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    iconEmoji: String? = null,
    enabled: Boolean = true,
    testTag: String = "secondary_button"
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(AppRadius.md),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = DarkSurfaceVariant,
            contentColor = TextPrimary,
            disabledContainerColor = DarkSurface,
            disabledContentColor = TextMuted
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = SolidColor(DarkCardBorder.copy(alpha = 0.6f))
        ),
        contentPadding = PaddingValues(horizontal = AppSpacing.md, vertical = AppSpacing.sm),
        modifier = modifier
            .defaultMinSize(minHeight = 44.dp)
            .testTag(testTag)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
        ) {
            if (iconEmoji != null) {
                Text(text = iconEmoji, fontSize = 15.sp)
            } else if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = TextSecondary
                )
            }
            Text(
                text = text,
                style = AppTypography.body,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/**
 * Standardized High-Craft Card Surface
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(AppRadius.lg),
    containerColor: Color = DarkSurface,
    borderColor: Color = DarkCardBorder,
    onClick: (() -> Unit)? = null,
    testTag: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val baseModifier = modifier
        .fillMaxWidth()
        .clip(shape)
        .background(containerColor)
        .border(1.dp, borderColor, shape)
        .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
        .then(if (testTag != null) Modifier.testTag(testTag) else Modifier)

    Column(
        modifier = baseModifier.padding(AppSpacing.md),
        content = content
    )
}

/**
 * Precision Animated Progress Bar with optional glowing fill
 */
@Composable
fun AppProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = PrimaryIndigo,
    trackColor: Color = DarkSurfaceVariant,
    height: Dp = 6.dp,
    label: String? = null,
    trailingText: String? = null
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = spring(stiffness = Spring.StiffnessLow, dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "progress_anim"
    )

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(AppSpacing.xxs)) {
        if (label != null || trailingText != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (label != null) {
                    Text(
                        text = label,
                        style = AppTypography.caption,
                        color = TextSecondary
                    )
                }
                if (trailingText != null) {
                    Text(
                        text = trailingText,
                        style = AppTypography.caption,
                        fontWeight = FontWeight.Bold,
                        color = color
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(AppRadius.pill))
                .background(trackColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(animatedProgress)
                    .clip(RoundedCornerShape(AppRadius.pill))
                    .background(color)
            )
        }
    }
}

/**
 * Streak Badge with warm amber glow
 */
@Composable
fun StreakBadge(
    streakDays: Int,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    Surface(
        shape = RoundedCornerShape(AppRadius.pill),
        color = AccentAmberSubtle,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = if (compact) 8.dp else 10.dp,
                vertical = if (compact) 3.dp else 5.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text("🔥", fontSize = if (compact) 11.sp else 13.sp)
            Text(
                text = "$streakDays" + if (compact) "" else " Gün",
                style = if (compact) AppTypography.badge else AppTypography.title,
                fontWeight = FontWeight.Bold,
                color = AccentAmber
            )
        }
    }
}

/**
 * Section Header with title, optional badge, and optional trailing action
 */
@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    iconEmoji: String? = null,
    badgeText: String? = null,
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs),
            modifier = Modifier.weight(1f, fill = false)
        ) {
            if (iconEmoji != null) {
                Text(text = iconEmoji, fontSize = 16.sp)
            }
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
                ) {
                    Text(
                        text = title,
                        style = AppTypography.heading3,
                        color = TextPrimary
                    )
                    if (badgeText != null) {
                        Surface(
                            shape = RoundedCornerShape(AppRadius.xs),
                            color = PrimarySubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
                        ) {
                            Text(
                                text = badgeText,
                                style = AppTypography.badge,
                                color = PrimaryIndigoLight,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = AppTypography.caption,
                        color = TextMuted
                    )
                }
            }
        }

        if (actionText != null && onActionClick != null) {
            Text(
                text = actionText,
                style = AppTypography.caption,
                fontWeight = FontWeight.Bold,
                color = PrimaryIndigoLight,
                modifier = Modifier
                    .clip(RoundedCornerShape(AppRadius.xs))
                    .clickable { onActionClick() }
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            )
        }
    }
}

/**
 * Node Status for Visual Course Journey & Skill Tree
 */
enum class NodeDisplayStatus {
    MASTERED,
    COMPLETED,
    CURRENT,
    AVAILABLE,
    LOCKED
}

/**
 * Visual Connecting Node Item for Course Map
 */
@Composable
fun CourseNodeItem(
    title: String,
    subtitle: String,
    status: NodeDisplayStatus,
    stepNumber: Int,
    isLast: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse_node")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (status == NodeDisplayStatus.CURRENT) 1.12f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    val nodeColor = when (status) {
        NodeDisplayStatus.MASTERED -> AccentEmerald
        NodeDisplayStatus.COMPLETED -> PrimaryIndigo
        NodeDisplayStatus.CURRENT -> AccentAmber
        NodeDisplayStatus.AVAILABLE -> TextSecondary
        NodeDisplayStatus.LOCKED -> DarkCardBorder
    }

    val nodeBg = when (status) {
        NodeDisplayStatus.MASTERED -> AccentEmeraldSubtle
        NodeDisplayStatus.COMPLETED -> PrimarySubtle
        NodeDisplayStatus.CURRENT -> AccentAmberSubtle
        NodeDisplayStatus.AVAILABLE -> DarkSurfaceVariant
        NodeDisplayStatus.LOCKED -> DarkSurface
    }

    val nodeIcon = when (status) {
        NodeDisplayStatus.MASTERED -> "👑"
        NodeDisplayStatus.COMPLETED -> "✓"
        NodeDisplayStatus.CURRENT -> "▶"
        NodeDisplayStatus.AVAILABLE -> "$stepNumber"
        NodeDisplayStatus.LOCKED -> "🔒"
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = status != NodeDisplayStatus.LOCKED) { onClick() }
            .padding(vertical = AppSpacing.xs),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(AppSpacing.md)
    ) {
        // Vertical Timeline Column (Node Circle + Connector Line)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(36.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .scale(pulseScale)
                    .clip(CircleShape)
                    .background(nodeBg)
                    .border(2.dp, nodeColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = nodeIcon,
                    fontSize = if (status == NodeDisplayStatus.MASTERED || status == NodeDisplayStatus.LOCKED) 13.sp else 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (status == NodeDisplayStatus.LOCKED) TextMuted else nodeColor
                )
            }

            if (!isLast) {
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(36.dp)
                        .background(
                            if (status == NodeDisplayStatus.COMPLETED || status == NodeDisplayStatus.MASTERED)
                                PrimaryIndigo.copy(alpha = 0.5f)
                            else DarkCardBorder
                        )
                )
            }
        }

        // Node Content Card
        Surface(
            shape = RoundedCornerShape(AppRadius.md),
            color = if (status == NodeDisplayStatus.CURRENT) DarkSurfaceVariant else DarkSurface,
            border = CardDefaults.outlinedCardBorder().copy(
                brush = SolidColor(if (status == NodeDisplayStatus.CURRENT) AccentAmberBorder else DarkCardBorder)
            ),
            modifier = Modifier
                .weight(1f)
                .padding(bottom = if (isLast) 0.dp else 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppSpacing.md, vertical = AppSpacing.sm),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = AppTypography.title,
                        color = if (status == NodeDisplayStatus.LOCKED) TextMuted else TextPrimary,
                        fontWeight = if (status == NodeDisplayStatus.CURRENT) FontWeight.Bold else FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = subtitle,
                        style = AppTypography.caption,
                        color = if (status == NodeDisplayStatus.LOCKED) TextMuted.copy(alpha = 0.6f) else TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (status == NodeDisplayStatus.CURRENT) {
                    Surface(
                        shape = RoundedCornerShape(AppRadius.xs),
                        color = AccentAmberSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder))
                    ) {
                        Text(
                            text = "ŞİMDİ",
                            style = AppTypography.badge,
                            color = AccentAmber,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Visual Mastery Breakdown with Theory, Practice, Quiz, Challenge, and Project checks
 */
@Composable
fun MasteryBreakdownCard(
    title: String,
    masteryPercent: Int,
    isTheoryCompleted: Boolean,
    isPracticeCompleted: Boolean,
    isQuizCompleted: Boolean,
    isChallengeCompleted: Boolean,
    isProjectCompleted: Boolean,
    modifier: Modifier = Modifier
) {
    AppCard(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title.uppercase(),
                    style = AppTypography.title,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "Konu Hakimiyet Düzeyi",
                    style = AppTypography.caption,
                    color = TextSecondary
                )
            }

            Surface(
                shape = RoundedCornerShape(AppRadius.sm),
                color = if (masteryPercent >= 80) AccentEmeraldSubtle else PrimarySubtle,
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = SolidColor(if (masteryPercent >= 80) AccentEmeraldBorder else PrimarySubtleBorder)
                )
            ) {
                Text(
                    text = "$masteryPercent% Mastery",
                    style = AppTypography.caption,
                    fontWeight = FontWeight.Bold,
                    color = if (masteryPercent >= 80) AccentEmeraldLight else PrimaryIndigoLight,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(AppSpacing.sm))

        // Progress Bar
        AppProgressBar(
            progress = masteryPercent / 100f,
            color = if (masteryPercent >= 80) AccentEmerald else PrimaryIndigo
        )

        Spacer(modifier = Modifier.height(AppSpacing.sm))

        // Checkmark Pillars
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MasteryCheckItem("Teori", isTheoryCompleted)
            MasteryCheckItem("Pratik", isPracticeCompleted)
            MasteryCheckItem("Quiz", isQuizCompleted)
            MasteryCheckItem("Görev", isChallengeCompleted)
            MasteryCheckItem("Proje", isProjectCompleted)
        }
    }
}

@Composable
private fun MasteryCheckItem(label: String, isDone: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(
            text = if (isDone) "✓" else "○",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = if (isDone) AccentEmerald else TextMuted
        )
        Text(
            text = label,
            style = AppTypography.caption,
            color = if (isDone) TextPrimary else TextMuted
        )
    }
}

/**
 * Smart Review Card for Weak Areas
 */
@Composable
fun SmartReviewCard(
    topicTitle: String,
    accuracyPct: Int,
    mistakesCount: Int,
    onReviewClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(AppRadius.md),
        color = DarkSurface,
        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onReviewClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppSpacing.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
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
                        .background(AccentRoseSubtle)
                        .border(1.dp, AccentRoseBorder, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🧠", fontSize = 16.sp)
                }

                Column {
                    Text(
                        text = topicTitle,
                        style = AppTypography.title,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "%$accuracyPct Başarı • $mistakesCount Tekrar Önerisi",
                        style = AppTypography.caption,
                        color = if (accuracyPct < 60) AccentRose else AccentAmber
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(AppRadius.sm),
                color = PrimarySubtle,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder))
            ) {
                Text(
                    text = "Tekrar Et →",
                    style = AppTypography.caption,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryIndigoLight,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
        }
    }
}

/**
 * Weekly Activity Chart with subtle vertical bars
 */
@Composable
fun WeeklyActivityChart(
    days: List<Pair<String, Int>>,
    modifier: Modifier = Modifier
) {
    val maxCount = remember(days) { (days.maxOfOrNull { it.second } ?: 1).coerceAtLeast(1) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        days.forEach { (dayName, count) ->
            val barRatio = (count.toFloat() / maxCount.toFloat()).coerceIn(0.1f, 1f)
            val isToday = dayName == "Bugün" || dayName == "Pz"

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = if (count > 0) "$count" else "",
                    style = AppTypography.caption,
                    fontSize = 9.sp,
                    color = if (count > 0) PrimaryIndigoLight else Color.Transparent
                )

                Box(
                    modifier = Modifier
                        .width(18.dp)
                        .fillMaxHeight(barRatio * 0.7f)
                        .clip(RoundedCornerShape(AppRadius.xs))
                        .background(
                            if (count > 0) {
                                if (isToday) PrimaryIndigo else PrimaryIndigo.copy(alpha = 0.6f)
                            } else DarkSurfaceVariant
                        )
                )

                Text(
                    text = dayName,
                    style = AppTypography.caption,
                    fontSize = 10.sp,
                    color = if (isToday) TextPrimary else TextMuted
                )
            }
        }
    }
}

/**
 * Inspiring Empty State View
 */
@Composable
fun EmptyStateView(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    iconEmoji: String = "✨",
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(AppSpacing.xl),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppSpacing.md)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(PrimarySubtle)
                .border(1.dp, PrimarySubtleBorder, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = iconEmoji, fontSize = 28.sp)
        }

        Text(
            text = title,
            style = AppTypography.heading3,
            color = TextPrimary,
            textAlign = TextAlign.Center
        )

        Text(
            text = description,
            style = AppTypography.body,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = AppSpacing.md)
        )

        if (actionText != null && onActionClick != null) {
            Spacer(modifier = Modifier.height(AppSpacing.xs))
            PrimaryButton(
                text = actionText,
                onClick = onActionClick,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
        }
    }
}

/**
 * Loading Skeleton Box
 */
@Composable
fun LoadingSkeleton(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(AppRadius.md)
) {
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shimmer_alpha"
    )

    Box(
        modifier = modifier
            .clip(shape)
            .background(DarkSurfaceVariant.copy(alpha = alpha))
    )
}

/**
 * Standardized Programming Language Logo Badge matching the official symbol style in CoursesScreen
 */
@Composable
fun LanguageLogoBox(
    language: ProgrammingLanguage,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    shapeRadius: Dp = 8.dp,
    padding: Dp = 4.dp,
    fallbackEmojiSize: TextUnit = 16.sp
) {
    val brandColor = Color(language.colorHex)
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(shapeRadius))
            .background(brandColor.copy(alpha = 0.15f))
            .border(1.dp, brandColor.copy(alpha = 0.4f), RoundedCornerShape(shapeRadius)),
        contentAlignment = Alignment.Center
    ) {
        if (language.drawableRes != null) {
            Image(
                painter = painterResource(id = language.drawableRes),
                contentDescription = "${language.name} logo",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .clip(RoundedCornerShape((shapeRadius - 2.dp).coerceAtLeast(2.dp))),
                contentScale = ContentScale.Fit
            )
        } else {
            Text(language.iconEmoji, fontSize = fallbackEmojiSize)
        }
    }
}

