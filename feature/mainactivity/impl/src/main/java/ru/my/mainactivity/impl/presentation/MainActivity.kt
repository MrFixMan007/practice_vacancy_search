package ru.my.mainactivity.impl.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.transitions.FadeTransition
import dagger.hilt.android.AndroidEntryPoint
import ru.my.navigation.SharedScreen
import ru.my.theme.LocalColors
import ru.my.theme.VacancySearchTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalVoyagerApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val snackbarHostState = remember { SnackbarHostState() }

            VacancySearchTheme(
                snackbarHostState = snackbarHostState
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                        .background(LocalColors.current.basicColors.black),
                ) {
                    val startScreen = if (false) { //TODO: shared pref for email
                        SharedScreen.MainHost
                    } else {
                        SharedScreen.Auth
                    }

                    Navigator(
                        screen = rememberScreen(provider = startScreen),
                        disposeBehavior = NavigatorDisposeBehavior(disposeSteps = false),
                    ) { navigator ->
                        FadeTransition(
                            navigator = navigator,
                            disposeScreenAfterTransitionEnd = true,
                        )
                    }
                }
            }
        }
    }
}