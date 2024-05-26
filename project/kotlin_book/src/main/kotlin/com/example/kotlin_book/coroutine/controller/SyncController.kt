package com.example.kotlin_book.coroutine.controller

import com.example.kotlin_book.coroutine.service.SyncService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class SyncController(private val service: SyncService) {

    @GetMapping("/sync")
    fun sync(): String{
        println("Current Thread Active Count: ${Thread.activeCount()}")
        println("[Start Coroutine Service !!!!] Thread Name : ${Thread.currentThread().name}")

        service.syncService()

        println("[After Coroutine Service !!!] Thread Name : ${Thread.currentThread().name}")

        return "Call Success !"
    }

}