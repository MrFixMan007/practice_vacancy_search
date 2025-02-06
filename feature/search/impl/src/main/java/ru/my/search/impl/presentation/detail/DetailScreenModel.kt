package ru.my.search.impl.presentation.detail

import ru.my.base.api.screenmodel.BaseScreenModel
import javax.inject.Inject

class DetailScreenModel @Inject constructor(

) : BaseScreenModel<DetailScreenState, Nothing>(DetailScreenState()) {

    fun onFavouriteClick() {
        setState {
            state.value.copy(isFavourite = !state.value.isFavourite)
        }
    }

}