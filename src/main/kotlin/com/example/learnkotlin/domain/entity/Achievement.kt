package com.example.learnkotlin.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDateTime,
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id", nullable = false)
    var id: Long? = null

    var title: String = title

    var description: String = description

    var achievedDate: LocalDateTime = achievedDate

    var host: String = host

    var isActive: Boolean = isActive


}