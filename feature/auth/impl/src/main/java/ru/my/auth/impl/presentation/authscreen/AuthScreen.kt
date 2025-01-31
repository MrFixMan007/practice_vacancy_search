package ru.my.auth.impl.presentation.authscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import ru.my.auth.impl.presentation.authscreen.components.AuthScreenContent

internal class AuthScreen(

) : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<AuthScreenModel>()
        val state by screenModel.state.collectAsState()

        AuthScreenContent(
            email = state.email,
            onEmailChanged = remember { { email -> screenModel.setEmail(email) } },
            isContinueButtonEnabled = state.isContinueButtonEnabled,
            isLoginWithPasswordEnabled = state.isLoginWithPasswordEnabled,
            onContinueClick = { /*TODO*/ },
            onLoginWithPasswordClick = { /*TODO*/ },
            onSearchEmployeesClick = { /*TODO*/ },
        )
    }
}