package ru.my.base.impl.data.storage

import ru.my.base.api.domain.storage.UserInfoManager
import javax.inject.Inject

class UserInfoManagerImpl @Inject constructor(
    private val prefs: Prefs
) : UserInfoManager {

    override fun setProfileEmail(email: String) {
        prefs.profileEmail = email
    }

    override fun profileEmail(): String {
        return prefs.profileEmail
    }
}