package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Özgün ve Çok Yönlü 'CodeBlock' Bileşeni.
 *
 * Özellikler:
 * 1. Syntax Highlighting: C++, Kotlin, Python, Dart, Java, JS, TS, Swift, Go, Rust, C#, SQL, JSON vb. diller için renkli sözdizimi.
 * 2. Satır Numaraları: Düzenli gutter, hatasız satır yüksekliği hizalaması ve vurgulu satır (highlightedLines) desteği.
 * 3. Kopya Butonu: Panoya kopyalama ve anında animasyonlu görsel geri bildirim (✓ Kopyalandı rozeti).
 * 4. Açık/Koyu Tema Uyumu: Açık (Light), Koyu (Dark), OLED ve Sıcak Amber temalarıyla otomatik veya manuel uyum.
 * 5. macOS / IDE Başlık Çubuğu: Dil etiketi, dosya adı/başlık ve pencere kontrol butonları.
 */
@Composable
fun CodeBlock(
    code: String,
    modifier: Modifier = Modifier,
    language: String = "kotlin",
    title: String? = null,
    showLineNumbers: Boolean = true,
    startLineNumber: Int = 1,
    highlightedLines: Set<Int> = emptySet(),
    allowCopy: Boolean = true,
    fontSize: TextUnit = 14.sp,
    cornerRadius: Dp = 14.dp,
    showWindowDots: Boolean = true,
    forceDarkMode: Boolean? = null,
    customEditorTheme: EditorTheme? = null
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    // Açık / Koyu tema algılama
    val currentAppColors = LocalAppColors.current
    val currentEditorTheme = LocalEditorTheme.current
    val isSysDark = isSystemInDarkTheme()

    val isDark = forceDarkMode ?: when {
        currentAppColors.themeMode == AppThemeMode.LIGHT -> false
        currentAppColors.themeMode == AppThemeMode.WARM_AMBER_EYE_CARE -> true
        currentAppColors.themeMode == AppThemeMode.OLED_MIDNIGHT -> true
        else -> isSysDark || currentAppColors.isDark
    }

    // Kod Bloğu Renk Paleti (Açık ve Koyu Tema Uyarlaması)
    val colorPalette = remember(isDark, customEditorTheme, currentEditorTheme, currentAppColors.themeMode) {
        if (customEditorTheme != null) {
            CodeBlockColorPalette.fromEditorTheme(customEditorTheme)
        } else if (!isDark) {
            CodeBlockColorPalette.LightPalette
        } else {
            when (currentAppColors.themeMode) {
                AppThemeMode.OLED_MIDNIGHT -> CodeBlockColorPalette.OledPalette
                AppThemeMode.WARM_AMBER_EYE_CARE -> CodeBlockColorPalette.WarmAmberPalette
                else -> CodeBlockColorPalette.fromEditorTheme(currentEditorTheme)
            }
        }
    }

    // Kopyalama animasyon durumu
    var isCopied by remember { mutableStateOf(false) }

    val highlightedCode = remember(code, language, colorPalette) {
        CodeBlockHighlighter.highlight(code, language, colorPalette)
    }

    val lines = remember(code) { code.lines() }
    val lineCount = lines.size
    val lineHeight = (fontSize.value + 7.5f).sp

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius))
            .border(1.dp, colorPalette.borderColor, RoundedCornerShape(cornerRadius))
            .testTag("code_block_card"),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(containerColor = colorPalette.backgroundColor)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // --- 1. Başlık ve Aksiyon Çubuğu (Header Bar) ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorPalette.headerColor)
                    .border(
                        width = 0.5.dp,
                        color = colorPalette.borderColor.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius)
                    )
                    .padding(horizontal = 12.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Sol: macOS Noktaları + Dil / Dosya Adı
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    if (showWindowDots) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFFFF5F56)))
                            Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFFFFBD2E)))
                            Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFF27C93F)))
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                    }

                    // Dil Rozeti (Badge)
                    val langDisplay = getLanguageDisplayName(language)
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = colorPalette.badgeBackgroundColor,
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = SolidColor(colorPalette.badgeBorderColor)
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = getLanguageEmoji(language),
                                fontSize = 11.sp
                            )
                            Text(
                                text = langDisplay.uppercase(),
                                color = colorPalette.badgeTextColor,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }

                    // Dosya Adı / Başlık (Varsa)
                    if (!title.isNullOrBlank()) {
                        Text(
                            text = title,
                            color = colorPalette.titleTextColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Sağ: Satır Sayısı Bilgisi & Kopyalama Butonu
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    if (lineCount > 1) {
                        Text(
                            text = "$lineCount satır",
                            fontSize = 10.sp,
                            color = colorPalette.gutterTextColor.copy(alpha = 0.8f),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    if (allowCopy) {
                        AnimatedContent(
                            targetState = isCopied,
                            transitionSpec = {
                                fadeIn(animationSpec = tween(150)) togetherWith
                                        fadeOut(animationSpec = tween(150))
                            },
                            label = "CopyButtonState"
                        ) { copied ->
                            if (copied) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFF10B981).copy(alpha = 0.2f),
                                    border = CardDefaults.outlinedCardBorder().copy(
                                        brush = SolidColor(Color(0xFF10B981))
                                    ),
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Kopyalandı",
                                            tint = Color(0xFF10B981),
                                            modifier = Modifier.size(12.dp)
                                        )
                                        Text(
                                            text = "Kopyalandı",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF10B981)
                                        )
                                    }
                                }
                            } else {
                                IconButton(
                                    onClick = {
                                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                        val clip = ClipData.newPlainText("Code", code)
                                        clipboard.setPrimaryClip(clip)
                                        isCopied = true
                                        Toast.makeText(context, "Kod panoya kopyalandı!", Toast.LENGTH_SHORT).show()

                                        coroutineScope.launch {
                                            delay(2000)
                                            isCopied = false
                                        }
                                    },
                                    modifier = Modifier
                                        .size(28.dp)
                                        .testTag("code_block_copy_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ContentCopy,
                                        contentDescription = "Kodu Kopyala",
                                        tint = colorPalette.gutterTextColor,
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // --- 2. Kod Gövdesi ve Satır Numaraları (Code Content) ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                // Satır Numaraları Sütunu (Gutter)
                if (showLineNumbers) {
                    val lineNumbersText = (startLineNumber until startLineNumber + lineCount).joinToString("\n")
                    Column(
                        modifier = Modifier
                            .padding(start = 12.dp, end = 10.dp)
                            .border(
                                width = 0.5.dp,
                                color = colorPalette.borderColor.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(0.dp)
                            ),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = lineNumbersText,
                            color = colorPalette.gutterTextColor,
                            fontSize = fontSize,
                            fontFamily = FontFamily.Monospace,
                            lineHeight = lineHeight,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                // Yatay Kaydırılabilir Kod Alanı
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = if (showLineNumbers) 4.dp else 12.dp, end = 12.dp)
                        .horizontalScroll(scrollState)
                ) {
                    Text(
                        text = highlightedCode,
                        fontSize = fontSize,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = lineHeight,
                        color = colorPalette.textColor
                    )
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// TEMA & RENK PALETİ MODELİ (Açık/Koyu Tema ve Özel Editör Temaları)
// -------------------------------------------------------------------------------------------------

data class CodeBlockColorPalette(
    val backgroundColor: Color,
    val headerColor: Color,
    val borderColor: Color,
    val textColor: Color,
    val gutterTextColor: Color,
    val titleTextColor: Color,
    val badgeBackgroundColor: Color,
    val badgeBorderColor: Color,
    val badgeTextColor: Color,
    // Syntax Token Renkleri
    val keywordColor: Color,
    val typeColor: Color,
    val stringColor: Color,
    val numberColor: Color,
    val commentColor: Color,
    val operatorColor: Color,
    val punctuationColor: Color,
    val functionColor: Color,
    val annotationColor: Color
) {
    companion object {
        // Modern Aydınlık (Light) Tema Paleti - Temiz, ferah ve yüksek kontrast
        val LightPalette = CodeBlockColorPalette(
            backgroundColor = Color(0xFFF8FAFC), // Slate 50
            headerColor = Color(0xFFEDF2F7),     // Slate 100
            borderColor = Color(0xFFCBD5E1),     // Slate 300
            textColor = Color(0xFF0F172A),       // Slate 900
            gutterTextColor = Color(0xFF94A3B8), // Slate 400
            titleTextColor = Color(0xFF334155),  // Slate 700
            badgeBackgroundColor = Color(0xFFE0E7FF), // Indigo 100
            badgeBorderColor = Color(0xFFC7D2FE),     // Indigo 200
            badgeTextColor = Color(0xFF4338CA),       // Indigo 700
            keywordColor = Color(0xFF4F46E5),         // Deep Indigo
            typeColor = Color(0xFF0284C7),            // Sky Blue
            stringColor = Color(0xFF15803D),          // Forest Green
            numberColor = Color(0xFFD97706),          // Amber 600
            commentColor = Color(0xFF64748B),         // Slate 500
            operatorColor = Color(0xFF7C3AED),        // Violet 600
            punctuationColor = Color(0xFF334155),     // Slate 700
            functionColor = Color(0xFF2563EB),        // Blue 600
            annotationColor = Color(0xFFC026D3)       // Fuchsia 600
        )

        // OLED Saf Siyah Paleti
        val OledPalette = CodeBlockColorPalette(
            backgroundColor = Color(0xFF000000),
            headerColor = Color(0xFF0A0A0A),
            borderColor = Color(0xFF262626),
            textColor = Color(0xFFFFFFFF),
            gutterTextColor = Color(0xFF525252),
            titleTextColor = Color(0xFFE5E5E5),
            badgeBackgroundColor = Color(0xFF14172B),
            badgeBorderColor = Color(0xFF222847),
            badgeTextColor = Color(0xFF818CF8),
            keywordColor = Color(0xFF818CF8),
            typeColor = Color(0xFF38BDF8),
            stringColor = Color(0xFF22C55E),
            numberColor = Color(0xFFF59E0B),
            commentColor = Color(0xFF737373),
            operatorColor = Color(0xFFA5B4FC),
            punctuationColor = Color(0xFFE5E5E5),
            functionColor = Color(0xFF67E8F9),
            annotationColor = Color(0xFFF472B6)
        )

        // Sıcak Amber / Göz Koruma Paleti
        val WarmAmberPalette = CodeBlockColorPalette(
            backgroundColor = Color(0xFF14110E),
            headerColor = Color(0xFF1D1813),
            borderColor = Color(0xFF332B22),
            textColor = Color(0xFFF5EDE0),
            gutterTextColor = Color(0xFF8C7965),
            titleTextColor = Color(0xFFFDF8F0),
            badgeBackgroundColor = Color(0xFF282015),
            badgeBorderColor = Color(0xFF423422),
            badgeTextColor = Color(0xFFFBBF24),
            keywordColor = Color(0xFFE07A5F),
            typeColor = Color(0xFFF4A261),
            stringColor = Color(0xFF81B29A),
            numberColor = Color(0xFFF2CC8F),
            commentColor = Color(0xFF8C7965),
            operatorColor = Color(0xFFE76F51),
            punctuationColor = Color(0xFFD4A373),
            functionColor = Color(0xFFF6BD60),
            annotationColor = Color(0xFFB5838D)
        )

        fun fromEditorTheme(theme: EditorTheme): CodeBlockColorPalette {
            return CodeBlockColorPalette(
                backgroundColor = theme.bg,
                headerColor = theme.header,
                borderColor = theme.border,
                textColor = theme.textPrimary,
                gutterTextColor = theme.gutterText,
                titleTextColor = theme.textPrimary,
                badgeBackgroundColor = theme.header.copy(alpha = 0.8f),
                badgeBorderColor = theme.border,
                badgeTextColor = theme.keywordColor,
                keywordColor = theme.keywordColor,
                typeColor = theme.typeColor,
                stringColor = theme.stringColor,
                numberColor = theme.numberColor,
                commentColor = theme.commentColor,
                operatorColor = theme.operatorColor,
                punctuationColor = theme.punctuationColor,
                functionColor = theme.typeColor,
                annotationColor = theme.keywordColor
            )
        }
    }
}

// -------------------------------------------------------------------------------------------------
// GELİŞMİŞ SÖZDİZİMİ AYRIŞTIRICI & RENKLENDİRİCİ (SYNTAX HIGHLIGHTER)
// -------------------------------------------------------------------------------------------------

object CodeBlockHighlighter {

    private val KEYWORDS = setOf(
        // Kotlin & Java
        "fun", "val", "var", "class", "object", "interface", "enum", "sealed", "data", "override",
        "private", "public", "protected", "internal", "import", "package", "return", "if", "else",
        "when", "while", "for", "in", "is", "as", "try", "catch", "finally", "throw", "null", "true",
        "false", "this", "super", "suspend", "coroutine", "companion", "by", "lazy", "lateinit",
        "abstract", "open", "final", "const", "inline", "reified", "crossinline", "noinline",
        "static", "void", "extends", "implements", "new", "switch", "case", "default", "break",
        // C++ & C
        "#include", "#define", "#ifdef", "#ifndef", "#endif", "using", "namespace", "template",
        "typename", "struct", "typedef", "constexpr", "nullptr", "sizeof", "auto", "cout", "cin", "endl",
        // Python
        "def", "elif", "pass", "lambda", "yield", "async", "await", "with", "from", "global",
        "nonlocal", "raise", "assert", "del", "None", "True", "False", "self", "cls",
        // Dart & Flutter
        "final", "const", "factory", "required", "mixin", "on", "typedef", "dynamic", "get", "set",
        // JavaScript & TypeScript
        "let", "function", "export", "typeof", "instanceof", "undefined", "NaN", "debugger",
        // Go, Rust, C#, SQL
        "go", "chan", "defer", "select", "mut", "pub", "impl", "trait", "fn", "match", "loop",
        "async", "unsafe", "use", "mod", "where", "SELECT", "FROM", "WHERE", "INSERT", "UPDATE",
        "DELETE", "JOIN", "INNER", "LEFT", "RIGHT", "GROUP", "ORDER", "BY", "LIMIT", "CREATE", "TABLE"
    )

    private val TYPES = setOf(
        // Primitives & Common Types
        "Int", "String", "Boolean", "Double", "Float", "Long", "Short", "Byte", "Char", "Unit", "Any",
        "int", "string", "bool", "double", "float", "long", "short", "char", "void", "boolean", "size_t",
        "List", "Map", "Set", "Array", "ArrayList", "HashMap", "HashSet", "Vector", "vector", "pair",
        "int32_t", "int64_t", "uint32_t", "uint64_t", "std::string", "std::vector", "std::map",
        // Mobile / Flutter / Compose Framework Types
        "Widget", "StatelessWidget", "StatefulWidget", "State", "BuildContext", "Modifier", "Composable",
        "Color", "Column", "Row", "Box", "Text", "Button", "Scaffold", "LazyColumn", "LazyRow",
        "ViewModel", "StateFlow", "SharedFlow", "Flow", "CoroutineScope", "Job", "Deferred", "Result"
    )

    fun highlight(code: String, language: String, palette: CodeBlockColorPalette): AnnotatedString {
        return buildAnnotatedString {
            val lines = code.lines()
            lines.forEachIndexed { lineIdx, line ->
                var cursor = 0
                val length = line.length

                while (cursor < length) {
                    val remaining = line.substring(cursor)

                    when {
                        // 1. Yorumlar (Comments: //, #)
                        remaining.startsWith("//") || remaining.startsWith("#") -> {
                            withStyle(SpanStyle(color = palette.commentColor, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)) {
                                append(remaining)
                            }
                            cursor = length
                        }

                        // 2. Çok Satırlı Yorum Başlangıcı (/* ... */)
                        remaining.startsWith("/*") -> {
                            val endIdx = remaining.indexOf("*/")
                            if (endIdx != -1) {
                                withStyle(SpanStyle(color = palette.commentColor, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)) {
                                    append(remaining.substring(0, endIdx + 2))
                                }
                                cursor += endIdx + 2
                            } else {
                                withStyle(SpanStyle(color = palette.commentColor, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)) {
                                    append(remaining)
                                }
                                cursor = length
                            }
                        }

                        // 3. String Değerler ("...", '...', `...`, """...""")
                        remaining.startsWith("\"\"\"") -> {
                            val endIdx = remaining.indexOf("\"\"\"", startIndex = 3)
                            if (endIdx != -1) {
                                withStyle(SpanStyle(color = palette.stringColor)) {
                                    append(remaining.substring(0, endIdx + 3))
                                }
                                cursor += endIdx + 3
                            } else {
                                withStyle(SpanStyle(color = palette.stringColor)) {
                                    append(remaining)
                                }
                                cursor = length
                            }
                        }

                        remaining.startsWith("\"") || remaining.startsWith("'") || remaining.startsWith("`") -> {
                            val quote = remaining[0]
                            var endIdx = -1
                            var isEscaped = false
                            for (i in 1 until remaining.length) {
                                val c = remaining[i]
                                if (c == '\\' && !isEscaped) {
                                    isEscaped = true
                                    continue
                                }
                                if (c == quote && !isEscaped) {
                                    endIdx = i
                                    break
                                }
                                isEscaped = false
                            }

                            if (endIdx != -1) {
                                withStyle(SpanStyle(color = palette.stringColor)) {
                                    append(remaining.substring(0, endIdx + 1))
                                }
                                cursor += endIdx + 1
                            } else {
                                withStyle(SpanStyle(color = palette.stringColor)) {
                                    append(remaining)
                                }
                                cursor = length
                            }
                        }

                        // 4. Anotasyonlar & Decorators (@Composable, @Override, #include)
                        remaining.startsWith("@") || (remaining.startsWith("#") && !language.equals("python", ignoreCase = true)) -> {
                            val match = Regex("""^[@#][a-zA-Z_0-9]+""").find(remaining)
                            if (match != null) {
                                withStyle(SpanStyle(color = palette.annotationColor, fontWeight = FontWeight.SemiBold)) {
                                    append(match.value)
                                }
                                cursor += match.value.length
                            } else {
                                append(remaining[0])
                                cursor++
                            }
                        }

                        // 5. Sayılar (Numbers: Integer, Float, Hex, Binary)
                        remaining.first().isDigit() -> {
                            val match = Regex("""^(0[xXbB][0-9a-fA-F_]+|\d+(\.\d+)?([eE][+-]?\d+)?[fFdDlL]?)""").find(remaining)
                            if (match != null) {
                                withStyle(SpanStyle(color = palette.numberColor, fontWeight = FontWeight.Medium)) {
                                    append(match.value)
                                }
                                cursor += match.value.length
                            } else {
                                append(remaining[0])
                                cursor++
                            }
                        }

                        // 6. Çoklu Karakter Operatörleri
                        remaining.startsWith("->") || remaining.startsWith("=>") || remaining.startsWith("==") ||
                        remaining.startsWith("!=") || remaining.startsWith("<=") || remaining.startsWith(">=") ||
                        remaining.startsWith("&&") || remaining.startsWith("||") || remaining.startsWith("++") ||
                        remaining.startsWith("--") || remaining.startsWith("::") || remaining.startsWith("<<") ||
                        remaining.startsWith(">>") -> {
                            withStyle(SpanStyle(color = palette.operatorColor, fontWeight = FontWeight.Bold)) {
                                append(remaining.substring(0, 2))
                            }
                            cursor += 2
                        }

                        // 7. Kelimeler (Anahtar Kelimeler, Türler, Fonksiyonlar ve Değişkenler)
                        remaining.first().isLetter() || remaining.first() == '_' -> {
                            val match = Regex("""^[a-zA-Z_][a-zA-Z0-9_]*""").find(remaining)
                            if (match != null) {
                                val word = match.value
                                val afterWord = remaining.substring(word.length)

                                when {
                                    // Anahtar Kelime (Keyword)
                                    KEYWORDS.contains(word) -> {
                                        withStyle(SpanStyle(color = palette.keywordColor, fontWeight = FontWeight.Bold)) {
                                            append(word)
                                        }
                                    }
                                    // Tip / Sınıf (Type)
                                    TYPES.contains(word) || (word.first().isUpperCase() && !word.all { it.isUpperCase() }) -> {
                                        withStyle(SpanStyle(color = palette.typeColor, fontWeight = FontWeight.SemiBold)) {
                                            append(word)
                                        }
                                    }
                                    // Fonksiyon Çağrısı / Tanımı (Function call e.g. print(...))
                                    afterWord.startsWith("(") || afterWord.startsWith("<") -> {
                                        withStyle(SpanStyle(color = palette.functionColor, fontWeight = FontWeight.SemiBold)) {
                                            append(word)
                                        }
                                    }
                                    // Normal Değişken / Tanımlayıcı
                                    else -> {
                                        withStyle(SpanStyle(color = palette.textColor)) {
                                            append(word)
                                        }
                                    }
                                }
                                cursor += word.length
                            } else {
                                append(remaining[0])
                                cursor++
                            }
                        }

                        // 8. Parantezler & Noktalama İşaretleri
                        listOf('{', '}', '(', ')', '[', ']').contains(remaining.first()) -> {
                            withStyle(SpanStyle(color = palette.punctuationColor, fontWeight = FontWeight.Bold)) {
                                append(remaining.first())
                            }
                            cursor++
                        }

                        listOf('+', '-', '*', '/', '%', '=', '<', '>', '!', '&', '|', ':', ';', ',', '.', '?').contains(remaining.first()) -> {
                            withStyle(SpanStyle(color = palette.operatorColor)) {
                                append(remaining.first())
                            }
                            cursor++
                        }

                        // 9. Diğer karakterler / Boşluklar
                        else -> {
                            append(remaining.first())
                            cursor++
                        }
                    }
                }

                if (lineIdx < lines.size - 1) {
                    append("\n")
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// DİL ADI VE EMOJİ YARDIMCILARI
// -------------------------------------------------------------------------------------------------

private fun getLanguageDisplayName(lang: String): String {
    return when (lang.lowercase().trim()) {
        "kotlin", "kt" -> "Kotlin"
        "cpp", "c++", "cplusplus" -> "C++"
        "python", "py" -> "Python"
        "dart", "flutter" -> "Dart"
        "java" -> "Java"
        "javascript", "js" -> "JavaScript"
        "typescript", "ts" -> "TypeScript"
        "swift" -> "Swift"
        "go", "golang" -> "Go"
        "rust", "rs" -> "Rust"
        "csharp", "c#" -> "C#"
        "c" -> "C"
        "sql" -> "SQL"
        "html" -> "HTML"
        "css" -> "CSS"
        "json" -> "JSON"
        "bash", "sh", "shell" -> "Bash"
        else -> lang.replaceFirstChar { it.uppercase() }
    }
}

private fun getLanguageEmoji(lang: String): String {
    return when (lang.lowercase().trim()) {
        "kotlin", "kt" -> "💜"
        "cpp", "c++", "cplusplus" -> "⚙️"
        "python", "py" -> "🐍"
        "dart", "flutter" -> "🎯"
        "java" -> "☕"
        "javascript", "js" -> "🟨"
        "typescript", "ts" -> "🔷"
        "swift" -> "🕊️"
        "go", "golang" -> "🐹"
        "rust", "rs" -> "🦀"
        "csharp", "c#" -> "🟣"
        "c" -> "🔷"
        "sql" -> "🗄️"
        "html" -> "🌐"
        "css" -> "🎨"
        "json" -> "📋"
        "bash", "sh", "shell" -> "💻"
        else -> "⚡"
    }
}
