package com.example.kotlin_book.chapter_3

class Kotlin_Funcation_Reference {
    
    
}

fun main(args: Array<String>) {
    
    // Kotlin 함수 참조
    
}

fun test1(n: Int, a: String): Int = n * 2

val test5: (Int) -> Int = {n -> n + 3}

val test2: (Int) -> Int = { n -> n * 2}

val test3: (Int) -> Int = { test5(it) }

// 함수 참조로도 사용이 가능 !, 함수 참조를 사용하면 더 간단하게 사용이 가능 !
val test4: (Int, String) -> Int = ::test1

val test6: (Int) -> Unit = { n -> println(n) }

fun test8(a :Int) {

}

// val 로 선언한 함수는 안되고 fun 으로 선언함 함수는 참조 변수로 접근이 가능 !
val test7: (Int) -> Unit = ::test8