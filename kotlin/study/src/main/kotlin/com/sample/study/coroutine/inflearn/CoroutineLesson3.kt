package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineLesson3 {

}

fun main(): Unit = runBlocking {
    // 실제로는 delay 때문에 2초를 예상하지만 실제로는 1.1 초 정도 걸림 Job1 delay 가 걸리는 동안 job2 가 바로 실행이 됨
    val job1 = launch {
        delay(1_000L)
        printWithThread("Job 1")

    }

    val job2 = launch {
        delay(1_000L)
        printWithThread("Job 2")
    }

}


fun example2(): Unit = runBlocking {

    val job = launch {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }

    delay(1_000L)
    printWithThread("JOB CANCEL START !!")
    job.cancel()
    printWithThread("JOB CANCEL END !!")
}

// Launch 는 반환 값이 없는 코루틴을 생성 시 사용
fun example(): Unit = runBlocking {

    // CoroutineStart.LAZY 사용 시 코루틴을 직접 실행 전 까지 실행을 하지 앟음
    val job = launch(start = CoroutineStart.LAZY) {
        printWithThread("Hello Launch !!")
    }

    printWithThread("JOB START")
    delay(1_000L)
    // 코루틴을 직접 실행함 LAZY 방식임
    job.start()
    printWithThread("JOB END")
}