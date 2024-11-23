package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class Link : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id", nullable = false)
    var id: Long? = null
}