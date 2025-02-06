package ru.my.base.api.domain.usecase

interface DeleteFavouriteVacancyUseCase {

    suspend fun execute(id: Int)
}