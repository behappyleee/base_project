package com.sample.study.coroutine.controller

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Non-Prremptive multitasking 은 Coroutine 은 OS 가 Thread 들의 작업을 스케줄링 하도록 하지 않고
// subroutine 간의 상호작용을 통해서 언어적으로 또는 코드 작성자가 작업을 스케줄링 할 수 있도록 함

fun main() {
    // Coroutine !!
    runBlocking {
        val lineUp = launch {
            coroutineLineUp()
        }

        val playMusicWithLinedUp = launch {
            coroutinePlayMusic()
        }

        lineUp.join()
        playMusicWithLinedUp.cancel()
        coroutineTicketing()

        val waitingBus = launch {
            coroutineWaitingBus()
        }

        val playMusicWithWaitingBus = launch {
            coroutinePlayMusic()
        }

        waitingBus.join()
        playMusicWithWaitingBus.cancel()
        coroutineTakeTheBus()


    }
}

suspend fun coroutineLineUp() {
    println("Lined Up !!")
    delay(2000)
}

suspend fun coroutinePlayMusic() {
    println("Play the music ...  !!")
    while(true) {
        println("Listening ..... !! ")
        delay(500)
    }
}

suspend fun coroutineWaitingBus() {
    println("Waiting the bus .... !!")
    delay(2000)
}

suspend fun coroutineTakeTheBus() {
    println("Waiting the bus .... ")
    delay(2000)
}

fun coroutineTicketing() {
    println("Coroutine Ticketing ..... !!!")

}


class CoroutineExample {


}