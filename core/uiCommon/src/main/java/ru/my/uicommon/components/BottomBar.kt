package ru.my.uicommon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.theme.LocalColors
import ru.my.theme.VacancySearchTheme
import ru.my.uicommon.R
import ru.my.uicommon.extensions.iconClickable
import ru.my.uicommon.model.BottomBarIcon

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
            val color = if (index == selectedIndex) selectedColor else unselectedColor

            IconWithLabel(
                modifier = Modifier
                    .height(40.dp)
                    .iconClickable { onItemSelected(index) },
                text = item.tab.options.title,
                textColor = color,
            ) {
                item.tab.options.icon?.let { icon ->
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        tint = color
                    )
                    item.additionalContent?.let { content ->
                        Box(modifier = Modifier.matchParentSize(), content = content)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun BottomBarPreview() {
    VacancySearchTheme {
        var selectedIndex by remember { mutableStateOf(0) }

        val selectedColor = LocalColors.current.specialColors.blue
        val defaultColor = LocalColors.current.basicColors.grey4

        val items = persistentListOf(
            BottomBarIcon(
                tab = object : Tab {
                    override val options: TabOptions
                        @Composable
                        get() = TabOptions(
                            index = 0u,
                            title = stringResource(R.string.responses),
                            icon = painterResource(id = R.drawable.ic_letter)
                        )

                    @Composable
                    override fun Content() {
                    }
                }
            )
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