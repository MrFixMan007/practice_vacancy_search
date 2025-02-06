package ru.my.search.impl.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.Job
import ru.my.base.api.extensions.singleAction
import ru.my.search.impl.presentation.detail.components.DetailScreenContent

class DetailScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<DetailScreenModel>()
        val state by screenModel.state.collectAsState()
        val job = remember { mutableStateOf<Job?>(null) }

        DetailScreenContent(
            title = state.title,
            incomeLevel = state.incomeLevel,
            requiredExperience = state.requiredExperience,
            timeline = state.timeline,
            company = state.company,
            address = state.address,
            addressPainter = painterResource(id = state.addressPainterRes),
            companyDescription = state.companyDescription,
            jobDescription = state.jobDescription,
            questions = state.questions,
            isFavourite = state.isFavourite,
            peopleRespondedCount = state.peopleRespondedCount,
            peopleWatchingCount = state.peopleWatchingCount,
            onBackClick = remember { { navigator.pop() } },
            onFavouriteClick = remember {
                {
                    job.value = job.value.singleAction {
                        screenModel.onFavouriteClick()
                    }
                }
            },
            onRespondClick = {},
        )
    }

}