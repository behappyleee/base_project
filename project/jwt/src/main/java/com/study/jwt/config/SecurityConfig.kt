package com.study.jwt.config

import com.study.jwt.token.JwtAccessDeniedHandler
import com.study.jwt.token.JwtAuthenticationEntryPoint
import com.study.jwt.token.JwtSecurityConfig
import com.study.jwt.token.TokenProvider
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.CorsFilter

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
class SecurityConfig(
    private val tokenProvider: TokenProvider,
    private val corsFilter: CorsFilter,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtAccessDeniedHandler: JwtAccessDeniedHandler
) {
    // Token 을 사용하기 때문에 CSRF 설정은 disable Excpetion 을 핸들링 할 시 우리가 만들었던 클래스들을 추가
    //

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
            .csrf { it.disable() }

            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter::class.java)

            .exceptionHandling {
                it.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .accessDeniedHandler(jwtAccessDeniedHandler)
            }

            // login / 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 모두 permitAll 로 설정
            .authorizeHttpRequests {
                it.requestMatchers("/api/hello", "/api/authenticate", "/api/signup").permitAll()
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .anyRequest().authenticated()
            }

            // 세션을 사용하지 않기 때문에 STATELESS로 설정
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

            // enable h2-console
            .headers {
                it.frameOptions { options ->
                    options.sameOrigin()
                }
            }
            
            // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스도 등록을 해 줌
            .with(JwtSecurityConfig(tokenProvider)) {}
        return http.build()
    }
}