package com.study.testmodule.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import java.time.Duration

@RestController
class RequestController(
    private val webClient: WebClient
) {

    @GetMapping("/hello")
    fun hello(): String {
        webClient.get().uri("/hello")

        val test  = webClient.get().uri("/board")
            .retrieve()
            .bodyToMono(String::class.java)
            .timeout(Duration.ofSeconds(15))
            .block()

        println("TEST $test")
        return "This is Return From The Server ! $test"
    }
}