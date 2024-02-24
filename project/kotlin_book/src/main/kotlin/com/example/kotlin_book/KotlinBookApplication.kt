package com.example.kotlin_book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBookApplication

fun main(args: Array<String>) {
    runApplication<KotlinBookApplication>(*args)
}
