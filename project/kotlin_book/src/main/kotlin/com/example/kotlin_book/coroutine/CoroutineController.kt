package com.example.kotlin_book.coroutine

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CoroutineController {

    // 일반적으로 프로그램은 메인 루틴과 서브 루틴으로 이루어져있음
    // 보통 프로그램을 시작하는 곳이 메인 루틴임, 메인 루틴은 다양한 서브 루틴으로 이루어져있음

    @GetMapping("/sync")
    fun syncTest(): String {
        // Main Thread 를 Sleep 시 해당 스레드가 끝나고 값을 반환한다 !
        Thread.sleep(1000)

        return "Sync Method Test !"
    }

}
