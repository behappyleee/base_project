package com.study.jwt.token

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException

class JwtFilter(private val tokenProvider: TokenProvider) : GenericFilterBean() {

    // GenericFilterBean 을 extends 하여 doFilter 를 Override 실제 필터링 로직은 doFilter 내부에 작성

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val httpServletRequest = servletRequest as HttpServletRequest
        val jwt = resolveToken(httpServletRequest)
        val requestURI = httpServletRequest.requestURI
        // reserveToken 을 통하여 토큰을 받아와서 유효성 검증을 한 후 정상 토큰 이면 Security Context 에 저장
        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
            val authentication = tokenProvider.getAuthentication(jwt)
            SecurityContextHolder.getContext().authentication = authentication
            Companion.logger.debug("Security Context에 '{}' 인증 정보를 저장했습니다, uri: {}", authentication.name, requestURI)
        } else {
            Companion.logger.debug("유효한 JWT 토큰이 없습니다, uri: {}", requestURI)
        }
        filterChain.doFilter(servletRequest, servletResponse)
    }

    // Request Header 에서 Token 정보를 꺼내기 위하여 resolveToken 메서드를 추가
    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(AUTHORIZATION_HEADER)
        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }

    companion object {
        private val logger = LoggerFactory.getLogger(JwtFilter::class.java)
        const val AUTHORIZATION_HEADER = "Authorization"
    }
}
