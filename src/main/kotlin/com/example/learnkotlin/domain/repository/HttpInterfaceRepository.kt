package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime)
}