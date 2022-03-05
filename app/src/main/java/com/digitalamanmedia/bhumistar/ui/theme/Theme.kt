package com.digitalamanmedia.bhumistar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BhumistarNight,
    primaryVariant = White,
    secondary = BhumistarNightDark,
    error = White,
    surface = BhumistarNight,
    background = Black,
)

private val LightColorPalette = lightColors(
    primary = Bhumistar,
    primaryVariant = Black,
    secondary = BhumistarDark,
    error = Bhumistar,
    surface = White,
    background = White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BhumistarTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
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