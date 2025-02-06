package ru.my.search.impl.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.internal.BackHandler
import kotlinx.coroutines.Job
import ru.my.base.api.extensions.singleAction
import ru.my.navigation.SharedScreen
import ru.my.search.impl.presentation.search.components.SearchScreenContent

class SearchScreen : Screen {

    @OptIn(InternalVoyagerApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SearchScreenModel>()
        val state by screenModel.state.collectAsState()
        val job = remember { mutableStateOf<Job?>(null) }

        BackHandler(enabled = state.isShowingAll) {
            screenModel.onBackClick()
        }

        SearchScreenContent(
            vacancies = state.vacancies,
            recommendations = state.recommendations,
            onBackClick = remember { { screenModel.onBackClick() } },
            onMoreVacanciesClick = remember { { screenModel.onMoreVacanciesClick() } },
            isShowingAll = state.isShowingAll,
            onRecommendationClick = {},
            onVacancyFavouriteClick = remember {
                { index ->
                    job.value = job.value.singleAction {
                        screenModel.onVacancyFavouriteClick(index)
                    }
                }
            },
            onVacancyRespondClick = {},
            onVacancyBlockClick = remember {
                {
                    val screen = ScreenRegistry.get(SharedScreen.DetailVacancy)
                    navigator.push(screen)
                }
            },
            onMapClick = {},
            onByCorrespondenceClick = {},
        )
    }
}