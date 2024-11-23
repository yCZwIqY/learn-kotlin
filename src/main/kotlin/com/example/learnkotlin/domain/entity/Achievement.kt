package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Achievement : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id", nullable = false)
    var id: Long? = null
}