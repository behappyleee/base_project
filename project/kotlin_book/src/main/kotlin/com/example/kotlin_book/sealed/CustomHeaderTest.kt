package com.example.kotlin_book.sealed

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomHeaderTest {

    @GetMapping("/custom-header")
    fun headerTest(
        @RequestHeader("CUSTOM") customHeader: String,
    ): String {
        println("CUSTOM HEADER TEST : $customHeader")
        return "Custom Header Test !"
    }
}
