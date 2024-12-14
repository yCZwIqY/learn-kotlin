package com.example.learnkotlin.admin.context.experience.form

import com.example.learnkotlin.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

class ExperienceDetailForm(
    val id: Long,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val isActive: Boolean,
) {
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): ExperienceDetail {
        val experienceDetail = this.toEntity()
        experienceDetail.id = id

        return experienceDetail
    }

}