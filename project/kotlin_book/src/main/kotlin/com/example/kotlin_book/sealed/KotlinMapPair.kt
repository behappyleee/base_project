package com.example.kotlin_book.sealed

import org.springframework.core.env.Environment

class KotlinMapPair(
    env: Environment,
) {

    // Kotlin Map
    // Map 은 Key 와 Value 로 구성되어있는 dictionary 형태
    // Key Value 에 한번 지정 된 타입은 불변
    // But, Key 와 Value 는 다른 타입이 가능


}

fun <KEY, VALUE> funTest(arg: KEY): KEY {
    return arg
}


fun main() {

    funTest<String, Int>("TEST CHECK")
    val listTest = listOf("TEST1", "TEST2")
    listTest.max()

    val mutalbleMap = mutableMapOf("TEST1" to 1, "TEST2" to 2)
    mutalbleMap["TEST3"] = 3
    mutalbleMap + Pair("TEST7", 7)

    val mapPairTest = mapOf("7" to 7)
    
    // Pair 를 생성 시 보통 to 라는 infix 함수를 사용하여 생성
    val pairTest = "TEST7" to 77    
    
    // mutalbleMap.put(Pair("TEST7"))

    val setTest = setOf("TEST1" to 3, "TEST2" to 2, "TEST2" to 3, "TEST2" to 3)
    println(setTest)

}