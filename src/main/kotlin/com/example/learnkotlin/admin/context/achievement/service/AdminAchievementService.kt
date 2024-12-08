package com.example.learnkotlin.admin.context.achievement.service

import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Achievement
import com.example.learnkotlin.domain.repository.AchievementRepository
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
}