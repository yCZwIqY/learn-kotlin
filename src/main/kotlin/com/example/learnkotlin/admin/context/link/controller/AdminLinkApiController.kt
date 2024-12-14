package com.example.learnkotlin.admin.context.link.controller

import com.example.learnkotlin.admin.context.link.form.LinkForm
import com.example.learnkotlin.admin.context.link.service.AdminLinkService
import com.example.learnkotlin.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/link")
class AdminLinkApiController(
    private val adminLinkService: AdminLinkService
) {
    @PostMapping
    fun postLink(@RequestBody @Validated linkForm: LinkForm): ResponseEntity<Any> {
        adminLinkService.save(linkForm)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putLink(@PathVariable id: Long, @RequestBody linkForm: LinkForm): ResponseEntity<Any> {
        adminLinkService.update(id, linkForm)
        return ApiResponse.successUpdate()
    }
}