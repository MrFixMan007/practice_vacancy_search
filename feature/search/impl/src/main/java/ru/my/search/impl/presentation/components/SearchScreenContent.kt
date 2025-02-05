package ru.my.search.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.search.impl.R
import ru.my.search.impl.domain.model.Recommendation
import ru.my.search.impl.domain.model.RecommendationType
import ru.my.search.impl.domain.model.Vacancy
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.components.AlphaButton
import ru.my.uicommon.components.RecommendationBlock
import ru.my.uicommon.components.VacancyBlock
import ru.my.uicommon.extensions.vacancyPluralString

@Composable
fun SearchScreenContent(
    vacancies: ImmutableList<Vacancy>,
    recommendations: ImmutableList<Recommendation>,
    isShowingAll: Boolean,
    onMoreVacanciesClick: () -> Unit,
    onBackClick: () -> Unit,
    onRecommendationClick: (index: Int) -> Unit,
    onVacancyFavouriteClick: (index: Int) -> Unit,
    onVacancyRespondClick: (index: Int) -> Unit,
    onVacancyBlockClick: (index: Int) -> Unit,
    onMapClick: () -> Unit,
    onByCorrespondenceClick: () -> Unit,
) {
    val listState = rememberLazyListState()

    LaunchedEffect(isShowingAll) {
        listState.animateScrollToItem(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = LocalColors.current.basicColors.grey2,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (isShowingAll) {
                        Icon(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp))
                                .clickable { onBackClick() }
                                .padding(8.dp),
                            painter = painterResource(id = ru.my.uicommon.R.drawable.ic_left_arrow),
                            contentDescription = null,
                            tint = LocalColors.current.basicColors.grey4
                        )
                    } else {
                        Icon(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp))
                                .padding(8.dp),
                            painter = painterResource(id = ru.my.uicommon.R.drawable.ic_search),
                            contentDescription = null,
                            tint = LocalColors.current.basicColors.grey4
                        )
                    }
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = stringResource(id = R.string.search_tip),
                        style = LocalTypography.current.title3,
                        color = LocalColors.current.basicColors.grey4
                    )
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(LocalColors.current.basicColors.grey2)
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = ru.my.uicommon.R.drawable.ic_filter),
                        contentDescription = null,
                        tint = LocalColors.current.basicColors.grey4
                    )
                }
            }
        },
        bottomBar = {
            if (isShowingAll) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 24.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(LocalColors.current.basicColors.grey2)
                            .clickable { onMapClick() }
                            .padding(12.dp)
                            .align(Alignment.End),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = ru.my.uicommon.R.drawable.ic_map),
                            contentDescription = null,
                            tint = LocalColors.current.basicColors.white
                        )
                        Text(
                            text = stringResource(id = R.string.map),
                            style = LocalTypography.current.title3,
                            color = LocalColors.current.basicColors.white
                        )
                    }
                }
            }
        },
        containerColor = Color.Transparent,
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding()),
            contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding() + 8.dp),
        ) {
            item {
                if (isShowingAll) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${vacancies.size} ${vacancies.size.vacancyPluralString()}",
                            style = LocalTypography.current.text1,
                            color = LocalColors.current.basicColors.white
                        )

                        Row(
                            modifier = Modifier.clickable { onByCorrespondenceClick() },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                        ) {
                            Text(
                                text = stringResource(id = R.string.by_correspondence),
                                style = LocalTypography.current.text1,
                                color = LocalColors.current.specialColors.blue
                            )
                            Icon(
                                painter = painterResource(id = ru.my.uicommon.R.drawable.ic_sort),
                                contentDescription = null,
                                tint = LocalColors.current.specialColors.blue
                            )
                        }
                    }
                } else {
                    LazyRow(
                        modifier = Modifier.height(120.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        itemsIndexed(recommendations) { index, recommendation ->
                            val iconBackColor: Color
                            val iconTint: Color

                            if (recommendation.iconRex == null || recommendation.recommendationType == RecommendationType.NearVacancies) {
                                iconBackColor = LocalColors.current.specialColors.darkBlue
                                iconTint = LocalColors.current.specialColors.blue
                            } else {
                                iconBackColor = LocalColors.current.specialColors.darkGreen
                                iconTint = LocalColors.current.specialColors.green
                            }

                            RecommendationBlock(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(132.dp),
                                title = recommendation.title,
                                buttonText = recommendation.buttonText,
                                iconRex = recommendation.iconRex,
                                iconBackColor = iconBackColor,
                                iconTint = iconTint,
                                onBlockClick = { onRecommendationClick(index) },
                            )
                        }
                    }
                }
            }


            if (!isShowingAll) {
                item {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 32.dp),
                        text = stringResource(id = R.string.vacancies_for_you),
                        style = LocalTypography.current.title2,
                        color = LocalColors.current.basicColors.white
                    )
                }
            }

            itemsIndexed(
                if (vacancies.size > 3 && !isShowingAll) vacancies.subList(
                    0,
                    3
                ) else vacancies
            ) { index, vacancy ->
                VacancyBlock(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp),
                    title = vacancy.title,
                    addressTown = vacancy.addressTown,
                    company = vacancy.company,
                    experience = vacancy.experience,
                    publishedDate = vacancy.publishedDate,
                    lookingNumber = vacancy.lookingNumber,
                    isFavourite = vacancy.isFavourite,
                    onFavouriteClick = { onVacancyFavouriteClick(index) },
                    onRespondClick = { onVacancyRespondClick(index) },
                    onBlockClick = { onVacancyBlockClick(index) }
                )
            }

            if (!isShowingAll) {
                item {
                    val moreVacanciesCount = (vacancies.size - 3).coerceAtLeast(0)

                    AlphaButton(
                        text = stringResource(
                            id = R.string.more_vacancies_count,
                            "$moreVacanciesCount ${moreVacanciesCount.vacancyPluralString()}"
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                            .height(48.dp),
                        isEnabled = true,
                        onClick = onMoreVacanciesClick,
                        textColor = LocalColors.current.basicColors.white,
                        buttonColor = LocalColors.current.specialColors.blue,
                        cornerRadius = 8.dp,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun SearchScreenContentPreview() {
    VacancySearchTheme {
        SearchScreenContent(
            vacancies = persistentListOf(),
            recommendations = persistentListOf(),
            isShowingAll = false,
            onMoreVacanciesClick = {},
            onBackClick = {},
            onRecommendationClick = {},
            onVacancyFavouriteClick = {},
            onVacancyRespondClick = {},
            onVacancyBlockClick = {},
            onMapClick = {},
            onByCorrespondenceClick = {},
        )
    }
}