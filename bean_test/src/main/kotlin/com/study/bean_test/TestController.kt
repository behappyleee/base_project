package com.study.bean_test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController{

    @GetMapping("/test")
    fun hello(): String {
        println("Hello This is In Controller !!")

//        throw RuntimeException("This is In Controller Exception Test !!!", IllegalArgumentException("This is Illegal Argument Exceiption !!"))

        return "Hello World This is kotlin world !!!!"
    }

}
