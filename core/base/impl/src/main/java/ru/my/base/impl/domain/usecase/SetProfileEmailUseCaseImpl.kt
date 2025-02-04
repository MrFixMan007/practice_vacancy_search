package ru.my.base.impl.domain.usecase

import ru.my.base.api.domain.storage.UserInfoManager
import ru.my.base.api.domain.usecase.SetProfileEmailUseCase
import javax.inject.Inject

class SetProfileEmailUseCaseImpl @Inject constructor(
    private val userInfoManager: UserInfoManager
) : SetProfileEmailUseCase {

    override fun execute(email: String) {
        userInfoManager.setProfileEmail(email)
    }
}