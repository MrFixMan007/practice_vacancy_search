package ru.my.base.api.domain.usecase

import ru.my.base.api.domain.model.Vacancy

interface GetAllFavouriteVacanciesUseCase {

    suspend fun execute(): List<Vacancy>
}