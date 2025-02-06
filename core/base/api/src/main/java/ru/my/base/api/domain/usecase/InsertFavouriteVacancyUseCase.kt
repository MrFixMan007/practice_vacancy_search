package ru.my.base.api.domain.usecase

import ru.my.base.api.domain.model.Vacancy

interface InsertFavouriteVacancyUseCase {

    suspend fun execute(vacancy: Vacancy)
}