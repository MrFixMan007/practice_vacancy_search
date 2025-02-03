package ru.my.mainscreen.impl.presentation

import cafe.adriel.voyager.navigator.tab.Tab
import ru.my.base.screenmodel.BaseScreenModel
import ru.my.mainscreen.impl.presentation.model.BottomBarScreenEnum
import ru.my.mainscreen.impl.presentation.model.FavouriteTab
import ru.my.mainscreen.impl.presentation.model.MessagesTab
import ru.my.mainscreen.impl.presentation.model.ProfileTab
import ru.my.mainscreen.impl.presentation.model.ResponsesTab
import ru.my.mainscreen.impl.presentation.model.SearchTab
import javax.inject.Inject

class MainScreenModel @Inject constructor(

) : BaseScreenModel<MainScreenState, Nothing>(MainScreenState()) {

    fun selectByIndex(index: Int): Tab {
        setState {
            state.value.copy(
                selectedPosition = index
            )
        }

        val screenEnum = BottomBarScreenEnum.getFromInt(index)

        return when (screenEnum) {
            BottomBarScreenEnum.Search -> SearchTab
            BottomBarScreenEnum.Favourite -> FavouriteTab
            BottomBarScreenEnum.Responses -> ResponsesTab
            BottomBarScreenEnum.Messages -> MessagesTab
            BottomBarScreenEnum.Profile -> ProfileTab
        }
    }

}