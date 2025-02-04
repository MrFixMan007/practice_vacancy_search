package ru.my.mainscreen.impl.presentation

import androidx.compose.runtime.Immutable
import ru.my.base.api.screenmodel.model.UIState

@Immutable
data class MainScreenState(
    val selectedPosition: Int = 0,
    val favouriteVacancyCount: Int? = 999,
) : UIState