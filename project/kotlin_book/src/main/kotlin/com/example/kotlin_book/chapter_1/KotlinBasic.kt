package com.example.kotlin_book.chapter_1

class KotlinBasic {

    // Program 은 일반적으로 자신만의 영역이 있는 작은 블록으로 이루어짐, 어떤 언어는 이런 블록을 Procedure
    // 다른 언어에서는 Method 라고 불리는 경우도 많음, Kotlin 에서는 이런 블록을 Function 이라고 함


}

// 참조 투명한 식을 그 결과 값으로 치환해 프로그램을 계산하는 모델을 -> 치환 모델 (Subsitution Model) 이라고 함
fun main(args: Array<String>) {
    // 여기서 mult(2,3) 과 mult(4,5) 를 각각의 반환 값으로 치환을 하여도 프로그램의 전체 의미는 변하지 않음
    val x = add(mult(2, 3), mult(4, 5))
    println(x)
}

fun add(a: Int, b: Int): Int {
    log(String.format("Returning ${a + b} as the Result of $a + $b"))
    return a + b
}

fun mult(a: Int, b: Int) = a * b

fun log(m: String) {
    println(m)
}