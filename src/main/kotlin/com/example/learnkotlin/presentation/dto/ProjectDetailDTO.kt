package com.example.learnkotlin.presentation.dto

import com.example.learnkotlin.domain.entity.ProjectDetail

data class ProjectDetailDTO(
        val content: String,
        val url: String?,
) {
    constructor(projectDetail: ProjectDetail) : this(
            content = projectDetail.content,
            url = projectDetail.url)
}