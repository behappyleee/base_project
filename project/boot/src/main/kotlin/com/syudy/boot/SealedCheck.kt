package com.syudy.boot

sealed class SealedCheck {

    object Test1: SealedCheck() {

    }

    object Test2: SealedCheck() {

    }

    object Test3: SealedCheck() {

    }

    class CheckTest(
        val name: String
    ) {
        fun checkTest(): String {
            return "TEST CHECCKCKK ~~ !"
        }
    }
}

fun main() {
    val SealedCheck = SealedCheck.Test1
    val sealTest2 = SealedCheck



}

fun testCheck(type: SealedCheck) {

}