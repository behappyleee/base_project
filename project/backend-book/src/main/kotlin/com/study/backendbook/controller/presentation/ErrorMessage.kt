package com.study.backendbook.controller.presentation

class ErrorMessage (
    private val errors: List<String>,
){

    fun getErrors(): List<String> {
        return errors
    }
}