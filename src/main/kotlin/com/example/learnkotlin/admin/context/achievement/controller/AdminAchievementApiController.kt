package com.example.learnkotlin.admin.context.achievement.controller

import com.example.learnkotlin.admin.context.achievement.form.AchievementForm
import com.example.learnkotlin.admin.context.achievement.service.AdminAchievementService
import com.example.learnkotlin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/api/achievement")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService,
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.save(form)
        return ApiResponse.successCreate()
    }

    @PostMapping("/{id}")
    fun putAchievement(@PathVariable id: Long, @RequestBody form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.update(id, form)

        return ApiResponse.successUpdate()
    }
}