package com.example.kotlin_book.chapter_2

class Kotlin_Checked_Exception {

    // 자바와 달리 코틀린에는 Checked Exception 이 없다.
    // 모든 예외는 비검사 Unchecked 예외다.
    // 모든 예외는 비 검사 예외이다.


}

val num: Int = try {
    "3".toInt()
} catch (e: Exception) {
    0
} finally {
    // 이 블록 안에 있는 코드는 항상 실행이 됨 !
}