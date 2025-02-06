package ru.my.favourite.impl.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.base.api.domain.model.Vacancy
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.components.VacancyBlock
import ru.my.uicommon.extensions.vacancyPluralString

@Composable
fun FavouriteScreenContent(
    favouriteVacancies: ImmutableList<Vacancy>,
    onFavouriteClick: (index: Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(id = ru.my.uicommon.R.string.favourite),
            style = LocalTypography.current.title2,
            color = LocalColors.current.basicColors.white
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "${favouriteVacancies.size} ${favouriteVacancies.size.vacancyPluralString()}",
            style = LocalTypography.current.text1,
            color = LocalColors.current.basicColors.grey3
        )

        LazyColumn {
            itemsIndexed(favouriteVacancies) { index, vacancy ->
                VacancyBlock(
                    modifier = Modifier.padding(vertical = 16.dp),
                    title = vacancy.title,
                    addressTown = vacancy.address,
                    company = vacancy.company,
                    experience = vacancy.requiredExperience,
                    publishedDate = vacancy.timeline,
                    lookingNumber = 10,
                    isFavourite = true,
                    onFavouriteClick = { onFavouriteClick(index) },
                    onRespondClick = { /*TODO*/ },
                    onBlockClick = { /*TODO*/ }
                )
            }
        }
    }

}

@Composable
@Preview
private fun FavouriteScreenContentPreview() {
    VacancySearchTheme {
        FavouriteScreenContent(
            favouriteVacancies = persistentListOf(
                Vacancy(
                    id = 0,
                    title = "UI/UX Designer",
                    incomeLevel = "Уровень дохода не указан",
                    requiredExperience = "Требуемый опыт: от 1 года до 3 лет",
                    timeline = "Полная занятость, полный день",
                    company = "Мобирикс",
                    address = "Минск, улица Бирюзова, 4/5",
                    companyDescription = """
                        MOBYRIX - динамично развивающаяся продуктовая IT-компания, специализирующаяся на разработке мобильных приложений для iOS и Android. Наша команда работает над собственными продуктами в разнообразных сферах: от утилит до развлечений и бизнес-приложений.
                        Мы ценим талант и стремление к инновациям и в данный момент в поиске талантливого UX/UI Designer, готового присоединиться к нашей команде и внести значимый вклад в развитие наших проектов.
                    """.trimIndent(),
                    jobDescription = """
                        -Проектировать пользовательский опыт, проводить UX исследования;
                        -Разрабатывать адаптивный дизайн интерфейса для мобильных приложений;
                        -Разрабатывать быстрые прототипы для тестирования идеи дизайна и их последующая; интеграция на основе обратной связи от команды и пользователей;
                        -Взаимодействовать с командой разработчиков для обеспечения точной реализации ваших дизайнов;
                        -Анализ пользовательского опыта и адаптация под тренды.
                    """.trimIndent(),
                    questions = persistentListOf(
                        "Где распологается место работы?",
                        "Какой график работы?",
                        "Вакансия открыта?",
                        "Какая оплата труда?",
                    ),
                    peopleRespondedCount = 147,
                    peopleWatchingCount = 2,
                )
            ),
            onFavouriteClick = {},
        )
    }
}