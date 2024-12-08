package com.example.learnkotlin.admin.context.skill.service

import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Link
import com.example.learnkotlin.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(private val skillRepository: SkillRepository) {
    fun getSkillTable(): TableDTO {
        val classInfo = Link::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}