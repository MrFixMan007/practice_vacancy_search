package ru.my.responses.impl.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import ru.my.navigation.SharedScreen
import ru.my.responses.api.ResponsesFeature
import ru.my.responses.impl.presentation.ResponsesScreen

class ResponsesFeatureImpl : ResponsesFeature {

    override val featureResponsesScreenModule: ScreenRegistry.() -> Unit =
        screenModule {
            register<SharedScreen.Global.Responses> { ResponsesScreen() }
        }
}