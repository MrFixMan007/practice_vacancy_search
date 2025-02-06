package ru.my.favourite.impl.presentation

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.base.api.domain.model.Vacancy
import ru.my.base.api.screenmodel.model.UIState

@Immutable
data class FavouriteScreenState(
    val favouriteVacancies: ImmutableList<Vacancy> = persistentListOf(),
) : UIState