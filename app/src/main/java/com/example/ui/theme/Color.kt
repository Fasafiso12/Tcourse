package com.example.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * App Theme Modes offering diverse eye comfort and contrast profiles.
 * Default is now FLUTTER_DART_DARK: A sleek, minimalist Flutter/Dart-inspired UI theme.
 */
enum class AppThemeMode(val displayName: String, val iconEmoji: String, val description: String) {
    FLUTTER_DART_DARK("Flutter Modern Dark", "💙", "Flutter & Dart tarzı minimalist ve sade koyu tema"),
    OBSIDIAN_DARK("Obsidian Koyu", "🌑", "Dengeli ve modern koyu tema"),
    OLED_MIDNIGHT("OLED Saf Siyah", "⬛", "Tam siyah, gözü dinlendirir & pil tasarrufu"),
    WARM_AMBER_EYE_CARE("Gece Işığı & Göz Koruma", "🌙", "Mavi ışığı süzen sıcak sepia/amber tonları"),
    LIGHT("Flutter Aydınlık", "☀️", "Flutter tarzı temiz, minimalist ve sade açık tema");

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
        displayName = "Flutter DevTools",
        iconEmoji = "💙",
        bg = Color(0xFF131722),
        header = Color(0xFF1B2234),
        border = Color(0xFF28334E),
        gutterText = Color(0xFF5B6B8C),
        textPrimary = Color(0xFFE2E8F0),
        keywordColor = Color(0xFF00B4D8),
        stringColor = Color(0xFF06D6A0),
        numberColor = Color(0xFFFFD166),
        commentColor = Color(0xFF6C7A9C),
        typeColor = Color(0xFF48CAE4),
        operatorColor = Color(0xFF90E0EF),
        punctuationColor = Color(0xFFB8C0D2)
    ),
    OBSIDIAN(
        displayName = "Obsidian Slate",
        iconEmoji = "🌑",
        bg = Color(0xFF0B1120),
        header = Color(0xFF161F30),
        border = Color(0xFF334155),
        gutterText = Color(0xFF64748B),
        textPrimary = Color(0xFFF8FAFC),
        keywordColor = Color(0xFFF43F5E),
        stringColor = Color(0xFF34D399),
        numberColor = Color(0xFFFBBF24),
        commentColor = Color(0xFF64748B),
        typeColor = Color(0xFF38BDF8),
        operatorColor = Color(0xFFF472B6),
        punctuationColor = Color(0xFFA78BFA)
    ),
    OLED_BLACK(
        displayName = "OLED Saf Siyah",
        iconEmoji = "⬛",
        bg = Color(0xFF000000),
        header = Color(0xFF0A0A0A),
        border = Color(0xFF262626),
        gutterText = Color(0xFF525252),
        textPrimary = Color(0xFFFFFFFF),
        keywordColor = Color(0xFFFF3366),
        stringColor = Color(0xFF00E676),
        numberColor = Color(0xFFFFD54F),
        commentColor = Color(0xFF757575),
        typeColor = Color(0xFF00E5FF),
        operatorColor = Color(0xFFFF4081),
        punctuationColor = Color(0xFFB388FF)
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
        bg = Color(0xFF1A191B),
        header = Color(0xFF222024),
        border = Color(0xFF38353D),
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

// 0. High-Tech Deep Obsidian / Modern Knowledge Palette (Dark-First Standard)
val FlutterDartDarkAppColors = AppColors(
    bg = Color(0xFF0B0E14), // Modern Knowledge Canvas
    surface = Color(0xFF111620), // Primary Surface
    surfaceVariant = Color(0xFF161C27), // Card Surface
    cardBorder = Color(0xFF242F42), // Fine Geometric Border
    textPrimary = Color(0xFFF5F7FA), // Crisp Readable Text
    textSecondary = Color(0xFFA0A7B5), // Muted Supporting Text
    textMuted = Color(0xFF596170), // Subtle Text & Indicators
    primaryIndigo = Color(0xFF7C83FF), // Electric Knowledge Indigo
    primaryIndigoLight = Color(0xFF9DA4FF),
    primaryDark = Color(0xFF5A62E8),
    primarySubtle = Color(0xFF171B33),
    primarySubtleBorder = Color(0xFF2E3566),
    accentEmerald = Color(0xFF4ADE80), // Mastered / Success
    accentEmeraldLight = Color(0xFF86EFAC),
    accentEmeraldSubtle = Color(0xFF0D2818),
    accentEmeraldBorder = Color(0xFF1A5330),
    accentAmber = Color(0xFFFBBF24), // XP / Streak Glow
    accentAmberSubtle = Color(0xFF2E230B),
    accentAmberBorder = Color(0xFF5C4717),
    accentOrange = Color(0xFFFB923C),
    accentOrangeSubtle = Color(0xFF331B0B),
    accentOrangeBorder = Color(0xFF6B3917),
    accentRose = Color(0xFFF87171), // Error / Warning
    accentRoseSubtle = Color(0xFF331215),
    accentRoseBorder = Color(0xFF6B252C),
    accentCyan = Color(0xFF5EEAD4), // Secondary Knowledge Accent (Teal)
    accentPurple = Color(0xFFC084FC),
    accentVioletSubtle = Color(0xFF261838),
    accentVioletBorder = Color(0xFF4F3175),
    codeBg = Color(0xFF0E131D),
    codeHeader = Color(0xFF151C2B),
    isDark = true,
    themeMode = AppThemeMode.FLUTTER_DART_DARK
)

// 1. High-tech Deep Obsidian Dark Palette
val DarkAppColors = AppColors(
    bg = Color(0xFF0B0E14),
    surface = Color(0xFF111620),
    surfaceVariant = Color(0xFF161C27),
    cardBorder = Color(0xFF283244),
    textPrimary = Color(0xFFF5F7FA),
    textSecondary = Color(0xFFA0A7B5),
    textMuted = Color(0xFF596170),
    primaryIndigo = Color(0xFF7C83FF),
    primaryIndigoLight = Color(0xFF9DA4FF),
    primaryDark = Color(0xFF5A62E8),
    primarySubtle = Color(0xFF171B33),
    primarySubtleBorder = Color(0xFF2E3566),
    accentEmerald = Color(0xFF4ADE80),
    accentEmeraldLight = Color(0xFF86EFAC),
    accentEmeraldSubtle = Color(0xFF0D2818),
    accentEmeraldBorder = Color(0xFF1A5330),
    accentAmber = Color(0xFFFBBF24),
    accentAmberSubtle = Color(0xFF2E230B),
    accentAmberBorder = Color(0xFF5C4717),
    accentOrange = Color(0xFFFB923C),
    accentOrangeSubtle = Color(0xFF331B0B),
    accentOrangeBorder = Color(0xFF6B3917),
    accentRose = Color(0xFFF87171),
    accentRoseSubtle = Color(0xFF331215),
    accentRoseBorder = Color(0xFF6B252C),
    accentCyan = Color(0xFF5EEAD4),
    accentPurple = Color(0xFFC084FC),
    accentVioletSubtle = Color(0xFF261838),
    accentVioletBorder = Color(0xFF4F3175),
    codeBg = Color(0xFF0E131D),
    codeHeader = Color(0xFF151C2B),
    isDark = true,
    themeMode = AppThemeMode.OBSIDIAN_DARK
)

// 2. OLED Pure Midnight True Black Palette
val OledMidnightAppColors = AppColors(
    bg = Color(0xFF000000),
    surface = Color(0xFF080808),
    surfaceVariant = Color(0xFF121212),
    cardBorder = Color(0xFF242424),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFFA3A3A3),
    textMuted = Color(0xFF666666),
    primaryIndigo = Color(0xFF38BDF8),
    primaryIndigoLight = Color(0xFF7DD3FC),
    primaryDark = Color(0xFF0284C7),
    primarySubtle = Color(0xFF141C24),
    primarySubtleBorder = Color(0xFF1E293B),
    accentEmerald = Color(0xFF10B981),
    accentEmeraldLight = Color(0xFF34D399),
    accentEmeraldSubtle = Color(0xFF042F24),
    accentEmeraldBorder = Color(0xFF065F46),
    accentAmber = Color(0xFFFBBF24),
    accentAmberSubtle = Color(0xFF382307),
    accentAmberBorder = Color(0xFF78350F),
    accentOrange = Color(0xFFFB923C),
    accentOrangeSubtle = Color(0xFF3A1807),
    accentOrangeBorder = Color(0xFF7C2D12),
    accentRose = Color(0xFFFB7185),
    accentRoseSubtle = Color(0xFF3F0B18),
    accentRoseBorder = Color(0xFF881337),
    accentCyan = Color(0xFF38BDF8),
    accentPurple = Color(0xFFC084FC),
    accentVioletSubtle = Color(0xFF240E40),
    accentVioletBorder = Color(0xFF581C87),
    codeBg = Color(0xFF000000),
    codeHeader = Color(0xFF0C0C0C),
    isDark = true,
    themeMode = AppThemeMode.OLED_MIDNIGHT
)

// 3. Warm Amber Eye-Care Palette
val WarmAmberEyeCareAppColors = AppColors(
    bg = Color(0xFF12100E),
    surface = Color(0xFF1A1612),
    surfaceVariant = Color(0xFF25201A),
    cardBorder = Color(0xFF3D342A),
    textPrimary = Color(0xFFF5EDE0),
    textSecondary = Color(0xFFC4B5A5),
    textMuted = Color(0xFF8C7E6E),
    primaryIndigo = Color(0xFFF59E0B),
    primaryIndigoLight = Color(0xFFFBBF24),
    primaryDark = Color(0xFFD97706),
    primarySubtle = Color(0xFF2B2215),
    primarySubtleBorder = Color(0xFF453622),
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

// 4. Flutter Crisp & Clean Minimal Light Palette
val LightAppColors = AppColors(
    bg = Color(0xFFF6F8FA), // Minimal Flutter canvas
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFEAEEF2),
    cardBorder = Color(0xFFD0D7DE),
    textPrimary = Color(0xFF1F2328),
    textSecondary = Color(0xFF656D76),
    textMuted = Color(0xFF8C959F),
    primaryIndigo = Color(0xFF0284C7),
    primaryIndigoLight = Color(0xFF0284C7),
    primaryDark = Color(0xFF0369A1),
    primarySubtle = Color(0xFFDDF4FF),
    primarySubtleBorder = Color(0xFFB6E3FF),
    accentEmerald = Color(0xFF1A7F37),
    accentEmeraldLight = Color(0xFF2DA44E),
    accentEmeraldSubtle = Color(0xFFDAFBE1),
    accentEmeraldBorder = Color(0xFF4AC26B),
    accentAmber = Color(0xFF9A6700),
    accentAmberSubtle = Color(0xFFFFF8C5),
    accentAmberBorder = Color(0xFFD4A72C),
    accentOrange = Color(0xFFBC4C00),
    accentOrangeSubtle = Color(0xFFFFEBE9),
    accentOrangeBorder = Color(0xFFFF8182),
    accentRose = Color(0xFFCF222E),
    accentRoseSubtle = Color(0xFFFFEBE9),
    accentRoseBorder = Color(0xFFFF8182),
    accentCyan = Color(0xFF0969DA),
    accentPurple = Color(0xFF8250DF),
    accentVioletSubtle = Color(0xFFFBEFFF),
    accentVioletBorder = Color(0xFFD2A8FF),
    codeBg = Color(0xFF1F2328),
    codeHeader = Color(0xFF2D333B),
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
