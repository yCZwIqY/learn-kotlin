package com.example.learnkotlin.admin.context.achievement.controller

import com.example.learnkotlin.admin.context.achievement.service.AdminAchievementService
import com.example.learnkotlin.admin.data.DateFormElementDTO
import com.example.learnkotlin.admin.data.FormElementDTO
import com.example.learnkotlin.admin.data.SelectFormElementDTO
import com.example.learnkotlin.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/achievement")
class AdminAchievementViewController(
    private val adminAchievementService: AdminAchievementService,
) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            DateFormElementDTO("achieveDate", 5),
            TextFormElementDTO("host", 5),
            SelectFormElementDTO("isActive", 2, listOf(true.toString())),
        )

        model.addAttribute("formElements", formElements)

        val table = adminAchievementService.getAchievementTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", true),
            Pair("hasDeletable", true),
        )

        model.addAttribute(pageAttributes)

        return "admin/page-table"
    }
}