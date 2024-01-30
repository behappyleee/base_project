package com.study.jwt.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController {

    @GetMapping("/hello")
    fun helloApi(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello This is from Jwt !")
    }

    // Security 를 설정 해주어야 401 Unauthroized 에러가 발생하지 않음


}