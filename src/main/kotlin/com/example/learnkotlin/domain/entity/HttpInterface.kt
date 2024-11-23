package com.example.learnkotlin.domain.entity

import jakarta.persistence.*

@Entity
class HttpInterface : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id", nullable = false)
    var id: Long? = null
}