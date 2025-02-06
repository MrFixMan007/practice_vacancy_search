package ru.my.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancy")
data class VacancyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val incomeLevel: String,
    val requiredExperience: String,
    val timeline: String,
    val company: String,
    val address: String,
    val companyDescription: String,
    val jobDescription: String,
    val questions: String,
    val peopleRespondedCount: Int,
    val peopleWatchingCount: Int,
)