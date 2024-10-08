package com.study.backendbook.shortenurl

import com.study.backendbook.shorturl.application.ShortenUrlService
import com.study.backendbook.shorturl.domain.NotFoundShortenUrlException
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ShortenUrlServiceTest(
    @Autowired
    private val shortenUrlService: ShortenUrlService,
) {
    @Test
    @DisplayName(value = "URL 을 단축 URL 로 단축 한 후 기존 URL 이 조회 되어야 한다.")
    fun shortenUrlTest() {
        val expectedOriginalUrl = "https://www.hanbit.co.kr"
        val shortenUrlRequestDto =
            ShortenUrlCreateRequest(
                originalUrl = expectedOriginalUrl,
            )

        val shortenUrlResponse= shortenUrlService.generateShortenUrl(shortenUrlCreateRequest = shortenUrlRequestDto)
        val shortenUrlKey = shortenUrlResponse.shortenUrlKey

        val originalUrl =
            shortenUrlService.getOriginalUrlByShortenUrlKey(
                shortenUrlKey = shortenUrlKey,
            )

        Assertions.assertTrue { expectedOriginalUrl == originalUrl }
    }

    @Test
    @DisplayName(value = "존재 하지 않는 단축 URL 을 조회하는 경우 에러가 발생하여야 한다.")
    fun invalidShortenUrlTest() {
        val invalidShortenUrlKey = "invalid shorten url key !"

        assertThrows<NotFoundShortenUrlException> {
            shortenUrlService.getShortenUrlInformationByShortenUrlKey(
                shortenUrlKey = invalidShortenUrlKey,
            )
        }
    }
}
