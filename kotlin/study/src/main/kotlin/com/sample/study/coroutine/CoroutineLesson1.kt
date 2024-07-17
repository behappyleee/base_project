package com.sample.study.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

class CoroutineLesson1

// Run Blocking 을 메인 함수로 지정
// Coroutine 실행에는 직관 적인 것과 차이가 있음
fun main(): Unit = runBlocking {// runBlocking 은 일반 루틴 세계와 코루틴 세계를 연결 함, 이 함수 자체로 새로운 코루틴을 만듦
    // 반환값이 없는 코루틴을 만듦
    printWithThread("START")
    
    // suspend 가 붙은 함수를 호출
    launch {// launch 는 반환값이 없는 코루틴을 만듦
        newRoutine()
    }
    
    yield() // 위 launch Coroutine 에 Coroutine 을 양보함 !
    printWithThread("END")
}

// suspend fun 은 다른 suspend fun 을 호출이 가능 그래서 yield() 호출이 가능
suspend fun newRoutine() {
    val num1 = 1
    val num2 = 2
    
    yield() // yield 는 지금 코루틴을 중단하고 다른 코루틴이 실행 되도록 해 줌 (스레드를 양보 해 줌)

    printWithThread("${num1 + num2}")
}

// Run Option 실행 시 VM Options 에 -Dkotlinx.coroutines.debug 를 추가
// Coroutine 확인 이 가능
fun printWithThread(str: Any) {
    println("${Thread.currentThread().name} - $str")
}