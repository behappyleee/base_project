package com.study.springboottest.controller

import com.study.springboottest.entity.User
import com.study.springboottest.service.IUserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserController(
    val userService: IUserService,
){
    // Go to Registration Page
    @GetMapping("/register")
    fun register(): String {
        return "registerUser"
    }

//     Read Form data to save into DB
    @PostMapping("/saveUser")
    fun saveUser(
    @ModelAttribute user: User,
    model: Model,
    ): String {
        val id: Int = userService.saveUser(user)
        val message = "User '$id' saved successfully !"
        model.addAttribute("msg", message)
        return "registerUser"
    }
}

fun main() {
    check()
}

fun test(test: (ab: String) -> Unit) {
    test("TEST CHECK")
}

fun check() {
    val aaa: (String) -> Unit = {strTest: String -> println(strTest) }
    test(aaa)
}