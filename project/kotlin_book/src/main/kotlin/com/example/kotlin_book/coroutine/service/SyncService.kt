package com.example.kotlin_book.coroutine.service

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class SyncService {

    fun syncService() {
        // 코루틴에서의 말하는 병행적으로 가능하다는 것은 다른 하나의 쓰레드가 똑같이 내가 처음에 할당한 메이 쓰레드들처럼 동시성으로 작업을 하는 것
        // Context Switch - 2개의 스레드를 사용하지만 비효율적으로 처음에 할당한 스레드가 아닌 다른 여러 스레드를 중구난방으로 들고온다는 이야이

        // RunBlocking 이라는 coroutine builder 를 사용하여 순차적으로 실행할 비동기 작업을 묶어준다.
        // 순차적인 비동기 작업 실행 예제
        runBlocking {
            normalFunction()
            firstSync()
            secondSync()
            normalFunction()
        }
    }

    fun normalFunction(): String {
        println("This is Normal Function !!")
        return "Just Normal Kotlin Function !"
    }

    // suspend keyword : suspend 키워드는 코루틴이 일시 중단하는 함수
    // 코루틴 함수가 실행되는 과정에서 suspend 키워드를 가진 함수를 만나게 되면 더 이상 아래 코드를 실행하지 않고
    // 탈출을 한다는 의미이다.
    suspend fun firstSync(): String {
        println("This is [Coroutine First Sync Function !!]")
        // delay 는 코루튼 내장함수이다. 실제로는 다양한 함수들이 존재
        delay(3000)
        return " First Sync !!"
    }

    suspend fun secondSync(): String {
        println("This is [Coroutine Second Sync Function !!]")
        delay(3000)
        return "Second Sync !!"
    }



}