package ru.my.mainscreen.impl.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import ru.my.mainscreen.impl.presentation.MainScreenModel

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(MainScreenModel::class)
    abstract fun bindMainScreenModel(mainScreenModel: MainScreenModel): ScreenModel

}