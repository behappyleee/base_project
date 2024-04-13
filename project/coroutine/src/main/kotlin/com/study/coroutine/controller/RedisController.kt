package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RedisController {

    @GetMapping("/test/redis")
    fun stringTest(): String {

        return "THIS IS TEST REDIS !"
    }


}