package ru.my.search.impl.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Recommendation(
    @DrawableRes val iconRex: Int?,
    val recommendationType: RecommendationType,
    val title: String,
    val buttonText: String?,
)
