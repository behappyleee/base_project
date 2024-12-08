package com.study.bean_test.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
@Order(1)
class OnceFilterTestFirst: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        runCatching {
            println("FIRST FILTER START !!!!!!")
            doFilter(request, response, filterChain)
            println("FIRST FILTER END !!!!!!")
        }
        .onFailure {
            println("Exception happend !! $it")
        }
    }
}