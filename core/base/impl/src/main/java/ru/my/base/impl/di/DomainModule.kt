package ru.my.base.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.my.base.api.domain.repository.ProfileRepository
import ru.my.base.api.domain.storage.UserInfoManager
import ru.my.base.api.domain.usecase.GetProfileUseCase
import ru.my.base.api.domain.usecase.SetProfileEmailUseCase
import ru.my.base.impl.domain.usecase.GetProfileUseCaseImpl
import ru.my.base.impl.domain.usecase.SetProfileEmailUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetProfileUseCase(
        profileRepository: ProfileRepository,
    ): GetProfileUseCase = GetProfileUseCaseImpl(profileRepository)

    @Provides
    fun provideSetProfileEmailUseCase(
        userInfoManager: UserInfoManager,
    ): SetProfileEmailUseCase = SetProfileEmailUseCaseImpl(userInfoManager)

}