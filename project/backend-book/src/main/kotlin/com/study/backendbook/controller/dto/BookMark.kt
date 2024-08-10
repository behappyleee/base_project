package com.study.backendbook.controller.dto

data class BookMark(
    // JSON key 와 클래스의 필드가 이름이 같을 경우에 서로 매핑 됨
    private val name: String,
    private val url: String,
)
