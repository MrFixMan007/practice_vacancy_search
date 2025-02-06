package ru.my.favourite.impl.presentation

import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.my.base.api.domain.usecase.DeleteFavouriteVacancyUseCase
import ru.my.base.api.domain.usecase.GetAllFavouriteVacanciesUseCase
import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class FavouriteScreenModel @Inject constructor(
    private val getAllFavouriteVacanciesUseCase: GetAllFavouriteVacanciesUseCase,
    private val deleteFavouriteVacancyUseCase: DeleteFavouriteVacancyUseCase,
) : BaseScreenModel<FavouriteScreenState, Nothing>(FavouriteScreenState()) {

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            val vacancies = getAllFavouriteVacanciesUseCase.execute()
            setState {
                state.value.copy(
                    favouriteVacancies = vacancies.toImmutableList()
                )
            }
        }
    }

    fun onVacancyFavouriteClick(index: Int) {
        runBlocking {
            val deleteId = state.value.favouriteVacancies[index].id
            setState {
                state.value.copy(
                    favouriteVacancies = state.value.favouriteVacancies
                        .mapIndexedNotNull { mapIndex, vacancy ->
                            if (mapIndex == index) {
                                null
                            } else {
                                vacancy
                            }
                        }
                        .toImmutableList()
                )
            }

            deleteFavouriteVacancyUseCase.execute(deleteId)
        }
    }

}