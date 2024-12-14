package com.example.learnkotlin.admin.context.achievement.controller

import com.example.learnkotlin.admin.context.achievement.service.AdminExperienceService
import com.example.learnkotlin.admin.context.experience.form.ExperienceForm
import com.example.learnkotlin.admin.data.ApiResponse
import com.example.learnkotlin.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/experience")
class AdminExperienceApiController(
    private val adminExperienceService: AdminExperienceService
) {

    @PostMapping
    fun postExperience(@RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putExperience(@PathVariable id: Long, @RequestBody form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.update(id, form)
        return ApiResponse.successUpdate()
    }

    @GetMapping("/{id}/details")
    fun getExperienceDetails(@PathVariable id: Long): TableDTO {
        return adminExperienceService.getDetailExperienceTable(id)
    }

}