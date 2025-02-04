package ru.my.base.impl.data.repository

import ru.my.base.api.domain.model.Profile
import ru.my.base.api.domain.repository.ProfileRepository
import ru.my.base.api.domain.storage.UserInfoManager
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val userInfoManager: UserInfoManager,
) : ProfileRepository {

    override fun getProfile(): Profile {
        return Profile(email = userInfoManager.profileEmail())
    }
}