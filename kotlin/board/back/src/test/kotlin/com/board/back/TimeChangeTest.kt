package com.board.back

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.json.JSONObject
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TimeChangeTest {
    @Test
    fun timeTest() {
        val mapper: ObjectMapper = ObjectMapper()
        val departure: String = "{\"arrival\":\"2023-11-19T22:00:00\"}";
        val timeStr: String = "{\"local\": \"2013-09-29T18:46:19Z\"}"
        val jsonObj: JSONObject = JSONObject(timeStr)
        println(jsonObj)
        val readJson = mapper.readValue(timeStr, TimeTest::class.java)
        println(readJson)
        val localDateTime: LocalDateTime = LocalDateTime.now()

    }
}

data class TimeTest(
    @JsonProperty("local")
    val local: LocalDateTime,
)