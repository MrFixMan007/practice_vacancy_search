package ru.my.auth.api.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry

interface AuthFeature {

    val featureAuthScreenModule: ScreenRegistry.() -> Unit
}