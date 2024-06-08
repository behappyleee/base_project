package com.example.kotlin_book.`fun`

import com.example.kotlin_book.chapter_3.square
import com.example.kotlin_book.chapter_3.triple

class KotlinTutorial_1 {

}

fun main() {
    val test: (Int) -> Int = { num ->  num + 30 }
    val testPrintNum = composeCustom(test, 7)

    println(testPrintNum)

    val ttt = composeLambda(::square, ::triple)
    println(ttt(2))

    // 함수 재 사용하기, 함수를 쉽게 재사용을 하려면 타입 파라미터를 사용하는 다형적 polymorphic 함수로 만들면 된다.

}

// 람다를 사용한 해법
fun composeLambda(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }
fun composeLambda2(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }

fun composeFunTest(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int {
    return { f(g(it)) }
}



fun composeTest(a: (Int) -> Int, b: (Int) -> Int): (Int) -> Int {
    return a
}

fun composeCustom(a: (Int) -> Int, b: Int): Int {
   return a(b)
}