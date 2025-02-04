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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.transitions.FadeTransition
import dagger.hilt.android.AndroidEntryPoint
import ru.my.base.api.domain.storage.Authenticator
import ru.my.navigation.SharedScreen
import ru.my.theme.LocalColors
import ru.my.theme.VacancySearchTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authenticator: Authenticator

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
                        .statusBarsPadding()
                        .background(LocalColors.current.basicColors.black),
                ) {
                    val startScreen = if (authenticator.isAuth()) {
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