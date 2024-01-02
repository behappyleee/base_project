package com.sample.study.coroutine.service

import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class CoroutineService {

    suspend fun getAsyncData(): String {
        delay(1000) // 비동기적으로 1초 대기
        return "Hello, Kotlin Coroutines !!"
    }

}