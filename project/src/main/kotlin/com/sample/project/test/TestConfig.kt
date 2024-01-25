package com.sample.project.test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestConfig {

    @Bean
    fun testService(): TestService {
        return TestService(
            testBeanConfig = testBeanConfig()
        )
    }

    @Bean
    fun testBeanConfig():TestBeanConfig {
        return TestBeanConfig()
    }
}