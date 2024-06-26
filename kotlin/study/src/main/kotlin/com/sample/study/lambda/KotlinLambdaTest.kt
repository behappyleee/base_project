package com.sample.study.lambda

import java.util.Date

class KotlinLambdaTest {

}

fun String.testStrFun(): String {
    return this
}

// val testCheck: Int.() -> Int

fun <T, R> testCheckFun(aa: T, bb: T.() -> String): String {

    return aa.bb()
}

class DateTestCheck {
    var mills: Long? = null

    var dateTest: Date
        get() = Date()
        set(value) {
            mills = value.time
        }
}

fun main() {

    val aa = "CheckinFun".testStrFun()
    println(aa)

}