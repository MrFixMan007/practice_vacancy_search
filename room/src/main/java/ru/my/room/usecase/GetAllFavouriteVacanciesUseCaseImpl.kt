package ru.my.room.usecase

import ru.my.base.api.domain.model.Vacancy
import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.base.api.domain.usecase.GetAllFavouriteVacanciesUseCase
import javax.inject.Inject

class GetAllFavouriteVacanciesUseCaseImpl @Inject constructor(
    private val vacancyRepository: FavouriteVacancyRepository
) : GetAllFavouriteVacanciesUseCase {

    override suspend fun execute(): List<Vacancy> {
        return vacancyRepository.getAll()
    }
}