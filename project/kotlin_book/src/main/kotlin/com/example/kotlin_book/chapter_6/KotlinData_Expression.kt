package com.example.kotlin_book.chapter_6

class KotlinData_Expression {

    // 컴퓨터 프로그램에서는 데이터가 존재하지 않는다는 사실을 표현하기는 조금 어렵다.
    // 일반적인 언어에서 null 을 반환하는 것은 가장 나쁜 해법이다.
    // 널을 반환함으로써 자바와 같은 언어에서 벌어진 일을 생각해 보자.

}

fun main() {
    println(Double.NaN) // Return 값 NaN

    val mapTest = emptyMap<String, Int>()
    val test = mapTest["TEST"]
    println(test)

    val pairTest = Pair("TEST1", 3)
    val pairTest2 = "TEST2" to 7

    println(pairTest)
    println(pairTest2)
    println(pairTest2.toList())

}

fun mean(list: List<Int>): Double = when {
    list.isEmpty() -> Double.NaN    // List 가 비었을 시 ... !
    else -> list.sum().toDouble()   // list.size
}

// 다른 방법 !
fun mean1(list: List<Int>): Double = when {
    // 또 다른 방법으로는 그냥 예외를 던져 버리는 것이다.
    // 하지만 해당 방법은 더 많은 문제를 일으킨다. 입력이 없어서 결과가 없는 것 뿐이다 !
    // 예외를 추가하면 함수가 더 이상 순수 함수가 아니게 된다. 그리고 다른 함수와 더 이상 호환이 안된다.
    // null 을 반환하고 호출 하는 쪽에서 null 처리를 할 수 있다. 일반적으로 언어에서 null 을 반환하는 것은 가장 나쁜 해법이다.
    list.isEmpty() -> throw IllegalArgumentException("This is Exception !")
    else -> list.sum().toDouble()
}

// 또 다른 방법은 default 수를 받는 것이다 ! list 가 없을 거나 대비해서 이다 !
fun maxWithDefault(list: List<Int>, defaultNum: Int): Int = when {
    list.isEmpty() -> defaultNum
    else -> list.max()  // 리스트가 비어 있으면 defaultNum 을 주는데 문제는 list 에 0 만 있거나
    // 진짜 최댓값이 0 일때가 문제이다 !
}
