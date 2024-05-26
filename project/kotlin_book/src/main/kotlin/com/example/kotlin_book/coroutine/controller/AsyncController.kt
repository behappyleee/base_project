package com.example.kotlin_book.coroutine.controller

import com.example.kotlin_book.coroutine.service.AsyncService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class AsyncController(
    private val asyncService: AsyncService
) {

    @GetMapping("/async-1")
    fun testAsync1() {
        println("[Start Async Test 1 !!!!] Thread Name : ${Thread.currentThread().name}")

        asyncService.async1()

        println("[End Async Test 1 !!!] Thread Name : ${Thread.currentThread().name}")
    }
}
