package com.example.learnkotlin.admin.context.achievement.service

import com.example.learnkotlin.admin.context.project.form.ProjectForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.admin.exception.AdminBadRequestException
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.entity.ProjectDetail
import com.example.learnkotlin.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {

    fun getProjectTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getDetailProjectTable(id: Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }

    fun save(form: ProjectForm) {
        val projectDetails = form.details?.map { it.toEntity() }?.toMutableList()
        val project = form.toEntity()
        project.addDetails(projectDetails)

        projectRepository.save(project)
    }

    fun update(id: Long, form: ProjectForm) {
        val project = projectRepository.findById(id).orElseThrow {
            throw AdminBadRequestException("ID ${id}에 해당하는 project가 없습니다.")
        }

        project.update(
            name = form.name,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive
        )

        val detailMap = project.details.associateBy { it.id }
        form.details.forEach {
            val entity = detailMap[it.id]
            if (entity != null) {
                entity.update(
                    content = it.content,
                    url = it.url,
                    isActive = it.isActive
                )
            } else {
                project.details.add(it.toEntity())
            }
        }

    }
}