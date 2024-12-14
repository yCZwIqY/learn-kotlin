package com.example.learnkotlin.admin.context.introduction.controller

import com.example.learnkotlin.admin.context.introduction.form.IntroductionForm
import com.example.learnkotlin.admin.context.introduction.service.AdminIntroductionService
import com.example.learnkotlin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/introduction")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {
    @PostMapping
    fun postIntroduction(@RequestBody @Validated introductionForm: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(introductionForm)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id: Long, @RequestBody introductionForm: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.update(id, introductionForm)
        return ApiResponse.successUpdate()
    }
}