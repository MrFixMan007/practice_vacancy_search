package ru.my.room.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.base.api.domain.usecase.DeleteFavouriteVacancyUseCase
import ru.my.base.api.domain.usecase.GetAllFavouriteVacanciesUseCase
import ru.my.base.api.domain.usecase.InsertFavouriteVacancyUseCase
import ru.my.room.usecase.DeleteFavouriteVacancyUseCaseImpl
import ru.my.room.usecase.GetAllFavouriteVacanciesUseCaseImpl
import ru.my.room.usecase.InsertFavouriteVacancyUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllFavouriteVacancies(
        vacancyRepository: FavouriteVacancyRepository,
    ): GetAllFavouriteVacanciesUseCase = GetAllFavouriteVacanciesUseCaseImpl(vacancyRepository)

    @Provides
    fun provideInsertFavouriteVacancy(
        vacancyRepository: FavouriteVacancyRepository,
    ): InsertFavouriteVacancyUseCase = InsertFavouriteVacancyUseCaseImpl(vacancyRepository)

    @Provides
    fun provideDeleteFavouriteVacancyUseCase(
        vacancyRepository: FavouriteVacancyRepository,
    ): DeleteFavouriteVacancyUseCase = DeleteFavouriteVacancyUseCaseImpl(vacancyRepository)

}