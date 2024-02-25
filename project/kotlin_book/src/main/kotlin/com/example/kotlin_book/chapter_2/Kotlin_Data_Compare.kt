package com.example.kotlin_book.chapter_2

class Kotlin_Data_Compare {

}

fun main(args: Array<String>) {
    val test1 = "TEST1"
    val test2 = "TEST1"

    // 참조 동일성 비교 identity
    println(test1 == test2)

    // 참조 동등성 비교 equality
    println(test1 === test2)

    val obj1 = ObjectTest(name = "AA")
    val obj2 = ObjectTest(name = "AA")

    // 참조 동일성 비교 identity
    println(obj1 == obj2)

    // 참조 동등성 비교 equality
    println(obj1 === obj2)

    println(obj1.equals(obj2))

    val aaList = listOf("333")
    val ass:List<Any> = aaList

    val aaMuta = mutableListOf("sdsd")
    // Compile 오류 해당 코드가 컴파일이 되면 문자열 List 에 Int 를 집어넣을 수 도 있음
    // val aasM: MutableList<Any> = aaMuta

    // 자바에서는 파라미터화한 타입이 파라미터 타입에 대해 무공변성 이다.
    // 즉 A 가 B 의 부모 타입이라 하더라도 List<A>, List<B> 와 사이에는 아무런 부모 자식 타입 관계가 성립 하지 않음


}

class ObjectTest(
    private val name: String,
)
