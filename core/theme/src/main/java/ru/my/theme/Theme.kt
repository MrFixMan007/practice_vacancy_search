package ru.my.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView

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
    lightTheme: Boolean = !isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            if (lightTheme) {
                window.navigationBarColor = android.graphics.Color.WHITE
                window.statusBarColor = android.graphics.Color.WHITE
            } else {
                window.navigationBarColor = android.graphics.Color.TRANSPARENT
                window.statusBarColor = android.graphics.Color.TRANSPARENT
            }
        }
    }

    CompositionLocalProvider {
        MaterialTheme {
            CompositionLocalProvider(
                LocalColors provides if (lightTheme) lightColors else darkColors,
                LocalTypography provides CustomTypography,
                LocalSnackbarHostState provides snackbarHostState,
            ) {
                content()
            }
        }
    }
}