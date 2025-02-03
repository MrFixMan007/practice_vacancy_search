package ru.my.favourite.impl.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import ru.my.favourite.api.domain.FavouriteFeature
import ru.my.favourite.impl.presentation.FavouriteScreen
import ru.my.navigation.SharedScreen

class FavouriteFeatureImpl : FavouriteFeature {

    override val featureFavouriteScreenModule: ScreenRegistry.() -> Unit =
        screenModule {
            register<SharedScreen.Main.Favourite> { FavouriteScreen() }
        }
}