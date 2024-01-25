package com.sample.webflux.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebfluxTestController {

    private val logger = LoggerFactory.getLogger(WebfluxTestController::class.java)

    @GetMapping("/get/test")
    fun testWebflux(): String {

        return "THIS IS SPRING WEB FLUX DATA !!"
    }

}