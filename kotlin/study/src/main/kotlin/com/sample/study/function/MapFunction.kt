package com.sample.study.function

fun main() {
    // Kotlin Map Function
    // map 함수는 각 원소를 원하는 형태로 변환하여 새 컬렉션을 만듦

    // mapIndexed() : 인덱스와 값 둘다 이용하여 조건을 주거나 새로운 값을 만들어 낼 수 있음

    val numbers = setOf(1 ,2 ,3)
    val doubleNumbers = numbers.map { num -> num * 2}

    println(doubleNumbers)

    // mapNotNull(), mapIndexedNotNull() : 이름 그대로 null 인 원소는 포함하지 않음
    val numbers2 = listOf("one", "two", "three", "", "four")
    println(numbers2.mapNotNull { num -> if( num == "two") null else num + "TEST" })

}