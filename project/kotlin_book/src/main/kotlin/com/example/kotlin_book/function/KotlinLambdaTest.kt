package com.example.kotlin_book.function

class KotlinLambdaTest {


}

fun main() {

    // 자바와 마찬가지로 람다는 익명 함수이다. Anonymous Function 이다.
    // 익명 함수라는 말은 함수를 가리키는 이름이 없어 구현만 있다는 뜻이다
    val listNumTest = listOf(1, 2, 3, 4, 5)

    // kotlin 에서는 매개변수를 파라미터로 넘길 때 람다로 넘길 수 있다. 이떄 소괄호는 생략이 가능하다.
    listNumTest.map { a -> a + 3 }

    fun testChecking(n :Int): Int {
        // 자바와 마찬가지로 코틀린에서도 람다가 자신을 둘러싸는 영역의 변수를 가두어 닫을 수 있다.
        // 일반적으로 클로저를 하뭇 인자로 바꿀 수 있다는 사실을 알고 있어야 한다.

        // 아주 좁은 영역에 있는 변수를 가두는 경우에만 클로저를 사용하여야 한다. 예를 들면 함수 내부에 정의 한 로컬 함수 이런 경우 자신을 둘러싸고 있는 함수의
        // 인자나 이 함수에서 만든 임시 결과를 가두어도 안전하다. 자바와 달리 코틀린 에서는 가변 변수도 가둘 수 있다 하지만 더 안전한 프로그램을 가변 참조 사용을 피하여야 한다.
        return n + listNumTest.size
    }
}

fun List<Int>.product(): Int = this.fold(1) { a: Int,b: Int -> a + b }
