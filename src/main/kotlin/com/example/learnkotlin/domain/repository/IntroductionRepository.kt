package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>