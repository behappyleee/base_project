package com.study.springbootboard.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController {

    @GetMapping("/board")
    fun getBoards(): String {
        println("IN THREAD !!!")
        println("THREAD NAME ! : ${Thread.currentThread().name}")
        Thread.sleep(7000)
        return "This is Board !!!"
    }
}