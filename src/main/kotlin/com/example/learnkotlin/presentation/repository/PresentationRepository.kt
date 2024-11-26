package com.example.learnkotlin.presentation.repository

import com.example.learnkotlin.domain.entity.*
import com.example.learnkotlin.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements(): List<Achievement> = achievementRepository.findAllByIsActive(true)
    fun getActiveIntroduction(): List<Introduction> = introductionRepository.findAllByIsActive(true)
    fun getActiveLinks(): List<Link> = linkRepository.findAllByIsActive(true)
    fun getActiveSkills(): List<Skill> = skillRepository.findAllByIsActive(true)
    fun getActiveProjects(): List<Project> = projectRepository.findAllByIsActive(true)
    fun getActiveExperiences(): List<Experience> = experienceRepository.findAllByIsActive(true)
}