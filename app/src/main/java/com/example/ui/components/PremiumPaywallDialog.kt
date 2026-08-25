package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.AppLanguage
import com.example.ui.theme.*

enum class PricingCurrency(
    val code: String,
    val symbol: String,
    val flag: String,
    val label: String
) {
    TRY("TRY", "₺", "🇹🇷", "Türk Lirası (₺)"),
    USD("USD", "$", "🇺🇸", "US Dollar ($)")
}

data class PlanPricingInfo(
    val id: String,
    val title: String,
    val titleEn: String,
    val priceMain: String,
    val period: String,
    val periodEn: String,
    val savingsBadge: String?,
    val subtext: String?,
    val note: String
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PremiumPaywallDialog(
    appLanguage: AppLanguage = AppLanguage.TR,
    onDismiss: () -> Unit,
    onUpgradeSuccess: () -> Unit,
    onToggleDevMode: () -> Unit = onUpgradeSuccess
) {
    var selectedCurrency by remember {
        mutableStateOf(if (appLanguage == AppLanguage.EN) PricingCurrency.USD else PricingCurrency.TRY)
    }
    var selectedPlanId by remember { mutableStateOf("yearly") }

    val isTr = appLanguage == AppLanguage.TR

    val plans = remember(selectedCurrency, isTr) {
        when (selectedCurrency) {
            PricingCurrency.TRY -> listOf(
                PlanPricingInfo(
                    id = "monthly",
                    title = "Aylık",
                    titleEn = "Monthly",
                    priceMain = "199 ₺",
                    period = "/ ay",
                    periodEn = "/ mo",
                    savingsBadge = null,
                    subtext = "Aylık ödeme",
                    note = "İstediğin an iptal edilebilir"
                ),
                PlanPricingInfo(
                    id = "yearly",
                    title = "Yıllık",
                    titleEn = "Yearly",
                    priceMain = "1.999 ₺",
                    period = "/ yıl",
                    periodEn = "/ yr",
                    savingsBadge = "EN POPÜLER 🔥",
                    subtext = "Aylık ~166 ₺ (%16 Tasarruf)",
                    note = "12 ay boyunca kesintisiz PRO erişim"
                ),
                PlanPricingInfo(
                    id = "lifetime",
                    title = "Ömür Boyu",
                    titleEn = "Lifetime",
                    priceMain = "5.000 ₺",
                    period = "",
                    periodEn = "",
                    savingsBadge = "TEK SEFERLİK ⚡",
                    subtext = "Kalıcı sınırsız lisans",
                    note = "Tek ödeme, tüm gelecekteki diller dahil"
                )
            )
            PricingCurrency.USD -> listOf(
                PlanPricingInfo(
                    id = "monthly",
                    title = "Monthly",
                    titleEn = "Monthly",
                    priceMain = "$5.99",
                    period = "/ mo",
                    periodEn = "/ mo",
                    savingsBadge = null,
                    subtext = "Billed monthly",
                    note = "Cancel anytime easily"
                ),
                PlanPricingInfo(
                    id = "yearly",
                    title = "Yearly",
                    titleEn = "Yearly",
                    priceMain = "$59.99",
                    period = "/ yr",
                    periodEn = "/ yr",
                    savingsBadge = "MOST POPULAR 🔥",
                    subtext = "~$4.99/mo (Save 16%)",
                    note = "12 months full PRO access"
                ),
                PlanPricingInfo(
                    id = "lifetime",
                    title = "Lifetime",
                    titleEn = "Lifetime",
                    priceMain = "$149",
                    period = "",
                    periodEn = "",
                    savingsBadge = "ONE-TIME ⚡",
                    subtext = "Forever PRO License",
                    note = "One payment, all future updates"
                )
            )
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.92f)
                .clip(RoundedCornerShape(26.dp))
                .border(1.5.dp, PrimaryIndigo.copy(alpha = 0.6f), RoundedCornerShape(26.dp)),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Top Action Row: Currency Selector Toggle + Close Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Currency Selector Pill Toggle (TL ₺ / USD $)
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = DarkSurfaceVariant,
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder))
                    ) {
                        Row(
                            modifier = Modifier.padding(3.dp),
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            PricingCurrency.values().forEach { curr ->
                                val isCurrSelected = curr == selectedCurrency
                                val bg by animateColorAsState(
                                    targetValue = if (isCurrSelected) PrimaryIndigo else Color.Transparent,
                                    label = "curr_bg"
                                )
                                val textColor by animateColorAsState(
                                    targetValue = if (isCurrSelected) Color.White else TextSecondary,
                                    label = "curr_text"
                                )

                                Surface(
                                    shape = RoundedCornerShape(16.dp),
                                    color = bg,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(16.dp))
                                        .clickable { selectedCurrency = curr }
                                        .testTag("currency_switch_${curr.code.lowercase()}")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text(curr.flag, fontSize = 12.sp)
                                        Text(
                                            text = curr.symbol,
                                            fontSize = 12.sp,
                                            fontWeight = if (isCurrSelected) FontWeight.Bold else FontWeight.Medium,
                                            color = textColor
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Close Button
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(36.dp).testTag("close_premium_dialog")
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextMuted)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Header Badge
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(PrimaryIndigo, AccentEmerald)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LockOpen,
                        contentDescription = "Kilit Aç",
                        tint = Color.White,
                        modifier = Modifier.size(34.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = if (isTr) "Premium İçeriğin Kilidini Aç 👑" else "Unlock Premium Content 👑",
                    color = TextPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Reassurance banner
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = AccentEmeraldSubtle,
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder)),
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = AccentEmerald, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isTr)
                                "İlk 3 konu ücretsiz — 4. konudan itibaren PRO üyelik!"
                            else
                                "First 3 lessons are free — Upgrade for full access!",
                            color = AccentEmeraldLight,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Feature Highlights
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(DarkSurfaceVariant)
                        .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PremiumFeatureItem(if (isTr) "🚀 9 Programlama Diline Sınırsız Erişim (C, Lua, Dart, Python, C++, Rust, Kotlin, JS, Flutter)" else "🚀 Unlimited Access to All 9 Programming Languages (C, Lua, Dart, Python, C++, Rust, Kotlin, JS, Flutter)")
                    PremiumFeatureItem(if (isTr) "💻 İnteraktif Kodlama Egzersizleri ve Otomatik Testler" else "💻 Interactive Coding Playgrounds & Test Cases")
                    PremiumFeatureItem(if (isTr) "🧠 Akıllı Quizler, Zayıf Nokta Analizleri ve Tekrarlar" else "🧠 Smart Quizzes, Mistake Analytics & Spaced Repetition")
                    PremiumFeatureItem(if (isTr) "📁 Uygulamalı Projeler (Bellek Yöneticisi, FSM Motoru, REST API, CLI)" else "📁 Hands-on Real-World Projects (Memory Manager, FSM Engine, REST API)")
                    PremiumFeatureItem(if (isTr) "🎓 Doğrulanabilir Başarı Sertifikaları & Portfolyo" else "🎓 Official Completion Certificates & Badges")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Currency Label & Plan Selection Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isTr) "Abonelik Planını Seç:" else "Select Subscription Plan:",
                        color = TextSecondary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = selectedCurrency.label,
                        color = PrimaryIndigoLight,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Responsive Subscription Plan Cards (FlowRow / Grid)
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    plans.forEach { plan ->
                        val isSelected = selectedPlanId == plan.id
                        val borderColor by animateColorAsState(
                            targetValue = if (isSelected) PrimaryIndigo else DarkCardBorder,
                            label = "plan_border"
                        )
                        val bgColor by animateColorAsState(
                            targetValue = if (isSelected) PrimarySubtle else DarkSurfaceVariant,
                            label = "plan_bg"
                        )

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = bgColor,
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(borderColor)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .clickable { selectedPlanId = plan.id }
                                .testTag("plan_option_${plan.id}")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    RadioButton(
                                        selected = isSelected,
                                        onClick = { selectedPlanId = plan.id },
                                        colors = RadioButtonDefaults.colors(selectedColor = PrimaryIndigo)
                                    )

                                    Column(
                                        modifier = Modifier.weight(1f, fill = false),
                                        verticalArrangement = Arrangement.spacedBy(3.dp)
                                    ) {
                                        androidx.compose.foundation.layout.FlowRow(
                                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                                            verticalArrangement = Arrangement.spacedBy(3.dp)
                                        ) {
                                            Text(
                                                text = if (isTr) plan.title else plan.titleEn,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = TextPrimary
                                            )
                                            if (plan.savingsBadge != null) {
                                                Surface(
                                                    shape = RoundedCornerShape(6.dp),
                                                    color = if (plan.id == "yearly") AccentAmberSubtle else AccentEmeraldSubtle
                                                ) {
                                                    Text(
                                                        text = plan.savingsBadge,
                                                        color = if (plan.id == "yearly") AccentAmber else AccentEmeraldLight,
                                                        fontSize = 9.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                                    )
                                                }
                                            }
                                        }

                                        if (plan.subtext != null) {
                                            Text(
                                                text = plan.subtext,
                                                fontSize = 11.sp,
                                                color = if (isSelected) PrimaryIndigoLight else TextMuted,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                    }
                                }

                                Column(
                                    horizontalAlignment = Alignment.End,
                                    modifier = Modifier.padding(start = 6.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.Bottom) {
                                        Text(
                                            text = plan.priceMain,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Black,
                                            color = if (isSelected) PrimaryIndigo else TextPrimary
                                        )
                                        if (plan.period.isNotEmpty()) {
                                            Text(
                                                text = if (isTr) plan.period else plan.periodEn,
                                                fontSize = 10.sp,
                                                color = TextMuted,
                                                modifier = Modifier.padding(start = 2.dp, bottom = 1.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Upgrade Action Button
                val activePlan = plans.firstOrNull { it.id == selectedPlanId } ?: plans[1]
                Button(
                    onClick = onUpgradeSuccess,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("upgrade_premium_button"),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(Icons.Default.Bolt, contentDescription = null, tint = AccentAmber)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isTr)
                                "${activePlan.title} Plana Geç (${activePlan.priceMain})"
                            else
                                "Upgrade to ${activePlan.titleEn} (${activePlan.priceMain})",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Developer / Testing Mode Sandbox Toggle Button
                OutlinedButton(
                    onClick = onToggleDevMode,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .testTag("dev_mode_test_premium_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = AccentEmeraldLight
                    ),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(AccentEmeraldBorder)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("🧪", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isTr) "Test & Geliştirici Modu: PRO Kilidini Aç" else "Sandbox / Dev Mode: Unlock PRO Free",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentEmeraldLight
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (isTr) "Güvenli ödeme altyapısı • İstediğin zaman test edebilir ve iptal edebilirsin" else "Secure payment • Test or cancel anytime",
                    color = TextMuted,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
private fun PremiumFeatureItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = AccentEmerald,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = text,
            color = TextPrimary,
            fontSize = 12.sp,
            lineHeight = 17.sp
        )
    }
}
