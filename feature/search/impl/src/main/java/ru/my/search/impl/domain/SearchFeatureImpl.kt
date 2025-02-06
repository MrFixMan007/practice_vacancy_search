package ru.my.search.impl.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import ru.my.navigation.SharedScreen
import ru.my.search.api.domain.SearchFeature
import ru.my.search.impl.presentation.detail.DetailScreen
import ru.my.search.impl.presentation.search.SearchScreen

class SearchFeatureImpl : SearchFeature {

    override val featureMainScreenModule: ScreenRegistry.() -> Unit =
        screenModule {
            register<SharedScreen.Main.Search> { SearchScreen() }
            register<SharedScreen.DetailVacancy> { DetailScreen() }
        }
}