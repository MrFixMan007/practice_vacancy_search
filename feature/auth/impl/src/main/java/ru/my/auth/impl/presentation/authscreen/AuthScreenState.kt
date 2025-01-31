package ru.my.auth.impl.presentation.authscreen

import androidx.compose.runtime.Immutable
import ru.my.base.screenmodel.model.UIState

@Immutable
data class AuthScreenState(
    val email: String = "",
    val isContinueButtonEnabled: Boolean = false,
    val isLoginWithPasswordEnabled: Boolean = false,
) : UIState