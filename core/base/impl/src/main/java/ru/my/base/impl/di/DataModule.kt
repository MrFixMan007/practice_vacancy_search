package ru.my.base.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.my.base.api.domain.storage.Authenticator
import ru.my.base.api.domain.storage.UserInfoManager
import ru.my.base.impl.data.storage.AuthenticatorImpl
import ru.my.base.impl.data.storage.Prefs
import ru.my.base.impl.data.storage.UserInfoManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideUserInfoManager(
        prefs: Prefs,
    ): UserInfoManager = UserInfoManagerImpl(prefs)

    @Provides
    @Singleton
    fun provideAuthenticator(
        prefs: Prefs,
    ): Authenticator = AuthenticatorImpl(prefs)
}