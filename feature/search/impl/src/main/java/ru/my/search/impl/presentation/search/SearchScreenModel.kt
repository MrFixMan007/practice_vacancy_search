package ru.my.search.impl.presentation.search

import kotlinx.collections.immutable.toImmutableList
import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class SearchScreenModel @Inject constructor(

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
    }

}