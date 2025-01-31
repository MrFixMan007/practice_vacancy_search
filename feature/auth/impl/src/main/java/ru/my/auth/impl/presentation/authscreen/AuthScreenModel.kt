package ru.my.auth.impl.presentation.authscreen

import ru.my.base.screenmodel.BaseScreenModel
import javax.inject.Inject

class AuthScreenModel @Inject constructor(

) : BaseScreenModel<AuthScreenState, Nothing>(AuthScreenState()) {

    internal fun setEmail(newEmail: String) {
        val emailIsNotEmpty = newEmail.isNotEmpty()
        setState {
            state.value.copy(
                email = newEmail,
                isContinueButtonEnabled = emailIsNotEmpty,
                isLoginWithPasswordEnabled = emailIsNotEmpty,
            )
        }
    }

}