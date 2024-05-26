package com.example.kotlin_book.coroutine

class CallbackHell {

}


fun main() {
    first { test, test1 ->
        println("Test Value : !!! :$test")
        println("Test 2 Value : !!! : $test1")

        second(input = test) {
            println("This is Second Test Value !! $test")

            third(input = test) {
                println("This is Third Test Value !!")
            }
        }
    }
}

fun first(callback: (String, String) -> Unit) {
    val inputResult = "input String"
    val inputResult2 = "input String 2"
    callback(inputResult,inputResult2)

}

fun second(input: String, callback: (String) -> Unit) {
    callback(input)
}

fun third(input: String, callback: (String) -> Unit) {
    callback(input)
}