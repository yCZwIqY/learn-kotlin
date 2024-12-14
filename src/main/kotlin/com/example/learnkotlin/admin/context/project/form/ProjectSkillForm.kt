package com.example.learnkotlin.admin.context.project.form

import jakarta.validation.constraints.NotBlank

class ProjectSkillForm(
    @field:NotBlank(message = "필수값입니다.")
    val project: String,
    @field:NotBlank(message = "필수값입니다.")
    val skill: String,
)