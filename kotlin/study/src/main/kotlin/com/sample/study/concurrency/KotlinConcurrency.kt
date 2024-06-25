package com.sample.study.concurrency

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class KotlinConcurrency {

}

fun getName1(): String {
    Thread.sleep(1000)
    return "Susan"
}

fun getLastName1(): String {
    Thread.sleep(1000)
    return "Calvin"
}


fun main2() {

    val time = measureTimeMillis {
        val name1 = getName1()
        val lastName1 = getLastName1()
        println("Hello My name is $name1 $lastName1")
    }

    println("Execution took time for $time")
}

fun main1() = runBlocking {

    // Thread 는 무겁고 생성하는 데 비용이 많이 들며 제한 된 수의 스레드만 생서이 가능
    // Kotlin 은 Channel / Actors / Mutual Exclusions
    // 의존성이 없기에 동시에 실행하는 게 나음 !
    val time = measureTimeMillis {
        // name 과 lastname 을 순차적 실행을 함 !!!
        // 하지만 name 과 lastName 은 의존 성이 없기에 각자 실행하는 게 나음 ... !
        val name = getName()
        val lastName = getLastName()

        println("Hello I am $name $lastName")
    }

    println("Execute took $time ms")
}

// 순차적인 아닌 각자 실행해버림
fun main() = runBlocking {

    // async 를 호출하면 두 함수를 동시에 실행하여야 하며 await() 을 호출하여 두 연산에 모두 결과가 나타날떄까지
    // main() 이 일시 중단 되도록 하였다.
    val time = measureTimeMillis {
        val name = async { getName() }
        val lastName = async { getLastName() }

        println("Hello My name is ${name.await()} ${lastName.await()}")
    }

    println("Execution took $time ms")
}

suspend fun getName(): String {
    delay(1000)
    return "Susan"
}

suspend fun getLastName(): String {
    delay(1000)
    return "Calvin"
}