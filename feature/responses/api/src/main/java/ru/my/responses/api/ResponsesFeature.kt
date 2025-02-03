package ru.my.responses.api

import cafe.adriel.voyager.core.registry.ScreenRegistry

interface ResponsesFeature {

    val featureResponsesScreenModule: ScreenRegistry.() -> Unit
}