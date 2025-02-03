package ru.my.uicommon.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R
import ru.my.uicommon.extensions.iconClickable

@Composable
fun IconWithLabel(
    text: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
    iconColor: Color = Color.Unspecified,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconColor,
        )
        Text(
            text = text,
            style = LocalTypography.current.tabText,
            color = textColor
        )
    }
}

@Composable
fun IconWithLabel(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
    content: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(content = content)
        Text(
            text = text,
            style = LocalTypography.current.tabText,
            color = textColor
        )
    }
}

@Composable
@Preview
private fun PreviewIconWithLabel() {
    VacancySearchTheme {
        Box(
            modifier = Modifier.size(100.dp),
            contentAlignment = Alignment.Center,
        ) {
            IconWithLabel(
                text = "Поиск",
                iconRes = R.drawable.ic_search,
                modifier = Modifier.iconClickable {},
                textColor = LocalColors.current.specialColors.blue,
                iconColor = LocalColors.current.specialColors.blue
            )
        }
    }
}