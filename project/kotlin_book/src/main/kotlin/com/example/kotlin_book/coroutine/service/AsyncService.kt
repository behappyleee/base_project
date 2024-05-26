package com.example.kotlin_book.coroutine.service

import org.springframework.stereotype.Service

@Service
class AsyncService {

    fun async1() {
        asyncLinedUp {

        }
    }

    fun asyncLinedUp(myTurn: () -> Unit) {
        Thread {
            println("Async Lined Up New Thread !!! Name : ${Thread.currentThread().name} , ThreadId : ${Thread.currentThread().threadId()}")
            Thread.sleep(3000)
            // myTurn.invoke() 랑 myTurn() 차이가 뭔지 확인이 필요 ... !!
            myTurn.invoke()
        }
    }




}