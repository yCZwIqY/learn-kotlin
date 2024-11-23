package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>