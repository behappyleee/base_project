package com.sample.study

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinRestController {

    @GetMapping("/hello")
    fun hello():String {
        var getObjectTest = KotlinService();
        getObjectTest.testKotlin();
        return "Hello Kotlin World !";
    }

}