package ru.my.search.api.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry

interface SearchFeature {

    val featureMainScreenModule: ScreenRegistry.() -> Unit
}