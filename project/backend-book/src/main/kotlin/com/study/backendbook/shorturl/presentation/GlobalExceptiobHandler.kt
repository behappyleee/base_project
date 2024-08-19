package com.study.backendbook.shorturl.presentation

import com.study.backendbook.shorturl.domain.NotFoundShortenUrlException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptiobHandler {

    @ExceptionHandler(NotFoundShortenUrlException::class)
    fun handleNotFoundException(
        exception: NotFoundShortenUrlException,
    ): ResponseEntity<String> {
        return ResponseEntity("단축 URL 을 찾이 못했습니다.", HttpStatus.NOT_FOUND)
    }
}