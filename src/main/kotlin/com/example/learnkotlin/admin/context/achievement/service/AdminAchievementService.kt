package com.example.learnkotlin.admin.context.achievement.service

import com.example.learnkotlin.admin.context.achievement.form.AchievementForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.repository.AchievementRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}