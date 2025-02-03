package ru.my.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

interface SharedScreen : ScreenProvider {
    object Auth : ScreenProvider
    data class CodeInput(
        val email: String,
    ) : ScreenProvider

    sealed class Global : ScreenProvider {
        data object Search : Global()
        data object Favourite : Global()
        data object Responses : Global()
        data object Messages : Global()
        data object Profile : Global()
    }
}