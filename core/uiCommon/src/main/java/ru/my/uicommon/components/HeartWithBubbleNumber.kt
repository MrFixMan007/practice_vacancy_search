package ru.my.uicommon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
internal fun HeartWithBubbleNumber(
    iconColor: Color,
    number: Int? = null,
) {
    Box(modifier = Modifier.size(24.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = null,
            tint = iconColor
        )
        if (number != null && number != 0) {
            val count = if (number < 999) "$number" else "999"
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(shape = CircleShape)
                    .background(color = LocalColors.current.specialColors.red)
                    .align(Alignment.TopEnd)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = count, style = LocalTypography.current.number,
                    color = LocalColors.current.basicColors.white
                )
            }
        }
    }
}

@Composable
@Preview
private fun HeartPreview() {
    VacancySearchTheme {
        HeartWithBubbleNumber(LocalColors.current.specialColors.blue)
    }
}

@Composable
@Preview
private fun HeartWithNumberPreview() {
    VacancySearchTheme {
        HeartWithBubbleNumber(
            number = 13,
            iconColor = LocalColors.current.basicColors.grey4
        )
    }
}
