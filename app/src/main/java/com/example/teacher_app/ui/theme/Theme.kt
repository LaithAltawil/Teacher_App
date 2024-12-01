package com.example.teacher_app

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.teacher_app.ui.theme.backgroundDark
import com.example.teacher_app.ui.theme.backgroundLight
import com.example.teacher_app.ui.theme.errorContainerDark
import com.example.teacher_app.ui.theme.errorContainerLight
import com.example.teacher_app.ui.theme.errorDark
import com.example.teacher_app.ui.theme.errorLight
import com.example.teacher_app.ui.theme.inverseOnSurfaceDark
import com.example.teacher_app.ui.theme.inverseOnSurfaceLight
import com.example.teacher_app.ui.theme.inversePrimaryDark
import com.example.teacher_app.ui.theme.inversePrimaryLight
import com.example.teacher_app.ui.theme.inverseSurfaceDark
import com.example.teacher_app.ui.theme.inverseSurfaceLight
import com.example.teacher_app.ui.theme.onBackgroundDark
import com.example.teacher_app.ui.theme.onBackgroundLight
import com.example.teacher_app.ui.theme.onErrorContainerDark
import com.example.teacher_app.ui.theme.onErrorContainerLight
import com.example.teacher_app.ui.theme.onErrorDark
import com.example.teacher_app.ui.theme.onErrorLight
import com.example.teacher_app.ui.theme.onPrimaryContainerDark
import com.example.teacher_app.ui.theme.onPrimaryContainerLight
import com.example.teacher_app.ui.theme.onPrimaryDark
import com.example.teacher_app.ui.theme.onPrimaryLight
import com.example.teacher_app.ui.theme.onSecondaryContainerDark
import com.example.teacher_app.ui.theme.onSecondaryContainerLight
import com.example.teacher_app.ui.theme.onSecondaryDark
import com.example.teacher_app.ui.theme.onSecondaryLight
import com.example.teacher_app.ui.theme.onSurfaceDark
import com.example.teacher_app.ui.theme.onSurfaceLight
import com.example.teacher_app.ui.theme.onSurfaceVariantDark
import com.example.teacher_app.ui.theme.onSurfaceVariantLight
import com.example.teacher_app.ui.theme.onTertiaryContainerDark
import com.example.teacher_app.ui.theme.onTertiaryContainerLight
import com.example.teacher_app.ui.theme.onTertiaryDark
import com.example.teacher_app.ui.theme.onTertiaryLight
import com.example.teacher_app.ui.theme.outlineDark
import com.example.teacher_app.ui.theme.outlineLight
import com.example.teacher_app.ui.theme.outlineVariantDark
import com.example.teacher_app.ui.theme.outlineVariantLight
import com.example.teacher_app.ui.theme.primaryContainerDark
import com.example.teacher_app.ui.theme.primaryContainerLight
import com.example.teacher_app.ui.theme.primaryDark
import com.example.teacher_app.ui.theme.primaryLight
import com.example.teacher_app.ui.theme.scrimDark
import com.example.teacher_app.ui.theme.scrimLight
import com.example.teacher_app.ui.theme.secondaryContainerDark
import com.example.teacher_app.ui.theme.secondaryContainerLight
import com.example.teacher_app.ui.theme.secondaryDark
import com.example.teacher_app.ui.theme.secondaryLight
import com.example.teacher_app.ui.theme.surfaceBrightDark
import com.example.teacher_app.ui.theme.surfaceBrightLight
import com.example.teacher_app.ui.theme.surfaceContainerDark
import com.example.teacher_app.ui.theme.surfaceContainerHighDark
import com.example.teacher_app.ui.theme.surfaceContainerHighLight
import com.example.teacher_app.ui.theme.surfaceContainerHighestDark
import com.example.teacher_app.ui.theme.surfaceContainerHighestLight
import com.example.teacher_app.ui.theme.surfaceContainerLight
import com.example.teacher_app.ui.theme.surfaceContainerLowDark
import com.example.teacher_app.ui.theme.surfaceContainerLowLight
import com.example.teacher_app.ui.theme.surfaceContainerLowestDark
import com.example.teacher_app.ui.theme.surfaceContainerLowestLight
import com.example.teacher_app.ui.theme.surfaceDark
import com.example.teacher_app.ui.theme.surfaceDimDark
import com.example.teacher_app.ui.theme.surfaceDimLight
import com.example.teacher_app.ui.theme.surfaceLight
import com.example.teacher_app.ui.theme.surfaceVariantDark
import com.example.teacher_app.ui.theme.surfaceVariantLight
import com.example.teacher_app.ui.theme.tertiaryContainerDark
import com.example.teacher_app.ui.theme.tertiaryContainerLight
import com.example.teacher_app.ui.theme.tertiaryDark
import com.example.teacher_app.ui.theme.tertiaryLight
import com.example.ui.theme.AppTypography


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)


@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        lightScheme
    } else {
        darkScheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        typography = AppTypography
    )
}
