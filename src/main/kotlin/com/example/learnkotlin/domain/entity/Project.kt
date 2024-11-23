package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Project : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    var id: Long? = null
}