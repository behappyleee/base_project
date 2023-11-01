package com.sample.study.basic

import kotlinx.coroutines.delay

fun main() {

    // Coroutine 은 다양한 태스크를 진행할 때 필요한 요소
    // Thread 와 비슷하지만 Thread 와 다른 점은

    // 1. Coroutine 은 스레드와 함께 사용
    // 2. Coroutine 은 코드를 실행 중 일떄 멈출 수 있고 다시 실행할 수 있는 제어 능력을
    //    가지고 있지만 스레드는 불가능
    // 3. 코루틴을 사용하면 작업을 쉽게 전환하며 스레드를 옮겨다니며 작업할 수 있다
    // 4. 효율적으로 처리 속도도 빠름


}

fun coroutineFun() {

    // Coroutine 을 사용하여 Delay 사용 하기
    // Coroutine 을 실행 하는 가장 기본적인 방법은 Global Scope 을 이용 하는 거다.
    // Job 은 백 그라운드 작업을 의미
    // Main Activity

}

// delay 에서 사용했던 suspend function 이다
suspend fun coroutineTest(): String {
    delay(1000)

    return "test"
}