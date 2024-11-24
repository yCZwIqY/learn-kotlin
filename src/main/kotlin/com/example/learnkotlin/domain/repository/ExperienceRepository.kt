package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Experience
import com.example.learnkotlin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Experience>
}