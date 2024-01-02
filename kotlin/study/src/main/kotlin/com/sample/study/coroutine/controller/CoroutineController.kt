package com.sample.study.coroutine.controller

import com.sample.study.coroutine.service.CoroutineService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoroutineController(
    private val service: CoroutineService,
) {

    // Kotlin 과 Coroutine 을 함께 사용하면 비동기 프로그래밍을 보다 간결하고 효율적으로 구현이 가능
    // 실제 어플리케이션에서는 더 복잡한 비동기 작업과 흐름 제어가 필요할 수 가 있음
    // 단일 데이터를 비동기적으로 반환
    @GetMapping("/async-data")
    suspend fun getAsyncData(): String {
        return service.getAsyncData()
    }

    @GetMapping("/async-data-stream")
    fun getAsyncDataStream(): Flow <String> = flow {
        println("Start Stream")
        // Flow 는 여러번 비동기적으로 여러 개의 데이터를 가져옴
        repeat(5) {
           service.getAsyncData()
        }
        println("End Stream !")
    }


}