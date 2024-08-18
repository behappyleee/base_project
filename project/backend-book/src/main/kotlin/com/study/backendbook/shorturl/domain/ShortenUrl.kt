package com.study.backendbook.shorturl.domain

import com.study.backendbook.shorturl.application.ShortenUrlService
import java.lang.StringBuilder
import kotlin.random.Random

data class ShortenUrl(
    val originalUrl: String,
    val shortenUrl: String,
    val redirectCount: Int = 0,
) {
    companion object {
        fun generateShortenUrl(): String {
            // Base56 인코딩에 사용되는 문자열
            val base56Chracters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz"
            val random = Random
            // StirngBuilder 는 ThreadSafe 한 방식은 아니다. 스레드 세이프 하지 않은 이 방식을 사용해도 괜찮을까 의문이 있다
            // 메서드 내에 있는 지역 변수는 해당 스레드 내에서만 사용이 되기에 괜찮다. 우리가 스레드 세이프 하지 않은 ArrayList 를 자주 사용하는 이유와 같다.
            val urlKey = StringBuilder()

            for (i in 1 ..ShortenUrlService.SHORT_URL_KEY_LENGTH) {
                val base56CharactersIndex = random.nextInt(0, base56Chracters.length)
                val base56Chracter = base56Chracters[base56CharactersIndex]

                urlKey.append(base56Chracter)
            }

            return urlKey.toString()
        }
    }
}
