package com.example.learnkotlin.presentation.controller

import com.example.learnkotlin.presentation.dto.IntroductionDTO
import com.example.learnkotlin.presentation.dto.LinkDTO
import com.example.learnkotlin.presentation.dto.ProjectDTO
import com.example.learnkotlin.presentation.dto.ResumeDTO
import com.example.learnkotlin.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class PresentationApiController(
        private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLink(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }


    @GetMapping("/v1/project")
    fun getProject(): List<ProjectDTO> {
        return presentationService.getProjects()
    }

}