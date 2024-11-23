package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id", nullable = false)
    var id: Long? = null
}