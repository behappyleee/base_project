package com.example.kotlin_book.`fun`

class KotlinFunTutorial_3 {

}

fun main() {

    // 다인자 multi-augument 함수를 생각해 보야야 한다.
    // 인자가 여럿 있는 함수란 존재하지 않는다. 단지 워소가 여러 개 들어있는 튜플을 유일한 인자로 받는 함수만 존재.
    // 원소 갯수가 적으면 갯수에 따라 튜플, 트리플렛, 쿼텟 등의 이름이 붙으며 코틀린에는 Pair / Triple 이라는 이름으로 미리 정의가 되어 있다.

    // 두 정수를 더하는 함수를 정의, (Int) 는 인자의 타입, (Int) -> Int 는 반환 타입
    // (Int) -> (Int) -> Int 이다
   println(addTest(3))


}

val addTest: (Int) -> (Int) -> Int = { a ->
    { b -> a + b }
}

// TypeAlias 를 사용 시 훨씬 짧고 간단하게 사용이 가능 !!!
val addAlia: tutorialAdd = { a -> { b -> a + b } }

// 타입을 짧게 하고 싶을 시 alias 를 사용
typealias tutorialAdd = (Int) -> (Int) -> Int


// 앞에서 함수 인자는 하나씩 차례로 적용이 되며 인자가 적용이 될 때 마다 새로운 함수를 반환
//fun addTwoFunNum(a : Int): (Int) -> Int {
//   val addNum = { abc -> abc + 2 }
//
//   return { a -> a + 2 }
//}
