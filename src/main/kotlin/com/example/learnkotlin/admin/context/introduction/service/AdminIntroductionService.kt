package com.example.learnkotlin.admin.context.introduction.service

import com.example.learnkotlin.admin.context.introduction.form.IntroductionForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository,
) {
    fun getIntroductionTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    fun save(form: IntroductionForm) {
        val introduction = form.toEntity()
        introductionRepository.save(introduction)
    }

    fun update(id: Long, form: IntroductionForm) {
        val introduction = form.toEntity(id)
        introductionRepository.save(introduction)
    }
}