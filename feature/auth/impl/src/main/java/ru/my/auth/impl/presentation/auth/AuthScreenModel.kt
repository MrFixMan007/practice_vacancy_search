package ru.my.auth.impl.presentation.auth

import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class AuthScreenModel @Inject constructor(

) : BaseScreenModel<AuthScreenState, Nothing>(AuthScreenState()) {

    internal fun setEmail(newEmail: String) {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
        val isCorrectEmail = newEmail.matches(emailRegex.toRegex())

        setState {
            state.value.copy(
                email = newEmail,
                isContinueButtonEnabled = isCorrectEmail,
                isLoginWithPasswordEnabled = isCorrectEmail,
            )
        }
    }

}