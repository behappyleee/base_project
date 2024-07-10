package com.sample.study.generic

import kotlin.reflect.KClass

sealed class TestSealed

data class PersonTest(val name: String): TestSealed()

data class PersonTest2(val age: Int): TestSealed()

object GenericTypeCheck {

    fun testByClass(test: TestSealed): TestSealed {
        return when(test) {
            is PersonTest ->
                test.copy(name = "SDSD")

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

