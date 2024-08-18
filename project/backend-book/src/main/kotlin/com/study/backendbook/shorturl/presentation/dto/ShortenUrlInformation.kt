package com.study.backendbook.shorturl.presentation.dto

data class ShortenUrlInformation(
    val originalUrl: String,
    val shortenUrlKey : String,
    val redirectCount: Int,
)