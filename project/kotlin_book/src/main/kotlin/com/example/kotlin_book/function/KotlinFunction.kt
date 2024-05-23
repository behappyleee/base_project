package com.example.kotlin_book.function

class KotlinFunction {

}

fun main() {
    // 코틀린 함수는 자바의 메서드와 동일


}

// 함수 표현식
fun add(a: Int, b: Int) = a + b

// 다음 처럼 사용도 가능하다
fun addExpression(a: Int, b: Int) {
    a + b
}


fun sumOfPrimes(limit: Int): Long {
    val seq: Sequence<Long> = sequenceOf(2L) + generateSequence(3L, {
        it + 2
    }).takeWhile {
        it < limit
    }

    // isPrime 함수를 sumOfPrimes 밖에서 구현할 수는 없다. 왜냐하먄 isPrime 이 seq 값을 가두어 닫기 떄문이다. 이러한 구조를 Closure 구조라고 한다.
    // 클로저는 자신이 가두어 닫은 변수를 함수 인저로 받는 것과 비슷하다.
    fun isPrime(n : Long): Boolean = seq.takeWhile {
        it * it <= n
    }.all {
        n % it != 0L
    }

    fun test() {
        println("Fun Test !!!")
    }


    val aa = listOf(1,2,3)

    fun testFun(n: Int): Int {
        return n
    }


    aa.map(::testFun)

    return seq.filter(::isPrime).sum()
}