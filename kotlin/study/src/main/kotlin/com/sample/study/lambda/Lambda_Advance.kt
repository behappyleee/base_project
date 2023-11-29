package com.sample.study.lambda

val funcTest: (String, String) -> String = {aStr: String, bStr: String ->
    println("THIS IS TEST")
    "THIS IS TEST CHECK !!!"
}

//val koFunc = {aStr: String, bStr: String: String ->
//    println("THIS IS A : $aStr , THIS IS B : $bStr")
//    return "THIS IS KO FUNC TEST !!"
//}


fun main() {
    println(funcTest)   // 그냥 함수 변수만 출력
    println(funcTest("TEST1", "TEST2"))// 함수를 실행 후 결과 값을 출력

    // Kotlin 은 1급 객체 변수나 데이터 구조에 저장되어 인자로 전달이 가능
    // 다른 고차원 함수의 리턴 값으로도 사용이 가능

    // Higher-order functions
    // Higher-Order function is the functional programming idiom fold for collection
    // A good example of a higher-order function is the functional programming idiom fold.
    // accumulator vlaue and combining function and builds its return value

    val list = listOf<Int>(1, 3, 5, 7, 8, 11)
    val listTest = list.foldTest(2, {a, b -> a + b})
    println(listTest)

    val map = mapOf("first" to 1, "second" to 2, "third" to 3)



}

fun myLambda(a : Int, lam: (a: Int, b: Int) -> Int): Int {
    println("[THIS IS MY CUSTOM LAMBDA A : $a]")

    // 왜 b 변수에 접근이 안될 까 ... ?
    // println(b)

    val result = lam(3 ,a)
    return result
}

fun List<String>.addStr(
    prefix: String,
    add: (str: String?) -> String)
: String? {
    var addStr: String? = null

    for(elem in this) {
        println(elem)
        addStr += elem
        val resultStr = add(addStr)

        println(resultStr)
    }

    return addStr
}


fun <T, R> Collection<T>.foldTest
            (
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial

    for(element: T in this) {
        // 1. 2
        // 2. 2 1  -> 3
        // 3. 3 3  -> 6
        // 4. 6 5  -> 11
        // 5. 11 7 -> 18
        // 6. 18 8 -> 26
        // 7. 26 11 -> 37
        accumulator = combine(accumulator, element)
    }

    return accumulator
}