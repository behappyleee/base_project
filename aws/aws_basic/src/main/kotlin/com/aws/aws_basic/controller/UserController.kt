package com.aws.aws_basic.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@RequestMapping("/v1/user")
class UserController {

    @GetMapping("/login")
    fun login(): String {

        return "login Test Check";
    }

}

