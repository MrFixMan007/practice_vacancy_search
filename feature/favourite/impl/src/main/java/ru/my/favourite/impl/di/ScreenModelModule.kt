package ru.my.favourite.impl.di

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.hilt.ScreenModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import ru.my.favourite.impl.presentation.FavouriteScreenModel

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModelModule {

    @Binds
    @IntoMap
    @ScreenModelKey(FavouriteScreenModel::class)
    abstract fun bindFavouriteScreenModel(favouriteScreenModel: FavouriteScreenModel): ScreenModel

}