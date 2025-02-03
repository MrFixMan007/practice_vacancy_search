package ru.my.mainactivity.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import ru.my.mainactivity.impl.presentation.model.FavouriteTab
import ru.my.mainactivity.impl.presentation.model.MessagesTab
import ru.my.mainactivity.impl.presentation.model.ProfileTab
import ru.my.mainactivity.impl.presentation.model.ResponsesTab
import ru.my.mainactivity.impl.presentation.model.SearchTab
import ru.my.theme.LocalColors
import ru.my.theme.LocalTypography
import ru.my.uicommon.components.BottomBar
import ru.my.uicommon.model.BottomBarIcon

@Composable
fun MyBottomBar(
    selectedIndex: Int,
    favouriteVacancyCount: Int?,
    onItemSelected: (Int) -> Unit,
) {
    val selectedColor = LocalColors.current.specialColors.blue
    val defaultColor = LocalColors.current.basicColors.grey4

    val items = persistentListOf(
        BottomBarIcon(tab = SearchTab),
        BottomBarIcon(
            tab = FavouriteTab,
            additionalContent = {
                if (favouriteVacancyCount != null && favouriteVacancyCount > 0) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(shape = CircleShape)
                            .background(color = LocalColors.current.specialColors.red)
                            .align(Alignment.TopEnd)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "$favouriteVacancyCount",
                            style = LocalTypography.current.number,
                            color = LocalColors.current.basicColors.white
                        )
                    }
                }
            }),
        BottomBarIcon(tab = ResponsesTab),
        BottomBarIcon(tab = MessagesTab),
        BottomBarIcon(tab = ProfileTab),
    )

    BottomBar(
        items = items,
        selectedIndex = selectedIndex,
        selectedColor = selectedColor,
        unselectedColor = defaultColor,
        onItemSelected = {
            onItemSelected(it)
        }
    )
}