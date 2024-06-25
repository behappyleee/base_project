package com.sample.study.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class AsyncIncrementNumber {

}

var counter = 0

fun main() = runBlocking {
    val workerC = asyncIncrement(23)
    val workerA = asyncIncrement(2000)
    val workerB = asyncIncrement(100)

    workerC.await()
    workerA.await()
    workerB.await()

    println("Counter Number : [$counter]")

}

fun asyncIncrement(by: Int) = GlobalScope.async {
    for (i in 0 until by) {
        counter++;
    }
}