package com.aws.aws_basic.controller

import DeployJarTest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun test(): String {
        println("[THIS IS TEST CONTROLLER TEST METHOD]")

        // 외부 직접 import 한 jar 를 생성
        return DeployJarTest().testFun()
    }

}