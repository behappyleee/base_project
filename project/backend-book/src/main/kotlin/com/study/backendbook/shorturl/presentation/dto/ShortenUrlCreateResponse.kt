package com.study.backendbook.shorturl.presentation.dto

data class ShortenUrlCreateResponse(
    val originalUrl: String,
    val shortenUrlKey: String,
)