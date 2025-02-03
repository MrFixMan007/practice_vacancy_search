package ru.my.mainactivity.impl.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ru.my.navigation.SharedScreen
import ru.my.uicommon.R

object FavouriteTab : Tab {
    private fun readResolve(): Any = FavouriteTab

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = stringResource(R.string.favourite),
            icon = painterResource(id = R.drawable.ic_heart)
        )

    @Composable
    override fun Content() {
        Navigator(screen = ScreenRegistry.get(SharedScreen.Global.Favourite))
    }

}