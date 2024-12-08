package com.example.learnkotlin.admin.context.link.controller

import com.example.learnkotlin.admin.context.link.service.AdminLinkService
import com.example.learnkotlin.admin.data.FormElementDTO
import com.example.learnkotlin.admin.data.SelectFormElementDTO
import com.example.learnkotlin.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/link")
class AdminLinkViewController(
    private val adminLinkService: AdminLinkService
) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            TextFormElementDTO("content", 8),
            SelectFormElementDTO("isActive", 2, listOf(true.toString())),
        )

        model.addAttribute("formElements", formElements)

        val table = adminLinkService.getLinkTable()
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