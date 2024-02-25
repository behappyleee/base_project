package com.example.kotlin_book.chapter_2

class Kotlin_Collection {

    // 코틀린에서 가장 중요한 점은 컬렉션에 불변 Immutable 가변 Mutable 이라는 두 가지 유형이 있다는 점


}

fun main(args: Array<String>) {

    // 불변 리스트
    val list = listOf(1, 2, 3)

    // 불변성이 리스트에 대한 연산을 수행할 수 없다는 뜻은 아님
    // 불변 컬렉션이여도 Collection 끼리 연산이 가능
    val list1 = listOf(1, 2, 3)
    val list2 = list1 + 4
    val list3 = list1 + list2

    println(list1)
    println(list2)
    println(list3)

    // 원소를 추가하려면 가변 리스트로 만들어야 함
    val mutableList1 = mutableListOf(1, 2, 3)
    mutableList1.add(element = 4)

    // 함수를 패키지 수준에서 정의가 가능, 그로 인하여 자바 패키지 사용 방식과 코틀린 패키지 사용 방식에 큰 차이가 있음
    // 코틀린 패키지 에서는 패키지가 저장 된 디렉토리 구조와 패키지 이름을 서로 일치시킬 필요가 없음



}
