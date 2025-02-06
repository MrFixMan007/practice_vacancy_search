package ru.my.search.impl.presentation.search

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.base.api.screenmodel.model.UIState
import ru.my.search.impl.domain.model.Recommendation
import ru.my.search.impl.domain.model.RecommendationType
import ru.my.search.impl.domain.model.VacancyShort

@Immutable
data class SearchScreenState(
    val vacancies: ImmutableList<VacancyShort> = persistentListOf(
        VacancyShort(
            id = 0,
            title = "UI/UX Designer",
            addressTown = "Минск",
            company = "Мобирикс",
            experience = "Опыт от 1 года до 3 лет",
            publishedDate = "20 февраля",
            lookingNumber = null,
            isFavourite = false,
        ),
        VacancyShort(
            id = 1,
            title = "Android-developer",
            addressTown = "Москва",
            company = "Мобидик",
            experience = "Опыт от 1 года до 5 лет",
            publishedDate = "25 февраля",
            lookingNumber = 4,
            isFavourite = false,
        ),
        VacancyShort(
            id = 2,
            title = "IOS-developer",
            addressTown = "Саратов",
            company = "УрСофт",
            experience = "Опыт от 1 года до 3 лет",
            publishedDate = "24 июня",
            lookingNumber = 6,
            isFavourite = false,
        ),
        VacancyShort(
            id = 3,
            title = "Project manager",
            addressTown = "Санкт-Петербург",
            company = "БраФост",
            experience = "Опыт от 1 года до 3 лет",
            publishedDate = "2 декабря",
            lookingNumber = 3,
            isFavourite = false,
        )
    ),
    val recommendations: ImmutableList<Recommendation> = persistentListOf(
        Recommendation(
            iconRex = null,
            recommendationType = RecommendationType.NearVacancies,
            title = "Вакансии рядом с вами",
            buttonText = null,
        ),
        Recommendation(
            iconRex = ru.my.uicommon.R.drawable.ic_star,
            recommendationType = RecommendationType.LevelUpResume,
            title = "Поднять резюме в поиске",
            buttonText = "Поднять",
        ),
        Recommendation(
            iconRex = ru.my.uicommon.R.drawable.ic_vacancy,
            recommendationType = RecommendationType.TemporaryJob,
            title = "Временная работа и подработка",
            buttonText = null,
        ),
    ),
    val isShowingAll: Boolean = false,
) : UIState