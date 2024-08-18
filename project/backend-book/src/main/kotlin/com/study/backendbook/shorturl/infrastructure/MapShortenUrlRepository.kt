package com.study.backendbook.shorturl.infrastructure

import com.study.backendbook.shorturl.domain.ShortenUrl
import org.springframework.stereotype.Repository

@Repository
open class MapShortenUrlRepository: ShortenUrlRepository {

    // 단축 URL 을 저장하는 컬렉션은 Map 을 사용한다, List 를 사용시 첫번째 요소 0 부터 비교를 하여야 하므로 비효울적이다.
    private val shortenUrls : MutableMap<String, ShortenUrl> = mutableMapOf()

    override fun saveShortenUrl(shortenUrl: ShortenUrl) {
        shortenUrls[shortenUrl.originalUrl] = shortenUrl
    }

    override fun findShortenUrlByShortenUrlKeyOrThrow(shortenUrlKey: String): ShortenUrl {
        return shortenUrls.get(
            key = shortenUrlKey,
        ) ?: throw RuntimeException("존재하지 않는 Shorten Url Key 입니다.")
    }
}
