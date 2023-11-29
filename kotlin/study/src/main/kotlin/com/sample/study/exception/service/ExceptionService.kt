package com.sample.study.exception.service

import org.springframework.stereotype.Service

@Service
class ExceptionService {

    fun throwTest(a : Int, b: Int): Int {
        if(b == 0) {
            throw IllegalArgumentException("Division by zero is not allowed !")
        }
        return  a/b
    }

    fun throwsTest(a: Int, b:Int): Int {

        return a / b
    }


}