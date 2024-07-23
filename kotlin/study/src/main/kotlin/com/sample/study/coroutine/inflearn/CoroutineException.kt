package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.*

class CoroutineException {
    
    // Root Coroutine (부모 코루틴)
    // runBlocking 코루틴 
    // launch 코루틴
    // launch 코루틴

    // 부모 코루틴 안에서 새로운 부모 코루틴을 만드는 방법은 새로운 영역 (Coroutine Scope) 를 통해서 만든다 !

    // launch 에서 예외 발생 시 바로 부모에게 전파가 됨
    
    
    
}

fun main(): Unit = runBlocking {

    val job = launch {
        try {
            // 안에서 예외를 잡았기에 밖에 부모에게 전파가 안 됨 !
            throw IllegalArgumentException()
        } catch(e: IllegalArgumentException) {
            printWithThread("정상 종료 !")
        }
    }

    delay(1_000L)
}


fun main_1(): Unit = runBlocking { 
    
    // 자식 코루틴에 예외를 부모 코루틴에게 예외를 안 던짐, SupervisorJob() 을 사용 안하면 부모 코루틴에게 예외가 전파가 됨 !
    val job = async(SupervisorJob()) { 
        throw IllegalArgumentException()
    }
    
    delay(1_000L)

    // 하지만 SupervisorJob() 을 사용하였더라도 await() 을 쓰는 순간 전파가 됨 !
    job.await()
}


fun example8(): Unit = runBlocking {

    // main thread 에 자식 Coroutine 으로 코루틴을 만듦
    // example6 async Coroutine 과 다르게 async 라도 바로 예외를 뱉어버림
    // 자식 코루틴의 예외는 부모 코루틴에게 전달이 됨 !
    val job = async {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}

fun example7(): Unit = runBlocking {

    // async 는 launch 가 달리 에러가 바로 출력되지 않음
    val job = CoroutineScope(Dispatchers.Default).async {
        throw IllegalArgumentException()
    }

    delay(1_000L)
    // Main Thread 에서 예외를 뱉음
    job.await() // await 을 써야만 예외를 뱉게 됨
}

fun example6(): Unit = runBlocking {

    // Coroutine launch 경우 예외가 발생 시 그냥 종료 되어버림
    val job = CoroutineScope(Dispatchers.Default).launch {
        throw IllegalArgumentException()

    }

    delay(1_000L)

}

fun example5(): Unit = runBlocking {

    // 현재 구조는 Root Coroutine 안에 Child Coroutine 이 2개있는 것임 !
    // Dispatchers 를 통하여 다른 스레드에서 실행 시켜 줌
    // Coroutine Scope 를 사용
    val job1 = launch(Dispatchers.Default) {
        printWithThread("Start Job 1")
        delay(1_000L)
        printWithThread("Job 1 End")
    }

    val job2 = launch(Dispatchers.Default) {
        printWithThread("Start Job 2")
        delay(1_000L)
        printWithThread("Job 2 End")
    }
}
