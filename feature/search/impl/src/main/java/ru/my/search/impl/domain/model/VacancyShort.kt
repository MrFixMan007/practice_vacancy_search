package ru.my.search.impl.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class VacancyShort(
    val id: Int,
    val title: String,
    val addressTown: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
    val lookingNumber: Int?,
    val isFavourite: Boolean,
)
