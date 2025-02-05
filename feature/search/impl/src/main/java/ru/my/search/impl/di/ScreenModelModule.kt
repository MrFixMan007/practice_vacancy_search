package ru.my.search.impl.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import ru.my.search.impl.presentation.SearchScreenModel

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(SearchScreenModel::class)
    abstract fun bindSearchScreenModel(searchScreenModel: SearchScreenModel): ScreenModel
}