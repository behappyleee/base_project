package com.sample.kotest.compare

class KotlinCompare {

}

fun testFunction1(): String {
    return "This is 11"
}

fun main() {


    val aa = "AA"
    val bb = "BB"

    aa.compareTo(bb)

    val cc = "AKotlin".compareTo("KSDSAD") > 0
    println(cc)
    compareBy<String>()
    println(::testFunction1)

}
