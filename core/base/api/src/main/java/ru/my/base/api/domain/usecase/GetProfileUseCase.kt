package ru.my.base.api.domain.usecase

import ru.my.base.api.domain.model.Profile


interface GetProfileUseCase {

    fun execute(): Profile
}