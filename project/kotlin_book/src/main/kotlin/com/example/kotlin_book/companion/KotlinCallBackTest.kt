package com.example.kotlin_book.companion

class KotlinCallBackTest {

}


fun main() {
    fun reStr(): String {
        return "rerer"
    }

    testFunction {
        println("This is Test Function !!")

        ""
    }
}

fun responseStr(): String {
    return "Callback Test !!"
}

fun testFunction(funTest: () -> String) {
    println(funTest())
}