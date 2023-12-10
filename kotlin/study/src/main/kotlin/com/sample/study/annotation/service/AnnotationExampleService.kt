package com.sample.study.annotation.service

import com.sample.study.annotation.custom.LogCustomAnnotation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AnnotationExampleService {

    private val logger = LoggerFactory.getLogger(AnnotationExampleService::class.java)

    @LogCustomAnnotation
    fun serviceTest() {
        // LogCustomAnnotation 이 존재하여 머전 LogCustomAnnotation
        // AOP 를 실행하고 해당 Method 를 실행 !
        println("[CURRENT THREAD NAME ] : " + Thread.currentThread().name)
        println("[CURRENT THREAD ID ] : " + Thread.currentThread().id)
        Thread.sleep(3000)
        println("[SERVICE TEST LOG CUSTOM ANNOTATION Execution !!!!]")
    }

}