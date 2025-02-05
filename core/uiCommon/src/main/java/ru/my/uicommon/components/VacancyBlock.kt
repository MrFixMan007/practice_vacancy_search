package ru.my.uicommon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R
import ru.my.uicommon.extensions.humanPluralString
import ru.my.uicommon.extensions.iconClickable

@Composable
fun VacancyBlock(
    modifier: Modifier = Modifier,
    title: String,
    addressTown: String,
    company: String,
    experience: String,
    publishedDate: String,
    lookingNumber: Int?,
    isFavourite: Boolean,
    onFavouriteClick: () -> Unit,
    onRespondClick: () -> Unit,
    onBlockClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(LocalColors.current.basicColors.grey1)
            .clickable { onBlockClick() }
            .padding(16.dp)
    ) {
        if (isFavourite) {
            Icon(
                modifier = Modifier
                    .iconClickable { onFavouriteClick() }
                    .align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.ic_heart_active),
                contentDescription = null,
                tint = LocalColors.current.specialColors.blue,
            )
        } else {
            Icon(
                modifier = Modifier
                    .iconClickable { onFavouriteClick() }
                    .align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = null,
                tint = LocalColors.current.basicColors.grey4,
            )
        }

        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                lookingNumber?.let {
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = stringResource(
                            id = R.string.looking_people_count,
                            it,
                            it.humanPluralString()
                        ),
                        style = LocalTypography.current.text1,
                        color = LocalColors.current.specialColors.green
                    )
                }
            }

            Text(
                text = title,
                style = LocalTypography.current.title3,
                color = LocalColors.current.basicColors.white
            )

            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = addressTown,
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.white
            )

            Row(
                modifier = Modifier.padding(top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = company,
                    style = LocalTypography.current.text1,
                    color = LocalColors.current.basicColors.white
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_mark),
                    contentDescription = null,
                    tint = LocalColors.current.basicColors.grey3
                )
            }

            Row(
                modifier = Modifier.padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_expirience),
                    contentDescription = null,
                    tint = LocalColors.current.basicColors.white
                )
                Text(
                    text = experience,
                    style = LocalTypography.current.text1,
                    color = LocalColors.current.basicColors.white
                )
            }

            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = stringResource(id = R.string.published_date, publishedDate),
                style = LocalTypography.current.text1,
                color = LocalColors.current.basicColors.grey3
            )

            AlphaButton(
                text = stringResource(id = R.string.respond),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(32.dp),
                onClick = onRespondClick
            )
        }
    }
}

@Composable
@Preview
private fun VacancyBlockPreview() {
    VacancySearchTheme {
        var isFavourite = remember { false }
        VacancyBlock(
            modifier = Modifier.fillMaxWidth(),
            title = "UI/UX Designer",
            addressTown = "Минск",
            company = "Мобирикс",
            experience = "Опыт от 1 года до 3 лет",
            publishedDate = "20 февраля",
            lookingNumber = 16,
            isFavourite = isFavourite,
            onFavouriteClick = remember { { isFavourite = !isFavourite } },
            onRespondClick = {},
            onBlockClick = {},
        )
    }
}

@Composable
@Preview
private fun VacancyBlockNoNumberLikedPreview() {
    VacancySearchTheme {
        var isFavourite = remember { true }
        VacancyBlock(
            modifier = Modifier.fillMaxWidth(),
            title = "UI/UX Designer",
            addressTown = "Минск",
            company = "Мобирикс",
            experience = "Опыт от 1 года до 3 лет",
            publishedDate = "20 февраля",
            lookingNumber = null,
            isFavourite = isFavourite,
            onFavouriteClick = remember { { isFavourite = !isFavourite } },
            onRespondClick = {},
            onBlockClick = {},
        )
    }
}