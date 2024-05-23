package com.example.kotlin_book.companion

import com.example.kotlin_book.test.a
import org.springframework.boot.util.LambdaSafe.Callbacks
import javax.security.auth.callback.Callback

class KotlinCallBackTest {

}

fun testReturn() = "Test Return !"

fun main() {

    println(testReturn())

    parameterTest { aTest ->
        println("A Tst Check $aTest")
        println("Run Test !!")

        "This is Check !!"
    }


    fun reStr(): String {
        return "rerer"
    }

    testFunction {
        println("This is Test Function !!")

        ""
    }
}

fun parameterTest(funTest: (String) -> String) {
    val testStr = "Test Str !"

    val aaaa = funTest(testStr)

    println("AAA Response : " + aaaa)
}



fun responseStr(): String {
    return "Callback Test !!"
}

fun testFunction(funTest: () -> String) {
    println(funTest())
}