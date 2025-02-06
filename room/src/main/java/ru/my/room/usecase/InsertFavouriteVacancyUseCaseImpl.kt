package ru.my.room.usecase

import ru.my.base.api.domain.model.Vacancy
import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.base.api.domain.usecase.InsertFavouriteVacancyUseCase
import javax.inject.Inject

class InsertFavouriteVacancyUseCaseImpl @Inject constructor(
    private val vacancyRepository: FavouriteVacancyRepository
) : InsertFavouriteVacancyUseCase {

    override suspend fun execute(vacancy: Vacancy) {
        return vacancyRepository.insert(vacancy)
    }
}