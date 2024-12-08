package com.example.learnkotlin.admin.context.skill.controller

import com.example.learnkotlin.admin.context.skill.service.AdminSkillService
import com.example.learnkotlin.admin.data.FormElementDTO
import com.example.learnkotlin.admin.data.SelectFormElementDTO
import com.example.learnkotlin.admin.data.TextFormElementDTO
import com.example.learnkotlin.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminSkillViewController(
    private val skillService: AdminSkillService
) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            SelectFormElementDTO("type", 2,  SkillType.entries.map { it.name }.toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString())),
        )

        model.addAttribute("formElements", formElements)

        val table = skillService.getSkillTable()
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