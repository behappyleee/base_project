package com.study.jwt.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class User (
    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val userId: Long,

    @Column(name = "username", length = 50, unique = true)
    private val userName: String,

    @JsonIgnore
    @Column(name = "password", length = 100)
    private val password: String,

    @Column(name = "nickname", length = 50)
    private val nickName: String,

    


) {

}