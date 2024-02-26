package com.example.kotlin_book.chapter_3

class Kotlin_Multi_Arguments {

}

fun main(args: Array<String>) {

    // 인자가 여러개인 함수 처리하기
    // 코틀린에는 Pair 와 Triple 이 미리 정의가 되어 있음

    // 두 정수를 더하는 함수 타입
    val numTest = addFunction(7, 3)

    println(numTest)

}

// 함수 인자의 갯수에는 제한이 없음 원하는 만큼 많은 함수를 정의가 가능
// 두 Int 값을 더하는 함수
val addTest: (Int) -> (Int) -> Int = { a -> {b -> a + b}}

// 타입이름을 짧게 하고 싶으면 type alias 를 사용
typealias addType = (Int) -> (Int) -> Int
val addCheck: addType = { a -> { b -> a + b }}


// Int 는 인자의 타입, (Int) -> Int 는 반환되는 값의 타입
fun addFunction(num1: Int, num2: Int): Int {
    return num1 + num2
}