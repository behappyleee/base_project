package com.example.kotlin_book.chapter_3

class Kotlin_Function_Check {

    // 합성 함수 적용

}

fun main(args: Array<String>) {

}

// 합성 함수 사용법 Int -> Int 로 가는 함수
fun composeLambda(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { num -> f(g(num))}

fun composeLambda2(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it))}

fun square(n : Int) = n * n

fun triple(n: Int) = n * 3

val squareOfTriple = composeLambda(::square, ::triple)

// 합성 함수 Int -> Int 로 가는 함수
fun composeTest(num : (Int) -> Int): Int {
    return composeTest(num)
}