package com.example.learnkotlin.presentation.dto

import com.example.learnkotlin.domain.entity.Introduction

data class IntroductionDTO(
        val content: String
) {
    constructor(introduction: Introduction) : this(
            content = introduction.content
    )

}