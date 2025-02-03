package ru.my.mainscreen.impl.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ru.my.navigation.SharedScreen
import ru.my.uicommon.R

object ResponsesTab : Tab {

    private fun readResolve(): Any = ResponsesTab

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = stringResource(R.string.responses),
            icon = painterResource(id = R.drawable.ic_letter)
        )

    @Composable
    override fun Content() {
        Navigator(screen = ScreenRegistry.get(SharedScreen.Main.Responses))
    }
}