package ru.my.base.api.domain.repository

import ru.my.base.api.domain.model.Profile

interface ProfileRepository {

    fun getProfile(): Profile
}