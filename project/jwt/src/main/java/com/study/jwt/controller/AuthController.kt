package com.study.jwt.controller

import com.study.jwt.dto.LoginDto
import com.study.jwt.dto.TokenDto
import com.study.jwt.token.JwtFilter
import com.study.jwt.token.TokenProvider
import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController(
    private val tokenProvider: TokenProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
) {
    @PostMapping("/authenticate")
    fun authorize(@RequestBody @Valid loginDto: LoginDto): ResponseEntity<TokenDto> {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        val authentication: Authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken)

        SecurityContextHolder.getContext().authentication = authentication

        // jwt 토큰을 response header 에도 넣어주고
        // Token Dto 를 이용하여 response body 에도 넣어 줌
        val jwt: String = tokenProvider.createToken(authentication)
        val httpHeaders = HttpHeaders()

        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer $jwt")

        return ResponseEntity<TokenDto>(TokenDto(jwt), httpHeaders, HttpStatus.OK)
    }
}