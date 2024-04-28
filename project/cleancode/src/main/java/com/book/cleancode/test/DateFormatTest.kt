package com.book.cleancode.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
class DateFormatTest {

    @GetMapping("/date/test")
    fun dateTest(): DateTestDto {
        return DateTestDto(
            kotlinDate = LocalDateTime.now(),
            //LocalDateTime.now()
        //    kotlinDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).,
        )
    }
}