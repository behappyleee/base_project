package com.study.coroutine.service

import org.springframework.stereotype.Service

@Service
class CoroutineService {

}


fun main() {

    val testInt = 7
    when(testInt) {
        3 -> println("THIS IS 3 !")
        5 -> println("THIS IS 5 !!")
        7 -> {
            val aaa = 777
            println(aaa)
        }
        else -> throw IllegalArgumentException("This is illegal exception !!")
    }

}