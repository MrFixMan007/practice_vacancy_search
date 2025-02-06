package ru.my.room.usecase

import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.base.api.domain.usecase.DeleteFavouriteVacancyUseCase
import javax.inject.Inject

class DeleteFavouriteVacancyUseCaseImpl @Inject constructor(
    private val vacancyRepository: FavouriteVacancyRepository
) : DeleteFavouriteVacancyUseCase {

    override suspend fun execute(id: Int) {
        vacancyRepository.deleteById(id)
    }

}