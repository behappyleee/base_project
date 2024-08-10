package com.study.backendbook.controller.product.domain

class DatabaseConnectionFailException(
    private val errorMessage: String,
) : RuntimeException(errorMessage)
