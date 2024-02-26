package com.example.kotlin_book.chapter_3

class UseableFunction {
    // Kotlin 함수 재활용 하기 !
    // 함수를 쉽게 재사용 하려면 타입 파라미터를 사용하는 다형적 함수로 만들면 됨


}

fun main(args: Array<String>) {

    val aaa: (String) -> Int = { num -> num.toInt() + 7 }
    val bbb: (Int) -> String = { num -> num.toString() }

    val ccc = compose<Int, String, Int>(
        f = aaa,
        g = bbb,
    )

    println(ccc)
    println(ccc(33))

}

// 함수를 쉽게 재 사용하기 위하여서는 타입 파라미터를 사용하는 다형적 함수로 생성
// 파라미터화 한 타입을 사용시에는 강력한 타입 시스템이 어떤 이점을 제공하는 지 볼 수 있다.
// 타입 파라미터를 사용 시 compose 함수를 모든 타입에 대해 작동하도록 정의가 가능 Int 버전과 달리 절대 그 구현이 잘 못 되지 않음
// f 와 g 를 뒤 바꾼다면 이 소스는 Compile 되지 않는다.
fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }