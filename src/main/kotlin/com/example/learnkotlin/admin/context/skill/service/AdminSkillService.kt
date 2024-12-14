package com.example.learnkotlin.admin.context.skill.service

import com.example.learnkotlin.admin.context.skill.form.SkillForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Skill
import com.example.learnkotlin.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(private val skillRepository: SkillRepository) {
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    fun save(form: SkillForm) {
        val skill = form.toEntity()
        skillRepository.save(skill)
    }

    fun update(id: Long, form: SkillForm) {
        val skill = form.toEntity(id)
        skillRepository.save(skill)
    }
}