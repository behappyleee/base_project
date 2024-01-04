package com.sample.study.coroutine.controller

import com.sun.tools.javac.Main
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.internal.MainDispatcherFactory
import kotlinx.coroutines.launch
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io

fun main() {

    // Coroutine Context 에는 Main / IO / Default 총 3가지가 있음
    // Main - 메인 스레드에 대한 컨텍스트로, UI 갱신이나 Toast 등의 view 작업에 사용이 됨
    // IO - 네트워킹이나 내부 DB 접근 등 백그라운드에서 필요한 작업들을 수행
    // Default - Default 는 크기가 큰 리스크를 다루거나 필터링을 수행하는 등의 무거운 연산을 할 떄 사용

    // suspend - suspend 함수는 그 함수가 비동기 환경에서 사용될 수 있다는 의미를 내포
    // Coroutine 은 하나의 스레드 속에서 돌아가는 하나의 job 이고 이 하나의 스레드 안에 여러 개의 코루틴이
    // 실행되고 있을 수 있다, 그렇기 떄문에 delay 는 한 스레드 속에 있는 여러 코루틴 중에 코루틴 하나만 멈추고
    // Thread.sleep 은 스레드 하나를 멈추니까 그 속에 있는 여러 개의 코루틴을 멈춘다. 그러니 Coroutine 내부에서
    // Thread.sleep 을 호출하면 매우 안좋다 ... !



}

class CoroutineStudy {

    fun test() {


    }

}