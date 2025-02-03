package ru.my.vacancysearch

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import dagger.hilt.android.HiltAndroidApp
import ru.my.auth.api.domain.AuthFeature
import ru.my.auth.impl.domain.AuthFeatureImpl
import ru.my.favourite.api.domain.FavouriteFeature
import ru.my.favourite.impl.domain.FavouriteFeatureImpl
import ru.my.responses.api.ResponsesFeature
import ru.my.responses.impl.domain.ResponsesFeatureImpl
import ru.my.search.api.domain.SearchFeature
import ru.my.search.impl.domain.SearchFeatureImpl

@HiltAndroidApp
class VacancySearchApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val authScreenFeature: AuthFeature = AuthFeatureImpl()
        val searchScreenFeature: SearchFeature = SearchFeatureImpl()
        val favouriteScreenFeature: FavouriteFeature = FavouriteFeatureImpl()
        val responsesScreenFeature: ResponsesFeature = ResponsesFeatureImpl()

        ScreenRegistry {
            authScreenFeature.featureAuthScreenModule(this)
            searchScreenFeature.featureMainScreenModule(this)
            favouriteScreenFeature.featureFavouriteScreenModule(this)
            responsesScreenFeature.featureResponsesScreenModule(this)
        }
    }

}