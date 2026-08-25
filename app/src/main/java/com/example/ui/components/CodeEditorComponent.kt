package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.engine.CodeExecutionEngine
import com.example.model.ExecutionResult
import com.example.ui.theme.*
import kotlinx.coroutines.launch

/**
 * VisualTransformation that tokenizes code in real-time and applies theme-specific syntax highlighting
 * for keywords, types, strings, comments, numbers, operators, and punctuation.
 */
class SyntaxHighlightingTransformation(
    private val language: String = "dart",
    private val editorTheme: EditorTheme = EditorTheme.OBSIDIAN
) : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val highlighted = buildSyntaxHighlightedString(text.text, language, editorTheme)
        return TransformedText(highlighted, OffsetMapping.Identity)
    }

    companion object {
        fun buildSyntaxHighlightedString(
            rawCode: String,
            language: String,
            theme: EditorTheme = EditorTheme.OBSIDIAN
        ): AnnotatedString {
            return buildAnnotatedString {
                val lines = rawCode.lines()
                lines.forEachIndexed { index, line ->
                    var remaining = line
                    while (remaining.isNotEmpty()) {
                        when {
                            // Comments
                            remaining.startsWith("//") || remaining.startsWith("#") -> {
                                withStyle(SpanStyle(color = theme.commentColor)) {
                                    append(remaining)
                                }
                                remaining = ""
                            }
                            // Multi-line / block comment openers
                            remaining.startsWith("/*") -> {
                                val endIdx = remaining.indexOf("*/")
                                if (endIdx != -1) {
                                    withStyle(SpanStyle(color = theme.commentColor)) {
                                        append(remaining.substring(0, endIdx + 2))
                                    }
                                    remaining = remaining.substring(endIdx + 2)
                                } else {
                                    withStyle(SpanStyle(color = theme.commentColor)) {
                                        append(remaining)
                                    }
                                    remaining = ""
                                }
                            }
                            // Strings
                            remaining.startsWith("\"") || remaining.startsWith("'") || remaining.startsWith("`") -> {
                                val quote = remaining[0]
                                val nextQuote = remaining.indexOf(quote, startIndex = 1)
                                if (nextQuote != -1) {
                                    val str = remaining.substring(0, nextQuote + 1)
                                    withStyle(SpanStyle(color = theme.stringColor)) {
                                        append(str)
                                    }
                                    remaining = remaining.substring(nextQuote + 1)
                                } else {
                                    withStyle(SpanStyle(color = theme.stringColor)) {
                                        append(remaining)
                                    }
                                    remaining = ""
                                }
                            }
                            // Keywords
                            isKeywordMatch(remaining) != null -> {
                                val kw = isKeywordMatch(remaining)!!
                                withStyle(SpanStyle(color = theme.keywordColor, fontWeight = FontWeight.Bold)) {
                                    append(kw)
                                }
                                remaining = remaining.substring(kw.length)
                            }
                            // Types
                            isTypeMatch(remaining) != null -> {
                                val type = isTypeMatch(remaining)!!
                                withStyle(SpanStyle(color = theme.typeColor, fontWeight = FontWeight.SemiBold)) {
                                    append(type)
                                }
                                remaining = remaining.substring(type.length)
                            }
                            // Numbers
                            remaining.firstOrNull()?.isDigit() == true -> {
                                val numMatch = Regex("""^\d+(\.\d+)?""").find(remaining)
                                if (numMatch != null) {
                                    withStyle(SpanStyle(color = theme.numberColor)) {
                                        append(numMatch.value)
                                    }
                                    remaining = remaining.substring(numMatch.value.length)
                                } else {
                                    append(remaining.first())
                                    remaining = remaining.substring(1)
                                }
                            }
                            // Punctuation & Operators
                            remaining.startsWith("->") || remaining.startsWith("=>") || remaining.startsWith("==") ||
                            remaining.startsWith("!=") || remaining.startsWith("<=") || remaining.startsWith(">=") -> {
                                withStyle(SpanStyle(color = theme.operatorColor, fontWeight = FontWeight.Bold)) {
                                    append(remaining.substring(0, 2))
                                }
                                remaining = remaining.substring(2)
                            }
                            listOf('{', '}', '(', ')', '[', ']').contains(remaining.first()) -> {
                                withStyle(SpanStyle(color = theme.punctuationColor)) {
                                    append(remaining.first())
                                }
                                remaining = remaining.substring(1)
                            }
                            listOf('+', '-', '*', '/', '%', '=', '<', '>', '!', '&', '|', ':', ';', ',').contains(remaining.first()) -> {
                                withStyle(SpanStyle(color = theme.operatorColor)) {
                                    append(remaining.first())
                                }
                                remaining = remaining.substring(1)
                            }
                            else -> {
                                withStyle(SpanStyle(color = theme.textPrimary)) {
                                    append(remaining.first())
                                }
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

        private val KEYWORDS = listOf(
            "var", "val", "const", "final", "void", "fun", "fn", "def", "let", "mut",
            "if", "else", "elif", "then", "end", "repeat", "until", "local", "function",
            "switch", "case", "for", "while", "do", "break", "continue", "return", "class",
            "struct", "union", "enum", "extern", "static", "import", "package", "public", "private", "protected",
            "async", "await", "Future", "print", "printf", "puts", "cout", "cin", "println", "console", "log",
            "true", "false", "null", "nil", "new", "this", "self", "super", "yield", "try", "catch",
            "except", "finally", "throw", "raise", "pass", "in", "is", "as", "typedef", "include", "using", "sizeof",
            "not", "and", "or"
        )

        private val TYPES = listOf(
            "int", "double", "float", "long", "short", "char", "unsigned", "signed", "void", "size_t",
            "uint8_t", "uint16_t", "uint32_t", "uint64_t", "int8_t", "int16_t", "int32_t", "int64_t",
            "String", "str", "bool", "boolean", "List", "Map", "Set", "table",
            "vector", "usize", "i32", "i64", "f64", "Widget", "BuildContext", "dynamic", "auto",
            "StatelessWidget", "StatefulWidget", "State", "MaterialApp", "Scaffold", "AppBar", "Text", "Center"
        )

        private fun isKeywordMatch(text: String): String? {
            for (kw in KEYWORDS) {
                if (text.startsWith(kw)) {
                    val after = text.getOrNull(kw.length)
                    if (after == null || (!after.isLetterOrDigit() && after != '_')) {
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
                    if (after == null || (!after.isLetterOrDigit() && after != '_')) {
                        return type
                    }
                }
            }
            return null
        }
    }
}

/**
 * Full-featured interactive Code Editor with Live Syntax Highlighting, Line Numbers,
 * Custom Eye-Care & Dark Mode Palettes, Font Size Zoom, Quick Symbol Insertion Toolbar,
 * Multi-Language Compiler & Runner, and Diagnostic Console.
 */
@Composable
fun CodeEditorComponent(
    code: String,
    onCodeChange: (String) -> Unit,
    language: String,
    modifier: Modifier = Modifier,
    initialOutput: ExecutionResult? = null,
    onExecuteCode: (suspend (String, String) -> ExecutionResult)? = null,
    onAskAi: ((String) -> Unit)? = null,
    onResetCode: (() -> Unit)? = null,
    title: String? = null,
    minEditorHeight: Int = 180,
    showSymbolsToolbar: Boolean = true,
    showConsoleInitially: Boolean = true,
    showRunButton: Boolean = true,
    showOutputTerminal: Boolean = true,
    customEditorTheme: EditorTheme? = null,
    testTagPrefix: String = "code_editor"
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val ambientEditorTheme = LocalEditorTheme.current
    var activeEditorTheme by remember(customEditorTheme, ambientEditorTheme) {
        mutableStateOf(customEditorTheme ?: ambientEditorTheme)
    }

    var editorFontSizeSp by remember { mutableIntStateOf(13) }
    var isRunning by remember { mutableStateOf(false) }
    var executionResult by remember { mutableStateOf(initialOutput) }

    LaunchedEffect(initialOutput) {
        executionResult = initialOutput
    }
    var isConsoleExpanded by remember { mutableStateOf(showConsoleInitially) }
    var showThemeMenu by remember { mutableStateOf(false) }
    var showFontSizeMenu by remember { mutableStateOf(false) }

    val visualTransformation = remember(language, activeEditorTheme) {
        SyntaxHighlightingTransformation(language, activeEditorTheme)
    }

    val lineCount = remember(code) {
        maxOf(1, code.lines().size)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .border(1.dp, activeEditorTheme.border, RoundedCornerShape(18.dp))
            .testTag("${testTagPrefix}_card"),
        colors = CardDefaults.cardColors(containerColor = activeEditorTheme.bg)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // 1. Editor Window Header Bar (macOS style dots + language badge + Eye Care / Theme Switcher + actions)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(activeEditorTheme.header)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Window dots
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFFFF5F56)))
                        Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFFFFBD2E)))
                        Box(modifier = Modifier.size(9.dp).clip(CircleShape).background(Color(0xFF27C93F)))
                    }

                    Spacer(modifier = Modifier.width(2.dp))

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = activeEditorTheme.bg.copy(alpha = 0.8f),
                        border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(activeEditorTheme.border))
                    ) {
                        Text(
                            text = language.uppercase(),
                            color = activeEditorTheme.keywordColor,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    if (title != null) {
                        Text(
                            text = title,
                            color = activeEditorTheme.gutterText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1
                        )
                    }
                }

                // Header Action Buttons (Theme Selector, Font Zoom, Reset, Copy, Run)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    // Eye Comfort / Theme Dropdown Menu
                    Box {
                        IconButton(
                            onClick = { showThemeMenu = true },
                            modifier = Modifier.size(28.dp).testTag("${testTagPrefix}_theme_menu_btn")
                        ) {
                            Text(
                                text = activeEditorTheme.iconEmoji,
                                fontSize = 13.sp
                            )
                        }

                        DropdownMenu(
                            expanded = showThemeMenu,
                            onDismissRequest = { showThemeMenu = false },
                            modifier = Modifier.background(DarkSurfaceVariant)
                        ) {
                            Text(
                                text = "Karanlık Tema Seçimi",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextMuted,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                            EditorTheme.values().forEach { theme ->
                                DropdownMenuItem(
                                    text = {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Text(theme.iconEmoji, fontSize = 14.sp)
                                            Text(
                                                text = theme.displayName,
                                                color = if (theme == activeEditorTheme) PrimaryIndigo else TextPrimary,
                                                fontWeight = if (theme == activeEditorTheme) FontWeight.Bold else FontWeight.Normal,
                                                fontSize = 12.sp
                                            )
                                        }
                                    },
                                    onClick = {
                                        activeEditorTheme = theme
                                        showThemeMenu = false
                                    }
                                )
                            }
                        }
                    }

                    // Font Size / Eye Comfort Zoom
                    Box {
                        IconButton(
                            onClick = { showFontSizeMenu = true },
                            modifier = Modifier.size(28.dp).testTag("${testTagPrefix}_font_size_btn")
                        ) {
                            Text(
                                text = "${editorFontSizeSp}pt",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = activeEditorTheme.gutterText,
                                fontFamily = FontFamily.Monospace
                            )
                        }

                        DropdownMenu(
                            expanded = showFontSizeMenu,
                            onDismissRequest = { showFontSizeMenu = false },
                            modifier = Modifier.background(DarkSurfaceVariant)
                        ) {
                            Text(
                                text = "Göz Konforu & Yazı Boyutu",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextMuted,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                            listOf(11 to "Kompakt (11sp)", 13 to "Normal (13sp)", 15 to "Rahat Göz (15sp)", 17 to "Büyük (17sp)").forEach { (size, label) ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = label,
                                            color = if (editorFontSizeSp == size) PrimaryIndigo else TextPrimary,
                                            fontWeight = if (editorFontSizeSp == size) FontWeight.Bold else FontWeight.Normal,
                                            fontSize = 12.sp
                                        )
                                    },
                                    onClick = {
                                        editorFontSizeSp = size
                                        showFontSizeMenu = false
                                    }
                                )
                            }
                        }
                    }

                    // AI Assistant Button
                    if (onAskAi != null) {
                        IconButton(
                            onClick = { onAskAi(code) },
                            modifier = Modifier.size(28.dp).testTag("${testTagPrefix}_ask_ai_btn")
                        ) {
                            Text("🤖", fontSize = 13.sp)
                        }
                    }

                    // Reset Button
                    if (onResetCode != null) {
                        IconButton(
                            onClick = onResetCode,
                            modifier = Modifier.size(28.dp).testTag("${testTagPrefix}_reset_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Sıfırla",
                                tint = activeEditorTheme.gutterText,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }

                    // Copy Button
                    IconButton(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText("Kod", code)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Kod panoya kopyalandı", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.size(28.dp).testTag("${testTagPrefix}_copy_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Kopyala",
                            tint = activeEditorTheme.gutterText,
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    // Run / Compile Button
                    if (showRunButton) {
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    isRunning = true
                                    isConsoleExpanded = true
                                    val res = if (onExecuteCode != null) {
                                        onExecuteCode(code, language)
                                    } else {
                                        CodeExecutionEngine.executePlaygroundCode(code, language)
                                    }
                                    executionResult = res
                                    isRunning = false
                                }
                            },
                            enabled = !isRunning,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AccentEmerald,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 9.dp, vertical = 4.dp),
                            modifier = Modifier.height(28.dp).testTag("${testTagPrefix}_run_btn")
                        ) {
                            if (isRunning) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(12.dp),
                                    color = Color.White,
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(13.dp))
                                Spacer(modifier = Modifier.width(3.dp))
                                Text("Çalıştır", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // 2. Main Editable Code Area with Synchronized Line Numbers Gutter
            val lineHeightVal = (editorFontSizeSp + 7).sp
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = minEditorHeight.dp)
                    .background(activeEditorTheme.bg)
                    .padding(vertical = 10.dp)
            ) {
                // Line Numbers Gutter
                val lineNums = (1..lineCount).joinToString("\n")
                Text(
                    text = lineNums,
                    color = activeEditorTheme.gutterText,
                    fontSize = editorFontSizeSp.sp,
                    fontFamily = FontFamily.Monospace,
                    lineHeight = lineHeightVal,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 8.dp)
                        .width(26.dp)
                )

                // Divider line between gutter and code
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(((lineCount * (editorFontSizeSp + 7)) + 20).dp)
                        .background(activeEditorTheme.border.copy(alpha = 0.6f))
                )

                // Live Syntax Highlighted Text Field
                BasicTextField(
                    value = code,
                    onValueChange = onCodeChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 12.dp)
                        .testTag("${testTagPrefix}_input"),
                    textStyle = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = editorFontSizeSp.sp,
                        lineHeight = lineHeightVal,
                        color = activeEditorTheme.textPrimary
                    ),
                    cursorBrush = SolidColor(activeEditorTheme.keywordColor),
                    visualTransformation = visualTransformation,
                    decorationBox = { innerTextField ->
                        if (code.isEmpty()) {
                            Text(
                                text = "// Buraya kodunuzu yazın...",
                                color = activeEditorTheme.commentColor,
                                fontSize = editorFontSizeSp.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                        innerTextField()
                    }
                )
            }

            // 3. Quick Symbol Insertion Toolbar
            if (showSymbolsToolbar) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(activeEditorTheme.header.copy(alpha = 0.7f))
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Kısayollar:",
                        fontSize = 10.sp,
                        color = activeEditorTheme.gutterText,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 2.dp)
                    )

                    val languageSymbols = when (language.lowercase()) {
                        "python" -> listOf("print()", "def", "for in :", "if :", "elif :", "else:", "[]", "{}", "()", "==", "!=", "+", "-", "*", "/")
                        "cpp" -> listOf("cout <<", "endl;", "int main()", "#include", ";", "{}", "()", "[]", "==", "!=", "+", "-", "*", "/")
                        "rust" -> listOf("println!()", "fn main()", "let mut", ";", "->", "{}", "()", "[]", "==", "!=", "+", "-")
                        "javascript" -> listOf("console.log()", "let", "const", "=>", ";", "{}", "()", "[]", "===", "!==")
                        "kotlin" -> listOf("println()", "val", "var", "fun", "when", ";", "{}", "()", "[]", "->", "==")
                        "flutter" -> listOf("Widget build", "return Scaffold(", "Text('')", "Center(", "Column(", "Row(", ";", "{}")
                        else -> listOf("print()", "void main()", "var", ";", "{}", "()", "[]", "=>", "==", "!=", "+", "-")
                    }

                    languageSymbols.forEach { sym ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = activeEditorTheme.bg,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(activeEditorTheme.border)),
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .clickable {
                                    onCodeChange(code + sym)
                                }
                        ) {
                            Text(
                                text = sym,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.Monospace,
                                color = activeEditorTheme.textPrimary,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            // 4. Integrated Compiler Terminal / Console Output Pane
            if (showOutputTerminal && executionResult != null) {
                val res = executionResult!!
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(activeEditorTheme.bg)
                        .border(
                            1.dp,
                            if (res.isSuccess) AccentEmeraldBorder else AccentRoseBorder,
                            RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp)
                        )
                        .animateContentSize()
                ) {
                    // Terminal Header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(if (res.isSuccess) Color(0xFF0B1E19) else Color(0xFF261016))
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(if (res.isSuccess) AccentEmerald else AccentRose)
                            )
                            Text(
                                text = if (res.isSuccess) "KONSOL ÇIKTISI (BAŞARILI)" else "DERLEME / ÇALIŞTIRMA HATASI",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (res.isSuccess) AccentEmeraldLight else AccentRose,
                                letterSpacing = 0.5.sp
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (res.executionTimeMs > 0) {
                                Text(
                                    text = "⏱️ ${res.executionTimeMs} ms",
                                    fontSize = 11.sp,
                                    color = Color(0xFF94A3B8),
                                    fontFamily = FontFamily.Monospace
                                )
                            }

                            IconButton(
                                onClick = { isConsoleExpanded = !isConsoleExpanded },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = if (isConsoleExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Genişlet/Daralt",
                                    tint = Color(0xFF94A3B8),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }

                    // Terminal Body
                    if (isConsoleExpanded) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            // Output Stream
                            Text(
                                text = res.output,
                                color = if (res.isSuccess) activeEditorTheme.textPrimary else AccentRose,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Monospace,
                                lineHeight = 18.sp,
                                modifier = Modifier.testTag("${testTagPrefix}_output_text")
                            )

                            // Error Diagnostics Alert if failure
                            if (res.error != null) {
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = AccentRoseSubtle,
                                    border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(AccentRoseBorder)),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(8.dp),
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Text("⚠️", fontSize = 12.sp)
                                        Text(
                                            text = res.error,
                                            fontSize = 11.sp,
                                            color = AccentRose,
                                            lineHeight = 15.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
