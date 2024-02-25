package com.example.kotlin_book.chapter_3

class Kotlin_Function {
    
    // 함수는 수학적인 개념 함수는 소스 집합 (정의역, domain), 타깃 집합 (공역, codomain)사이에서 어떤 조건을 만족 시키는 대응 관계
    // 프로그래밍에서는 부분 함수가 중요, 왜냐하면 부분 함수를 전함수로 다루어서 생기는 버그들이 많음
    // 함수는 둘 이상의 소스 집합과 타깃 집합 사이의 대응 관계가 아님, 함수는 인자를 여러개 받을 수 있다
    // 코틀린에서 함수 - 여러 언어에서 메서드는 함수를 표현하는 방식 중 하나

    // 함수는 데이터와 비슷 String 이나 Int 등의 타입이 있는 다른 데이터와 마찬가지로 함수도 타입이 있다
    // 순수 함수는 인자가 같을 때 같은 결과를 돌려주어야 함

    // 프로그래머들은 진정함 함수를 순수 함수라고 부른다. 이와 반대로 진정한 함수가 아닌 함수들은 순수 하지 않은 함수라고 부름
    //

}

fun main(args: Array<String>) {

    val per1 = Person7(name = "TEST")
    val per2 = Person7(name = "TEST")

    println(per1 == per2) // 일반 객체 클래스 동등성 비교 - false
    println(per1.equals(per2))  // equals 를 제대로 구현 하여야 함 동등성 비교를 제대로 하려면 .... !!

    val per3 = Person8(name = "TEST")
    val per4 = Person8(name = "TEST")

    println(per3 == per4) // Data Class 동등성 비교 - true, Data Class 가 아니면 정의 한 equals 에 따라 동등성이 달라짐
    println(per3.equals(per4))  // true data class 는 내부 값으로 equals 를 비교 함 !


}

data class Person8(
    private val name: String,
)

class Person7(
    private val name: String,
)