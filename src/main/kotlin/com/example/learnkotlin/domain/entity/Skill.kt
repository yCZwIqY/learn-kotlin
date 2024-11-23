package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Skill : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    var id: Long? = null
}