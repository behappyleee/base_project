package com.sample.study.concurrency

import kotlinx.coroutines.*

class CoroutineDeadLock {

}

var jobA: Job? = null
var jobB: Job? = null

// DeadLock 상태
fun main(args: Array<String>) = runBlocking {
    jobA = launch {
        println("Job A Launch ~~ !!!")
        delay(1000)
        jobB?.join()
    }

    jobB = launch {
        println("Job B Launch ~~ !!!")
        // wait for JobA to finish
        jobA?.join()
    }

    jobA?.join()

    println("Finished The Coroutine !!")
}