package com.example.learnkotlin.presentation.service

import com.example.learnkotlin.presentation.dto.IntroductionDTO
import com.example.learnkotlin.presentation.dto.LinkDTO
import com.example.learnkotlin.presentation.dto.ProjectDTO
import com.example.learnkotlin.presentation.dto.ResumeDTO
import com.example.learnkotlin.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
        private val presentationRepository: PresentationRepository
) {
    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroduction()

        return introductions.map { IntroductionDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()

        return links.map { LinkDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
                experiences = experiences,
                achievements = achievements,
                skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProject(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }
}