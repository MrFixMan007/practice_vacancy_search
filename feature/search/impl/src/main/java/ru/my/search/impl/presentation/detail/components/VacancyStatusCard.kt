package ru.my.search.impl.presentation.detail.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.search.impl.R
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.extensions.humanPluralString

@Composable
fun VacancyStatusCard(
    text: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier.width(110.dp),
            text = text,
            style = LocalTypography.current.text1,
            color = LocalColors.current.basicColors.white
        )
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Composable
@Preview
private fun VacancyStatusCardPreview() {
    VacancySearchTheme {
        VacancyStatusCard(
            modifier = Modifier
                .height(50.dp)
                .background(
                    color = LocalColors.current.specialColors.darkGreen,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp),
            text = stringResource(
                id = R.string.people_watching_count,
                "5 ${5.humanPluralString()}"
            ),
            iconRes = ru.my.uicommon.R.drawable.ic_green_eye
        )
    }
}