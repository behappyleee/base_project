package com.study.springboottest

import kotlin.math.abs
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootTestApplication

fun main(args: Array<String>) {
    runApplication<SpringbootTestApplication>(*args)
}

fun test(test: (ab: String) -> Unit) {
    test("TEST CHECK")
}

fun check() {
    val aaa: (String) -> Unit = {strTest: String -> println(strTest) }
    test(aaa)
}