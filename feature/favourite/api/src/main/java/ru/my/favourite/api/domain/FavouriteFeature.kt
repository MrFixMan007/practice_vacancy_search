package ru.my.favourite.api.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry

interface FavouriteFeature {

    val featureFavouriteScreenModule: ScreenRegistry.() -> Unit
}