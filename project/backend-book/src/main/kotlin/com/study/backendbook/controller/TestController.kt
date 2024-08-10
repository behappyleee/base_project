package com.study.backendbook.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    // OPTIONS HTTP METHOD 를 사용하여 API 조회 시
    // Allow GET,HEAD,POST,PUT,PATCH,DELETE,OPTIONS
    @RequestMapping("/request-mapping")
    fun requestMappin(): String {
        return "This is Request Mapping !"
    }

    // OPTIONS HTTP METHOD 를 사용하여 API 조회 시
    // Allow GET,HEAD, OPTIONS
    @GetMapping("/get-mapping")
    fun getMapping(): String {
        return "This is Get Mapping !"
    }

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "This is Post Mapping !"
    }
}
