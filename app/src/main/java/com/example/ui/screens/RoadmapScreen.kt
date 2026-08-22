package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.db.UserProgressEntity
import com.example.model.Lesson
import com.example.model.LessonStatus
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

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
    val lessons = CourseCatalog.getLessonsForCourse(selectedLanguageId)
    val sections = CourseCatalog.getSections(selectedLanguageId)

    val completedLessonIds = allProgress
        .filter { it.courseId == selectedLanguageId && it.status == LessonStatus.COMPLETED.name }
        .map { it.lessonId }
        .toSet()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(PrimarySubtle)
                        .border(1.dp, PrimarySubtleBorder, RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(activeLang.iconEmoji, fontSize = 22.sp)
                }
                Column {
                    Text(
                        text = "${activeLang.name} Kurs Haritası",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Adım Adım Öğrenme Ağacı",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = AccentEmeraldSubtle,
                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
            ) {
                Text(
                    text = "${completedLessonIds.size}/${lessons.size} Tamamlandı",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AccentEmeraldLight,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Freemium notice bar
        if (!isUserPremium) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                color = AccentAmberSubtle,
                border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text("💡", fontSize = 16.sp)
                    Text(
                        text = "1. ve 2. dersler ücretsizdir. 3. dersten itibaren kilitleri açmak için Premium'a geçebilirsiniz.",
                        fontSize = 11.sp,
                        color = AccentAmber,
                        lineHeight = 15.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            itemsIndexed(lessons) { index, lesson ->
                val isCompleted = completedLessonIds.contains(lesson.id)
                val isAccessible = !lesson.isPremium || isUserPremium
                val isCurrent = !isCompleted && isAccessible

                RoadmapNodeItem(
                    index = index + 1,
                    lesson = lesson,
                    isCompleted = isCompleted,
                    isCurrent = isCurrent,
                    isLocked = !isAccessible,
                    isPremium = lesson.isPremium,
                    onClick = { onOpenLesson(lesson) }
                )
            }
        }
    }
}

@Composable
private fun RoadmapNodeItem(
    index: Int,
    lesson: Lesson,
    isCompleted: Boolean,
    isCurrent: Boolean,
    isLocked: Boolean,
    isPremium: Boolean,
    onClick: () -> Unit
) {
    val nodeBg = when {
        isCompleted -> AccentEmerald
        isCurrent -> PrimaryIndigo
        isLocked -> DarkSurfaceVariant
        else -> DarkSurfaceVariant
    }

    val icon = when {
        isCompleted -> Icons.Default.Check
        isLocked -> Icons.Default.Lock
        isCurrent -> Icons.Default.PlayArrow
        else -> Icons.Default.LockOpen
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(if (isCurrent) PrimarySubtle else DarkSurface)
            .border(
                1.dp,
                if (isCurrent) PrimaryIndigo else DarkCardBorder,
                RoundedCornerShape(18.dp)
            )
            .clickable { onClick() }
            .padding(14.dp)
            .testTag("roadmap_node_${lesson.id}"),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Step node circle
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(nodeBg),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isLocked) TextMuted else Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        // Lesson Info
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "DERS $index • ${lesson.level.displayName.uppercase()}",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCurrent) PrimaryIndigo else TextMuted
                )

                if (isPremium) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = AccentAmberSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentAmberBorder))
                    ) {
                        Text(
                            text = "PREMIUM",
                            color = AccentAmber,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                } else {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = AccentEmeraldSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
                    ) {
                        Text(
                            text = "ÜCRETSİZ",
                            color = AccentEmeraldLight,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = lesson.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = if (isLocked) TextSecondary else TextPrimary
            )

            Text(
                text = lesson.shortDesc,
                fontSize = 12.sp,
                color = TextMuted,
                maxLines = 1
            )
        }

        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = TextMuted,
            modifier = Modifier.size(20.dp)
        )
    }
}
