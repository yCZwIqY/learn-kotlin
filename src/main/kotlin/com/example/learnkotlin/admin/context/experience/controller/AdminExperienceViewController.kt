package com.example.learnkotlin.admin.context.achievement.controller

import com.example.learnkotlin.admin.context.achievement.service.AdminExperienceService
import com.example.learnkotlin.admin.context.achievement.service.AdminProjectService
import com.example.learnkotlin.admin.data.FormElementDTO
import com.example.learnkotlin.admin.data.SelectFormElementDTO
import com.example.learnkotlin.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/experiences")
class AdminExperienceViewController(
    private val adminExperienceService: AdminExperienceService
) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            SelectFormElementDTO("startYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString())),
        )

        model.addAttribute("formElements", formElements)


        val detailFormElements = listOf<FormElementDTO>(
            TextFormElementDTO("content", 10),
            SelectFormElementDTO("isActive", 2, listOf(true.toString())),
        )
        model.addAttribute("detailFormElements", detailFormElements)


        val table = adminExperienceService.getExperienceTable()
        model.addAttribute("table", table)

        val detailTable = adminExperienceService.getDetailExperienceTable(null)
        model.addAttribute("detailTable", detailTable)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", true),
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }


}