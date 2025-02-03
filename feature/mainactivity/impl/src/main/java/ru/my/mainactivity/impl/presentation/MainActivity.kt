package ru.my.mainactivity.impl.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import dagger.hilt.android.AndroidEntryPoint
import ru.my.mainactivity.impl.presentation.components.MyBottomBar
import ru.my.mainactivity.impl.presentation.model.SearchTab
import ru.my.theme.LocalColors
import ru.my.theme.VacancySearchTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val snackbarHostState = remember { SnackbarHostState() }

            val viewModel: BottomBarViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            VacancySearchTheme(
                snackbarHostState = snackbarHostState
            ) {
                TabNavigator(SearchTab) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .navigationBarsPadding(),
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
                                        val tab = viewModel.selectByIndex(it)
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
    }
}