package ru.my.base.api.domain.repository

import ru.my.base.api.domain.model.Vacancy

interface FavouriteVacancyRepository {

    suspend fun getAll(): List<Vacancy>

    suspend fun insert(vacancy: Vacancy)

    suspend fun deleteById(id: Int)

}