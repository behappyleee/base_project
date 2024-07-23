package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineExceptionHandler

class CoroutineExceptionHandler {
    // Coroutine 에서 예외가 발생 시
    // 에러 메세지 전송, 에러 핸들링 등 기능을 사용하기 위하여 Handler 기능을 사용 !
}

fun main(): Unit = runBlocking {

    // coroutineContext 는 코루틴 구성요소 임 !
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        printWithThread("[In Coroutine Exception Handler!]예외 발생 !!")

    }

    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException("코루틴 예외 ~~~ !!! !")
    }


    delay(1_000L)

}