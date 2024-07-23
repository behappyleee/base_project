package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.*

class CancelCoroutine {
    // 코루틴 취소 - 필요하지 않은 코루틴을 적절히 취소해 컴퓨터 자원을 아낌
    // 코루틴도 취소에 협조해 주어야 한다.

    // 취소에 협조하는 방법 2
    // 1. suspend 같은 delay 함수 사용
    
}

fun main(): Unit = runBlocking {

    val job = launch {
        try {
            // 해당 부분은 취소 되어서 exception 은 떨어지지 만 해당 코루틴은 취소가 되지 않음 !
            // 오류를 잡았기 때문에 ! suspend 에 cancel 이 걸림 !
            delay(1_000L)
        } catch(e: CancellationException) {
            e.printStackTrace()
        } finally {
            printWithThread("필요 한 자원을 닫을 수 있습니다.")
        }

        printWithThread("Delay 에 의하여 취소 되지 않았다 !")
    }

    delay(100L)
    printWithThread("취소 시작 !")
    job.cancel()
}

fun example3(): Unit = runBlocking {

    // delay 같은 suspend 함수가 없으니까 job 은 취소가 안됨 !!
    // launch 에 의해 생성 된 Coroutine 은 Main Thread 이외에 다른 스레드에서 실행이 됨  !
    // Dispatchers.Default : 우리의 코루틴을 다른 스레드에 배정
    // 다른 스레드에서 일부러 실행 시킨게 Main Thread 는 비어 있기에 job.cancel() 실행이 가능함 !
    val job = launch(Dispatchers.Default) {
        var i = 1
        var nextPrintTime = System.currentTimeMillis()

        while (i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithThread("${i++} 번 째 출력  !!!")
                nextPrintTime += 1_000L
            }

            // isActive 를 통하여 현재 코루틴이 실행 중인 지 중지 명령을 받았는 지 확인
            if (!isActive) {
                throw CancellationException()
            }
        }
    }

     // 취소 명령을 하였음에도 취소 되지 않음 !
    delay(100L)
    job.cancel()
}


fun example1(): Unit = runBlocking {
    val job1 = launch {
        printWithThread("Start Job 1")
        delay(1_000L)
        printWithThread("Job 1")
    }

    val job2 = launch {
        printWithThread("Start Job 2")
        delay(1_000L)
        printWithThread("Job 2")
    }

    // 1초 있다가 코루틴 job1 을 취소 함 !
    // delay 는 suspend 함수임
    delay(100)
    job1.cancel()
}

