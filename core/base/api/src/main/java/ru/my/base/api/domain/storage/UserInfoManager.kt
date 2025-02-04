package ru.my.base.api.domain.storage

interface UserInfoManager {

    fun setProfileEmail(email: String)

    fun profileEmail(): String
}