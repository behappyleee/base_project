package com.example.kotlin_book.coroutine.service

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.springframework.stereotype.Service

@Service
class AsyncService {

    class Async1 {
        // 각각의 Routine 들은 독립적인 Thread 안에서 동작을 함
        // 코드가 매우 복잡해 짐, 각 루틴들이 서로에게 영향을 주기 위하여서는 Thread 사이에서 통신을 필요로 하게됨
        // 기본적으로 Thread 는 OS 에서 관리를 하게 됨 OS 에서 Thread 들을 관리하는 것은 비용이 비쌈
        // OS 가 각 Thread 작업들을 스케줄링 할 때 Context Switching 비용이 필요하게 됨

        // coroutine 는 thread 와 callback 을 통한 비동기 프로그래밍에서의 단점들을 non-preemptive multitasking 방식으로 해결하고 있습니다.

        fun async1() {
            asyncLinedUp {
                stopMusic()

                asyncTakeTheBus {
                    stopMusic()
                }

                asyncPlayMusic()
            }

            asyncPlayMusic()
        }

        fun asyncLinedUp(myTurn: () -> Unit) {
            Thread {
                println("Async Lined Up New Thread !!! Name : ${Thread.currentThread().name} , ThreadId : ${Thread.currentThread().threadId()}")
                Thread.sleep(3000)
                // myTurn.invoke() 랑 myTurn() 차이가 뭔지 확인이 필요 ... !!
                myTurn.invoke()
            }.start()
        }

        fun asyncTakeTheBus(onTime: () -> Unit) {
            Thread {
                println("Async Take The Bus  New Thread !!! Name : ${Thread.currentThread().name} , ThreadId : ${Thread.currentThread().threadId()}")
                Thread.sleep(3000)
                onTime.invoke()
                println("Finish Take The Bus !!!")
            }
        }

        var playingMusic = false

        fun asyncPlayMusic() {
            Thread {
                println("Play The Music New Thread !!! Name : ${Thread.currentThread().name} , ThreadId : ${Thread.currentThread().threadId()}")
                playingMusic = true
                while(playingMusic) {
                    println("listening..")
                    Thread.sleep(500)
                }
            }.start()
        }

        fun stopMusic() {
            playingMusic = false
            println("stop music")
        }
    }

    class Async2 {

        fun async2() {
            // runBlocking : runBlocking 은 현재 Thread 를 block 하는 Coroutine dmf todtjdgksms gkatn
            // 즉 runBlocking 이 호출 된 Thread 는 runBlocking 내의 작업이 완료 되기 전까지는 다른 작업을 하지 못함
            // launch 함수는 현재 thread 에 대한 blocking 없이 실행 되는 coroutine 을 생성, 즉 현재 Thread 에 다른 작업을 할당이 가능
            runBlocking {
                CoroutineScope(Dispatchers.IO).launch {
                    val tesst = Channel<Int>().receive()
                    println("GET RECEIVED DATA : $tesst")
                }

                val lineUp = launch {
                    coroutineLinedUp()
                }

                val playMusicWithLinedUp = launch {
                    coroutinePlayMusic()
                }

                lineUp.join()
                playMusicWithLinedUp.cancel()
                coroutineTicketing()

                val waitingBus = launch {
                    coroutineWaitingTheBus()
                }

                val playMusicWithWaitingBus = launch {
                    coroutinePlayMusic()
                }

                waitingBus.join()
                playMusicWithWaitingBus.cancel()
                coroutineTakeTheBus()
            }
        }

        suspend fun coroutineLinedUp() {
            println("lined up")
            delay(2000)
        }

        fun coroutineTicketing() {
            println("ticketing")
        }

        suspend fun coroutineWaitingTheBus() {
            println("waiting the bus")
            delay(2000)
        }

        fun coroutineTakeTheBus() {
            println("take the bus")
        }

        suspend fun coroutinePlayMusic() {
            println("play music")
            while(true) {
                println("listening..")
                delay(500)
            }
        }



    }
}
