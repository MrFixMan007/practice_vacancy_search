package ru.my.base.api.domain.model

data class Vacancy(
    val id: Int,
    val title: String,
    val incomeLevel: String,
    val requiredExperience: String,
    val timeline: String,
    val company: String,
    val address: String,
    val companyDescription: String,
    val jobDescription: String,
    val questions: List<String>,
    val peopleRespondedCount: Int,
    val peopleWatchingCount: Int,
)
