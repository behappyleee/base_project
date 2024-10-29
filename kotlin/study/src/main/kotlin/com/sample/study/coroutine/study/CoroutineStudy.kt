package com.sample.study.coroutine.study

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.web.servlet.function.ServerResponse.async

class CoroutineStudy {}

suspend fun main()  {
    println("Start Thread : ${Thread.currentThread().name}")

    runBlocking {
        println("Start CoroutineStudy 11111 : ${Thread.currentThread().name}")
        delay(3000)
        println("SDSDSDSD")
    }

    val aaa = runBlocking(Dispatchers.IO) {
        println("CURRENT THREAD NAME IN ASYNC !! ${Thread.currentThread().name}")
        delay(7000)
        async { println("TEST CHECK !!!! THIS IS ASYNC !!! FUNCTION !!!") }
    }

    aaa.await()

    CoroutineScope(Dispatchers.IO).launch {
        println("TRRRERER")
        delay(8000)
        println("THREAD CHECK - 2 AAAA : ${Thread.currentThread().name}")
        delay(2100L)
        println("IN LAUN CH !!!TEST asdasd !!!")
    }

//    runBlockTest()

    CoroutineScope(Dispatchers.IO).launch {
        println("THREAD CHECK - 1 : ${Thread.currentThread().name}")
        delay(2500L)
        println("EXECUTE DIRECTLY !!")
    }

    CoroutineScope(Dispatchers.IO).launch {
        println("THREAD CHECK - 2 : ${Thread.currentThread().name}")
        delay(5000L)
        println("IN LAUN CH !!!TEST !!!")
    }

    runBlockFun()

//    runBlockTest()

    println("END !")
//    val job1 = launch {
//        println("runBlocking Thread : ${Thread.currentThread().name}")
//        println("This is in runBlocking !!")
//    }
//
//    val job2 = async(Dispatchers.IO) {
//        delay(1000)
//        println("In Async Thread : ${Thread.currentThread().name}")
//        println("This is Async !")
//    }
//
//    job1.join()
//    job2.await()
//
//    println("Current Thread : ${Thread.currentThread().name}")
//    println("Coroutine Test !")
}

fun runBlockFun() = runBlocking {
    println("THE THREAD NAME IN RUN BLOCK FUN !!! ${Thread.currentThread().name}")
    delay(2000L)
    println("THIS IS RUN BLOCK SECOND FUNCTION !!!")
}

suspend fun runBlockTest() {
    delay(2000)
    println("THIS IS RUN BLOCKING FUNCTION !!")
}