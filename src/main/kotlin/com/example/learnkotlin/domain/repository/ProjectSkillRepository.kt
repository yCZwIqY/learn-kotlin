package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long>