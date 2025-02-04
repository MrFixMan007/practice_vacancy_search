package ru.my.base.impl.data.storage

import ru.my.base.api.domain.storage.Authenticator
import javax.inject.Inject

class AuthenticatorImpl @Inject constructor(
    private val prefs: Prefs,
) : Authenticator {

    override fun isAuth(): Boolean {
        return prefs.profileEmail.isNotEmpty()
    }
}