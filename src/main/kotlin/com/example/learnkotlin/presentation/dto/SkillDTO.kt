package com.example.learnkotlin.presentation.dto

import com.example.learnkotlin.domain.entity.Skill

data class SkillDTO(
        val name: String,
        val type: String
) {
    constructor(skill: Skill) : this(
            name = skill.name,
            type = skill.type.name
    )
}