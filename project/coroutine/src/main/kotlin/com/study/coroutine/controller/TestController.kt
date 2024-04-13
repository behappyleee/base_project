package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {

    @GetMapping("/call/test")
    fun test(): String {
        // Thread.sleep(10000)
        return "call test String !"
    }
}