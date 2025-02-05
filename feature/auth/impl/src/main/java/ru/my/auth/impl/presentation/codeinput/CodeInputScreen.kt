package ru.my.auth.impl.presentation.codeinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.Job
import ru.my.auth.impl.presentation.codeinput.components.CodeInputScreenContent
import ru.my.base.api.extensions.singleAction
import ru.my.navigation.SharedScreen

internal class CodeInputScreen(
    private val email: String,
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<CodeInputScreenModel>()
        val state by screenModel.state.collectAsState()
        val job = remember { mutableStateOf<Job?>(null) }

        LaunchedEffect(Unit) {
            screenModel.init(email)

            screenModel.effect.collect { sideEffect ->
                when (sideEffect) {
                    is CodeInputScreenSideEffect.Login -> {
                        val screen = ScreenRegistry.get(SharedScreen.MainHost)
                        navigator.replaceAll(screen)
                    }
                }
            }
        }

        CodeInputScreenContent(
            email = email,
            code = state.code,
            pinLength = state.pinLength,
            isContinueButtonEnabled = state.isContinueButtonEnabled,
            onContinueClick = remember {
                {
                    job.value = job.value.singleAction {
                        screenModel.login()
                    }
                }
            },
            onPinChange = remember { { _, s -> screenModel.setCodeSymbol(s) } },
            focusRequester = state.focusRequester,
        )
    }
}