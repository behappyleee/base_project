package com.study.coroutine.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class UserTest(
    @Id
    @GeneratedValue
    val id: Long,

    val name: String,

    val email: String,
)