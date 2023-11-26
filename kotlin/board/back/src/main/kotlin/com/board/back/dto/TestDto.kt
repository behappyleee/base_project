package com.board.back.dto

data class TestDto(
    val person: List<Person>,
)

data class Person(
    val name: String,
    val age: Int,
)