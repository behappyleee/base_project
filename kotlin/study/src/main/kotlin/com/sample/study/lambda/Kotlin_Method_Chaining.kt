package com.sample.study.lambda

import java.lang.StringBuilder

fun main() {

    // Kotlin Method Chaining
    // Method Chaining is a programming style where multiple methods are called on an object
    // in a chain, one after another. Kotlin supports method chaining, and it can be quite expressive

    // An example of method chaining in Kotlin using the StringBuilder Class

    val result = StringBuilder()
        .append("Hello !")
        .append("Kotlin !!")
        .append("World !!")
        .toString()

    println(result)

    // In this example multiple append methods are called on the StringBuilder instance in a chaing
    // making the code more concies.
    // Calculator allows method chaining for operations like addition and multiplication.
    // Both Lambda expressions and method chaining are powerful features in Kotlin that contribute
    // to writing concise and expressive code. They are widely used in Kotlin programming.
    // Especially in functional programming paradigms and DSLs(Domain-Specific-Languages)
    val cal = Calculator()
        .add(3)
        .add(6)
        .getResult()

    println(cal)
}

class Calculator(
    private var result: Int = 0
) {

    fun add(value: Int): Calculator {
        result += value
        return this
    }

    fun multiply(value: Int) :Calculator {
        result *= value
        return this
    }

    fun getResult(): Int {
        return result
    }
}