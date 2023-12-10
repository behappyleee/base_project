package com.sample.study.annotation.controller

import com.sample.study.annotation.service.AnnotationExampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnnotationExampleController(
    val service: AnnotationExampleService,
) {

    // Annotation Sample Controller !
    // Annotations play a crucial role in Spring Boot application for configuring and customizing
    // various aspects of the application.
    @GetMapping("/test/annotation")
    fun testAnnotation(): String {
        service.serviceTest()

        return "This is Test Annotation to Check !"
    }

}