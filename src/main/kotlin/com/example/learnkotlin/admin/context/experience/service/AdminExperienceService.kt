package com.example.learnkotlin.admin.context.achievement.service

import com.example.learnkotlin.admin.context.experience.form.ExperienceForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.admin.exception.AdminBadRequestException
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.entity.ExperienceDetail
import com.example.learnkotlin.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {

    fun getExperienceTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = experienceRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getDetailExperienceTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) experienceRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }

    fun save(form: ExperienceForm) {
        val experienceDetails = form.details?.map { it.toEntity() }?.toMutableList()
        val experience = form.toEntity()
        experience.addDetails(experienceDetails)

        experienceRepository.save(experience)
    }

    fun update(id: Long, form: ExperienceForm) {
        val experience = experienceRepository.findById(id).orElseThrow {
            throw AdminBadRequestException("ID ${id}에 해당하는 experience가 없습니다.")
        }

        experience.update(
            title = form.title,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive
        )

        val detailMap = experience.details.associateBy { it.id }
        form.details.forEach {
            val entity = detailMap[it.id]
            if(entity != null) {
                entity.update(
                    content = it.content,
                    isActive = it.isActive
                )
            } else {
                experience.details.add(it.toEntity())
            }
        }

    }
}