package com.study.backendbook.shortenurl

import com.study.backendbook.shorturl.application.ShortenUrlService
import com.study.backendbook.shorturl.domain.LackOfShortenUrlKeyException
import com.study.backendbook.shorturl.domain.ShortenUrl
import com.study.backendbook.shorturl.infrastructure.ShortenUrlRepository
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LackOfShortenUrlTest(
    @Mock
    private val shortenUrlRepository: ShortenUrlRepository,
    // TODO - 왜 ShortenUrlService 는 InjectMock 어노테이션이 사용이 안될까 ... ?! 확인이 필요 ... !!!
    @Mock
    private val shortenUrlService: ShortenUrlService,
) {
    @Test
    @DisplayName(value = "단축 URL이 계속 중복이 되면 LackOfShortenUrlKeyException 이 발생한다.")
    fun throwLackOfShortenUrlExceptionTest() {
        val shortenUrlCreateRequestDto =
            ShortenUrlCreateRequest(
                originalUrl = "",
            )

        // 해당 메서드를 Mock 으로 이용한다 !
        // Mocking 을 활용하면 테스트 하기 어려운 코드들도 쉽게 테스트가 가능하다 !, 만약 Mocking 을 하지 않았다면 다섯 번 중복되는 상황을 만들기는 어려웠을 것이다.
        `when`(shortenUrlRepository.findShortenUrlByShortenUrlKeyOrThrow(anyString())).thenReturn(
            ShortenUrl(originalUrl = "", shortenUrl = "")
        )

        Assertions.assertThrows(LackOfShortenUrlKeyException::class.java) {
            shortenUrlService.generateShortenUrl(shortenUrlCreateRequest = shortenUrlCreateRequestDto)
        }
    }
}