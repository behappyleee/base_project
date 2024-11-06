package com.study.testmodule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestModuleApplication

fun main(args: Array<String>) {
    runApplication<TestModuleApplication>(*args)
}
