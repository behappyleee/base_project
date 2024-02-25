package com.example.kotlin_book.chapter_2

class Kotlin_Control {
    // 코틀린에서 다중 조건 선택하기

}

fun getTest(): String {
    // 코틀린에서는 when 구문을 사용
    val country = "TEST"

    val capital = when(country) {
        "Austrailia" -> "Canberra"
        "Bolivia" -> "Surce"
        "Brazil" -> "Brasilia"
        else -> "Unknow"
    }

    return capital
}