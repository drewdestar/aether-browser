package com.newr.aether.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = AetherPrimary,
    onPrimary = AetherOnPrimary,
    secondary = AetherAccent,
    onSecondary = AetherOnPrimary,
    background = AetherBackground,
    onBackground = AetherOnBackground,
    surface = AetherSurface,
    onSurface = AetherOnBackground
)

private val LightColorScheme = lightColorScheme(
    primary = AetherPrimary,
    onPrimary = AetherOnPrimary,
    secondary = AetherAccent,
    onSecondary = AetherOnPrimary,
    background = AetherLightBackground,
    onBackground = AetherOnPrimary,
    surface = AetherLightSurface,
    onSurface = AetherPrimary
)

@Composable
fun AetherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AetherTypography,
        content = content
    )
}
