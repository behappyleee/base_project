package com.example.kotlin_book.chapter_1

class KotlinInitTest (
    private val test1: String,
    private val test2: String,
){
    lateinit var aaTest: String

    val testCheck1 = test1;
    val testCheck2 = {
        aaTest = "asdasd"

        println("TEST CHECK ! $test2")
        test2
    }

}

fun main(args: Array<String>) {

    // by lazy 를 사용하면 name 참조를 최초로 사용하는 시점에 getNameTest() 함수를 호출
    val name: String by lazy { getNameTest() }

    val nameReference: String by lazy (::getNameTest)

}

fun getNameTest(): String {

    return "GET NAME TEST CHECK !!!"
}

