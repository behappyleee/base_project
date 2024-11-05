package com.study.springbootboard.controller

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController {

    @GetMapping("/board")
    fun getBoards() {

    }
}