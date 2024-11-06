package com.study.springbootboard.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class OnetimeFilterTest: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        println("ONE TIME FILTER !!!! THIS REQUEST START !!!")
        val startTime = System.currentTimeMillis()

        filterChain.doFilter(request, response)

        val executionTime = System.currentTimeMillis() - startTime

        println("ONE TIME FILTER !!!! TASK EXECUTION TIME !! $executionTime ms")
        println("ONE TIME FILTER !!!! THIS REEQUEST END !!")
    }
}