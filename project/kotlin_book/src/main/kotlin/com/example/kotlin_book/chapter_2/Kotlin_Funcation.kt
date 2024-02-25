package com.example.kotlin_book.chapter_2

class Kotlin_Funcation {


}

fun main(args: Array<String>) {

    // 코틀린에서는 프로퍼티와 마찬가지로 함수도 패키지 수준이나 클래스, 객체 내부에 정의할 수 있다.
    val testSample = addSample(3, 5)
    println(testSample)

    println(product)

}

// 코틀린을 사용하면 다음과 같이 파라미터화 한 클래스에 함수 추가도 가능 (확장 함수)
fun List<Int>.product(): Int = this.fold(1) {a, b -> a * b}

val ints = listOf(1, 2, 3, 4, 5)

val product = ints.product()

fun sumOfPrime(limit: Int): Long {
    // 클래스나 객체 안에서 함수 정의가 가능, 더 나아가 함수 내부에서도 함수를 정의가 가능
    
    // isPrime 함수를 sumOfPrime 밖에서 정의는 불가능, 왜냐하면 isPrime 이 seq 값을 가두어 닫음 ->
    // -> 이런 구조를 Closure 구조라고 함 클로저는 자신이 가두어 닫은 변수를 함수 인자로 받는 것과 비슷
    
    val seq: Sequence<Long> = sequenceOf(2L) + generateSequence(3L, {
        it +2
    }).takeWhile {
        it < limit
    }

    fun isPrime(n: Long): Boolean = seq.takeWhile {
        it * it <= n
    }.all {
        n % it  != 0L
    }

    return seq.filter(::isPrime).sum()
}

// 여기서 (n: Long, seq: Sequence<Long>) 을 파라미터로 받는 isPrime 함수를 sumOfPrimes 밖에서 다른 용도로 크게
// 사용할 일이 없으면 Local 함수로 만드는 것도 좋음
fun isPrimeOut(n: Long, seq: Sequence<Long>): Boolean = seq.takeWhile {
    it * it <= n
}.all {
    n % it  != 0L
}


// 함수 선언 시 fun 을 사용
fun add(a: Int, b:Int): Int {

    return a + b
}

// 함수 본문을 한줄로 표현 가능하면 중괄호를 없애도 됨 -> expression syntax 라고 함 식 구문을 사용 시 에는 타입 추론이 가능
fun addPlus(a: Int, b:Int) = a+ b

// 반환 타입이 Int 가 아니다
fun addSample(a: Int, b: Int) = {
    a + b
}

