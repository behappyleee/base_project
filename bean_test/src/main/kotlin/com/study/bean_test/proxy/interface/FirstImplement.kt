package com.study.bean_test.proxy.`interface`

import org.springframework.stereotype.Component

@Component
class FirstImplement: InterfaceTest {

    override fun test(): String {
        println("This is First Implementation")
        return "First implementation"
    }
}
