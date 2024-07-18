package com.sample.study.coroutine.inflearn

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.web.servlet.function.ServerResponse.async
import kotlin.system.measureTimeMillis

class CoroutineLesson4 {
}

// async - 주어진 함수의 실행 결과를 반환할 수 있다
// async 를 활용하면 여러 API 를 동시에 호출하여 소욧시간을 최소화 할 수 있다
fun main(): Unit = runBlocking {

//    val job = async {
//        3 + 5
//    }
//
//    // await 이라는 것은 async 의 결과를 가져오는 함수임
//    val eight = job.await()
//    printWithThread(eight)

    val time = measureTimeMillis {
        val job1 = async {
            apiCall1()
        }

        val job2 = async {
            apiCall2()
        }

        // async 한 것의 결과물을 가져옴 소요시간
        printWithThread(job1.await() + job2.await())
    }

    // 소요시간은 1초대임 여러, async 의 최대 장점은 callback 을 사용하지 않고 동기화 코드처럼 작성이 가능
    printWithThread("소요 시간 : $time ms")

    val time1 = measureTimeMillis {
        val job3 = async {
            apiCall1()
        }

        val job4 = async { apiCall3(job3.await()) }

        printWithThread("Plus Result ${job3.await() + job4.await()}")
    }

    printWithThread("소요 시간 2 : $time ms")

    val time2 = measureTimeMillis {
        val job5 = async(start = CoroutineStart.LAZY) {
            apiCall1()
        }

        val job6 = async {
            apiCall3(job5.await())
        }

        printWithThread("Plus Result ${job5.await() + job6.await()}")
    }

    printWithThread("소요 시간 3 : $time ms")


}

// suspend 를 사용하면 또 다른 suspend 를 호출이 가능함
suspend fun apiCall1(): Int {
    delay(1_000L)
    return 1
}

suspend fun apiCall2(): Int {
    delay(1_000L)
    return 2
}

suspend fun apiCall3(num: Int): Int {
    delay(1_000L)
    return num + 2
}


