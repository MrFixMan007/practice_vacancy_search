package ru.my.mainscreen.api.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry

interface MainScreenFeature {

    val featureMainScreenModule: ScreenRegistry.() -> Unit
}