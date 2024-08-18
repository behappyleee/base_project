package com.study.backendbook.shorturl.infrastructure

import com.study.backendbook.shorturl.domain.ShortenUrl


interface ShortenUrlRepository {

    fun saveShortenUrl(shortenUrl: ShortenUrl)

    // TODO - ShortenUrlKey 의미랑 ShortenUrl 의미를 확실하게 알기 ... !!
    fun findShortenUrlByShortenUrlKeyOrThrow(shortenUrlKey: String): ShortenUrl

}
