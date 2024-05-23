package com.example.kotlin_book.function

class KotlinExtenstionFunction {

}

fun main() {

    val listTest = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(listTest.koCustomFun())

}

fun <T> List<T>.koCustomFun(): Int {
    return this.size + 3
}