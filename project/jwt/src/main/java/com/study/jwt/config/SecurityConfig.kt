package com.study.jwt.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class SecurityConfig() {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf {
                    csrfConfig: CsrfConfigurer<HttpSecurity> -> csrfConfig.disable()
            } // 1번
            .headers { headerConfig: HeadersConfigurer<HttpSecurity?> ->
                headerConfig.frameOptions(
                    { frameOptionsConfig -> frameOptionsConfig.disable() }
                )
            } // 2번
            .authorizeHttpRequests { authorizeRequests ->
                // authorizedhttprequest 를 http 를 사용하는 요청들에 대하여 접근 제한을 설정하겠다는 의미
                // /api/hello 에 대한 내용은 인증 없이 접근이 가능하도록 설정
                authorizeRequests
                    .requestMatchers(AntPathRequestMatcher("/api/hello")).permitAll()
                    .requestMatchers(AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
//                    .requestMatchers(AntPathRequestMatcher("/swagger-resources/**")).permitAll()
//                    .requestMatchers(AntPathRequestMatcher("/favicon.ico")).permitAll()
//                    .requestMatchers(AntPathRequestMatcher("/error")).permitAll()
                    .anyRequest().authenticated()
            } // 3번
//            .exceptionHandling { exceptionConfig: ExceptionHandlingConfigurer<HttpSecurity?> ->
//                exceptionConfig.authenticationEntryPoint(
//                    unauthorizedEntryPoint
//                ).accessDeniedHandler(accessDeniedHandler)
//            } // 401 403 관련 예외처리

        return http.build()
    }


}