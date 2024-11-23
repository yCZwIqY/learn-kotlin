package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id", nullable = false)
    var id: Long? = null
}