package com.study.jpasample

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long
        get() {
            TODO()
        }
        set(value) {
            field = value
        }

    private lateinit var name: String

    private lateinit var password: String
}