package com.example.learnkotlin.admin.context.project.form

import com.example.learnkotlin.domain.entity.ProjectDetail
import jakarta.validation.constraints.NotBlank

class ProjectDetailForm(
    val id: Long,
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val url: String?,
    val isActive: Boolean,
) {
    fun toEntity(): ProjectDetail {
        return ProjectDetail(
            content = this.content,
            url = this.url,
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): ProjectDetail {
        val projectDetail = this.toEntity()
        projectDetail.id = id

        return projectDetail
    }

}