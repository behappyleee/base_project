package com.sample.study.exception.controller

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun handlerCustomerException(ex: Exception): ResponseEntity<String> {
        println("THIS IS KOTLIN EXCEPTION !!! : " + ex)
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("THIS IS ADBIDE CONTROLLER : ${ex}")
    }

    @ExceptionHandler(CustomBrowserException::class)
    fun handleCustomerBrowserException(ex: CustomBrowserException): ResponseEntity<String> {
        println("THIS IS TEST CONTROLLER CHECK HANDLE CUSTOMER BROWSER EXCEPTION !")
        logger.debug("THIS IS Controller Advice !!! Exception Handler !!")

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occurred: ${ex.message}")
    }

    // Add more exception handlers as needed
    @ExceptionHandler(MyCustomExceptionUseEnum::class)
    fun handleUseEnumException(ex: MyCustomExceptionUseEnum, request: HttpServletRequest): ResponseEntity<ErrorResponseCustom> {
        val customErrorResponse = ErrorResponseCustom(ex.errorCode.status, ex.errorCode.message, request.servletPath)
        logger.debug("THIS IS HANDLE USE ENUM EXCEPTION DATA CHECK !!!")
        return ResponseEntity.status(ex.errorCode.status).body(customErrorResponse)
    }

    // Add more exception handlers as needed

}

data class ErrorResponseCustom(
    val status: Int,
    val message: String,
    val path: String,
)