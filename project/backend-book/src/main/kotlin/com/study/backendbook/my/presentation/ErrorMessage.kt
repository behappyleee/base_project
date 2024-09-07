package com.study.backendbook.my.presentation

class ErrorMessage(
    private val errors: List<String>,
) {
    fun getErrors(): List<String> {
        return errors
    }
}
