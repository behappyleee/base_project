package com.example.kotlin_book.sealed

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanNameTest {

    @Bean(name = ["AASASAS"])
    fun beanNoNameTest(): String {
        return "asdasdd"
    }
}