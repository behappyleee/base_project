package com.study.backendbook.shorturl.infrastructure

import com.study.backendbook.shorturl.domain.ShortenUrl


interface ShortenUrlRepository {

    fun saveShortenUrl(shortenUrl: ShortenUrl)

}