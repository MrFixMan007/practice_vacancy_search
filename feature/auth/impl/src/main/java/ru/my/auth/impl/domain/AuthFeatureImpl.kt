package ru.my.auth.impl.domain

import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import ru.my.auth.api.domain.AuthFeature
import ru.my.auth.impl.presentation.auth.AuthScreen
import ru.my.auth.impl.presentation.codeinput.CodeInputScreen
import ru.my.navigation.SharedScreen

class AuthFeatureImpl : AuthFeature {

    override val featureAuthScreenModule: ScreenRegistry.() -> Unit =
        screenModule {
            register<SharedScreen.Auth> { AuthScreen() }
            register<SharedScreen.CodeInput> { provider ->
                CodeInputScreen(provider.email)
            }
        }
}