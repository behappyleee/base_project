package com.syudy.boot

sealed class SealedUserTest {

    data class Customer(
        val name: String,
        val address: String,
        val phoneNumber: String,
    ): SealedUserTest()

    class Check(): SealedUserTest() {
        fun test() {
            println("THIS IS TEST LOG IN CHECK METHOD !!!")
        }
    }

    class Check2(): SealedUserTest() {
        fun testCheck() {
            println("THIS IS TEST CHECKCKCKCK ~ !!!")
        }
    }

}