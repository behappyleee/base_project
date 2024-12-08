package com.study.bean_test.proxy.`interface`

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InterfaceUseClass(
    @Qualifier("firstImplement")
    private val interfaceTest: InterfaceTest,
) {
    @GetMapping("/call/interface")
    fun callInterface(): String {

        return "Call Success Interface !!!"
    }
}