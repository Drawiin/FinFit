package com.drawiin.funfit.common_ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Secondary,
    background = Color.White,
    surface = Surface,
    onPrimary = Surface,
    onSecondary = Surface,
    onBackground = OnSurface,
    onSurface = OnSurface
)

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Secondary,
    background = Color.White,
    surface = Surface,
    onPrimary = Surface,
    onSecondary = Surface,
    onBackground = OnSurface,
    onSurface = OnSurface
)

@Composable
fun FunFitTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}