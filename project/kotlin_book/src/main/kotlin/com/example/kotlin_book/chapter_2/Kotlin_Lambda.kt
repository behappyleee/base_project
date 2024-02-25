package com.example.kotlin_book.chapter_2

class Kotlin_Lambda {
    // 자바와 마찬가지로 Lambda 는 익명 함수 이다.
    // 익명 함수라는 말은 함수를 가르키는 이름 없으 구현만 있다는 뜻, 코틀린에서는 중괄호 사이에 람다가 위치

}

// 중괄호 사이에 람다가 위치
// Map 코드에서 람다는 마지막 인자일 뿐아니라 유일 한 인자이기에 () 를 없앨 수 있음
fun lambdaTest(list: List<Int>): List<Int> = list.map{ a -> a * 3 }


// 람다의 파라미터 주변에는 괄호를 치지 않음, 코틀린은 람다의 파라미터 타입을 추론 함
fun productLambdaTest(list: List<Int>): Int = list.fold(1) {a, b -> a * b}

fun main(args: Array<String>) {

}