package com.book.cleancode.test

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class DateTestDto(
    val name: String = "nameTest",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    val kotlinDate: LocalDateTime
)