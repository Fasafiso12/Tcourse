package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Info
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
import androidx.compose.ui.window.DialogProperties
import com.example.data.util.AppStrings
import com.example.model.AppLanguage
import com.example.ui.theme.*

@Composable
fun InitialLanguageSelectionDialog(
    currentLanguage: AppLanguage,
    onConfirmLanguage: (AppLanguage) -> Unit
) {
    var selectedLanguage by remember { mutableStateOf(currentLanguage) }
    val strings = remember(selectedLanguage) { AppStrings.get(selectedLanguage) }

    Dialog(
        onDismissRequest = { /* Modal must be interacted with */ },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.85f))
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 440.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .border(
                        1.5.dp,
                        Brush.linearGradient(listOf(PrimaryIndigo, AccentCyan.copy(alpha = 0.5f))),
                        RoundedCornerShape(28.dp)
                    )
                    .testTag("initial_language_selection_dialog"),
                color = DarkSurface,
                shadowElevation = 16.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    // Top Icon
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    listOf(PrimaryIndigo.copy(alpha = 0.4f), PrimaryIndigo.copy(alpha = 0.05f))
                                )
                            )
                            .border(1.dp, PrimaryIndigo.copy(alpha = 0.6f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "🌐",
                            fontSize = 32.sp
                        )
                    }

                    // Title & Description
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = strings.initialLangTitle,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = strings.initialLangSubtitle,
                            fontSize = 13.sp,
                            color = TextSecondary,
                            textAlign = TextAlign.Center,
                            lineHeight = 18.sp
                        )
                    }

                    // Language Cards
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        AppLanguage.values().forEach { lang ->
                            val isSelected = lang == selectedLanguage
                            val scale by animateFloatAsState(if (isSelected) 1.02f else 1.0f, label = "card_scale")

                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .scale(scale)
                                    .clip(RoundedCornerShape(18.dp))
                                    .border(
                                        width = if (isSelected) 2.dp else 1.dp,
                                        brush = if (isSelected) {
                                            Brush.horizontalGradient(listOf(PrimaryIndigo, AccentCyan))
                                        } else {
                                            androidx.compose.ui.graphics.SolidColor(DarkCardBorder)
                                        },
                                        shape = RoundedCornerShape(18.dp)
                                    )
                                    .clickable { selectedLanguage = lang }
                                    .testTag("lang_option_${lang.code}"),
                                color = if (isSelected) PrimarySubtle else DarkSurfaceVariant,
                                shape = RoundedCornerShape(18.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 14.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // Flag icon container
                                    Box(
                                        modifier = Modifier
                                            .size(46.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(
                                                if (isSelected) PrimaryIndigo.copy(alpha = 0.2f) else DarkBg
                                            )
                                            .border(
                                                1.dp,
                                                if (isSelected) PrimaryIndigo.copy(alpha = 0.4f) else DarkCardBorder,
                                                RoundedCornerShape(12.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = lang.flagEmoji,
                                            fontSize = 24.sp
                                        )
                                    }

                                    // Language Details
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            Text(
                                                text = lang.displayName,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = if (isSelected) PrimaryIndigoLight else TextPrimary
                                            )
                                            if (lang == AppLanguage.TR) {
                                                Surface(
                                                    shape = RoundedCornerShape(6.dp),
                                                    color = AccentEmeraldSubtle,
                                                    border = CardDefaults.outlinedCardBorder().copy(
                                                        brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder)
                                                    )
                                                ) {
                                                    Text(
                                                        text = "Türkçe",
                                                        color = AccentEmeraldLight,
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                                    )
                                                }
                                            } else {
                                                Surface(
                                                    shape = RoundedCornerShape(6.dp),
                                                    color = PrimarySubtle,
                                                    border = CardDefaults.outlinedCardBorder().copy(
                                                        brush = androidx.compose.ui.graphics.SolidColor(PrimarySubtleBorder)
                                                    )
                                                ) {
                                                    Text(
                                                        text = "English",
                                                        color = PrimaryIndigoLight,
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                                    )
                                                }
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(2.dp))

                                        Text(
                                            text = lang.description,
                                            fontSize = 12.sp,
                                            color = TextMuted,
                                            lineHeight = 16.sp
                                        )
                                    }

                                    // Radio / Checkmark Icon
                                    Icon(
                                        imageVector = if (isSelected) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
                                        contentDescription = null,
                                        tint = if (isSelected) PrimaryIndigo else TextMuted.copy(alpha = 0.5f),
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    }

                    // Helpful Hint
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(DarkBg.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            tint = AccentCyan,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = strings.initialLangChangeNote,
                            fontSize = 11.sp,
                            color = TextMuted,
                            lineHeight = 15.sp
                        )
                    }

                    // Continue CTA Button
                    Button(
                        onClick = { onConfirmLanguage(selectedLanguage) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("initial_language_continue_button"),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryIndigo,
                            contentColor = Color.White
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = selectedLanguage.flagEmoji,
                                fontSize = 16.sp
                            )
                            Text(
                                text = strings.initialLangContinue,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
