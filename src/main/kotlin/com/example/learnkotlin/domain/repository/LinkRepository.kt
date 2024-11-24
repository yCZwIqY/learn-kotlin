package com.example.learnkotlin.domain.repository

import com.example.learnkotlin.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {
    fun findByIsActive(isActive: Boolean): List<Link>

}