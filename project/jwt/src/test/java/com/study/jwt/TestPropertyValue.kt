package com.study.jwt

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value

class TestPropertyValue(
    @Value("${jwt.secret}") val secretKey: String,
) {

    @Test
    fun testPropertyValue() {
        println(secretKey)
    }
}