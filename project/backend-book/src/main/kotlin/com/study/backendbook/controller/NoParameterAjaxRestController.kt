package com.study.backendbook.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NoParameterAjaxRestController {
    
    @RequestMapping("/get-with-no-parameters")
    fun getWithNoParameters(): String {

        check(true) {
            println("TEST PRINT !!!")
        }

        check(false, lazyMessage = { println("") })
        check(true, lazyMessage = fun () { println("This is test !") })

        return "파라미터가 없는 GET 요청"
    }
}
