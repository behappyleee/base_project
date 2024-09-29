package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoroutineBasicController {

    // Coroutine - 실행과 지연을 재개 함으로써 비선점적 멀티태스킹을 위한 서브 루틴을 일반화한
    // 컴퓨터 프로그램의 구성 요소

    @GetMapping("/coroutine/basic")
    fun coroutineBasic() {

    }

    companion object {

    }
}

fun main() {
    val testArray = arrayOf(3, 4, 5, 6)
    println("TEST ARRAY $testArray")

    val test = TestInterface {
        "A"
        "B"
        println("TEST CHECK !!")
        "C"
    }

    println("TEST RESULT : " +  test.test())
    println("TEST 11 $test")

    val cc = test.apply {
        println("SDSD")
        println("SDSD")
        "Sdasd"
    }

    println(cc)

    val reverseStr = reverseString("abcd")
    println(reverseStr)

}

fun reverseString(str: String): String {
    return str
}

fun interface TestInterface {
    fun test(): String
}
