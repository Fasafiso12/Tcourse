package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val FlutterDartDarkMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF7C83FF),
    onPrimary = Color(0xFF0B0E14),
    primaryContainer = Color(0xFF171B33),
    onPrimaryContainer = Color(0xFF9DA4FF),
    secondary = Color(0xFF5EEAD4),
    onSecondary = Color(0xFF0B0E14),
    secondaryContainer = Color(0xFF0D2824),
    onSecondaryContainer = Color(0xFF86EFAC),
    tertiary = Color(0xFFFBBF24),
    onTertiary = Color(0xFF0B0E14),
    background = Color(0xFF0B0E14),
    onBackground = Color(0xFFF5F7FA),
    surface = Color(0xFF111620),
    onSurface = Color(0xFFF5F7FA),
    surfaceVariant = Color(0xFF161C27),
    onSurfaceVariant = Color(0xFFA0A7B5),
    outline = Color(0xFF242F42)
)

private val DarkMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF7C83FF),
    onPrimary = Color(0xFF0B0E14),
    primaryContainer = Color(0xFF171B33),
    onPrimaryContainer = Color(0xFF9DA4FF),
    secondary = Color(0xFF4ADE80),
    onSecondary = Color(0xFF0B0E14),
    secondaryContainer = Color(0xFF0D2818),
    onSecondaryContainer = Color(0xFF86EFAC),
    tertiary = Color(0xFFFBBF24),
    onTertiary = Color(0xFF0B0E14),
    background = Color(0xFF0B0E14),
    onBackground = Color(0xFFF5F7FA),
    surface = Color(0xFF111620),
    onSurface = Color(0xFFF5F7FA),
    surfaceVariant = Color(0xFF161C27),
    onSurfaceVariant = Color(0xFFA0A7B5),
    outline = Color(0xFF283244)
)

private val OledMaterialColorScheme = darkColorScheme(
    primary = Color(0xFF38BDF8),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF141C24),
    onPrimaryContainer = Color(0xFF7DD3FC),
    secondary = Color(0xFF10B981),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF042F24),
    onSecondaryContainer = Color(0xFF34D399),
    tertiary = Color(0xFFFBBF24),
    onTertiary = Color.Black,
    background = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF080808),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF121212),
    onSurfaceVariant = Color(0xFFA3A3A3),
    outline = Color(0xFF242424)
)

private val WarmAmberMaterialColorScheme = darkColorScheme(
    primary = Color(0xFFF59E0B),
    onPrimary = Color(0xFF1F1200),
    primaryContainer = Color(0xFF2B2215),
    onPrimaryContainer = Color(0xFFFBBF24),
    secondary = Color(0xFF81B29A),
    onSecondary = Color(0xFF10261E),
    secondaryContainer = Color(0xFF1B2B24),
    onSecondaryContainer = Color(0xFFA8D5BA),
    tertiary = Color(0xFFE07A5F),
    onTertiary = Color(0xFF2E110B),
    background = Color(0xFF12100E),
    onBackground = Color(0xFFF5EDE0),
    surface = Color(0xFF1A1612),
    onSurface = Color(0xFFF5EDE0),
    surfaceVariant = Color(0xFF25201A),
    onSurfaceVariant = Color(0xFFC4B5A5),
    outline = Color(0xFF3D342A)
)

private val LightMaterialColorScheme = lightColorScheme(
    primary = Color(0xFF0284C7),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDDF4FF),
    onPrimaryContainer = Color(0xFF0369A1),
    secondary = Color(0xFF1A7F37),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFDAFBE1),
    onSecondaryContainer = Color(0xFF196C2E),
    tertiary = Color(0xFF9A6700),
    onTertiary = Color.White,
    background = Color(0xFFF6F8FA),
    onBackground = Color(0xFF1F2328),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1F2328),
    surfaceVariant = Color(0xFFEAEEF2),
    onSurfaceVariant = Color(0xFF656D76),
    outline = Color(0xFFD0D7DE)
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
