package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpRepository : JpaRepository<HttpInterface, Long>