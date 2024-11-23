package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Experience : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id", nullable = false)
    var id: Long? = null
}