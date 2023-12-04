package com.sample.study.lambda

import java.util.Arrays
import kotlin.reflect.typeOf

fun main() {
    // High Order Function
    // High order function is a function that takes functions as parameters, or returns a function

    val a = ArrayList<Int>().test(7, { a, b -> a + b})

    println(a)

    // To call fold

    val aa = callTest<Int, Int, String>(3, 3, "t")
    val bb = callTest<String, String, Int>("t1", "t2", 3)

    val items = listOf(1, 2, 3, 4 , 5)
    items.test(0, {
        acc: Int, i: Int ->
        println("ACC TEST CHECK !")
        val result = acc + 1
        println("RESULT DATA CHECK : " + result)
        result
    })

    val ctest = callTest<Int, Int, String>(3,2, "tt2")
    println(ctest)

    val joinStr = items.test("Elements : ", {acc, i -> acc + " " + i})
    println(joinStr)
    
    // map 은 custome 한 함수 test 함수에 접근 불가능
    val mapTest = mapOf("1" to 1, "2" to 2, "3" to 3)
    
    // list 는 custom 한 함수 test 함수에 접근이 가능
    val listTest = listOf(3 , 2 ,1)

    // val mapResult = mapTest.mapChec(a: String, b: Int -> a + " " + b)
    // println(mapResult)

}

fun <T> accuPlusInt(
    t1: T,
): T?  {
    val value = t1
    val size = Integer.parseInt(value.toString())

    for(i : Int in 0 .. size) {

    }

    return null
}


fun <T, R> Collection<T>.test(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial

    println("ACCUMUL : " + accumulator)
    println("THIS ACCUMUL DATA CHECK : " + this.size)

    for(element: T in this) {

        println("ELEM : " + element)

        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun <T, R> Map<T, R>.mapChec (
    test: (t1: T, t2: R) -> R
): R? {

    return null
}

fun <T, R, K> callTest(
    t1 : T,
    t2 : R,
    t3 : K,
) {
    val a : T = t1
    val b : R = t2

    println("A : " + t1)
    println("B : " + t2)
    println("A : " + a)
    println("B : " + b)


}

