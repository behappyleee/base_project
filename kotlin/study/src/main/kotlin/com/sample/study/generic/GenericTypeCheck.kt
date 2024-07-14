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


    inline fun <reified T>specialHandlingByClass(test: T, test1: () -> Unit = { Unit }): T {
        test1.invoke()
        return when(test) {
            is PersonTest ->
                test.copy(name = "TEST 111") as T
            is PersonTest2 ->
                test.copy(age = 23) as T
            else -> test
        }
    }
}

fun testInt(a : Int): Int {
    return a
}

fun main() {
    val listTest = listOf(1, 2, 3, 4, 5, 6, 7)

    val takeIf1 = listTest.takeIf { true }.run {
        println(this)
    }.let {
        println(it)
        println("TESTTT" + ::testInt)

        val cc = testInt(a = 3)
        val dd = ::testInt
        dd(2)
    }

    println(takeIf1)

    val takeIf2 = listTest.takeIf { false }.run {
        println(this)
    }?.let { println("SDSDS  $it") }

    println(takeIf2)

    val pt1 = PersonTest(name = "NAME_AS")
    val aa = GenericTypeCheck.testByClass(test = pt1)
    println(aa)

    val bb = GenericTypeCheck.specialHandlingByClass(test = pt1)
    println(bb)
}

