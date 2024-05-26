package com.example.kotlin_book.coroutine.controller

import com.example.kotlin_book.coroutine.service.AsyncService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class AsyncController(
    private val asyncService: AsyncService,
) {

    @GetMapping("/async-1")
    fun testAsync1() {
        println("[Start Async Test 1 !!!!] Thread Name : ${Thread.currentThread().name}")

        val aaa = AsyncService.Async1().async1()


        println("[End Async Test 1 !!!] Thread Name : ${Thread.currentThread().name}")
    }

    @GetMapping("/async-2")
    fun testAsync2() {
        println("[Start Async Test 2 !!!] Thread Name : ${Thread.currentThread().name}")

        AsyncService.Async2().async2()

        // Channeld 함수를 통하여 생성
        val channel = Channel<Int>()

        CoroutineScope(Dispatchers.Default).launch {
            channel.send(element = 7777777)
            // 데이터를 스트림으로 밀어넣을 때는 send
            // 데이터를 스트림에서 받을떄는 received
        }

        println("[End Async Test 2 !!!] Thread Name : ${Thread.currentThread().name}")
    }



}
