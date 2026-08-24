package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun SyntaxHighlightedCode(
    code: String,
    modifier: Modifier = Modifier,
    language: String = "code",
    showLineNumbers: Boolean = true,
    allowCopy: Boolean = true,
    fontSizeSp: Int = 13
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val editorTheme = LocalEditorTheme.current

    val annotatedCode = remember(code, language, editorTheme) {
        SyntaxHighlightingTransformation.buildSyntaxHighlightedString(code, language, editorTheme)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(editorTheme.bg)
            .border(1.dp, editorTheme.border, RoundedCornerShape(14.dp))
    ) {
        Column {
            // Header bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(editorTheme.header)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(modifier = Modifier.size(9.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFFFF5F56)))
                    Box(modifier = Modifier.size(9.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFFFFBD2E)))
                    Box(modifier = Modifier.size(9.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFF27C93F)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = language.uppercase(),
                        color = editorTheme.keywordColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                }

                if (allowCopy) {
                    IconButton(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("Code", code)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Kod panoya kopyalandı!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.size(26.dp).testTag("copy_code_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Kodu Kopyala",
                            tint = editorTheme.gutterText,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
            }

            // Code Content with Line Numbers
            val lineHeightVal = (fontSizeSp + 7).sp
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                if (showLineNumbers) {
                    val lineCount = code.lines().size
                    val lineNums = (1..lineCount).joinToString("\n")
                    Text(
                        text = lineNums,
                        color = editorTheme.gutterText,
                        fontSize = fontSizeSp.sp,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = lineHeightVal,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }

                Box(modifier = Modifier.horizontalScroll(scrollState)) {
                    Text(
                        text = annotatedCode,
                        fontSize = fontSizeSp.sp,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = lineHeightVal,
                        color = editorTheme.textPrimary
                    )
                }
            }
        }
    }
}
