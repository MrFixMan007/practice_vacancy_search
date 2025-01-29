package ru.my.uicommon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.theme.LocalColors
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R
import ru.my.uicommon.extensions.iconClickable
import ru.my.uicommon.model.BottomBarIcon
import ru.my.uicommon.model.BottomBarIcon.BottomBarIconWithContent
import ru.my.uicommon.model.BottomBarIcon.BottomBarIconWithRes

@Composable
fun BottomBar(
    items: ImmutableList<BottomBarIcon>,
    selectedIndex: Int,
    selectedColor: Color,
    unselectedColor: Color,
    onItemSelected: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(LocalColors.current.shadowColors.shadows)
            .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex

            when (item) {
                is BottomBarIconWithRes -> {
                    IconWithLabel(
                        modifier = Modifier
                            .height(40.dp)
                            .iconClickable { onItemSelected(index) },
                        text = item.text,
                        iconRes = item.iconRes,
                        textColor = if (isSelected) selectedColor else unselectedColor,
                        iconColor = if (isSelected) selectedColor else unselectedColor,
                    )
                }

                is BottomBarIconWithContent -> {
                    IconWithLabel(
                        modifier = Modifier
                            .height(40.dp)
                            .iconClickable { onItemSelected(index) },
                        text = item.text,
                        content = item.content,
                        textColor = if (isSelected) selectedColor else unselectedColor,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun BottomBarPreview() {
    VacancySearchTheme {
        var selectedIndex by remember { mutableStateOf(-1) }

        val selectedColor = LocalColors.current.specialColors.blue
        val defaultColor = LocalColors.current.basicColors.grey4

        val items = persistentListOf(
            BottomBarIconWithRes(
                text = "Поиск",
                iconRes = R.drawable.ic_search
            ),
            BottomBarIconWithContent(
                text = "Избраное",
                content = {
                    HeartWithBubbleNumber(
                        iconColor = if (selectedIndex == 1) selectedColor else defaultColor,
                        number = 5
                    )
                }
            ),
            BottomBarIconWithRes(
                text = "Отклики",
                iconRes = R.drawable.ic_letter
            ),
            BottomBarIconWithRes(
                text = "Сообщения",
                iconRes = R.drawable.ic_comment
            ),
            BottomBarIconWithRes(
                text = "Профиль",
                iconRes = R.drawable.ic_profile
            ),
        )

        BottomBar(
            items = items,
            selectedIndex = selectedIndex,
            selectedColor = selectedColor,
            unselectedColor = defaultColor,
            onItemSelected = {
                selectedIndex = it
            }
        )
    }
}