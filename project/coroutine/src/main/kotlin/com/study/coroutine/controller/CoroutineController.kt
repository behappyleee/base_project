package com.study.coroutine.controller

import com.study.coroutine.service.CoroutineService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CoroutineController(
    private val coroutineService: CoroutineService,
) {

    @GetMapping("/hello")
    fun sayHello(): String {
        coroutineService.findUserById(1)

        return "Hello, Spring Boot with Kotlin !"
    }

    // suspend functin which are the building block of coroutines in Kotlin,
    // No Special configuration is needed for coroutines to work with Spring boot.
    // However ensure your Spring Boot version is compatible with Kotlin Coroutines.
    @GetMapping("/async-data")
    suspend fun getAsyncData(): ResponseEntity<String> {
        logger.debug("GET CURRENT THREAD ! : {} ", Thread.currentThread().name)

        val data = coroutineService.getAsyncData()
        return ResponseEntity.ok(data)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CoroutineController::class.java)
    }

}