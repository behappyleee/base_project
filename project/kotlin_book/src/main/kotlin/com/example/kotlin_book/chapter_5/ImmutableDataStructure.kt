package com.example.kotlin_book.chapter_5

class ImmutableDataStructure {

}

fun main(args: Array<String>) {

    // 불변이며 영속적인 단인 연결 리스트
    // List 의 첫번째 원소 - 머리
    // List 의 나머지 부분- 꼬리

}

// 이 정의에는 누구나 리스트 클래스를 확장할 수 있다는 단점이 있음, 누구나 리스트 클래스를 확장할 수 있으며
// 리스트 구현의 일관성이 없어지고 구현 세부 사항이라서 외부에 노출해서는 안 되는 NilCustom 이나 ConsCustom 하위 클래스에
// 아무나 접근이 가능해진다.
//open class ListCustom<A>
//
//object NilCustom: List<Nothing>()
//
//class ConsCustom<A>(private val head: A, private val tail: List<A>): List<A>()

sealed class List<A> {
    internal object NilCustom: List<Nothing>()  // 재귀 정의를 마무리 하기 위한 종료 조건 - Nil
    internal class ConsCustom<A>(private val head: A, private val tail:List<A>): List<A>()
}


