package ru.my.uicommon.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R

@Composable
fun RecommendationBlock(
    modifier: Modifier = Modifier,
    title: String,
    buttonText: String?,
    @DrawableRes iconRex: Int?,
    iconTint: Color,
    iconBackColor: Color,
    onBlockClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(LocalColors.current.basicColors.grey1)
            .clickable { onBlockClick() }
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(color = iconBackColor, shape = CircleShape)
        ) {
            iconRex?.let {
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = iconTint
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title,
            style = LocalTypography.current.title4,
            color = LocalColors.current.basicColors.white,
            softWrap = true,
            maxLines = if (buttonText != null) 2 else 3
        )
        buttonText?.let {
            Text(
                text = it,
                style = LocalTypography.current.text1,
                color = LocalColors.current.specialColors.green,
            )
        }
    }
}

@Composable
@Preview
private fun RecommendationBlockGreenPreview() {
    VacancySearchTheme {
        RecommendationBlock(
            modifier = Modifier.size(width = 132.dp, height = 120.dp),
            title = "Поднять резюме в поиске на расстоянии 5 метров",
            buttonText = null,
            iconRex = R.drawable.ic_star,
            iconTint = LocalColors.current.specialColors.green,
            iconBackColor = LocalColors.current.specialColors.darkGreen,
            onBlockClick = {}
        )
    }
}

@Composable
@Preview
private fun RecommendationBlockWithButtonNoIconPreview() {
    VacancySearchTheme {
        RecommendationBlock(
            modifier = Modifier.size(width = 132.dp, height = 120.dp),
            title = "Поднять резюме в поиске на расстоянии 5 метров",
            buttonText = "Поднять",
            iconRex = null,
            onBlockClick = {},
            iconTint = LocalColors.current.specialColors.blue,
            iconBackColor = LocalColors.current.specialColors.darkBlue,
        )
    }
}
