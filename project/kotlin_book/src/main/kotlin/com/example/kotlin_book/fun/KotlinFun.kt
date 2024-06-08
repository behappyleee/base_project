package com.example.kotlin_book.`fun`

class KotlinFun {

}

fun main() {

    // Java 에서는 하위 프로그램을 메서드라고 부르지만 코틀린에서는 함수라고 부른다.
    // 계산 시 순수 함수만 사용, 계산 결과를 외부 세계에서 사용 하려면 순수 효과만 사용
    // 함수는 수학적인 개념, 함수는 소스 집합 정의역 Domain / 공역 Codomain
    // 함수에는 역함수가 있을수도 있고 없을수도 있다.

    // 함수가 되려면 대응 관계가 다음 두 가지 조건을 만족 하여야 한다.
    // 1. 정의 역의 모든 원소에 대해 함수가 정의 되어야 한다.
    // 2. 정의역의 모든 원소는 반드시 공역의 한 값에만 대응이 되어야 한다.

    // 함수는 서로 합성해서 다른 함수를 만들어 낼 수 있는 빌딩 블록이다.
    // 데이터와 함수는 근본적으로 동일, 어떤 데이터든 실제로는 함수라 할 수 있고, 어떤 함수든 실제로는 데이터라고 할 수 있다.

    // data class 는 equals 를 진짜 데이터가 같은지를 보고 그 외는 정의한 equals 에 따라 달라진다.
    // 코틀린은 함수를 데이터처럼 다룰 수 있게 해준다.

    // 프로그래머들은 진정한 함수를 순수 함수 pure function 이라고 부른다,
    val kt1 = KotlinFunTest(name = "NAME")
    val kt2 = KotlinFunTest(name = "NAME")
    // false 이다
    println(kt1 == kt2)

    val dt1 = KotlinDataTest(name = "NAME")
    val dt2 = KotlinDataTest(name = "NAME")
    println(dt1 == dt2) // true 이다.

    fun double(x: Int): Int = x * 2

    // 이 때 double 함수의 타입은 (Int) -> Int 이다.
    // 이 예제에서 double 은 함수 이름이 아니다, 람담로 정의 한 함수에는 이름이 없다.
    val double: (Int) -> Int = { it * 2 }

    double(3)

    val doubleIncrement: (Int) -> Int = { x ->
        val double = x * 2
        double + 1
    }

    val doubleTuble: (Int, Int) -> Int = { x, y -> x + y }

    // 함수 참조
    fun testKotlin(a : Int, b: Int): Int = a + b

    val test2: (Int, Int) -> Int = { x, y -> x + y }
    val test3: (Int, Int) -> Int = { x, y -> testKotlin(a = x, b = y) }
    val test7: (Int, Int) -> Int = ::testKotlin     // 메서드 참조도 사용 이 가능 !


}

class KotlinFunTest(
    val name: String,
)

data class KotlinDataTest(
    val name: String,
)