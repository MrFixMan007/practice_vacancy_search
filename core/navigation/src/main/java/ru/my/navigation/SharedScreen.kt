package ru.my.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

interface SharedScreen : ScreenProvider {
    object Auth : ScreenProvider
}