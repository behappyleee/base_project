package com.sample.study.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// coroutines 는 Kotlin 만의 것이 아니다 이름이 비슷해서 헷갈릴 수도 있지만
// JavaScript 에서 Async / Await 을 사용해본 경험이 있다면 이미 코루틴을 사용을 해 본 경험이 있는 것이다.
// 코루틴을 사용하면 비동기 처리가 너무나도 쉽게 이루어질 수 있다.

// 1. 협력형 멀티 태스킹 (Co + Routine) => Routine 은 하나의 태스크, 함수 정도로 생각하면 된다. 즉 협력하는 함수
//

// Routine 에는 Main Routine 과 Sub Routine 이 존재
// 
// Main Routine
fun testCoroution(): String {
    // SubRoutine
    callSubRoutine();   // SubRoutine 은 진입 하는 지점과 빠져 나오는 지점이 명확함

    // 즉, 메인 루틴이 서브 루틴을 호출 하면 서브 루틴의 맨 처음 부분에 진입하여 return 문을 만나거나 Sub Routine 의 닫는 괄호를 만나면
    // 해당 서브루티을 빠져 나오게 됨
    return "TEST Coroutine";
}

fun callSubRoutine(): String {

    return "End SubRoutine !";
}

fun main() = runBlocking {
    println("My program runs : ... ${Thread.currentThread().name}");

    launch {
        longRunningTast();
    }

    println("My Program run ends ... " + "${Thread.currentThread().name}");
    println("Basic Grammar : " + Thread.currentThread().name);

}

// 코루틴 함수가 실행 되는 과정에서 suspend 키워드를 가진 함수를 만나게 되면 더 이상 아래 코드를 실행 하지 않고 멈추고
// 코루틴 block 을 탈출함

suspend fun longRunningTast() {
    println("Executing Long RunniungTask On ....  ${Thread.currentThread().name} ");
    delay(1000);
    println("Long RunningTask Ends On Thread ..... : ${Thread.currentThread().name}");
}
