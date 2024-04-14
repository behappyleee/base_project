package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.LinkedList

@RestController
class RedisController {

    @GetMapping("/test/redis")
    fun stringTest(): String {
        val aaa = 300

        return "THIS IS TEST REDIS !"
    }


}