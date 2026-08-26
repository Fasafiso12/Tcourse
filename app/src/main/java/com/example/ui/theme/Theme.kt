package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val FlutterDartDarkMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF6366F1),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF181C30),
    onPrimaryContainer = Color(0xFF818CF8),
    secondary = Color(0xFF06B6D4),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF0E232B),
    onSecondaryContainer = Color(0xFF67E8F9),
    tertiary = Color(0xFFF59E0B),
    onTertiary = Color.White,
    background = Color(0xFF0B0F17),
    onBackground = Color(0xFFF8FAFC),
    surface = Color(0xFF111722),
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF161E2D),
    onSurfaceVariant = Color(0xFF94A3B8),
    outline = Color(0xFF222C3E)
)

private val DarkMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF6366F1),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF181C30),
    onPrimaryContainer = Color(0xFF818CF8),
    secondary = Color(0xFF22C55E),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF0F2618),
    onSecondaryContainer = Color(0xFF4ADE80),
    tertiary = Color(0xFFF59E0B),
    onTertiary = Color.White,
    background = Color(0xFF0B0F17),
    onBackground = Color(0xFFF8FAFC),
    surface = Color(0xFF111722),
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF161E2D),
    onSurfaceVariant = Color(0xFF94A3B8),
    outline = Color(0xFF222C3E)
)

private val OledMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF6366F1),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF14172B),
    onPrimaryContainer = Color(0xFF818CF8),
    secondary = Color(0xFF22C55E),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF0A2414),
    onSecondaryContainer = Color(0xFF4ADE80),
    tertiary = Color(0xFFF59E0B),
    onTertiary = Color.White,
    background = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF0A0A0A),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF141414),
    onSurfaceVariant = Color(0xFFA3A3A3),
    outline = Color(0xFF262626)
)

private val WarmAmberMaterialColorScheme = darkColorScheme(
    primary = Color(0xFFF59E0B),
    onPrimary = Color(0xFF1F1200),
    primaryContainer = Color(0xFF282015),
    onPrimaryContainer = Color(0xFFFBBF24),
    secondary = Color(0xFF81B29A),
    onSecondary = Color(0xFF10261E),
    secondaryContainer = Color(0xFF1B2B24),
    onSecondaryContainer = Color(0xFFA8D5BA),
    tertiary = Color(0xFFE07A5F),
    onTertiary = Color(0xFF2E110B),
    background = Color(0xFF12100E),
    onBackground = Color(0xFFFDF8F0),
    surface = Color(0xFF1A1612),
    onSurface = Color(0xFFFDF8F0),
    surfaceVariant = Color(0xFF241F1A),
    onSurfaceVariant = Color(0xFFC7B8A6),
    outline = Color(0xFF383027)
)

private val LightMaterialColorScheme = lightColorScheme(
    primary = Color(0xFF4F46E5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEEF2FF),
    onPrimaryContainer = Color(0xFF3730A3),
    secondary = Color(0xFF0891B2),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFE0F2FE),
    onSecondaryContainer = Color(0xFF075985),
    tertiary = Color(0xFFD97706),
    onTertiary = Color.White,
    background = Color(0xFFF8FAFC),
    onBackground = Color(0xFF0F172A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = Color(0xFF475569),
    outline = Color(0xFFE2E8F0)
)

@Composable
fun MyApplicationTheme(
    themeMode: AppThemeMode = AppThemeMode.FLUTTER_DART_DARK,
    editorTheme: EditorTheme = EditorTheme.FLUTTER_STUDIO,
    content: @Composable () -> Unit,
) {
    val appColors = when (themeMode) {
        AppThemeMode.FLUTTER_DART_DARK -> FlutterDartDarkAppColors
        AppThemeMode.OBSIDIAN_DARK -> DarkAppColors
        AppThemeMode.OLED_MIDNIGHT -> OledMidnightAppColors
        AppThemeMode.WARM_AMBER_EYE_CARE -> WarmAmberEyeCareAppColors
        AppThemeMode.LIGHT -> LightAppColors
    }

    val colorScheme = when (themeMode) {
        AppThemeMode.FLUTTER_DART_DARK -> FlutterDartDarkMaterialColorScheme
        AppThemeMode.OBSIDIAN_DARK -> DarkMaterialColorScheme
        AppThemeMode.OLED_MIDNIGHT -> OledMaterialColorScheme
        AppThemeMode.WARM_AMBER_EYE_CARE -> WarmAmberMaterialColorScheme
        AppThemeMode.LIGHT -> LightMaterialColorScheme
    }

    val effectiveEditorTheme = if (themeMode == AppThemeMode.WARM_AMBER_EYE_CARE && editorTheme == EditorTheme.FLUTTER_STUDIO) {
        EditorTheme.WARM_AMBER
    } else if (themeMode == AppThemeMode.OLED_MIDNIGHT && editorTheme == EditorTheme.FLUTTER_STUDIO) {
        EditorTheme.OLED_BLACK
    } else {
        editorTheme
    }

    CompositionLocalProvider(
        LocalAppColors provides appColors,
        LocalEditorTheme provides effectiveEditorTheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
