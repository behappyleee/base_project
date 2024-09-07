package com.study.backendbook.my

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @PostMapping("/article")
    fun article(
        @RequestParam(name = "post") post: String,
        @RequestParam(name = "title") title: String,
        @RequestParam(name = "content") content: String,
    ): String {
        return "Some Messages $post $title $content"
    }
}
