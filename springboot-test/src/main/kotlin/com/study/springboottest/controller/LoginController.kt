package com.study.springboottest.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/home")
    fun getHomePage(): String {
        return "homePage"
    }

    @GetMapping("/welcome")
    fun getWelcomePage(): String {
        return "welcomePage"
    }

    @GetMapping("/admin")
    fun getAdminPage(): String {
        return "adminPage"
    }

    @GetMapping("/emp")
    fun getEmployeePage(): String {
        return "empPage"
    }

    @GetMapping("/mgr")
    fun getManagerPage(): String {
        return "mgrPage"
    }

    @GetMapping("/hr")
    fun getHrPage(): String {
        return "hrPage"
    }

    @GetMapping("/common")
    fun getCommonPage(): String {
        return "commonPage"
    }

    @GetMapping("/accessDenied")
    fun getAccessDeniedPage(): String {
        return "accessDeniedPage"
    }
}