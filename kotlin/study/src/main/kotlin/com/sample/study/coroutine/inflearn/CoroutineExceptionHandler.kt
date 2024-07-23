package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineExceptionHandler

class CoroutineExceptionHandler {
    // Coroutine 에서 예외가 발생 시
    // 에러 메세지 전송, 에러 핸들링 등 기능을 사용하기 위하여 Handler 기능을 사용 !
}

// 코루틴 취소 예외 정리 -> CancellationException 경우 취소로 간주하고 부모 코루틴에게 전파 하지 않음 !!
// 그 외 다른 예외가 발생하 ㄴ경우 실패로 간주하고 부모 코루틴에게 전파함 !, 다만 내부적으로는 취소나 실패 모두 '취소 됨 상태로 간주 함 !'

fun main(): Unit = runBlocking {

    // Coroutine ExceptionHandler 사용 시 주의 사항은 -> launch 에만 사용이 가능하고 부모 코루틴이 있으면 동작하지 않음 !
    // coroutineContext 는 코루틴 구성요소 임 !
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        printWithThread("[In Coroutine Exception Handler!]예외 발생 !!")

    }

    // 만약 같은 Main Thread 였으면 Exception Handler 가 동작하지 않음 (부모 코루틴이 존재하기에 ! 다른 스레드를 생성하여 코루틴을 실행 함 !)
    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        // 만약
        try {
            throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            println("[LAUNCH Coroutine 안 EXCEPTION !!!!!]")
            // 만약 try catch 로 잡아주면 Exception 핸들러를 안 탐 !
        }


        throw IllegalArgumentException("코루틴 예외 ~~~ !!! !")
    }


    delay(1_000L)

}