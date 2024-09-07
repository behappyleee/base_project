package com.study.backendbook.my.product.domain

class DatabaseConnectionFailException(
    private val errorMessage: String,
) : RuntimeException(errorMessage)
