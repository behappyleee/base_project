package com.example.kotlin_book.chapter_1

import com.example.kotlin_book.function.koCustomFun

class KoExtenstionFunTest {

}

fun main() {
    // 확장 함수를 다른 패키지 에서도 사용이 가능 !
    val cc = listOf(3,3,34)
    print( cc.koCustomFun())

}