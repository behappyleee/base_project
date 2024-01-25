package com.syudy.boot

fun main() {
    val intList = listOf(3, 4, 5, null, 6, 7, 9, 11)
    val newList = intList.mapNotNull { num -> num?.plus(1) }

    println(newList)

    val strList = listOf("GET", "CHECK", "TEST", null, "TESST", "")
    val newList2 = strList.mapNotNull { str -> str + "77" }

    println(newList2)

    val per1 = Person(
        name = "GET1",
        age = 3,
    )
}

class Person(
    private val name: String,
    private val age: Int,
)


// sealed class 는 자기 자신이 추상 클래스이고 자신을 상속받는 서브 클래스를 가질 수 있다
// 또한 부모 클래스를 상속 받는 자식 클래스의 종류를 제한 함

// sealed class 는 해당 패키지 내에서만 자식 클래스를 상속 할 수 있는 추상 클래스
// 추상 클래스이기에 sealed class 인스턴스를 생성할 수 는 없음



