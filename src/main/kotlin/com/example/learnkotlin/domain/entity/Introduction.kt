package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Introduction : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id", nullable = false)
    var id: Long? = null
}