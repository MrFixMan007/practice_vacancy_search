package ru.my.room.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.room.repository.FavouriteVacancyRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideFavouriteVacancyRepositoryImpl(favouriteVacancyRepositoryImpl: FavouriteVacancyRepositoryImpl): FavouriteVacancyRepository

}