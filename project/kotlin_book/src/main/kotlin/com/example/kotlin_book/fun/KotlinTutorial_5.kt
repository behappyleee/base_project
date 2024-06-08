package com.example.kotlin_book.`fun`

class KotlinTutorial_5 {


}

fun main() {


}

fun  <T, U, V> funDoubleTest(
    a: T,
    b: (T) -> (U) -> V
): (U) -> V {
    return b(a)
}

//fun <T, U, V>funCheck(
//    a: U,
//    b: (T) -> (U) -> V
//): (T) -> V {
// return {
//     ac: T ->
//     b(ac)
// }
//}

fun doubleFunArg(a :(Int) -> Int, b: (Int, Int) -> Int): Int {
    return 0
}
