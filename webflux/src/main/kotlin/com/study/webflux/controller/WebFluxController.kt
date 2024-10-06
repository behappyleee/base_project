package com.study.webflux.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebFluxController {

    @GetMapping("/my-resource", produces = ["application/json"])
    fun listResources(): List<String> {
        return listOf(
            "TEST 1",
            "TEST 2",
            "TEST 3"
        )
    }
}
