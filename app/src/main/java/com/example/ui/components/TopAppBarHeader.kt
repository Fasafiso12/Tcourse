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
import com.example.data.util.AppStrings
import com.example.model.AppLanguage
import com.example.model.ProgrammingLanguage
import com.example.model.UserProfileData
import com.example.ui.theme.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TopAppBarHeader(
    languages: List<ProgrammingLanguage>,
    selectedLanguageId: String,
    userProfile: UserProfileData,
    isDarkTheme: Boolean = true,
    currentThemeMode: AppThemeMode = AppThemeMode.OBSIDIAN_DARK,
    appLanguage: AppLanguage = AppLanguage.TR,
    onToggleTheme: () -> Unit = {},
    onSelectThemeMode: (AppThemeMode) -> Unit = {},
    onToggleEyeCare: () -> Unit = {},
    onSelectAppLanguage: (AppLanguage) -> Unit = {},
    onLanguageSelected: (String) -> Unit,
    onSearchClick: () -> Unit,
    onPremiumClick: () -> Unit
) {
    var showThemeDropdown by remember { mutableStateOf(false) }
    var showLanguageDropdown by remember { mutableStateOf(false) }
    val strings = remember(appLanguage) { AppStrings.get(appLanguage) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .statusBarsPadding()
            .border(
                1.dp,
                DarkCardBorder.copy(alpha = 0.5f),
                RoundedCornerShape(bottomStart = AppRadius.md, bottomEnd = AppRadius.md)
            )
            .padding(horizontal = AppSpacing.md, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Tier 1: User Profile Header & Dynamic FlowRow Gamification Chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // User Avatar & Welcome Text
            Row(
                modifier = Modifier.weight(1f, fill = false),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(AppSpacing.sm)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(PrimaryIndigo),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = userProfile.username.firstOrNull()?.uppercase() ?: "A",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(modifier = Modifier.padding(end = 4.dp)) {
                    Text(
                        text = strings.welcomeBack,
                        style = AppTypography.caption,
                        color = TextMuted,
                        maxLines = 1
                    )
                    Text(
                        text = userProfile.username,
                        style = AppTypography.title,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                }
            }

            // Gamification Chips in a FlowRow (Auto wraps if screen is narrow)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Streak Chip
                Surface(
                    shape = RoundedCornerShape(AppRadius.pill),
                    color = AccentOrangeSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentOrangeBorder)),
                    modifier = Modifier.testTag("streak_chip")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text("🔥", fontSize = 11.sp)
                        Text(
                            text = "${userProfile.streakDays}",
                            style = AppTypography.caption,
                            fontWeight = FontWeight.Bold,
                            color = AccentOrange
                        )
                    }
                }

                // XP Chip
                Surface(
                    shape = RoundedCornerShape(AppRadius.pill),
                    color = PrimarySubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimarySubtleBorder)),
                    modifier = Modifier.testTag("xp_chip")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text("⭐", fontSize = 10.sp)
                        Text(
                            text = "${userProfile.currentXp}",
                            style = AppTypography.caption,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigoLight
                        )
                    }
                }

                // PRO Badge
                if (userProfile.isPremium) {
                    Surface(
                        shape = RoundedCornerShape(AppRadius.pill),
                        color = AccentEmeraldSubtle,
                        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentEmeraldBorder))
                    ) {
                        Text(
                            text = "PRO",
                            style = AppTypography.badge,
                            color = AccentEmeraldLight,
                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                        )
                    }
                }
            }
        }

        // Tier 2: Responsive Action Bar (Search Bar + Language Selector + Theme Mode)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacing.xs)
        ) {
            // Interactive Search Bar (Primary action occupying maximum available space)
            Surface(
                shape = RoundedCornerShape(AppRadius.md),
                color = DarkSurfaceVariant,
                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp)
                    .clip(RoundedCornerShape(AppRadius.md))
                    .clickable { onSearchClick() }
                    .testTag("open_search_button")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = strings.searchPlaceholder,
                        tint = TextMuted,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = strings.searchPlaceholder,
                        style = AppTypography.bodySmall,
                        color = TextMuted,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )
                }
            }

            // Quick App Language Switcher
            Box {
                Surface(
                    shape = RoundedCornerShape(AppRadius.md),
                    color = DarkSurfaceVariant,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(AppRadius.md))
                        .clickable { showLanguageDropdown = true }
                        .testTag("app_language_toggle_btn")
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = appLanguage.flagEmoji,
                            fontSize = 16.sp
                        )
                    }
                }

                DropdownMenu(
                    expanded = showLanguageDropdown,
                    onDismissRequest = { showLanguageDropdown = false },
                    properties = androidx.compose.ui.window.PopupProperties(focusable = true),
                    modifier = Modifier.background(DarkSurfaceVariant)
                ) {
                    Text(
                        text = strings.selectLanguage,
                        style = AppTypography.badge,
                        color = TextMuted,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )

                    AppLanguage.values().forEach { lang ->
                        DropdownMenuItem(
                            text = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text(lang.flagEmoji, fontSize = 16.sp)
                                    Column {
                                        Text(
                                            text = lang.displayName,
                                            color = if (lang == appLanguage) PrimaryIndigo else TextPrimary,
                                            fontWeight = if (lang == appLanguage) FontWeight.Bold else FontWeight.Normal,
                                            style = AppTypography.body
                                        )
                                        Text(
                                            text = lang.nativeName,
                                            color = TextMuted,
                                            style = AppTypography.caption
                                        )
                                    }
                                }
                            },
                            onClick = {
                                onSelectAppLanguage(lang)
                                showLanguageDropdown = false
                            }
                        )
                    }
                }
            }

            // Theme Mode Selector Button & Dropdown (Clean, recognizable palette button)
            Box {
                Surface(
                    shape = RoundedCornerShape(AppRadius.md),
                    color = PrimarySubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimaryIndigo.copy(alpha = 0.5f))),
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(AppRadius.md))
                        .clickable { showThemeDropdown = true }
                        .testTag("theme_toggle_btn")
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = strings.themeSettingTitle,
                            tint = PrimaryIndigoLight,
                            modifier = Modifier.size(19.dp)
                        )
                    }
                }

                DropdownMenu(
                    expanded = showThemeDropdown,
                    onDismissRequest = { showThemeDropdown = false },
                    properties = androidx.compose.ui.window.PopupProperties(focusable = true),
                    modifier = Modifier
                        .background(DarkSurfaceVariant)
                        .border(1.dp, PrimaryIndigo.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = null,
                            tint = PrimaryIndigoLight,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = strings.themeSettingTitle,
                            style = AppTypography.badge,
                            color = PrimaryIndigoLight,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Divider(color = DarkCardBorder, thickness = 1.dp)

                    AppThemeMode.values().forEach { mode ->
                        val isCurrent = mode == currentThemeMode
                        DropdownMenuItem(
                            text = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Surface(
                                            shape = CircleShape,
                                            color = if (isCurrent) PrimaryIndigo.copy(alpha = 0.2f) else DarkBg,
                                            border = CardDefaults.outlinedCardBorder().copy(
                                                brush = SolidColor(if (isCurrent) PrimaryIndigo else DarkCardBorder)
                                            ),
                                            modifier = Modifier.size(28.dp)
                                        ) {
                                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                                Text(mode.iconEmoji, fontSize = 14.sp)
                                            }
                                        }

                                        Column {
                                            Text(
                                                text = mode.displayName,
                                                color = if (isCurrent) PrimaryIndigoLight else TextPrimary,
                                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                                                style = AppTypography.body
                                            )
                                            Text(
                                                text = mode.description,
                                                color = TextMuted,
                                                style = AppTypography.caption
                                            )
                                        }
                                    }

                                    if (isCurrent) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Seçili",
                                            tint = PrimaryIndigoLight,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            },
                            onClick = {
                                onSelectThemeMode(mode)
                                showThemeDropdown = false
                            }
                        )
                    }
                }
            }
        }
    }
}

