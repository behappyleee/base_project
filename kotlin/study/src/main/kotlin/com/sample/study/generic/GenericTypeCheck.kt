package com.sample.study.generic

data class PersonTest(val name: String)

data class PersonTest2(val age: Int)

object GenericTypeCheck {

    fun <T>testByClass(test: T): T {
        return when(test) {
            is PersonTest ->
                test.copy(name = "SDSD") as T

            else -> test
        }
    }


    inline fun <reified T>specialHandlingByClass(test: T): T {
        return when(test) {
            is PersonTest ->
                test.copy(name = "TEST 111") as T
            is PersonTest2 ->
                test.copy(age = 23) as T
            else -> test
        }
    }
}

fun main() {
    val pt1 = PersonTest(name = "NAME_AS")
    val aa = GenericTypeCheck.testByClass(test = pt1)
    println(aa)

    val bb = GenericTypeCheck.specialHandlingByClass(test = pt1)
    println(bb)
}

