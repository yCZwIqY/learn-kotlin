package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>