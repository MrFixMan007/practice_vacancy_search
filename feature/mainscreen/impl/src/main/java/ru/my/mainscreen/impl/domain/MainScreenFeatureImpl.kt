package ru.my.mainscreen.impl.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import ru.my.mainscreen.api.domain.MainScreenFeature
import ru.my.mainscreen.impl.presentation.MainScreen
import ru.my.navigation.SharedScreen

class MainScreenFeatureImpl : MainScreenFeature {

    override val featureMainScreenModule: ScreenRegistry.() -> Unit =
        screenModule {
            register<SharedScreen.MainHost> { MainScreen() }
        }

}