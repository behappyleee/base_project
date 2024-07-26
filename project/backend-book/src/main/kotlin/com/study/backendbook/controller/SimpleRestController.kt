package com.study.backendbook.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleRestController {

    @GetMapping("/")
    fun hello(): String {
        return "Hello !"
    }

    @GetMapping("/bye")
    fun bye(): String {
        return "Bye !"
    }

    @GetMapping("/html/test")
    fun html(): String {
        return "<h1>Hello This is world !</h1>"
    }

}
