package com.example.kotlin_book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.FilterType
import org.springframework.core.env.Environment

@SpringBootApplication
class KotlinBookApplication

fun main(args: Array<String>) {
    runApplication<KotlinBookApplication>(*args)
}
