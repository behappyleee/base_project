package com.study.jwt

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value

class TestPropertyValue(
    // jwt value property 값을 못 읽어옴, 1 번쨰 시도 lombok import !
    @Value("\${jwt.secret}")
    val testVal: String,
) {

    @Test
    fun testPropertyValue() {

    }
}