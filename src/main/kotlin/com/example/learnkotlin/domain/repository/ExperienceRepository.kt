package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>