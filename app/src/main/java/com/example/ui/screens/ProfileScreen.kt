package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.catalog.CourseCatalog
import com.example.data.db.FavoriteEntity
import com.example.data.db.MistakeEntity
import com.example.data.db.UserNoteEntity
import com.example.data.engine.GamificationService
import com.example.data.util.AppStrings
import com.example.model.*
import com.example.ui.theme.*
import com.example.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    viewModel: MainViewModel,
    userProfile: UserProfileData,
    notes: List<UserNoteEntity>,
    favorites: List<FavoriteEntity>,
    mistakes: List<MistakeEntity>,
    onOpenCertificate: (ProgrammingLanguage) -> Unit
) {
    val languages = CourseCatalog.languages
    val allProgressMap by viewModel.allLanguagesProgress.collectAsState()
    val appLanguage by viewModel.appLanguage.collectAsState()
    val strings = remember(appLanguage) { AppStrings.get(appLanguage) }

    val richAchievements by viewModel.richAchievements.collectAsState()
    val weeklyStats by viewModel.weeklyStats.collectAsState()

    val levelTier = remember(userProfile.currentXp) {
        GamificationService.getLevelTier(userProfile.currentXp)
    }
    val levelProgress = remember(userProfile.currentXp) {
        GamificationService.getLevelProgressRatio(userProfile.currentXp)
    }

    var selectedAchievementCategory by remember { mutableStateOf<AchievementCategory?>(null) }
    var activeSubTab by remember { mutableStateOf("ACHIEVEMENTS") } // ACHIEVEMENTS, STATS, MISTAKES, NOTES, SETTINGS

    val filteredAchievements = remember(selectedAchievementCategory, richAchievements) {
        if (selectedAchievementCategory == null) richAchievements
        else richAchievements.filter { it.category == selectedAchievementCategory }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBg)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 36.dp)
    ) {
        // ==========================================
        // 1. Profile & 10-Level XP Tier Card
        // ==========================================
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(22.dp))
                    .testTag("profile_tier_card"),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(PrimarySubtle)
                                .border(1.dp, PrimarySubtleBorder, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(levelTier.badgeEmoji, fontSize = 28.sp)
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = userProfile.username,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Text(
                                text = "LEVEL ${levelTier.level} • ${levelTier.titleTr} (${levelTier.titleEn})",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = PrimaryIndigo
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = AccentAmberSubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentAmberBorder))
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
                                    color = AccentAmber
                                )
                            }
                        }
                    }

                    // Level XP Progress
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${userProfile.currentXp} / ${levelTier.maxXp} XP",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextSecondary
                            )
                            Text(
                                text = "%${(levelProgress * 100).toInt()} İlerleme",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryIndigo
                            )
                        }

                        LinearProgressIndicator(
                            progress = { levelProgress },
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

        // ==========================================
        // 2. Profile Sub-Tabs
        // ==========================================
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                val tabs = listOf(
                    "ACHIEVEMENTS" to "🏆 Başarımlar (${richAchievements.count { it.isUnlocked }})",
                    "STATS" to "📊 Haftalık İstatistik",
                    "MISTAKES" to "🧠 Tekrar Havuzu (${mistakes.size})",
                    "NOTES" to "📝 Notlarım (${notes.size})",
                    "SETTINGS" to "⚙️ Ayarlar"
                )
                items(tabs) { (key, label) ->
                    val isSelected = activeSubTab == key
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) PrimarySubtle else DarkSurface,
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = SolidColor(if (isSelected) PrimaryIndigo else DarkCardBorder)
                        ),
                        modifier = Modifier.clickable { activeSubTab = key }
                    ) {
                        Text(
                            text = label,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) PrimaryIndigo else TextPrimary,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        )
                    }
                }
            }
        }

        // ==========================================
        // 3. Tab Content
        // ==========================================
        when (activeSubTab) {
            "ACHIEVEMENTS" -> {
                item {
                    // Category Filter Chips
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        item {
                            FilterChip(
                                selected = selectedAchievementCategory == null,
                                onClick = { selectedAchievementCategory = null },
                                label = { Text("Tümü (${richAchievements.size})", fontSize = 11.sp) }
                            )
                        }
                        items(AchievementCategory.values()) { cat ->
                            FilterChip(
                                selected = selectedAchievementCategory == cat,
                                onClick = { selectedAchievementCategory = cat },
                                label = { Text("${cat.iconEmoji} ${cat.titleTr}", fontSize = 11.sp) }
                            )
                        }
                    }
                }

                items(filteredAchievements) { ach ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(
                                1.dp,
                                if (ach.isUnlocked) AccentAmberBorder else DarkCardBorder,
                                RoundedCornerShape(16.dp)
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = if (ach.isUnlocked) DarkSurfaceVariant else DarkSurface
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(if (ach.isUnlocked) AccentAmberSubtle else DarkSurfaceVariant),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(if (ach.isUnlocked) ach.iconEmoji else "🔒", fontSize = 22.sp)
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = ach.titleTr,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    if (ach.isUnlocked) {
                                        Text("✓ Açıldı", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                                    }
                                }
                                Text(
                                    text = ach.descriptionTr,
                                    fontSize = 12.sp,
                                    color = TextSecondary
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (ach.isUnlocked) AccentAmberSubtle else DarkBg
                            ) {
                                Text(
                                    text = "+${ach.xpReward} XP",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (ach.isUnlocked) AccentAmber else TextMuted,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            "STATS" -> {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .border(1.dp, DarkCardBorder, RoundedCornerShape(18.dp)),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            Text(
                                text = "Haftalık Çalışma Dağılımı",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                weeklyStats.daysBreakdown.forEach { day ->
                                    val heightRatio = (day.studyMinutes.toFloat() / 60f).coerceIn(0.15f, 1f)
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .width(28.dp)
                                                .fillMaxHeight(heightRatio)
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(if (day.isToday) PrimaryIndigo else DarkSurfaceVariant)
                                        )
                                        Text(day.dayNameTr, fontSize = 10.sp, color = TextMuted)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            "MISTAKES" -> {
                if (mistakes.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Harika! Henüz kaydedilmiş soru hatası bulunmuyor. 🎉", color = TextSecondary, fontSize = 13.sp)
                        }
                    }
                } else {
                    items(mistakes) { mistake ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, AccentRoseBorder.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(mistake.topicName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                Text(mistake.questionText, fontSize = 12.sp, color = TextSecondary)
                                Text("Doğru Cevap: ${mistake.correctAnswer}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = AccentEmeraldLight)
                            }
                        }
                    }
                }
            }

            "NOTES" -> {
                if (notes.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Henüz ders notu eklenmedi.", color = TextSecondary, fontSize = 13.sp)
                        }
                    }
                } else {
                    items(notes) { note ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                            colors = CardDefaults.cardColors(containerColor = DarkSurface)
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text(note.lessonTitle, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                                Text(note.noteContent, fontSize = 13.sp, color = TextSecondary)
                            }
                        }
                    }
                }
            }

            "SETTINGS" -> {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(1.dp, if (userProfile.isPremium) AccentEmeraldBorder else DarkCardBorder, RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Text("🧪", fontSize = 22.sp)
                                    Column {
                                        Text(
                                            text = "Test & Geliştirici Modu",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = TextPrimary
                                        )
                                        Text(
                                            text = if (userProfile.isPremium) "PRO özellikleri aktif (Tüm kilitler açık)" else "Ücretsiz mod (PRO kilitleri aktif)",
                                            fontSize = 12.sp,
                                            color = if (userProfile.isPremium) AccentEmeraldLight else TextSecondary
                                        )
                                    }
                                }
                                Switch(
                                    checked = userProfile.isPremium,
                                    onCheckedChange = { isChecked ->
                                        viewModel.setPremiumDevMode(isChecked)
                                    },
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = Color.White,
                                        checkedTrackColor = AccentEmerald,
                                        uncheckedThumbColor = TextMuted,
                                        uncheckedTrackColor = DarkSurfaceVariant
                                    )
                                )
                            }

                            Text(
                                text = "Bu ayarı açarak tüm kilitli dersleri, yapay zeka ipuçlarını ve sınırsız can özelliklerini hiçbir ücret ödemeden anında test edebilir, istediğinizde tekrar kapatabilirsiniz.",
                                fontSize = 11.sp,
                                color = TextMuted,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }

                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(containerColor = DarkSurface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text("Tema ve Görünüm", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                            Button(
                                onClick = { viewModel.toggleTheme() },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text("Temayı Değiştir (Aydınlık / Karanlık)")
                            }
                        }
                    }
                }
            }
        }
    }
}
