package ru.my.room.mapper

import ru.my.base.api.domain.model.Vacancy
import ru.my.room.entity.VacancyEntity
import javax.inject.Inject

class VacancyMapper @Inject constructor() {

    fun fromDataToDomain(entity: VacancyEntity): Vacancy {
        return Vacancy(
            id = entity.id,
            title = entity.title,
            incomeLevel = entity.incomeLevel,
            requiredExperience = entity.requiredExperience,
            timeline = entity.timeline,
            company = entity.company,
            address = entity.address,
            companyDescription = entity.companyDescription,
            jobDescription = entity.jobDescription,
            questions = entity.questions.split("\n"),
            peopleRespondedCount = entity.peopleRespondedCount,
            peopleWatchingCount = entity.peopleWatchingCount,
        )
    }

    fun fromDomainToData(vacancy: Vacancy): VacancyEntity {
        return VacancyEntity(
            title = vacancy.title,
            incomeLevel = vacancy.incomeLevel,
            requiredExperience = vacancy.requiredExperience,
            timeline = vacancy.timeline,
            company = vacancy.company,
            address = vacancy.address,
            companyDescription = vacancy.companyDescription,
            jobDescription = vacancy.jobDescription,
            questions = vacancy.questions.joinToString(separator = "\n"),
            peopleRespondedCount = vacancy.peopleRespondedCount,
            peopleWatchingCount = vacancy.peopleWatchingCount,
        )
    }
}