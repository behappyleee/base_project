package com.sample.study.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class CoroutineAsync {

}

suspend fun main() {

    val message = GlobalScope.async {
        delay(1000)
        "hello "
    }

    val count = GlobalScope.async {
        delay(1000)
        3
    }

    val result = message.await().repeat(count.await())
    println("Result : $result")

}