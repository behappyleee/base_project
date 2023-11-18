package practice.grammar

import java.util.Objects

/*
*   Infix Function
*   Kotlin 에서는 두 개의 객체 중간에 들어가게 되는 함수 형태를 Infix Function 이라고 부른다.
*
* */

fun main(args: Array<String>) {

    val x: Int = 6
    val y: Int = 10

    val greaterVal = x findGreaterValue y
    println(greaterVal)

    val testStr: String = "test"
    val customNum: Int = testStr.customInfix(7)
    println(customNum)

}

infix fun Int.findGreaterValue(other: Int): Int {
    if(this > other) {
        return this
    } else {
        return other
    }
}

infix fun String.customInfix(a :Int): Int {
    return a
}




