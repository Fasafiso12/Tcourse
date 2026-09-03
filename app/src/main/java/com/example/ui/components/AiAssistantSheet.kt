package com.example.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.*
import com.example.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiAssistantSheet(
    state: AiAssistantState,
    onClose: () -> Unit,
    onSendMessage: (String, AiShortcut?) -> Unit,
    onSelectShortcut: (AiShortcut) -> Unit,
    onClearChat: () -> Unit
) {
    var inputText by remember { mutableStateOf("") }
    var sentenceExplainText by remember { mutableStateOf("") }
    var isSentenceModeOpen by remember { mutableStateOf(false) }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current

    // Intercept hardware/system back button to smoothly close AI Assistant
    BackHandler(enabled = true) {
        onClose()
    }

    // Auto-scroll to bottom on new messages
    LaunchedEffect(state.messages.size, state.isLoading) {
        if (state.messages.isNotEmpty()) {
            listState.animateScrollToItem(state.messages.size)
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .testTag("ai_assistant_screen"),
        color = DarkBg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            // 1. Header with Back Button, Title & Controls
            Surface(
                color = DarkSurface,
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.horizontalGradient(listOf(PrimaryIndigo.copy(alpha = 0.5f), DarkCardBorder))
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left: Back button & Title info
                    Row(
                        modifier = Modifier.weight(1f, fill = false),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Prominent, high-contrast Back Button
                        Surface(
                            shape = CircleShape,
                            color = PrimarySubtle,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(PrimaryIndigo.copy(alpha = 0.6f))),
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .clickable { onClose() }
                                .testTag("ai_back_btn")
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Geri",
                                    tint = PrimaryIndigoLight,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.linearGradient(listOf(PrimaryIndigo, PrimaryIndigoLight))
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🤖", fontSize = 18.sp)
                        }

                        Column(modifier = Modifier.weight(1f, fill = false)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Yapay Zeka Eğitmeni",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = PrimarySubtle
                                ) {
                                    Text(
                                        text = "Gemini AI",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryIndigo,
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            val contextLabel = if (state.context.lessonTitle != null) {
                                "${state.context.languageName} • ${state.context.lessonTitle}"
                            } else {
                                "${state.context.languageName} Programlama"
                            }
                            Text(
                                text = contextLabel,
                                fontSize = 11.sp,
                                color = TextSecondary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    // Right: Actions (Clear & Close)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (state.messages.isNotEmpty()) {
                            Surface(
                                shape = CircleShape,
                                color = DarkSurfaceVariant,
                                border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .clickable { onClearChat() }
                                    .testTag("ai_clear_chat_btn")
                            ) {
                                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                    Icon(
                                        Icons.Outlined.DeleteSweep,
                                        contentDescription = "Sohbeti Temizle",
                                        tint = TextMuted,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }

                        Surface(
                            shape = CircleShape,
                            color = DarkSurfaceVariant,
                            border = CardDefaults.outlinedCardBorder().copy(brush = SolidColor(DarkCardBorder)),
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .clickable { onClose() }
                                .testTag("ai_close_btn")
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Kapat",
                                    tint = TextPrimary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }

            // 2. Shortcut Roles Row (Adım Adım, Derinlemesine, Özet, Cümleyi Açıkla, vb.)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkSurfaceVariant.copy(alpha = 0.5f))
                    .padding(vertical = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "⚡ Hızlı Öğrenme Kısayolları",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted
                    )
                    Text(
                        text = "1-Tıkla Açıkla",
                        fontSize = 11.sp,
                        color = PrimaryIndigoLight
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(AiShortcut.values()) { shortcut ->
                        val isSelected = state.selectedShortcut == shortcut
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) PrimaryIndigo else DarkSurface,
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        if (isSelected) PrimaryIndigoLight else DarkCardBorder,
                                        if (isSelected) PrimaryIndigo else DarkCardBorder
                                    )
                                )
                            ),
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .clickable {
                                    onSelectShortcut(shortcut)
                                    if (shortcut == AiShortcut.EXPLAIN_SENTENCE) {
                                        isSentenceModeOpen = true
                                    } else {
                                        isSentenceModeOpen = false
                                        val topicName = state.context.lessonTitle ?: state.context.languageName
                                        onSendMessage("${shortcut.title}: $topicName konusunu açıkla.", shortcut)
                                    }
                                }
                                .testTag("shortcut_${shortcut.id}")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(shortcut.iconEmoji, fontSize = 14.sp)
                                Column {
                                    Text(
                                        text = shortcut.shortLabel,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) Color.White else TextPrimary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 3. Sentence / Code Snippet Targeted Input Expandable Panel
            AnimatedVisibility(
                visible = isSentenceModeOpen || state.selectedShortcut == AiShortcut.EXPLAIN_SENTENCE,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.dp, PrimaryIndigo.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                    colors = CardDefaults.cardColors(containerColor = DarkSurface)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text("🔍", fontSize = 16.sp)
                                Text(
                                    text = "Anlamadığınız Cümleyi / Kodu Yazın",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimary
                                )
                            }
                            IconButton(
                                onClick = { isSentenceModeOpen = false },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(Icons.Default.Close, contentDescription = "Kapat", tint = TextMuted, modifier = Modifier.size(16.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = sentenceExplainText,
                            onValueChange = { sentenceExplainText = it },
                            placeholder = {
                                Text(
                                    text = "Örn: 'Bu satırdaki async ne işe yarıyor?' veya 'Değişken kapsamı (scope) neden önemli?'",
                                    fontSize = 12.sp,
                                    color = TextMuted
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .testTag("sentence_explain_input"),
                            shape = RoundedCornerShape(10.dp),
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp, color = TextPrimary),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = DarkSurfaceVariant,
                                unfocusedContainerColor = DarkSurfaceVariant,
                                focusedBorderColor = PrimaryIndigo,
                                unfocusedBorderColor = DarkCardBorder
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {
                                    if (sentenceExplainText.isNotBlank()) {
                                        onSendMessage(sentenceExplainText, AiShortcut.EXPLAIN_SENTENCE)
                                        sentenceExplainText = ""
                                        isSentenceModeOpen = false
                                    }
                                },
                                enabled = sentenceExplainText.isNotBlank() && !state.isLoading,
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.testTag("submit_sentence_explain_btn")
                            ) {
                                Text("Açıklamasını Getir", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // 4. Chat Messages Scroll List
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                if (state.messages.isEmpty() && !state.isLoading) {
                    // Empty state with welcoming guidance
                    AiEmptyWelcomeState(
                        context = state.context,
                        onShortcutClick = { shortcut ->
                            onSelectShortcut(shortcut)
                            if (shortcut == AiShortcut.EXPLAIN_SENTENCE) {
                                isSentenceModeOpen = true
                            } else {
                                val topicName = state.context.lessonTitle ?: state.context.languageName
                                onSendMessage("${shortcut.title}: $topicName konusunu açıkla.", shortcut)
                            }
                        },
                        onSamplePromptClick = { prompt ->
                            onSendMessage(prompt, null)
                        }
                    )
                } else {
                    LazyColumn(
                        state = listState,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp),
                        contentPadding = PaddingValues(top = 14.dp, bottom = 14.dp)
                    ) {
                        items(state.messages, key = { it.id }) { message ->
                            AiMessageBubble(
                                message = message,
                                languageId = state.context.languageId,
                                onCopy = {
                                    clipboardManager.setText(AnnotatedString(message.text))
                                },
                                onFollowUpClick = { followUp ->
                                    onSendMessage(followUp, null)
                                }
                            )
                        }

                        if (state.isLoading) {
                            item {
                                AiLoadingBubble()
                            }
                        }
                    }
                }
            }

            // 5. Bottom Prompt Input Bar
            Surface(
                color = DarkSurface,
                border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(DarkCardBorder, DarkCardBorder))),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = inputText,
                            onValueChange = { inputText = it },
                            placeholder = {
                                Text("Anlamadığınız bir yeri veya sorunuzu yazın...", fontSize = 13.sp, color = TextMuted)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 48.dp, max = 110.dp)
                                .testTag("ai_message_input"),
                            shape = RoundedCornerShape(14.dp),
                            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp, color = TextPrimary),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = DarkSurfaceVariant,
                                unfocusedContainerColor = DarkSurfaceVariant,
                                focusedBorderColor = PrimaryIndigo,
                                unfocusedBorderColor = DarkCardBorder
                            ),
                            trailingIcon = {
                                if (inputText.isNotBlank()) {
                                    IconButton(onClick = { inputText = "" }) {
                                        Icon(Icons.Default.Clear, contentDescription = "Sil", tint = TextMuted, modifier = Modifier.size(18.dp))
                                    }
                                }
                            }
                        )

                        IconButton(
                            onClick = {
                                if (inputText.isNotBlank() && !state.isLoading) {
                                    val textToSend = inputText
                                    inputText = ""
                                    onSendMessage(textToSend, state.selectedShortcut)
                                }
                            },
                            enabled = inputText.isNotBlank() && !state.isLoading,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(
                                    if (inputText.isNotBlank() && !state.isLoading) PrimaryIndigo else DarkSurfaceVariant
                                )
                                .testTag("ai_send_message_btn")
                        ) {
                            Icon(
                                Icons.Default.Send,
                                contentDescription = "Gönder",
                                tint = if (inputText.isNotBlank() && !state.isLoading) Color.White else TextMuted,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component: AI Chat Message Bubble (with Markdown & Syntax Highlighting)
// -----------------------------------------------------------------------------------------
@Composable
private fun AiMessageBubble(
    message: AiChatMessage,
    languageId: String,
    onCopy: () -> Unit,
    onFollowUpClick: (String) -> Unit
) {
    val isUser = message.sender == AiMessageSender.USER

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        if (!isUser) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(PrimarySubtle)
                    .border(1.dp, PrimaryIndigo.copy(alpha = 0.5f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("🤖", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column(
            modifier = Modifier.widthIn(max = 330.dp),
            horizontalAlignment = if (isUser) Alignment.End else Alignment.Start
        ) {
            if (message.shortcutUsed != null && !isUser) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = PrimarySubtle,
                    modifier = Modifier.padding(bottom = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(message.shortcutUsed.iconEmoji, fontSize = 10.sp)
                        Text(
                            text = message.shortcutUsed.title,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigoLight
                        )
                    }
                }
            }

            Card(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = if (isUser) 16.dp else 4.dp,
                    bottomEnd = if (isUser) 4.dp else 16.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = if (isUser) PrimaryIndigo else DarkSurface
                ),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.horizontalGradient(
                        listOf(
                            if (isUser) PrimaryIndigoLight else DarkCardBorder,
                            if (isUser) PrimaryIndigo else DarkCardBorder
                        )
                    )
                )
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    // Render formatted text & code blocks
                    RenderAiResponseContent(text = message.text, defaultLanguage = languageId)

                    if (!isUser) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Kod Akademi AI",
                                fontSize = 10.sp,
                                color = TextMuted
                            )

                            IconButton(
                                onClick = onCopy,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    Icons.Outlined.ContentCopy,
                                    contentDescription = "Kopyala",
                                    tint = TextMuted,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Quick Follow-up chips for assistant response
            if (!isUser && !message.isError) {
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(start = 2.dp)
                ) {
                    SuggestionChip(
                        onClick = { onFollowUpClick("Bunu bir örnek kodla pekiştirir misin?") },
                        label = { Text("💡 Örnek Kod Ver", fontSize = 11.sp) },
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = DarkSurfaceVariant,
                            labelColor = TextSecondary
                        ),
                        border = SuggestionChipDefaults.suggestionChipBorder(
                            enabled = true,
                            borderColor = DarkCardBorder
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                    SuggestionChip(
                        onClick = { onFollowUpClick("Bunu daha da basit, bir çocuk gibi anlatır mısın?") },
                        label = { Text("👶 Daha Basit Anlat", fontSize = 11.sp) },
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = DarkSurfaceVariant,
                            labelColor = TextSecondary
                        ),
                        border = SuggestionChipDefaults.suggestionChipBorder(
                            enabled = true,
                            borderColor = DarkCardBorder
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                }
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Helper: Parse and Render Markdown / Code Blocks
// -----------------------------------------------------------------------------------------
@Composable
private fun RenderAiResponseContent(text: String, defaultLanguage: String) {
    val codeBlockRegex = Regex("""```([a-zA-Z0-9_-]*)\n([\s\S]*?)```""")
    var lastIndex = 0
    val matches = codeBlockRegex.findAll(text).toList()

    if (matches.isEmpty()) {
        Text(
            text = text,
            fontSize = 13.sp,
            color = TextPrimary,
            lineHeight = 19.sp
        )
        return
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (match in matches) {
            val textBefore = text.substring(lastIndex, match.range.first).trim()
            if (textBefore.isNotEmpty()) {
                Text(
                    text = textBefore,
                    fontSize = 13.sp,
                    color = TextPrimary,
                    lineHeight = 19.sp
                )
            }

            val lang = match.groupValues[1].ifBlank { defaultLanguage }
            val code = match.groupValues[2].trimEnd()

            CodeBlock(
                code = code,
                language = lang,
                showLineNumbers = code.lines().size > 1
            )

            lastIndex = match.range.last + 1
        }

        if (lastIndex < text.length) {
            val remainingText = text.substring(lastIndex).trim()
            if (remainingText.isNotEmpty()) {
                Text(
                    text = remainingText,
                    fontSize = 13.sp,
                    color = TextPrimary,
                    lineHeight = 19.sp
                )
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component: AI Loading / Thinking Bubble
// -----------------------------------------------------------------------------------------
@Composable
private fun AiLoadingBubble() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(PrimarySubtle)
                .border(1.dp, PrimaryIndigo.copy(alpha = 0.5f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("🤖", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.width(8.dp))

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = DarkSurface,
            border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(DarkCardBorder, DarkCardBorder)))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = PrimaryIndigoLight,
                    strokeWidth = 2.dp
                )
                Text(
                    text = "Düşünüyor ve en sade şekilde hazırlıyor...",
                    fontSize = 12.sp,
                    color = TextSecondary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

// -----------------------------------------------------------------------------------------
// Component: Empty Welcome State with Quick Action Suggestions
// -----------------------------------------------------------------------------------------
@Composable
private fun AiEmptyWelcomeState(
    context: AiAssistantContext,
    onShortcutClick: (AiShortcut) -> Unit,
    onSamplePromptClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(CircleShape)
                    .background(PrimarySubtle)
                    .border(2.dp, PrimaryIndigo, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("💡", fontSize = 32.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Nasıl Yardımcı Olabilirim?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            val desc = if (context.lessonTitle != null) {
                "'${context.lessonTitle}' konusunda anlamadığın, karışık gelen her cümleyi veya kodu hemen açıklayabilirim."
            } else {
                "${context.languageName} programlama dilinde takıldığın herhangi bir konuyu sıfırdan öğrenebilirsin."
            }
            Text(
                text = desc,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, DarkCardBorder, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = DarkSurface)
            ) {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Öğrenme Rolleri & Kısayollar",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryIndigoLight
                    )

                    AiShortcut.values().forEach { shortcut ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = DarkSurfaceVariant,
                            border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(DarkCardBorder, DarkCardBorder))),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { onShortcutClick(shortcut) }
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Text(shortcut.iconEmoji, fontSize = 20.sp)
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = shortcut.title,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    Text(
                                        text = shortcut.description,
                                        fontSize = 11.sp,
                                        color = TextSecondary,
                                        lineHeight = 15.sp
                                    )
                                }
                                Icon(Icons.Default.ChevronRight, contentDescription = null, tint = TextMuted, modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Sık Sorulan Sorular",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted
                )

                val suggestions = if (context.lessonTitle != null) {
                    listOf(
                        "Bu konunun mantığını tek bir gerçek hayat örneğiyle açıkla",
                        "Burada en sık yapılan hata nedir?",
                        "Bu dersi 3 maddede özetle"
                    )
                } else {
                    listOf(
                        "${context.languageName} diline nereden başlamalıyım?",
                        "${context.languageName} ile diğer diller arasındaki en büyük fark nedir?",
                        "Değişkenler ve veri tipleri ne işe yarar?"
                    )
                }

                suggestions.forEach { suggestion ->
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = DarkSurface,
                        border = CardDefaults.outlinedCardBorder().copy(brush = Brush.horizontalGradient(listOf(DarkCardBorder, DarkCardBorder))),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { onSamplePromptClick(suggestion) }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "💬 $suggestion",
                                fontSize = 12.sp,
                                color = TextPrimary
                            )
                            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = PrimaryIndigoLight, modifier = Modifier.size(14.dp))
                        }
                    }
                }
            }
        }
    }
}
