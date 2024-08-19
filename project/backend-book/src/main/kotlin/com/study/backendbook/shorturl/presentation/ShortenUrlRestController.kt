package com.study.backendbook.shorturl.presentation

import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateRequest
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlCreateResponse
import com.study.backendbook.shorturl.presentation.dto.ShortenUrlInformation
import com.study.backendbook.shorturl.application.ShortenUrlService
import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.net.URISyntaxException

@RestController
class ShortenUrlRestController(
    private val shortenUrlService: ShortenUrlService,
) {
    @PostMapping("/shorten-url")
    fun createShortUrl(
        @Valid @RequestBody shortenUrlCreateRequest: ShortenUrlCreateRequest,
    ): ResponseEntity<ShortenUrlCreateResponse> {
        return ResponseEntity.ok(
            shortenUrlService.generateShortenUrl(shortenUrlCreateRequest = shortenUrlCreateRequest)
        )
    }

    @GetMapping("/{shorten-url-key}")
    @Throws(URISyntaxException::class)
    fun <T>redirectShortUrl(
        @PathVariable(name = "shorten-url-key") shortenUrlKey: String,
    ): ResponseEntity<T> {
        val originalUrl = shortenUrlService.getOriginalUrlByShortenUrlKey(
            shortenUrlKey = shortenUrlKey,
        )

        val redirectURI = URI(originalUrl)
        val httpHeaders = HttpHeaders()
        httpHeaders.location = redirectURI

        return ResponseEntity(httpHeaders, HttpStatus.MOVED_PERMANENTLY)
    }

    @GetMapping("/shorten-rul/{shorten-url-key}")
    fun <T> getShortenUrlInformation(
        @PathVariable(name = "shorten-url-key") shortenUrlKey: String,
    ): ResponseEntity<ShortenUrlInformation> {
        return ResponseEntity.ok(
             shortenUrlService.getShortenUrlInformationByShortenUrlKey(
                shortenUrlKey = shortenUrlKey,
            )
        )
    }
}
