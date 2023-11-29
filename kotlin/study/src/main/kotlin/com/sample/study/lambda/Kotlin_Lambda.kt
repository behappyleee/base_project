package com.sample.study.lambda

val sum: (Int, Int) -> Int = {a, b -> a + b}

fun main() {
    // Lambda Expression in Kotlin are aconcise way to define anonymous functions. They are
    // often used for functional programming constructs, such as passing functions as parameters
    // or returning functions from other functions.
    val result = sum(3, 5)
    println("RESULT IS : $result")

    // In this example the operateOnNumbers function takes two numbers and a lambda expression
    // representing an operation. It then applies the opreation to the numbers.
    val returnLambda = operatorOnNumbers(3, 5, {a, b -> a + b}, {x, y -> println(x)
        println(y)
    })





}

// can also use lambda function as parameter
fun operatorOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int, test: (String, String) -> Unit): Int {
    println("THIS IS TEST !!! " + test.toString())
    test("Test 1", "Test 2")
    return operation(a ,b)
}