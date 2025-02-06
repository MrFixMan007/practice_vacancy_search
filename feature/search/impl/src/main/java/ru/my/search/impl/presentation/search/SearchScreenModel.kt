package ru.my.search.impl.presentation.search

import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.runBlocking
import ru.my.base.api.domain.model.Vacancy
import ru.my.base.api.domain.usecase.InsertFavouriteVacancyUseCase
import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class SearchScreenModel @Inject constructor(
    private val insertFavouriteVacancyUseCase: InsertFavouriteVacancyUseCase
) : BaseScreenModel<SearchScreenState, Nothing>(SearchScreenState()) {

    fun onBackClick() {
        setState {
            state.value.copy(
                isShowingAll = false,
            )
        }
    }

    fun onMoreVacanciesClick() {
        setState {
            state.value.copy(
                isShowingAll = true,
            )
        }
    }

    fun onVacancyFavouriteClick(index: Int) {
        runBlocking {
            setState {
                state.value.copy(
                    vacancies = state.value.vacancies
                        .mapIndexed { mapIndex, vacancy ->
                            if (mapIndex == index) {
                                vacancy.copy(
                                    isFavourite = !vacancy.isFavourite
                                )
                            } else {
                                vacancy
                            }
                        }
                        .toImmutableList()
                )
            }

            val shortVacancy = state.value.vacancies[index]

            if (state.value.vacancies[index].isFavourite) {
                val newVacancy = Vacancy(
                    id = shortVacancy.id,
                    title = shortVacancy.title,
                    incomeLevel = "10",
                    requiredExperience = shortVacancy.experience,
                    timeline = shortVacancy.publishedDate,
                    company = shortVacancy.company,
                    address = shortVacancy.addressTown,
                    companyDescription = "companyDescription",
                    jobDescription = "jobDescription",
                    questions = persistentListOf("questions"),
                    peopleRespondedCount = 10,
                    peopleWatchingCount = 5,
                )
                insertFavouriteVacancyUseCase.execute(newVacancy)
            }
        }
    }

}