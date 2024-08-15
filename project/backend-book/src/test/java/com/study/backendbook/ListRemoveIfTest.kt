package com.study.backendbook

import org.junit.jupiter.api.Test

class ListRemoveIfTest {

    val listTest = mutableListOf(1, 2, 3, 4, 5, 6, 7)

    @Test
    fun testList() {
        listTest.removeIf { num: Int -> num == 3 }
        println(listTest)
    }
}
