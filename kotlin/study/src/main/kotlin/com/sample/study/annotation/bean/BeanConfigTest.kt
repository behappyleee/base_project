package com.sample.study.annotation.bean

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class BeanConfigTest {

    @Bean
    fun makeBeanTest(): String {
        println("[THIS IS MAKE BEAN TEST CHECK BEAN TEST METHOD !!!]")
        return "THIS IS BEAN CONFIG TEST MAKE BEAN METHOD !!"
    }

}