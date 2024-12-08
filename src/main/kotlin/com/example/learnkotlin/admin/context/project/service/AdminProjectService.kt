package com.example.learnkotlin.admin.context.achievement.service

import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.admin.exception.AdminBadRequestException
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.entity.ExperienceDetail
import com.example.learnkotlin.domain.repository.ExperienceRepository
import com.example.learnkotlin.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {

    fun getExperienceTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getDetailExperienceTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }
}