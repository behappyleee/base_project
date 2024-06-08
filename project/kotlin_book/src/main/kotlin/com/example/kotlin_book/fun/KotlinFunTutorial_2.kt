package com.example.kotlin_book.`fun`

import com.example.kotlin_book.chapter_2.num

class KotlinFunTutorial_2 {

}

fun main() {

    // 함수 재 사용하기, 함수를 쉽게 재사용을 하려면 타입 파라미터를 사용하는 다형적 polymorphic 함수로 만들면 된다.
    // compose 함수를 타입 파라미터를 사용하는 다형적 함수로 만들라

    val aaa: (String) -> Int = String::length
    val bbb: (Int) -> (String) = Int::toString

    val aaaa= polyCompose2(
        f = aaa,
        g = bbb
    )

    println(aaaa(3))
}

fun myCompose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int {
    // 합성 함수 같은 개념
    return { num -> f(g(num))}
}

// 다형적 함수를 생성 ... !, fun 키워드와 함수 이름 사이에 타입 파라미터를 선언
fun <T> polyCompose(f: (T) -> T, g: (T) ->T): (T) -> T {
   return { f(g(it))}
}

// 다형적 파라미터를 사용 시 훨씬 유연 하고 안전 한 함수 작성이 가능하다.
// 파라미터화 한 타입을 사용할 때 강력한 타입 시스템이 어떤 이점을 제공하는 지도 확인이 가능하다.
// 모든 타입에 대하여 작동하도록 정의를 할 수 있을 뿐 아니라 Int 버전 과 달리 그 구현이 절대 잘못 되지 않는다. f 와 g 를 바꾼다면 컴파일이 되지 않는다.
fun <T, U, V> polyCompose2(f: (V) -> U, g: (T) -> V): (T) -> U {
    return { num -> f(g(num)) }
}
