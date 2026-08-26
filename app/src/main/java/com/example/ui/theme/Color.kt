package com.example.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * App Theme Modes offering diverse eye comfort and contrast profiles.
 * Default is FLUTTER_DART_DARK: Modern minimalist dark theme with refined Indigo accent.
 */
enum class AppThemeMode(val displayName: String, val iconEmoji: String, val description: String) {
    FLUTTER_DART_DARK("Modern Slate Koyu", "🌑", "Minimalist ve sade modern koyu tema"),
    OBSIDIAN_DARK("Obsidian Koyu", "🌌", "Dengeli ve zarif derin koyu tema"),
    OLED_MIDNIGHT("OLED Saf Siyah", "⬛", "Tam siyah, gözü dinlendirir & pil tasarrufu"),
    WARM_AMBER_EYE_CARE("Gece Işığı & Göz Koruma", "🌙", "Mavi ışığı süzen sıcak sepia/amber tonları"),
    LIGHT("Minimal Aydınlık", "☀️", "Ferah, temiz ve sade açık tema");

    val isDark: Boolean get() = this != LIGHT
}

/**
 * Specialized Code Editor color themes specifically optimized for low eye fatigue.
 */
enum class EditorTheme(
    val displayName: String,
    val iconEmoji: String,
    val bg: Color,
    val header: Color,
    val border: Color,
    val gutterText: Color,
    val textPrimary: Color,
    val keywordColor: Color,
    val stringColor: Color,
    val numberColor: Color,
    val commentColor: Color,
    val typeColor: Color,
    val operatorColor: Color,
    val punctuationColor: Color
) {
    FLUTTER_STUDIO(
        displayName = "Studio Dark",
        iconEmoji = "💻",
        bg = Color(0xFF0F141E),
        header = Color(0xFF161D2B),
        border = Color(0xFF222C3E),
        gutterText = Color(0xFF5B6B8C),
        textPrimary = Color(0xFFE2E8F0),
        keywordColor = Color(0xFF818CF8),
        stringColor = Color(0xFF34D399),
        numberColor = Color(0xFFFBBF24),
        commentColor = Color(0xFF64748B),
        typeColor = Color(0xFF38BDF8),
        operatorColor = Color(0xFFA5B4FC),
        punctuationColor = Color(0xFFCBD5E1)
    ),
    OBSIDIAN(
        displayName = "Obsidian Slate",
        iconEmoji = "🌑",
        bg = Color(0xFF0B0F17),
        header = Color(0xFF131924),
        border = Color(0xFF1E2837),
        gutterText = Color(0xFF64748B),
        textPrimary = Color(0xFFF8FAFC),
        keywordColor = Color(0xFF818CF8),
        stringColor = Color(0xFF34D399),
        numberColor = Color(0xFFFBBF24),
        commentColor = Color(0xFF64748B),
        typeColor = Color(0xFF38BDF8),
        operatorColor = Color(0xFFA5B4FC),
        punctuationColor = Color(0xFFE2E8F0)
    ),
    OLED_BLACK(
        displayName = "OLED Saf Siyah",
        iconEmoji = "⬛",
        bg = Color(0xFF000000),
        header = Color(0xFF0A0A0A),
        border = Color(0xFF242424),
        gutterText = Color(0xFF525252),
        textPrimary = Color(0xFFFFFFFF),
        keywordColor = Color(0xFF818CF8),
        stringColor = Color(0xFF22C55E),
        numberColor = Color(0xFFF59E0B),
        commentColor = Color(0xFF737373),
        typeColor = Color(0xFF38BDF8),
        operatorColor = Color(0xFFA5B4FC),
        punctuationColor = Color(0xFFE5E5E5)
    ),
    WARM_AMBER(
        displayName = "Göz Koruma (Amber)",
        iconEmoji = "🌙",
        bg = Color(0xFF14110E),
        header = Color(0xFF1D1813),
        border = Color(0xFF332B22),
        gutterText = Color(0xFF8C7965),
        textPrimary = Color(0xFFF5EDE0),
        keywordColor = Color(0xFFE07A5F),
        stringColor = Color(0xFF81B29A),
        numberColor = Color(0xFFF2CC8F),
        commentColor = Color(0xFF8C7965),
        typeColor = Color(0xFFF4A261),
        operatorColor = Color(0xFFE76F51),
        punctuationColor = Color(0xFFD4A373)
    ),
    MONOKAI_PRO(
        displayName = "Monokai Pro",
        iconEmoji = "🔥",
        bg = Color(0xFF18181A),
        header = Color(0xFF202023),
        border = Color(0xFF2E2E33),
        gutterText = Color(0xFF727075),
        textPrimary = Color(0xFFFCFCFA),
        keywordColor = Color(0xFFFF6188),
        stringColor = Color(0xFFA9DC76),
        numberColor = Color(0xFFAB9DF2),
        commentColor = Color(0xFF727075),
        typeColor = Color(0xFF78DCE8),
        operatorColor = Color(0xFFFFD866),
        punctuationColor = Color(0xFFFC9867)
    )
}

data class AppColors(
    val bg: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val cardBorder: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textMuted: Color,
    val primaryIndigo: Color,
    val primaryIndigoLight: Color,
    val primaryDark: Color,
    val primarySubtle: Color,
    val primarySubtleBorder: Color,
    val accentEmerald: Color,
    val accentEmeraldLight: Color,
    val accentEmeraldSubtle: Color,
    val accentEmeraldBorder: Color,
    val accentAmber: Color,
    val accentAmberSubtle: Color,
    val accentAmberBorder: Color,
    val accentOrange: Color,
    val accentOrangeSubtle: Color,
    val accentOrangeBorder: Color,
    val accentRose: Color,
    val accentRoseSubtle: Color,
    val accentRoseBorder: Color,
    val accentCyan: Color,
    val accentPurple: Color,
    val accentVioletSubtle: Color,
    val accentVioletBorder: Color,
    val codeBg: Color,
    val codeHeader: Color,
    val isDark: Boolean,
    val themeMode: AppThemeMode
)

// 0. Modern Minimal Slate Dark Palette (Single Primary Accent: Modern Indigo)
val FlutterDartDarkAppColors = AppColors(
    bg = Color(0xFF0B0F17), // Deep Slate Neutral Canvas
    surface = Color(0xFF111722), // Primary Surface
    surfaceVariant = Color(0xFF161E2D), // Card Surface
    cardBorder = Color(0xFF222C3E), // Subtle Geometric Border
    textPrimary = Color(0xFFF8FAFC), // Crisp Slate 50
    textSecondary = Color(0xFF94A3B8), // Slate 400 Supporting Text
    textMuted = Color(0xFF64748B), // Slate 500 Subtle Text
    primaryIndigo = Color(0xFF6366F1), // Modern Single Primary Accent (Indigo 500)
    primaryIndigoLight = Color(0xFF818CF8), // Indigo 400
    primaryDark = Color(0xFF4F46E5), // Indigo 600
    primarySubtle = Color(0xFF181C30), // Soft Primary Surface Tint
    primarySubtleBorder = Color(0xFF2A3358),
    accentEmerald = Color(0xFF22C55E), // Mastered / Success
    accentEmeraldLight = Color(0xFF4ADE80),
    accentEmeraldSubtle = Color(0xFF0F2618),
    accentEmeraldBorder = Color(0xFF1C452C),
    accentAmber = Color(0xFFF59E0B), // XP / Streak Glow
    accentAmberSubtle = Color(0xFF261D0C),
    accentAmberBorder = Color(0xFF4A3816),
    accentOrange = Color(0xFFF97316),
    accentOrangeSubtle = Color(0xFF29170D),
    accentOrangeBorder = Color(0xFF4D2B18),
    accentRose = Color(0xFFEF4444), // Error / Warning
    accentRoseSubtle = Color(0xFF2B1417),
    accentRoseBorder = Color(0xFF522328),
    accentCyan = Color(0xFF06B6D4), // Secondary Info Accent
    accentPurple = Color(0xFFA855F7),
    accentVioletSubtle = Color(0xFF201633),
    accentVioletBorder = Color(0xFF3E2B63),
    codeBg = Color(0xFF0F141E),
    codeHeader = Color(0xFF161D2B),
    isDark = true,
    themeMode = AppThemeMode.FLUTTER_DART_DARK
)

// 1. Deep Obsidian Dark Palette
val DarkAppColors = AppColors(
    bg = Color(0xFF0B0F17),
    surface = Color(0xFF111722),
    surfaceVariant = Color(0xFF161E2D),
    cardBorder = Color(0xFF222C3E),
    textPrimary = Color(0xFFF8FAFC),
    textSecondary = Color(0xFF94A3B8),
    textMuted = Color(0xFF64748B),
    primaryIndigo = Color(0xFF6366F1),
    primaryIndigoLight = Color(0xFF818CF8),
    primaryDark = Color(0xFF4F46E5),
    primarySubtle = Color(0xFF181C30),
    primarySubtleBorder = Color(0xFF2A3358),
    accentEmerald = Color(0xFF22C55E),
    accentEmeraldLight = Color(0xFF4ADE80),
    accentEmeraldSubtle = Color(0xFF0F2618),
    accentEmeraldBorder = Color(0xFF1C452C),
    accentAmber = Color(0xFFF59E0B),
    accentAmberSubtle = Color(0xFF261D0C),
    accentAmberBorder = Color(0xFF4A3816),
    accentOrange = Color(0xFFF97316),
    accentOrangeSubtle = Color(0xFF29170D),
    accentOrangeBorder = Color(0xFF4D2B18),
    accentRose = Color(0xFFEF4444),
    accentRoseSubtle = Color(0xFF2B1417),
    accentRoseBorder = Color(0xFF522328),
    accentCyan = Color(0xFF06B6D4),
    accentPurple = Color(0xFFA855F7),
    accentVioletSubtle = Color(0xFF201633),
    accentVioletBorder = Color(0xFF3E2B63),
    codeBg = Color(0xFF0F141E),
    codeHeader = Color(0xFF161D2B),
    isDark = true,
    themeMode = AppThemeMode.OBSIDIAN_DARK
)

// 2. OLED Pure Midnight True Black Palette
val OledMidnightAppColors = AppColors(
    bg = Color(0xFF000000),
    surface = Color(0xFF0A0A0A),
    surfaceVariant = Color(0xFF141414),
    cardBorder = Color(0xFF262626),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFFA3A3A3),
    textMuted = Color(0xFF737373),
    primaryIndigo = Color(0xFF6366F1),
    primaryIndigoLight = Color(0xFF818CF8),
    primaryDark = Color(0xFF4F46E5),
    primarySubtle = Color(0xFF14172B),
    primarySubtleBorder = Color(0xFF222847),
    accentEmerald = Color(0xFF22C55E),
    accentEmeraldLight = Color(0xFF4ADE80),
    accentEmeraldSubtle = Color(0xFF0A2414),
    accentEmeraldBorder = Color(0xFF154024),
    accentAmber = Color(0xFFF59E0B),
    accentAmberSubtle = Color(0xFF2B1F0A),
    accentAmberBorder = Color(0xFF4D3812),
    accentOrange = Color(0xFFF97316),
    accentOrangeSubtle = Color(0xFF2B160A),
    accentOrangeBorder = Color(0xFF4D2812),
    accentRose = Color(0xFFEF4444),
    accentRoseSubtle = Color(0xFF2E1215),
    accentRoseBorder = Color(0xFF542026),
    accentCyan = Color(0xFF06B6D4),
    accentPurple = Color(0xFFA855F7),
    accentVioletSubtle = Color(0xFF211536),
    accentVioletBorder = Color(0xFF42286B),
    codeBg = Color(0xFF000000),
    codeHeader = Color(0xFF0A0A0A),
    isDark = true,
    themeMode = AppThemeMode.OLED_MIDNIGHT
)

// 3. Warm Amber Eye-Care Palette
val WarmAmberEyeCareAppColors = AppColors(
    bg = Color(0xFF12100E),
    surface = Color(0xFF1A1612),
    surfaceVariant = Color(0xFF241F1A),
    cardBorder = Color(0xFF383027),
    textPrimary = Color(0xFFFDF8F0),
    textSecondary = Color(0xFFC7B8A6),
    textMuted = Color(0xFF8C7E6E),
    primaryIndigo = Color(0xFFF59E0B),
    primaryIndigoLight = Color(0xFFFBBF24),
    primaryDark = Color(0xFFD97706),
    primarySubtle = Color(0xFF282015),
    primarySubtleBorder = Color(0xFF423422),
    accentEmerald = Color(0xFF81B29A),
    accentEmeraldLight = Color(0xFFA8D5BA),
    accentEmeraldSubtle = Color(0xFF1B2B24),
    accentEmeraldBorder = Color(0xFF2C483C),
    accentAmber = Color(0xFFF59E0B),
    accentAmberSubtle = Color(0xFF33230C),
    accentAmberBorder = Color(0xFF6B4715),
    accentOrange = Color(0xFFE07A5F),
    accentOrangeSubtle = Color(0xFF381F19),
    accentOrangeBorder = Color(0xFF6B3629),
    accentRose = Color(0xFFE76F51),
    accentRoseSubtle = Color(0xFF381E19),
    accentRoseBorder = Color(0xFF6E3326),
    accentCyan = Color(0xFF70A9A1),
    accentPurple = Color(0xFFB5838D),
    accentVioletSubtle = Color(0xFF2B1F24),
    accentVioletBorder = Color(0xFF4D333E),
    codeBg = Color(0xFF14110E),
    codeHeader = Color(0xFF1D1813),
    isDark = true,
    themeMode = AppThemeMode.WARM_AMBER_EYE_CARE
)

// 4. Modern Minimal Clean Light Palette
val LightAppColors = AppColors(
    bg = Color(0xFFF8FAFC), // Slate 50 canvas
    surface = Color(0xFFFFFFFF), // Pure white surface
    surfaceVariant = Color(0xFFF1F5F9), // Slate 100 card surface
    cardBorder = Color(0xFFE2E8F0), // Slate 200 fine border
    textPrimary = Color(0xFF0F172A), // Slate 900
    textSecondary = Color(0xFF475569), // Slate 600
    textMuted = Color(0xFF94A3B8), // Slate 400
    primaryIndigo = Color(0xFF4F46E5), // Indigo 600
    primaryIndigoLight = Color(0xFF6366F1), // Indigo 500
    primaryDark = Color(0xFF3730A3), // Indigo 800
    primarySubtle = Color(0xFFEEF2FF), // Indigo 50
    primarySubtleBorder = Color(0xFFC7D2FE), // Indigo 200
    accentEmerald = Color(0xFF16A34A),
    accentEmeraldLight = Color(0xFF22C55E),
    accentEmeraldSubtle = Color(0xFFDCFCE7),
    accentEmeraldBorder = Color(0xFF86EFAC),
    accentAmber = Color(0xFFD97706),
    accentAmberSubtle = Color(0xFFFEF3C7),
    accentAmberBorder = Color(0xFFFDE68A),
    accentOrange = Color(0xFFEA580C),
    accentOrangeSubtle = Color(0xFFFFEDD5),
    accentOrangeBorder = Color(0xFFFED7AA),
    accentRose = Color(0xFFDC2626),
    accentRoseSubtle = Color(0xFFFEE2E2),
    accentRoseBorder = Color(0xFFFECACA),
    accentCyan = Color(0xFF0891B2),
    accentPurple = Color(0xFF9333EA),
    accentVioletSubtle = Color(0xFFF3E8FF),
    accentVioletBorder = Color(0xFFE9D5FF),
    codeBg = Color(0xFF0F172A),
    codeHeader = Color(0xFF1E293B),
    isDark = false,
    themeMode = AppThemeMode.LIGHT
)

val LocalAppColors = compositionLocalOf { FlutterDartDarkAppColors }
val LocalEditorTheme = compositionLocalOf { EditorTheme.FLUTTER_STUDIO }

// Dynamic Accessors (Seamless Composable Theming)
val DarkBg: Color @Composable get() = LocalAppColors.current.bg
val DarkSurface: Color @Composable get() = LocalAppColors.current.surface
val DarkSurfaceVariant: Color @Composable get() = LocalAppColors.current.surfaceVariant
val DarkCardBorder: Color @Composable get() = LocalAppColors.current.cardBorder

val PrimaryIndigo: Color @Composable get() = LocalAppColors.current.primaryIndigo
val PrimaryIndigoLight: Color @Composable get() = LocalAppColors.current.primaryIndigoLight
val PrimaryDark: Color @Composable get() = LocalAppColors.current.primaryDark
val PrimarySubtle: Color @Composable get() = LocalAppColors.current.primarySubtle
val PrimarySubtleBorder: Color @Composable get() = LocalAppColors.current.primarySubtleBorder

val AccentEmerald: Color @Composable get() = LocalAppColors.current.accentEmerald
val AccentEmeraldLight: Color @Composable get() = LocalAppColors.current.accentEmeraldLight
val AccentEmeraldSubtle: Color @Composable get() = LocalAppColors.current.accentEmeraldSubtle
val AccentEmeraldBorder: Color @Composable get() = LocalAppColors.current.accentEmeraldBorder

val AccentAmber: Color @Composable get() = LocalAppColors.current.accentAmber
val AccentAmberSubtle: Color @Composable get() = LocalAppColors.current.accentAmberSubtle
val AccentAmberBorder: Color @Composable get() = LocalAppColors.current.accentAmberBorder

val AccentOrange: Color @Composable get() = LocalAppColors.current.accentOrange
val AccentOrangeSubtle: Color @Composable get() = LocalAppColors.current.accentOrangeSubtle
val AccentOrangeBorder: Color @Composable get() = LocalAppColors.current.accentOrangeBorder

val AccentRose: Color @Composable get() = LocalAppColors.current.accentRose
val AccentRoseSubtle: Color @Composable get() = LocalAppColors.current.accentRoseSubtle
val AccentRoseBorder: Color @Composable get() = LocalAppColors.current.accentRoseBorder

val AccentCyan: Color @Composable get() = LocalAppColors.current.accentCyan
val AccentPurple: Color @Composable get() = LocalAppColors.current.accentPurple
val AccentVioletSubtle: Color @Composable get() = LocalAppColors.current.accentVioletSubtle
val AccentVioletBorder: Color @Composable get() = LocalAppColors.current.accentVioletBorder

val TextPrimary: Color @Composable get() = LocalAppColors.current.textPrimary
val TextSecondary: Color @Composable get() = LocalAppColors.current.textSecondary
val TextMuted: Color @Composable get() = LocalAppColors.current.textMuted

// Code Syntax Colors - Dynamic based on active Editor Theme
val CodeBg: Color @Composable get() = LocalEditorTheme.current.bg
val CodeHeader: Color @Composable get() = LocalEditorTheme.current.header
val CodeKeyword: Color @Composable get() = LocalEditorTheme.current.keywordColor
val CodeString: Color @Composable get() = LocalEditorTheme.current.stringColor
val CodeNumber: Color @Composable get() = LocalEditorTheme.current.numberColor
val CodeComment: Color @Composable get() = LocalEditorTheme.current.commentColor
val CodeType: Color @Composable get() = LocalEditorTheme.current.typeColor
val CodeFunction: Color @Composable get() = LocalEditorTheme.current.punctuationColor
val CodeOperator: Color @Composable get() = LocalEditorTheme.current.operatorColor
val CodePunctuation: Color @Composable get() = LocalEditorTheme.current.punctuationColor

