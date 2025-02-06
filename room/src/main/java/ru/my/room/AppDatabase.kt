package ru.my.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.my.room.dao.VacancyDao
import ru.my.room.entity.VacancyEntity

@Database(entities = [VacancyEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vacancyDao(): VacancyDao
}