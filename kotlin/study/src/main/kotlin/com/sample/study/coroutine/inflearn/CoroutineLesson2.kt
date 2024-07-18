package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineLesson2 {

}

// runBlocking 이름에 blocking 이 들어가 있음, nonblocking 특성이 있음
// runBlocking 은 코루틴을 새로 만듦, 코루틴 빌더 애들임 이름에 blocking 이 들어가 있는 이유는
//fun main(): Unit = runBlocking {
//
//
//}

fun main() {
    // runBlocking 코드가 끝날 때 까지 Nonblocking 이 되어 다음 함수가 실행이 안됨 !
    runBlocking {
        printWithThread("START")
        launch {
            delay(2_000L)
            printWithThread("LAUNCH END")
        }
    }

    // 여기로 코드가 넘어오지 않음 !
    printWithThread("END")
}