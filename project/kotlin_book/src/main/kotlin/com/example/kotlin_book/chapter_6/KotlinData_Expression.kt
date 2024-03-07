package com.example.kotlin_book.chapter_6

class KotlinData_Expression {

    // 컴퓨터 프로그램에서는 데이터가 존재하지 않는다는 사실을 표현하기는 조금 어렵다.
    // 일반적인 언어에서 null 을 반환하는 것은 가장 나쁜 해법이다.
    // 널을 반환함으로써 자바와 같은 언어에서 벌어진 일을 생각해 보자.

}

fun main() {

    val mapTest = emptyMap<String, Int>()
    val test = mapTest["TEST"]
    println(test)

    val pairTest = Pair("TEST1", 3)
    val pairTest2 = "TEST2" to 7

    println(pairTest)
    println(pairTest2)
    println(pairTest2.toList())

}



