package ru.my.mainscreen.impl.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ru.my.mainscreen.impl.presentation.components.MyBottomBar
import ru.my.mainscreen.impl.presentation.model.SearchTab
import ru.my.theme.LocalColors
import ru.my.theme.LocalSnackbarHostState

class MainScreen : Screen {

    @Composable
    override fun Content() {

        val screenModel = getScreenModel<MainScreenModel>()
        val state by screenModel.state.collectAsState()
        val snackbarHostState = LocalSnackbarHostState.currentOrThrow

        TabNavigator(SearchTab) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = LocalColors.current.basicColors.black,
                snackbarHost = {
                    SnackbarHost(
                        modifier = Modifier
                            .consumeWindowInsets(WindowInsets.navigationBars)
                            .imePadding(),
                        hostState = snackbarHostState,
                        snackbar = { data ->
                            Snackbar(
                                snackbarData = data,
                                containerColor = Color.Red,
                            )
                        },
                    )
                },
                bottomBar = {
                    val tabNavigator = LocalTabNavigator.current
                    MyBottomBar(
                        selectedIndex = state.selectedPosition,
                        favouriteVacancyCount = state.favouriteVacancyCount,
                        onItemSelected = remember {
                            {
                                val tab = screenModel.selectByIndex(it)
                                tabNavigator.current = tab
                            }
                        }
                    )
                }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    CurrentTab()
                }
            }
        }
    }

}