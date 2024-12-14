package com.example.learnkotlin.admin.context.skill.controller

import com.example.learnkotlin.admin.context.skill.form.SkillForm
import com.example.learnkotlin.admin.context.skill.service.AdminSkillService
import com.example.learnkotlin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/skill")
class AdminSkillApiController(
    private val adminSkillService: AdminSkillService
) {
    @PostMapping
    fun postSkill(@RequestBody @Validated skillForm: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(skillForm)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putSkill(@PathVariable id: Long, @RequestBody skillForm: SkillForm): ResponseEntity<Any> {
        adminSkillService.update(id, skillForm)
        return ApiResponse.successUpdate()
    }
}