package com.example.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

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
    val isDark: Boolean
)

// High-tech Deep Obsidian Dark Palette
val DarkAppColors = AppColors(
    bg = Color(0xFF090D16),                   // Deep Obsidian
    surface = Color(0xFF111827),              // Dark Slate 900
    surfaceVariant = Color(0xFF1E293B),       // Slate 800
    cardBorder = Color(0xFF334155),           // Slate 700
    textPrimary = Color(0xFFF8FAFC),          // Slate 50
    textSecondary = Color(0xFF94A3B8),        // Slate 400
    textMuted = Color(0xFF64748B),            // Slate 500
    primaryIndigo = Color(0xFF3B82F6),        // Bright Blue 500
    primaryIndigoLight = Color(0xFF60A5FA),   // Blue 400
    primaryDark = Color(0xFF0284C7),          // Sky 600
    primarySubtle = Color(0xFF1E293B),        // Deep Slate Blue
    primarySubtleBorder = Color(0xFF334155),  // Slate Border
    accentEmerald = Color(0xFF10B981),        // Emerald 500
    accentEmeraldLight = Color(0xFF34D399),   // Emerald 400
    accentEmeraldSubtle = Color(0xFF064E3B),  // Dark Emerald
    accentEmeraldBorder = Color(0xFF047857),  // Emerald Border
    accentAmber = Color(0xFFF59E0B),          // Amber 500
    accentAmberSubtle = Color(0xFF451A03),    // Dark Amber
    accentAmberBorder = Color(0xFFB45309),    // Amber Border
    accentOrange = Color(0xFFF97316),         // Orange 500
    accentOrangeSubtle = Color(0xFF431407),   // Dark Orange
    accentOrangeBorder = Color(0xFFC2410C),   // Orange Border
    accentRose = Color(0xFFF43F5E),           // Rose 500
    accentRoseSubtle = Color(0xFF4C0519),     // Dark Rose
    accentRoseBorder = Color(0xFFBE123C),     // Rose Border
    accentCyan = Color(0xFF38BDF8),           // Sky 400
    accentPurple = Color(0xFFA855F7),         // Purple 500
    accentVioletSubtle = Color(0xFF2E1065),   // Dark Violet
    accentVioletBorder = Color(0xFF6D28D9),   // Violet Border
    codeBg = Color(0xFF0B1120),               // Code Editor Canvas
    codeHeader = Color(0xFF161F30),           // Code Header
    isDark = true
)

// Crisp & Clean Slate Light Palette
val LightAppColors = AppColors(
    bg = Color(0xFFF8FAFC),                   // Slate 50
    surface = Color(0xFFFFFFFF),              // White
    surfaceVariant = Color(0xFFF1F5F9),       // Slate 100
    cardBorder = Color(0xFFE2E8F0),           // Slate 200
    textPrimary = Color(0xFF0F172A),          // Slate 900
    textSecondary = Color(0xFF475569),        // Slate 600
    textMuted = Color(0xFF94A3B8),            // Slate 400
    primaryIndigo = Color(0xFF2563EB),        // Blue 600
    primaryIndigoLight = Color(0xFF3B82F6),   // Blue 500
    primaryDark = Color(0xFF0F172A),          // Slate 900
    primarySubtle = Color(0xFFEFF6FF),        // Blue 50
    primarySubtleBorder = Color(0xFFDBEAFE),  // Blue 100
    accentEmerald = Color(0xFF10B981),        // Emerald 500
    accentEmeraldLight = Color(0xFF059669),   // Emerald 600
    accentEmeraldSubtle = Color(0xFFECFDF5),  // Emerald 50
    accentEmeraldBorder = Color(0xFFD1FAE5),  // Emerald 100
    accentAmber = Color(0xFFD97706),          // Amber 600
    accentAmberSubtle = Color(0xFFFEF3C7),    // Amber 50
    accentAmberBorder = Color(0xFFFDE68A),    // Amber 200
    accentOrange = Color(0xFFC2410C),         // Orange 700
    accentOrangeSubtle = Color(0xFFFFF7ED),   // Orange 50
    accentOrangeBorder = Color(0xFFFFEDD5),   // Orange 100
    accentRose = Color(0xFFE11D48),           // Rose 600
    accentRoseSubtle = Color(0xFFFFF1F2),     // Rose 50
    accentRoseBorder = Color(0xFFFFE4E6),     // Rose 100
    accentCyan = Color(0xFF0284C7),           // Sky 600
    accentPurple = Color(0xFF7C3AED),         // Violet 600
    accentVioletSubtle = Color(0xFFF5F3FF),   // Violet 50
    accentVioletBorder = Color(0xFFDDD6FE),   // Violet 200
    codeBg = Color(0xFF0F172A),               // Slate 900
    codeHeader = Color(0xFF1E293B),           // Slate 800
    isDark = false
)

val LocalAppColors = compositionLocalOf { DarkAppColors }

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

// Code Syntax Colors
val CodeBg: Color @Composable get() = LocalAppColors.current.codeBg
val CodeHeader: Color @Composable get() = LocalAppColors.current.codeHeader
val CodeKeyword = Color(0xFFF43F5E)
val CodeString = Color(0xFF34D399)
val CodeNumber = Color(0xFFFBBF24)
val CodeComment = Color(0xFF94A3B8)
val CodeType = Color(0xFF38BDF8)
val CodeFunction = Color(0xFFA78BFA)



