package com.sample.study.concurrency

import io.netty.util.internal.MathUtil
import java.util.Random

class KotlinCallbackTest {

}

fun callbackCheck3(a: Int, b: String): String {
    return "This is callback 33 !! $a $b"
}

fun callbackCheck7(): String {
    return "This is callback 77 !!"
}

fun sleepMethod(afterFun: ()-> String) {
    Thread.sleep(300)
    afterFun()
}

fun main() {
    val random = (Math.random() * 100).toInt()
    val isOddNumber = random % 2 != 0

    if (isOddNumber) {
        sleepMethod { callbackCheck3(a = 3737, b = "TestStr !!!") }
    } else {
        sleepMethod { callbackCheck7() }
    }


    println(isOddNumber)
    println(random)
}