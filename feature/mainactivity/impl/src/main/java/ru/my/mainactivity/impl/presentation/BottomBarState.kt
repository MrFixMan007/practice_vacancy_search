package ru.my.mainactivity.impl.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class BottomBarState(
    val selectedPosition: Int = 0,
    val favouriteVacancyCount: Int? = 999,
)