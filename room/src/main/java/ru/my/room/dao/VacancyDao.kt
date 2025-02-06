package ru.my.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.my.room.entity.VacancyEntity

@Dao
interface VacancyDao {
    @Query("SELECT * FROM vacancy")
    suspend fun getVacancies(): List<VacancyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(user: VacancyEntity)

    @Query("DELETE FROM vacancy WHERE id = :id")
    suspend fun deleteById(id: Int)

}
