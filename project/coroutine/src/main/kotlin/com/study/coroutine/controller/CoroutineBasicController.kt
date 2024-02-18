package com.study.coroutine.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoroutineBasicController {

    // Coroutine - 실행과 지연을 재개 함으로써 비선점적 멀티태스킹을 위한 서브 루틴을 일반화한
    // 컴퓨터 프로그램의 구성 요소

    @GetMapping("/coroutine/basic")
    fun coroutineBasic() {

    }

}