package com.study.testmodule.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun test(): String {
        println("TEST THREAD NAME !!!! ${Thread.currentThread().name}")
        // Stackoverflow Test !!
        // test()
        return "Hello Hi !"
    }
}
