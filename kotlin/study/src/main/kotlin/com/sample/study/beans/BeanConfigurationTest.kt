package com.sample.study.beans

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfigurationTest {

    @Bean
    fun beanTest1() {
        println("[THIS IS BEAN TEST 1 !!!!]")
    }

    @Bean
    fun beanTest2() {
        println("[THIS IS BEAN TEST 2 !!!!!]")
    }

}