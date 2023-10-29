package com.board.back.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/check/test")
    fun test(): String {
        return "Check Test Pass";
    }

}