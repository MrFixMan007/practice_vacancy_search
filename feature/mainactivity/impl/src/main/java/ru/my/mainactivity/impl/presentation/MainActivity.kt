package ru.my.mainactivity.impl.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = LocalColors.current.basicColors.black,
                    snackbarHost = {
                        SnackbarHost(
                            modifier = Modifier
                                .consumeWindowInsets(WindowInsets.navigationBars)
                                .imePadding(),
                            hostState = snackbarHostState,
                            snackbar = { data ->
                                Snackbar(
                                    snackbarData = data,
                                    containerColor = Color.Red,
                                )
                            },
                        )
                    }
                ) { _ ->
                    val startScreen = SharedScreen.Auth

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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}