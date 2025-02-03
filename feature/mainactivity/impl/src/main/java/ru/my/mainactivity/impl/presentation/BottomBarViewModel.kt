package ru.my.mainactivity.impl.presentation

import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.navigator.tab.Tab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.my.mainactivity.impl.presentation.model.BottomBarScreenEnum
import ru.my.mainactivity.impl.presentation.model.FavouriteTab
import ru.my.mainactivity.impl.presentation.model.MessagesTab
import ru.my.mainactivity.impl.presentation.model.ProfileTab
import ru.my.mainactivity.impl.presentation.model.ResponsesTab
import ru.my.mainactivity.impl.presentation.model.SearchTab
import javax.inject.Inject

@HiltViewModel
class BottomBarViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<BottomBarState> = MutableStateFlow(BottomBarState())
    val state = _state.asStateFlow()

    fun selectByIndex(index: Int): Tab {
        _state.update {
            _state.value.copy(
                selectedPosition = index,
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