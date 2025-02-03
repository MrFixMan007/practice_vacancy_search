package ru.my.auth.impl.presentation.codeinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.my.auth.impl.presentation.codeinput.components.CodeInputScreenContent
import ru.my.navigation.SharedScreen

internal class CodeInputScreen(
    private val email: String,
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<CodeInputScreenModel>()
        val state by screenModel.state.collectAsState()

        CodeInputScreenContent(
            email = email,
            code = state.code,
            pinLength = state.pinLength,
            isContinueButtonEnabled = state.isContinueButtonEnabled,
            onContinueClick = remember {
                {
                    val screen = ScreenRegistry.get(SharedScreen.MainHost)
                    navigator.replaceAll(screen)
                }
            },
            onPinChange = remember { { index, s -> screenModel.setCodeSymbol(index, s) } },
            focusRequester = state.focusRequester,
        )
    }
}