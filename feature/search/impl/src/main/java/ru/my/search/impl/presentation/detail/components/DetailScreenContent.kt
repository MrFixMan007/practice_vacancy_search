package ru.my.search.impl.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R
import ru.my.uicommon.components.AlphaButton
import ru.my.uicommon.extensions.humanPluralString
import ru.my.uicommon.extensions.iconClickable

@Composable
fun DetailScreenContent(
    title: String,
    incomeLevel: String,
    requiredExperience: String,
    timeline: String,
    company: String,
    address: String,
    addressPainter: Painter,
    companyDescription: String,
    jobDescription: String,
    questions: ImmutableList<String>,
    isFavourite: Boolean,
    peopleRespondedCount: Int,
    peopleWatchingCount: Int,
    onBackClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    onRespondClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.iconClickable { onBackClick() },
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = null,
                    tint = LocalColors.current.basicColors.white
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye_opened),
                        contentDescription = null,
                        tint = LocalColors.current.basicColors.white
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null,
                        tint = LocalColors.current.basicColors.white
                    )
                    if (isFavourite) {
                        Icon(
                            modifier = Modifier.iconClickable { onFavouriteClick() },
                            painter = painterResource(id = R.drawable.ic_heart_active),
                            contentDescription = null,
                            tint = LocalColors.current.specialColors.blue
                        )
                    } else {
                        Icon(
                            modifier = Modifier.iconClickable { onFavouriteClick() },
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = null,
                            tint = LocalColors.current.basicColors.white
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding() + 24.dp)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = title,
                style = LocalTypography.current.title1,
                color = LocalColors.current.basicColors.white
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = incomeLevel,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = requiredExperience,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = timeline,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )

            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                VacancyStatusCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .background(
                            color = LocalColors.current.specialColors.darkGreen,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    text = stringResource(
                        id = ru.my.search.impl.R.string.people_responded_count,
                        "$peopleRespondedCount ${peopleRespondedCount.humanPluralString()}"
                    ),
                    iconRes = R.drawable.ic_green_profile
                )

                VacancyStatusCard(
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .background(
                            color = LocalColors.current.specialColors.darkGreen,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    text = stringResource(
                        id = ru.my.search.impl.R.string.people_watching_count,
                        "$peopleWatchingCount ${peopleWatchingCount.humanPluralString()}"
                    ),
                    iconRes = R.drawable.ic_green_eye
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .background(
                        color = LocalColors.current.basicColors.grey2,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = company,
                        style = LocalTypography.current.title3,
                        color = LocalColors.current.basicColors.white
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check_mark),
                        contentDescription = null,
                        tint = LocalColors.current.basicColors.grey3
                    )
                }

                Image(
                    painter = addressPainter,
                    contentDescription = null,
                    modifier = Modifier
                        .height(58.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = address,
                    style = LocalTypography.current.text1,
                    color = LocalColors.current.basicColors.white
                )
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = companyDescription,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(id = ru.my.search.impl.R.string.your_job),
                style = LocalTypography.current.title2,
                color = LocalColors.current.basicColors.white
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = jobDescription,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )

            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = stringResource(id = ru.my.search.impl.R.string.ask_question),
                style = LocalTypography.current.title4,
                color = LocalColors.current.basicColors.white
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = ru.my.search.impl.R.string.ask_question_tip),
                style = LocalTypography.current.title4,
                color = LocalColors.current.basicColors.grey3
            )

            questions.forEachIndexed { index, s ->
                val topPadding = if (index == 0) 16.dp else 8.dp

                Box(
                    modifier = Modifier
                        .padding(top = topPadding)
                        .background(
                            color = LocalColors.current.basicColors.grey2,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                ) {
                    Text(
                        text = s,
                        style = LocalTypography.current.title4,
                        color = LocalColors.current.basicColors.white
                    )
                }
            }

            AlphaButton(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                text = stringResource(id = R.string.respond),
                onClick = onRespondClick,
            )
        }
    }

}

@Composable
@Preview
private fun DetailScreenContentPreview() {
    VacancySearchTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LocalColors.current.basicColors.black)
        ) {
            DetailScreenContent(
                title = "UI/UX Designer",
                incomeLevel = "Уровень дохода не указан",
                requiredExperience = "Требуемый опыт: от 1 года до 3 лет",
                timeline = "Полная занятость, полный день",
                company = "Мобирикс",
                address = "Минск, улица Бирюзова, 4/5",
                addressPainter = painterResource(id = R.drawable.map),
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
                isFavourite = true,
                peopleRespondedCount = 147,
                peopleWatchingCount = 2,
                onFavouriteClick = {},
                onBackClick = {},
                onRespondClick = {}
            )
        }
    }
}