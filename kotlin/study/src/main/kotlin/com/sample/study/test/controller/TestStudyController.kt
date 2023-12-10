package com.sample.study.test.controller

import com.sample.study.test.service.TestStudyService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestStudyController(
    val service: TestStudyService,
) {
    // Create a global Exception handler using @ControllerAdvice to handle exceptions
    // across your application. This is handler can be used to centralize exception handling logic.

    //

    val logger = LoggerFactory.getLogger(TestStudyController::class.java)

    @GetMapping("/api/parameter/encoding/{pathEncoding}")
    fun testStudy(
        @PathVariable pathEncoding: String,
    ): String {
        logger.debug("TEST STUDYING CHECK PATH ENCODING : {} ", pathEncoding)
        service.studyTest()

        return "This is Test Controller !"
    }

    // Add more exception handlers as needed
    // Handling Enum Error Code

}