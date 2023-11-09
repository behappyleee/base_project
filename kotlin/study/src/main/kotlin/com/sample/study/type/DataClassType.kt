package com.sample.study.type

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*

fun main() {
    val calendarInstance = Calendar.getInstance()
    val todayDateTime: LocalDateTime = LocalDateTime.now()
    val todayDate: LocalDate = LocalDate.now()

    println(todayDateTime)
    println(todayDate)

    val zoneId = ZoneId.of("")


}



class DataClassType {

    var t1 = StudentData("test1", 3);
    val calInstance = Calendar.getInstance();


}




fun testFun(param: StudentData) {

}


data class StudentData (val name: String, val age: Int) {

}

