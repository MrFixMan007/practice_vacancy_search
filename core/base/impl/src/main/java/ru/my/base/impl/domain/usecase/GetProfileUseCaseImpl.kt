package ru.my.base.impl.domain.usecase

import ru.my.base.api.domain.model.Profile
import ru.my.base.api.domain.repository.ProfileRepository
import ru.my.base.api.domain.usecase.GetProfileUseCase
import javax.inject.Inject

class GetProfileUseCaseImpl @Inject constructor(
    private val profileRepository: ProfileRepository
) : GetProfileUseCase {

    override fun execute(): Profile {
        return profileRepository.getProfile()
    }
}