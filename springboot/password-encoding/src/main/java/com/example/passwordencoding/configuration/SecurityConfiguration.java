package com.example.passwordencoding.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

 // @Configuration  // TEST 를 위하여 Security 임시 OFF !!!
 @EnableWebSecurity
 @RequiredArgsConstructor    // private final 들 bean 들 생성 해 줌
public class SecurityConfiguration {

    // Spring 3 version starter-security 부터는 Lambda DSL 강화로 많이 바뀜
    // 기존에는 WebSecurityConfigurerAdapter 를 extends 하였지만 해당 Class 가 deprecated 됨

    // ERROR 발생
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring().requestMatchers(
//                "",
//                "",
//                "");
//    }

//    Adds the Security headers to the response. This is activated by default when using EnableWebSecurity.
//    Accepting the default provided by EnableWebSecurity or only invoking headers()
//    without invoking additional methods on it, is the equivalent of:

// You can disable the headers using the following:
//  @Configuration
//  @EnableWebSecurity
//  public class CsrfSecurityConfig {
//  	@Bean
//  	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//  		http
//  			.headers().disable()
//  			...;
//  		return http.build();
//  	}
//  }

    // HttpSecurity#authorizeHttpRequests -> to define our authorization rules.
    // withDefaults() -> enables a security feature using the defaults provided by Spring Security
    // This is a shortcut for the lambda expression it -> {}
    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                                .anyRequest().authenticated())
                        .httpBasic(withDefaults());

        return http.build();
    }

}
