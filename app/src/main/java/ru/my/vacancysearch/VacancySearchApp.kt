package ru.my.vacancysearch

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import dagger.hilt.android.HiltAndroidApp
import ru.my.auth.api.domain.AuthFeature
import ru.my.auth.impl.domain.AuthFeatureImpl

@HiltAndroidApp
class VacancySearchApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val authScreenFeature: AuthFeature = AuthFeatureImpl()

        ScreenRegistry {
            authScreenFeature.featureAuthScreenModule(this)
        }
    }

}