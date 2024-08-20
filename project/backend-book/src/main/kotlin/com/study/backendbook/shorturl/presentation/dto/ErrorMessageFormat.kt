package com.study.backendbook.shorturl.presentation.dto

import org.springframework.http.HttpStatus

data class ErrorMessageFormat(
    val message: String,
    val code: HttpStatus,
)