package ru.my.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

interface SharedScreen : ScreenProvider {
    object Auth : ScreenProvider
    data class CodeInput(
        val email: String,
    ) : ScreenProvider

    object MainHost : ScreenProvider
    object DetailVacancy : ScreenProvider

    sealed class Main : ScreenProvider {
        data object Search : Main()
        data object Favourite : Main()
        data object Responses : Main()
        data object Messages : Main()
        data object Profile : Main()
    }
}