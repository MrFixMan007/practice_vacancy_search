package ru.my.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalColors = staticCompositionLocalOf<CustomColors> {
    error("No colors provided")
}

val LocalTypography = staticCompositionLocalOf<CustomTypography> {
    error("No typography provided")
}

val LocalSnackbarHostState = staticCompositionLocalOf<SnackbarHostState?> {
    null
}

@Composable
fun VacancySearchTheme(
    snackbarHostState: SnackbarHostState? = null,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider {
        MaterialTheme {
            CompositionLocalProvider(
                LocalColors provides if (darkTheme) darkColors else lightColors,
                LocalTypography provides CustomTypography,
                LocalSnackbarHostState provides snackbarHostState,
            ) {
                content()
            }
        }
    }
}