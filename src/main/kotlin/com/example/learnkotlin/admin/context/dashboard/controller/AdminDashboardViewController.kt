package com.example.learnkotlin.admin.context.dashboard.controller

import com.example.learnkotlin.admin.context.dashboard.data.VisitorDTO
import com.example.learnkotlin.admin.context.dashboard.service.AdminDashboardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminDashboardViewController(
    private val adminDashboardService: AdminDashboardService
) {
    @GetMapping
    fun index(model: Model): String {

        val table = adminDashboardService.getHttpInterfaceTable()
        model.addAttribute("table", table)
        val total = adminDashboardService.countVisitorTotal()
        val weekly = adminDashboardService.countVisitorsWeekly()
        val today = adminDashboardService.countVisitorsToday()

        val visitors = listOf(
            VisitorDTO(name = "Total", count = total, color = "#4154f1", background = "#f6f6fe"),
            VisitorDTO(name = "Weekly", count = weekly, color = "#2eca6a", background = "#e0f8e9"),
            VisitorDTO(name = "Today", count = today, color = "#ff771d", background = "#ffecdf"),
        )
        model.addAttribute("visitors", visitors)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "t"),
            Pair("pageName", "Dashboard"),
            Pair("editable", false),
            Pair("deletable", false),
            Pair("hasDeletable", false),
        )

        model.addAttribute(pageAttributes)

        return "admin/index"
    }
}