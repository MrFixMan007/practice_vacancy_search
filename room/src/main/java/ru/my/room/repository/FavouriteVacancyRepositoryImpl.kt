package ru.my.room.repository

import ru.my.base.api.domain.model.Vacancy
import ru.my.base.api.domain.repository.FavouriteVacancyRepository
import ru.my.room.dao.VacancyDao
import ru.my.room.mapper.VacancyMapper
import javax.inject.Inject

class FavouriteVacancyRepositoryImpl @Inject constructor(
    private val vacancyDao: VacancyDao,
    private val mapper: VacancyMapper,
) : FavouriteVacancyRepository {

    override suspend fun getAll(): List<Vacancy> {
        return vacancyDao.getVacancies().map { entity ->
            mapper.fromDataToDomain(entity)
        }
    }

    override suspend fun insert(vacancy: Vacancy) {
        vacancyDao.insertVacancy(mapper.fromDomainToData(vacancy))
    }

    override suspend fun deleteById(id: Int) {
        vacancyDao.deleteById(id)
    }
}