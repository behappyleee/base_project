package com.sample.study.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class CoroutineLaunchTest {

}

suspend fun main() {

    // launch() 빌더는 코루틴을 시작하고 코루틴을 실행 중인 작업의 상태를 추적하고 변경할 수 있는 Job 객체를 돌려 받음
    val time = measureTimeMillis {
        val launch = GlobalScope.launch {
            delay(5000)
        }
        // launch.cancel()
        launch.join()
    }

//        println(launch.cancel())


    println("Time : $time")
}
