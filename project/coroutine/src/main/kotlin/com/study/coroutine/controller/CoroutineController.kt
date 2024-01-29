package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CoroutineController {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, Spring Boot with Kotlin !"
    }

}