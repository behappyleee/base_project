package com.sample.study.exception.controller

import com.sample.study.exception.service.ExceptionService
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.lang.IllegalArgumentException

@RestController
@RequiredArgsConstructor
class ExceptionController(
    private val service: ExceptionService,
) {
    // Exception Handling in kotlin similar to many other programming languages
    // In Kotlin exceptions are instances of classes that inherit from 'Throwable' class
    // Exception (for exceptional conditions that a program should catch)
    // Error (for exceptional conditions that are external to the application that the application
    // cannot recover from)

    // Try-catch Block
    // The 'try' block contains the code that might an exception. The 'catch' block is uses to
    // handle the exception if it occurs.
    @GetMapping("/test/exception")
    fun testException(): String {
        // 만약 Error Handling 을 해주지 않으면 해당 Request Thread 가 그대로 끝남
//        val result = divide(10, 0)
//        println("[RESULT] :  $result")
        try {
            val result = divide(10, 0)
            println("[RESULT] :  $result")
        } catch(e: IOException) {
            println("Exception caught : ${e.message}")
        } finally {
            println("Finally Block Execute !!")
        }
        return "This is test for exception"
    }

    // Multiple Catch Blocks
    // You can have multiple 'catch' blocks to handle different types of exceptions.
    @GetMapping("/test/multi/catch")
    fun catchTest(): String {
        try {
            val result = divide(10, 0)
            println("Result : $result")
        } catch(e: ArithmeticException) {
            println("Arithmetic Exception : ${e.message}")
        } catch(e: IllegalArgumentException) {
            println("IllegalArgumentException : ${e.message}")
        } finally {
            println("This is finally block !")
        }
        return "This is Multiple Catch Block !"
    }

    // Throwing Exceptions
    // You can throw exceptions explicitly using the 'throw' keyword
    @GetMapping("/test/throw")
    fun throwTest(): String {
        service.throwTest()

        return "This is Throw Test !!!"
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }

}