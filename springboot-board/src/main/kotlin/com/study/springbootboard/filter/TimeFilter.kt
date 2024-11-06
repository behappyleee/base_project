package com.study.springbootboard.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class TimeFilter: Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        println("THIS REQUEST START !!!")
        val startTime = System.currentTimeMillis()

        filterChain.doFilter(request, response)

        val executionTime = System.currentTimeMillis() - startTime

        println("TASK EXECUTION TIME !! $executionTime ms")
        println("THIS REEQUEST END !!")
    }
}