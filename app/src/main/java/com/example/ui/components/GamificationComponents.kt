package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.model.*
import com.example.ui.theme.*
import kotlinx.coroutines.delay

/**
 * Animated Floating +XP Overlay Badge
 */
@Composable
fun FloatingXpGainBadge(
    event: XpGainEvent?,
    onDismiss: () -> Unit
) {
    var isVisible by remember(event) { mutableStateOf(event != null) }

    LaunchedEffect(event) {
        if (event != null) {
            isVisible = true
            delay(2400)
            isVisible = false
            onDismiss()
        }
    }

    AnimatedVisibility(
        visible = isVisible && event != null,
        enter = slideInVertically(initialOffsetY = { 80 }) + fadeIn(tween(300)),
        exit = slideOutVertically(targetOffsetY = { -100 }) + fadeOut(tween(400)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp),
        content = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = DarkSurfaceVariant,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimaryIndigo)),
                    shadowElevation = 8.dp,
                    modifier = Modifier.testTag("floating_xp_badge")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("✨", fontSize = 18.sp)
                        Text(
                            text = "+${event?.amount} XP",
                            color = AccentAmber,
                            fontWeight = FontWeight.Black,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "• ${event?.sourceTitle ?: ""}",
                            color = TextPrimary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    )
}

/**
 * Top floating Banner for Achievement Unlocked
 */
@Composable
fun AchievementUnlockedBanner(
    achievement: AppAchievement?,
    onDismiss: () -> Unit
) {
    var isVisible by remember(achievement) { mutableStateOf(achievement != null) }

    LaunchedEffect(achievement) {
        if (achievement != null) {
            isVisible = true
            delay(3500)
            isVisible = false
            onDismiss()
        }
    }

    AnimatedVisibility(
        visible = isVisible && achievement != null,
        enter = slideInVertically(initialOffsetY = { -120 }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { -120 }) + fadeOut(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 50.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .border(1.dp, AccentAmberBorder, RoundedCornerShape(18.dp))
                .testTag("achievement_unlocked_banner"),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(AccentAmberSubtle)
                        .border(1.dp, AccentAmberBorder, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(achievement?.iconEmoji ?: "🏆", fontSize = 24.sp)
                }

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "BAŞARIM AÇILDI!",
                            color = AccentAmber,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "+${achievement?.xpReward} XP",
                            color = AccentEmeraldLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = achievement?.titleTr ?: "",
                        color = TextPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = achievement?.descriptionTr ?: "",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        maxLines = 1
                    )
                }

                IconButton(
                    onClick = {
                        isVisible = false
                        onDismiss()
                    },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextMuted, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

/**
 * Level Up Celebration Modal Dialog
 */
@Composable
fun LevelUpCelebrationDialog(
    event: LevelUpEvent?,
    onDismiss: () -> Unit
) {
    if (event == null) return

    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(26.dp))
                .border(2.dp, PrimaryIndigo, RoundedCornerShape(26.dp))
                .testTag("level_up_dialog"),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Animated Badge
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .scale(scale)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                listOf(PrimaryIndigo.copy(alpha = 0.5f), Color.Transparent)
                            )
                        )
                        .border(2.dp, PrimaryIndigo, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(event.newTier.badgeEmoji, fontSize = 48.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "TEBRİKLER! LEVEL ATLADIN",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = AccentAmber,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "LEVEL ${event.newTier.level}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        color = TextPrimary
                    )
                    Text(
                        text = "${event.newTier.titleTr} (${event.newTier.titleEn})",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigo
                    )
                }

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = DarkSurfaceVariant,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Toplam XP", fontSize = 11.sp, color = TextSecondary)
                            Text("${event.totalXp} XP", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AccentAmber)
                        }
                        Divider(
                            modifier = Modifier
                                .height(24.dp)
                                .width(1.dp),
                            color = PrimarySubtleBorder
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Seviye Durumu", fontSize = 11.sp, color = TextSecondary)
                            Text("Kilitler Açıldı", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                        }
                    }
                }

                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("level_up_continue_button"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo)
                ) {
                    Text("Öğrenmeye Devam Et 🚀", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.White)
                }
            }
        }
    }
}

/**
 * Daily Challenge Interactive Dialog
 */
@Composable
fun DailyChallengeModal(
    challenge: DailyChallengeItem,
    onSolve: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var isSubmitted by remember { mutableStateOf(challenge.isCompletedToday) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(22.dp))
                .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(22.dp))
                .testTag("daily_challenge_modal"),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
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
                        Text("🔥", fontSize = 20.sp)
                        Column {
                            Text(
                                text = "GÜNÜN MEYDAN OKUMASI",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                color = AccentAmber
                            )
                            Text(
                                text = challenge.courseName,
                                fontSize = 13.sp,
                                color = TextSecondary,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = AccentAmberSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
                    ) {
                        Text(
                            text = "+${challenge.xpReward} XP",
                            color = AccentAmber,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Text(
                    text = challenge.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Text(
                    text = challenge.question,
                    fontSize = 14.sp,
                    color = TextSecondary,
                    lineHeight = 20.sp
                )

                challenge.codeSnippet?.let { snippet ->
                    CodeBlock(
                        code = snippet,
                        language = challenge.courseId,
                        showLineNumbers = snippet.lines().size > 1,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Options
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    challenge.options.forEachIndexed { index, optionText ->
                        val isSelected = selectedOption == index
                        val isCorrect = index == challenge.correctOptionIndex

                        val containerColor = when {
                            isSubmitted && isCorrect -> AccentEmeraldSubtle
                            isSubmitted && isSelected && !isCorrect -> AccentRoseSubtle
                            isSelected -> PrimarySubtle
                            else -> DarkSurfaceVariant
                        }

                        val borderColor = when {
                            isSubmitted && isCorrect -> AccentEmeraldBorder
                            isSubmitted && isSelected && !isCorrect -> AccentRoseBorder
                            isSelected -> PrimaryIndigo
                            else -> DarkCardBorder
                        }

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = containerColor,
                            border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(borderColor)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !isSubmitted) {
                                    selectedOption = index
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Text(
                                    text = "${('A' + index)}.",
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) PrimaryIndigo else TextMuted
                                )
                                Text(
                                    text = optionText,
                                    fontSize = 13.sp,
                                    color = TextPrimary,
                                    modifier = Modifier.weight(1f)
                                )
                                if (isSubmitted && isCorrect) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmeraldLight, modifier = Modifier.size(18.dp))
                                } else if (isSubmitted && isSelected && !isCorrect) {
                                    Icon(Icons.Default.Close, contentDescription = null, tint = AccentRose, modifier = Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }

                if (isSubmitted) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = DarkSurfaceVariant,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Açıklama", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(challenge.explanation, fontSize = 12.sp, color = TextSecondary, lineHeight = 17.sp)
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Kapat", color = TextSecondary)
                    }

                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                selectedOption?.let {
                                    isSubmitted = true
                                    onSolve(it)
                                }
                            },
                            enabled = selectedOption != null,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo)
                        ) {
                            Text("Cevapla", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Interactive Skill Tree Node Bottom Sheet / Dialog
 */
@Composable
fun SkillNodeDetailDialog(
    node: SkillNode?,
    onOpenLesson: (String) -> Unit,
    onDismiss: () -> Unit
) {
    if (node == null) return

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(22.dp))
                .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(22.dp))
                .testTag("skill_node_detail_dialog"),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(PrimarySubtle)
                            .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(node.iconEmoji, fontSize = 28.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = node.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = "Seviye: ${node.level.displayName}",
                            fontSize = 12.sp,
                            color = PrimaryIndigo,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Text(
                    text = node.description,
                    fontSize = 13.sp,
                    color = TextSecondary,
                    lineHeight = 19.sp
                )

                // Mastery and Tasks
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = DarkSurfaceVariant,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Beceri Hakimiyeti", fontSize = 12.sp, color = TextSecondary)
                            Text("%${node.masteryPercentage}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                        }
                        LinearProgressIndicator(
                            progress = { node.masteryPercentage / 100f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = AccentEmeraldLight,
                            trackColor = DarkSurfaceVariant
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Tamamlanan Görevler", fontSize = 12.sp, color = TextSecondary)
                            Text("${node.tasksCompleted}/${node.totalTasks}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                        }
                    }
                }

                if (node.prerequisites.isNotEmpty()) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Gerekli Ön Koşul:", fontSize = 11.sp, color = TextMuted)
                        node.prerequisites.forEach { prereq ->
                            Text("• $prereq", fontSize = 12.sp, color = TextSecondary)
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Kapat", color = TextSecondary)
                    }

                    Button(
                        onClick = {
                            node.relatedLessonId?.let { onOpenLesson(it) }
                            onDismiss()
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo)
                    ) {
                        Text("Konuya Git 🚀", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }
}
