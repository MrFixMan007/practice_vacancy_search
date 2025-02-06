package ru.my.favourite.impl.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.Job
import ru.my.base.api.extensions.singleAction
import ru.my.favourite.impl.presentation.components.FavouriteScreenContent

class FavouriteScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<FavouriteScreenModel>()
        val state by screenModel.state.collectAsState()
        val job = remember { mutableStateOf<Job?>(null) }

        LaunchedEffect(Unit) {
            screenModel.init()
        }

        FavouriteScreenContent(
            favouriteVacancies = state.favouriteVacancies,
            onFavouriteClick = remember {
                { index ->
                    job.value = job.value.singleAction {
                        screenModel.onVacancyFavouriteClick(index)
                    }
                }
            }
        )
    }
}