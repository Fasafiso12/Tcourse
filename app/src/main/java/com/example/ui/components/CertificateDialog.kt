package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.model.ProgrammingLanguage
import com.example.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CertificateDialog(
    language: ProgrammingLanguage,
    username: String,
    onDismiss: () -> Unit
) {
    val dateStr = SimpleDateFormat("dd MMMM yyyy", Locale("tr")).format(Date())

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .clip(RoundedCornerShape(20.dp))
                .border(2.dp, Brush.linearGradient(listOf(AccentAmber, PrimaryIndigo)), RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(containerColor = DarkSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "RESMİ BAŞARI BELGESİ",
                        color = AccentAmber,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                    IconButton(onClick = onDismiss, modifier = Modifier.size(32.dp).testTag("close_certificate_dialog")) {
                        Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextMuted)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Certificate Frame
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF0F172A))
                        .border(1.dp, Color(0xFF334155), RoundedCornerShape(16.dp))
                        .padding(18.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Brush.radialGradient(listOf(AccentAmber, Color(0xFFD97706)))),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.WorkspacePremium, contentDescription = null, tint = Color.White, modifier = Modifier.size(30.dp))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "KOD AKADEMİ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 3.sp,
                            color = PrimaryIndigo
                        )

                        Text(
                            text = "PROGRAMLAMA UZMANLIK SERTİFİKASI",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextSecondary,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = "Bu sertifika başarıyla tamamlayan:",
                            fontSize = 11.sp,
                            color = TextMuted
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = username,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "${language.name} Programlama Dili ve Yazılım Geliştirme müfredatındaki tüm teori, quiz, kodlama egzersizleri ve projeleri üstün başarıyla tamamlamıştır.",
                            fontSize = 12.sp,
                            color = TextSecondary,
                            textAlign = TextAlign.Center,
                            lineHeight = 16.sp
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Column {
                                Text(text = "Tarih:", fontSize = 10.sp, color = TextMuted)
                                Text(text = dateStr, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = TextPrimary)
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(text = "Doğrulama Kodu:", fontSize = 10.sp, color = TextMuted)
                                Text(text = "KA-${language.id.uppercase()}-2026", fontSize = 11.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, color = AccentEmerald)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth().height(48.dp).testTag("download_certificate_button"),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Sertifikayı Paylaş & Kaydet", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
