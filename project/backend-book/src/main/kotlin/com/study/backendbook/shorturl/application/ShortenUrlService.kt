package com.study.backendbook.shorturl.application

import com.study.backendbook.shorturl.domain.LackOfShortenUrlKeyException
import com.study.backendbook.shorturl.domain.NotFoundShortenUrlException
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateRequest
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateResponse
import com.study.backendbook.shorturl.domain.ShortenUrl
import com.study.backendbook.shorturl.infrastructure.ShortenUrlRepository
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlInformation
import org.springframework.stereotype.Service

@Service
class ShortenUrlService(
    private val shortenUrlRepository: ShortenUrlRepository,
) {

    // 상품 관리 애플리케이션에서는 ProductDto 를 Product 로 변환해주는 과정이 있었다.
    // 상품관리 애플리케이션은 간단한 CRUD 만 진행하는 애플리케이션이기에 클라이언트가 모든 데이터를 채워서 보내주었지만
    // 단축 URL 서비스는 다르다. 단축 URL 의 키는 사용자가 지정해서 보내는 것이 아니라 애플리케이션 내에서 생성이 된다.
    // 따라서 dto 를 그대로 반환하는 것이 아닌 오직 original Url 이라는 문자열만 가져오고 단축 URL 키는 애플리케이션에서 생성 된 값을 이용한다.
    fun generateShortenUrl(
        shortenUrlCreateRequest: ShortenUrlCreateRequest,
    ): ShortenUrlCreateResponse {
        val originalUrl = shortenUrlCreateRequest.originalUrl
        val shortenUrlKey = getUniqueShortenUrlKey()

        shortenUrlRepository.saveShortenUrl(
                shortenUrl = ShortenUrl(
                    originalUrl = originalUrl,
                    shortenUrl = shortenUrlKey,
            )
        )

        return ShortenUrlCreateResponse(
            originalUrl = originalUrl,
            shortenUrlKey = shortenUrlKey,
        )
    }

    fun getShortenUrlInformationByShortenUrlKey(shortenUrlKey: String): ShortenUrlInformation {
        val shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKeyOrThrow(
            shortenUrlKey = shortenUrlKey
        )

        return ShortenUrlInformation(
            originalUrl = shortenUrl.originalUrl,
            shortenUrlKey = shortenUrl.shortenUrl,
            redirectCount = shortenUrl.redirectCount,
        )
    }

    // 단축 URL -> 원본 URL 로 리다이렉트를 해줘야함 !
    fun getOriginalUrlByShortenUrlKey(shortenUrlKey: String): String {
        val shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKeyOrThrow(
            shortenUrlKey = shortenUrlKey,
        )

        shortenUrl.increaseRedirectCount()
        return shortenUrl.originalUrl
    }

    private fun getUniqueShortenUrlKey(): String {
        var count = 0
        while (count++ < GENERATE_KET_RETRY_COUNT) {
            val shortenUrlKey = ShortenUrl.generateShortenUrlKey()
            try {
                shortenUrlRepository.findShortenUrlByShortenUrlKeyOrThrow(
                    shortenUrlKey = shortenUrlKey
                )
            } catch (exception: NotFoundShortenUrlException) {
                return shortenUrlKey
            }
        }

        throw LackOfShortenUrlKeyException("생성 가능한 URL 자원이 없습니다.")
    }

    companion object {
        const val SHORT_URL_KEY_LENGTH = 8
        const val GENERATE_KET_RETRY_COUNT = 5
    }
}