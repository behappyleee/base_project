package com.study.backendbook.shorturl.infrastructure

import com.study.backendbook.shorturl.domain.NotFoundShortenUrlException
import com.study.backendbook.shorturl.domain.ShortenUrl
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentMap

@Repository
open class MapShortenUrlRepository: ShortenUrlRepository {

    // 단축 URL 을 저장하는 컬렉션은 Map 을 사용한다, List 를 사용시 첫번째 요소 0 부터 비교를 하여야 하므로 비효울적이다.
    private val shortenUrls : MutableMap<String, ShortenUrl> = mutableMapOf()

    override fun saveShortenUrl(shortenUrl: ShortenUrl) {
        shortenUrls[shortenUrl.shortenUrl] = shortenUrl
    }

    override fun findShortenUrlByShortenUrlKeyOrThrow(shortenUrlKey: String): ShortenUrl {
        return shortenUrls.get(
            key = shortenUrlKey,
        ) ?: throw NotFoundShortenUrlException("찾으시는 ShortenUrl 이 존재 하지 않습니다.")
    }
}
