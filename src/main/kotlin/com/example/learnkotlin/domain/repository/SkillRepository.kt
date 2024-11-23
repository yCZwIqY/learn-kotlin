package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>