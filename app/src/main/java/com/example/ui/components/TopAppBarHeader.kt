package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import com.example.model.ProgrammingLanguage
import com.example.model.UserProfileData
import com.example.ui.theme.*

@Composable
fun TopAppBarHeader(
    languages: List<ProgrammingLanguage>,
    selectedLanguageId: String,
    userProfile: UserProfileData,
    isDarkTheme: Boolean = true,
    onToggleTheme: () -> Unit = {},
    onLanguageSelected: (String) -> Unit,
    onSearchClick: () -> Unit,
    onPremiumClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .statusBarsPadding()
            .border(1.dp, DarkCardBorder.copy(alpha = 0.7f), RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        // Upper row: User avatar / Welcome text, Streak Chip, XP chip, Premium Badge, Search
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(PrimaryIndigo),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = userProfile.username.firstOrNull()?.uppercase() ?: "A",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column {
                    Text(
                        text = "Tekrar hoş geldin,",
                        fontSize = 11.sp,
                        color = TextMuted,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = userProfile.username,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Streak Chip (Professional Polish Orange Pill)
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = AccentOrangeSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentOrangeBorder)),
                    modifier = Modifier.testTag("streak_chip")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("🔥", fontSize = 12.sp)
                        Text(
                            text = "${userProfile.streakDays}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentOrange
                        )
                    }
                }

                // XP Chip (Professional Polish Blue Pill)
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = PrimarySubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder)),
                    modifier = Modifier.testTag("xp_chip")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("⭐", fontSize = 11.sp)
                        Text(
                            text = "${userProfile.currentXp}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigo
                        )
                    }
                }

                // Premium or Search button
                if (userProfile.isPremium) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = AccentEmeraldSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder))
                    ) {
                        Text(
                            text = "PRO",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Black,
                            color = AccentEmeraldLight,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                        )
                    }
                } else {
                    IconButton(
                        onClick = onPremiumClick,
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(AccentAmberSubtle)
                            .border(1.dp, AccentAmberBorder, CircleShape)
                            .testTag("open_premium_header_btn")
                    ) {
                        Icon(Icons.Default.Bolt, contentDescription = "Premium", tint = AccentAmber, modifier = Modifier.size(18.dp))
                    }
                }

                IconButton(
                    onClick = onToggleTheme,
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(DarkSurfaceVariant)
                        .border(1.dp, DarkCardBorder, CircleShape)
                        .testTag("theme_toggle_btn")
                ) {
                    Icon(
                        imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Tema Değiştir",
                        tint = if (isDarkTheme) AccentAmber else PrimaryIndigo,
                        modifier = Modifier.size(18.dp)
                    )
                }

                IconButton(
                    onClick = onSearchClick,
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(DarkSurfaceVariant)
                        .border(1.dp, DarkCardBorder, CircleShape)
                        .testTag("open_search_button")
                ) {
                    Icon(Icons.Default.Search, contentDescription = "Ara", tint = TextSecondary, modifier = Modifier.size(18.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Horizontal Language Pills Selector
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            languages.forEach { lang ->
                val isSelected = lang.id == selectedLanguageId
                val bg = if (isSelected) PrimaryIndigo else DarkSurfaceVariant
                val textColor = if (isSelected) Color.White else TextSecondary
                val borderColor = if (isSelected) PrimaryIndigo else DarkCardBorder

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(bg)
                        .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                        .clickable { onLanguageSelected(lang.id) }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .testTag("lang_chip_${lang.id}")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(lang.iconEmoji, fontSize = 14.sp)
                        Text(
                            text = lang.name,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = textColor
                        )
                    }
                }
            }
        }
    }
}
