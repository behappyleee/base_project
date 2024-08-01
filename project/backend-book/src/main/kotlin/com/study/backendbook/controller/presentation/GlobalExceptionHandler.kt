package com.study.backendbook.controller.presentation

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// RestControllerAdvice
@RestControllerAdvice
class GlobalExceptionHandler {

    // 컨트롤러에서 유효성 검사에 실패 한 경우
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException
    ): ResponseEntity<ErrorMessage> {
        val fieldErrors = exception.bindingResult.fieldErrors

        val errors = fieldErrors.map { fieldError ->
            "${fieldError.field} , ${fieldError.defaultMessage}"

        }

        val errorMessages = ErrorMessage(errors = errors)
        return ResponseEntity(errorMessages, HttpStatus.BAD_REQUEST)
    }

    // 도메인 객체의 유효성 검사가 실패하였을 때 500 에러가 던져지는 상황을 400 에러가 던져지도록 바꾸어서 해결
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolatedException(
        exception: ConstraintViolationException
    ): ResponseEntity<ErrorMessage> {
        // val errorMessage = "This is Constraint Violation Exception !"

        val constraintViolations = exception.constraintViolations
            .map { violation -> "${violation.propertyPath} , ${violation.message}"}

        val errorMessage = ErrorMessage(errors = constraintViolations)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

}