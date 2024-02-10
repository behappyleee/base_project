package com.study.jwt.token

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value

class TokenProvider(
    @Value("${jwt.secret}") val secret: String,
    @Value("${jwt.validity}") val tokenValidityInSeconds: Long,
): InitializingBean{

    @Override
    fun afterPropertiesSet() {
        val keyBytes = Decorders.

    }

}