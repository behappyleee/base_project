package com.example.kotlin_book.test

import com.example.kotlin_book.chapter_2.getTest

class KotlinFunctionTest {

}

fun main() {

    b(::a)
    // b(c<String>("sd", ::a))

    c(ObjectTestCheck(name = "TEST 1 !!"), ::getC)

}

data class ObjectTestCheck(
    val name: String,
)

fun a(str : String) {
    println("함수 String : $str")
}

fun b(function: (String) -> Unit) {
    function("B 호출 !!")
}

fun getC(argTest: Any) {
    println("ARGUMENT TO STIRNG : ${argTest.toString()}")
}

fun <T> c(testArgument: T, function: (T) -> Unit) {
    function(testArgument)
}