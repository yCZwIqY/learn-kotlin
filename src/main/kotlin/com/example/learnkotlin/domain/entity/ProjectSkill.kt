package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id", nullable = false)
    var id: Long? = null
}