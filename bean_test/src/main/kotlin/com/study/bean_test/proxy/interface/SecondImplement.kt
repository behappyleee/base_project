package com.study.bean_test.proxy.`interface`

import org.springframework.stereotype.Component

@Component
class SecondImplement: InterfaceTest {
    override fun test(): String {
        println("SecondImplement !!!")
        return "Second Implement !"
    }
}
