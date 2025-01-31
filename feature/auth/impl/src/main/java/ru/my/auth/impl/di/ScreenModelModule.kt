package ru.my.auth.impl.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import ru.my.auth.impl.presentation.auth.AuthScreenModel
import ru.my.auth.impl.presentation.codeinput.CodeInputScreenModel

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(AuthScreenModel::class)
    abstract fun bindAuthScreenModel(authScreenModel: AuthScreenModel): ScreenModel

    @Binds
    @IntoMap
    @ScreenModelKey(CodeInputScreenModel::class)
    abstract fun bindCodeInputScreenModel(codeInputScreenModel: CodeInputScreenModel): ScreenModel
}