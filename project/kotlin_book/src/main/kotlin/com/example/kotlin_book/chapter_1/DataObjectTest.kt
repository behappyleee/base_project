package com.example.kotlin_book.chapter_1

import java.time.Instant

class DataObjectTest {

    // 데이터 객체 구조 분해하기
    // 프로퍼티가 N 개 있는 데이터 클래스에는 component1 ... componentN 이라는 함수가 자동으로 정의

}

fun main(args: Array<String>) {

}

fun show(persons: List<DataCheck>) {
    // 각 데이터를 구조분해 함
    for((name, date) in persons) {
        println("Name : $name + Date: $date")
    }
}

data class DataCheck(val name: String, val registered: Instant = Instant.now())