package com.board.back.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController {

    private val log = LoggerFactory.getLogger(this.javaClass);

    @GetMapping("/hello")
    fun hello(): String {
        log.info("[HELLO CONTROLLER FIRST INCOME]")
        log.info("[HELLO CONTROLLER !!]");
        var testStr: String = "aaa bbb";

        log.info("[HELLO CONTROLLER TEST STR : {}]", testStr);

        log.info("[HELLO CONTROLLER LAST BREAK POINT !!!]");

        return "Hello This is From Kotlin";
    }

}