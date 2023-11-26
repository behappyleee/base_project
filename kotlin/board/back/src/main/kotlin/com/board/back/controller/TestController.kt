package com.board.back.controller

import com.board.back.dto.Person
import com.board.back.dto.TestDto
import com.board.back.test.jsonSimple
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    val logger = LoggerFactory.getLogger(TestController::class.java)

    @GetMapping("/check/test")
    fun test(): String {
        return "Check Test Pass";
    }

    @GetMapping("/test/data")
    fun test1(): String {
        logger.info("TEST CHECK : {} ", jsonSimple().getData())
        return "This is TEST"
    }

    @GetMapping("/data")
    fun testData(): TestDto {
        return TestDto(listOf(Person("TEST 1" , 21)
            , Person("TEST 2", 22)
        , Person("TEST 3", 23)))
    }

}