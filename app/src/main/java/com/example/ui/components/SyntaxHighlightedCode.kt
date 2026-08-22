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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

@Composable
fun SyntaxHighlightedCode(
    code: String,
    modifier: Modifier = Modifier,
    language: String = "code",
    showLineNumbers: Boolean = true,
    allowCopy: Boolean = true
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val annotatedCode = remember(code) {
        buildAnnotatedString {
            val lines = code.lines()
            lines.forEachIndexed { index, line ->
                // Token parsing for syntax highlights
                var remaining = line
                while (remaining.isNotEmpty()) {
                    when {
                        // Comments
                        remaining.startsWith("//") || remaining.startsWith("#") -> {
                            withStyle(SpanStyle(color = CodeComment)) {
                                append(remaining)
                            }
                            remaining = ""
                        }
                        // Strings (single or double quoted or backticks)
                        remaining.startsWith("\"") || remaining.startsWith("'") || remaining.startsWith("`") -> {
                            val quote = remaining[0]
                            val nextQuote = remaining.indexOf(quote, startIndex = 1)
                            if (nextQuote != -1) {
                                val str = remaining.substring(0, nextQuote + 1)
                                withStyle(SpanStyle(color = CodeString)) {
                                    append(str)
                                }
                                remaining = remaining.substring(nextQuote + 1)
                            } else {
                                withStyle(SpanStyle(color = CodeString)) {
                                    append(remaining)
                                }
                                remaining = ""
                            }
                        }
                        // Keywords
                        isKeywordMatch(remaining) != null -> {
                            val kw = isKeywordMatch(remaining)!!
                            withStyle(SpanStyle(color = CodeKeyword, fontWeight = FontWeight.Bold)) {
                                append(kw)
                            }
                            remaining = remaining.substring(kw.length)
                        }
                        // Types
                        isTypeMatch(remaining) != null -> {
                            val type = isTypeMatch(remaining)!!
                            withStyle(SpanStyle(color = CodeType, fontWeight = FontWeight.SemiBold)) {
                                append(type)
                            }
                            remaining = remaining.substring(type.length)
                        }
                        // Numbers
                        remaining.firstOrNull()?.isDigit() == true -> {
                            val numMatch = Regex("""^\d+(\.\d+)?""").find(remaining)
                            if (numMatch != null) {
                                withStyle(SpanStyle(color = CodeNumber)) {
                                    append(numMatch.value)
                                }
                                remaining = remaining.substring(numMatch.value.length)
                            } else {
                                append(remaining.first())
                                remaining = remaining.substring(1)
                            }
                        }
                        else -> {
                            // Plain character
                            append(remaining.first())
                            remaining = remaining.substring(1)
                        }
                    }
                }
                if (index < lines.size - 1) {
                    append("\n")
                }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(CodeBg)
            .border(1.dp, DarkCardBorder, RoundedCornerShape(12.dp))
    ) {
        Column {
            // Header bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CodeHeader)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(modifier = Modifier.size(10.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFFFF5F56)))
                    Box(modifier = Modifier.size(10.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFFFFBD2E)))
                    Box(modifier = Modifier.size(10.dp).clip(RoundedCornerShape(5.dp)).background(Color(0xFF27C93F)))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = language.uppercase(),
                        color = Color(0xFF94A3B8),
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
                            Toast.makeText(context, "Kod kopyalandı!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.size(28.dp).testTag("copy_code_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Kodu Kopyala",
                            tint = Color(0xFF94A3B8),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Code Content
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
                        color = Color(0xFF64748B),
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }

                Box(modifier = Modifier.horizontalScroll(scrollState)) {
                    Text(
                        text = annotatedCode,
                        fontSize = 13.sp,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = 20.sp,
                        color = Color(0xFFF8FAFC)
                    )
                }
            }
        }
    }
}

private val KEYWORDS = listOf(
    "var", "val", "const", "final", "void", "fun", "fn", "def", "let", "mut",
    "if", "else", "elif", "switch", "case", "for", "while", "do", "break", "continue",
    "return", "class", "struct", "import", "package", "public", "private", "protected",
    "async", "await", "Future", "print", "cout", "cin", "println", "console", "log",
    "true", "false", "null", "nil", "new", "this", "self", "super", "yield", "try", "catch"
)

private val TYPES = listOf(
    "int", "double", "float", "String", "str", "bool", "boolean", "char", "List", "Map", "Set",
    "vector", "usize", "i32", "i64", "f64", "Widget", "BuildContext", "dynamic", "auto"
)

private fun isKeywordMatch(text: String): String? {
    for (kw in KEYWORDS) {
        if (text.startsWith(kw)) {
            val after = text.getOrNull(kw.length)
            if (after == null || !after.isLetterOrDigit() && after != '_') {
                return kw
            }
        }
    }
    return null
}

private fun isTypeMatch(text: String): String? {
    for (type in TYPES) {
        if (text.startsWith(type)) {
            val after = text.getOrNull(type.length)
            if (after == null || !after.isLetterOrDigit() && after != '_') {
                return type
            }
        }
    }
    return null
}
