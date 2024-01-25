package com.sample.project.test

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService,
) {

    @GetMapping("/study/test")
    fun study(): String {
        logger.debug("[GET DATA CHECKCKCKC ] : {} ", testService.testService())

        return "Study Test Check !"
    }

    companion object {
        val logger = LoggerFactory.getLogger(TestController::class.java)
    }
}