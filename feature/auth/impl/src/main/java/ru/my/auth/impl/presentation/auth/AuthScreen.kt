package ru.my.auth.impl.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.my.auth.impl.presentation.auth.components.AuthScreenContent
import ru.my.navigation.SharedScreen

internal class AuthScreen(

) : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<AuthScreenModel>()
        val state by screenModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        AuthScreenContent(
            email = state.email,
            onEmailChanged = remember { { email -> screenModel.setEmail(email) } },
            isContinueButtonEnabled = state.isContinueButtonEnabled,
            isLoginWithPasswordEnabled = state.isLoginWithPasswordEnabled,
            onContinueClick = remember {
                {
                    val screen = ScreenRegistry.get(SharedScreen.CodeInput(state.email))
                    navigator.push(screen)
                }
            },
            onLoginWithPasswordClick = { /*TODO*/ },
            onSearchEmployeesClick = { /*TODO*/ },
        )
    }
}