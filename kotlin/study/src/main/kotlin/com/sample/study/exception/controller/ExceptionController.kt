package com.sample.study.exception.controller

import com.sample.study.exception.custom.CustomException
import com.sample.study.exception.enums.ErrorCode
import com.sample.study.exception.service.ExceptionService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.lang.IllegalArgumentException

@RestController
@RequiredArgsConstructor
class ExceptionController(
    private val service: ExceptionService,
) {
    // Java 와 달리 Kotlin 은 메서드 옆에 throws 절이 없다는 점이 가장 큰 차이점

    // Exception Handling is an essential aspect of writing robus and maintainable code, In kotlin
    // like in many other programming languages you can use try cat finally and throw for handling exceptions.
    // Use Specific Exceptions Types ===> Catch only the exceptions that you expect and can handle, Avoid catching general
    // exceptions like 'Exception' unless absolutely necessary. This helps in maintaining code clarify.

    // finally for Clean up,


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
        } catch (e: IOException) {
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
        } catch (e: ArithmeticException) {
            println("Arithmetic Exception : ${e.message}")
        } catch (e: IllegalArgumentException) {
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
        val result = service.throwTest(3, 0)
        return "This is Throw Test $result !!!"
    }

    // 4. Custom Exception
    // This is basic overview exception handling in Kotlin. Remember th handle exceptions
    // that you expect might occur and allow the program to gracefully handle unexpected errors.
    // Additionally, be mindful of the types of exceptions you catch to avoid more than you intend.
    @GetMapping("/test/custom")
    fun customTest(): String {
        try {
            throw CustomException("This is a Custom Exception !")
        } catch (e: CustomException) {
            println("Custom Exception Pring [${e.message} , ${e.localizedMessage} , ${e.cause}]")
        }
        return "This is custom exception !"
    }

    @GetMapping("/test/throws")
    fun throwsTest(): String {
        return "This is Throws Test !!"
    }


    fun divide(a: Int, b: Int): Int {
        return a / b
    }

    @GetMapping("/throw/check")
    fun throwCheck(): String {
        val throwCheck = try {
            "Check Throw !"
        } catch (e: Exception) {
            throw Exception("This is Kotlin Exception !")
        }
        return throwCheck
    }

    @GetMapping("/trigger/enum/exception")
    fun enumException(): String {
        throw MyCustomExceptionUseEnum(ErrorCode.INVALID_REQUSET)
    }

    @GetMapping("/trigger/exception")
    fun triggerException(): String {
        // 만약 throw 가 던져졌을 시 처리해주는 try / catch 문이 존재 하지 않을 시 Controller Advice 에서 모든 throw Exception 을 처리해 줌 !!!!
        // throw 를 던졌을 시 처리해주는 try / catch 문이 존재 시 ControllerAdvide 를 통하지 않음 !!
        // throw CustomBrowserException("This is Customer Browser Exception from Trigger Exception Controller !")
        throw Exception("This is Exception Exception ! From Trigger Exception CONTROLLER !!!")
        return "Test Return !"
//        return try {
//            // throw Exception("This is Trigger Exception Test It is made !!")
//            // throw CustomRuntimeException("This is My Customer Exception !!")
//            throw CustomBrowserException("This is Browser Exception Test Check !!")
//
//        } catch (e :CustomBrowserException) {
//            println("PRINTING IN CATCH BLOCK ! : " + e.message)
//            return "Ths is Error Please Parameter Check !"
//        // Exception 이 제일 상위에 존재 시 모든 것이 Exception Catch 문에서 걸려 버림 !
//        // 항상 Exception 은 맨 뒤에 위치 하거나 주의해서 배치 !
//        } catch(e: Exception) {
//            println("THIS IS EXCEPTION CATCH !!! : " + e.message)
//            return e.message.toString()
//        }
////        } catch (e :CustomBrowserException) {
////            println(e.message)
////            "Ths is Error Please Parameter Check !"
////        }
//        }
    }

    @GetMapping("/test/loop/exception")
    fun testLoopException() {
        val listNumbers = listOf(3, 1, 2, 7, 0, 3)

        listNumbers.forEach {
            try {
                val divNum = 3 / it
                println("DIVIDE NUM : " + divNum)
            } catch (e: ArithmeticException) {
                println("DIVNUM CHECK : ")
                println("WHEN IT HAPPEN ERROR IN LIST : ${it}")
                println("THIS IS KOTLIN ARTIMETIC EXCEPTION !!! [ONLY ERROR MESSAGE : ${e.message} ]")
            }
        }

    }
}

class CustomRuntimeException(message: String): RuntimeException(message)
class CustomBrowserException(message: String): IllegalArgumentException(message + "My Custom Exception !")
class MyCustomExceptionUseEnum(val errorCode: ErrorCode): RuntimeException(errorCode.message)