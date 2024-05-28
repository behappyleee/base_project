package com.canbe.libraryimport.controller

import com.canbe.libraryimport.service.KotlinLibraryService
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class KotlinTestController(
    val service: KotlinLibraryService
) {

    @GetMapping("/test")
    fun testMain(): LocalDateTime {
        service.serviceTest()
        return LocalDateTime.now()
    }

    @GetMapping("/date/test")
    fun dateTest(): kotlinx.datetime.LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.UTC)
    }
}
