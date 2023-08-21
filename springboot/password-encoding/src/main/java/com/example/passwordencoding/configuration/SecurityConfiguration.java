package com.example.passwordencoding.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity(debug = true)
@RequiredArgsConstructor    // private final 들 bean 들 생성 해 줌
public class SecurityConfiguration {

    // Web Security 가 항상 Http Security 보다 우선이 된다.
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring()
                    .requestMatchers(
                            "/h2",
                            "/h2/**"
                    );
        };
    }

     // Applications with REST APIs and password-based authentication supported by Spring Security
     // To keep it simple in this example we send the user credentials with every HTTP Request.
     // It means the application must start authentication whenever the client wants to access the API.

//    // Spring 3 version starter-security 부터는 Lambda DSL 강화로 많이 바뀜
//    // 기존에는 WebSecurityConfigurerAdapter 를 extends 하였지만 해당 Class 가 deprecated 됨
//
//    // ERROR 발생
////    @Bean
////    public WebSecurityCustomizer configure() {
////        return (web) -> web.ignoring().requestMatchers(
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

    // H2 Database Console 을 이용하기 위하여서는 CSRF 에 대해서만 면제 처리를 해주어야 한다.
    // 기본으로 CSRF 처리를 포함하고 있어 접근이 불가하여 H2 Console 에 만 CSRF 면제 처리를 해준다. 전체 다 적용을 해주면 보안에 약해진다.

    // HttpSecurity#authorizeHttpRequests -> to define our authorization rules.
    // withDefaults() -> enables a security feature using the defaults provided by Spring Security
    // This is a shortcut for the lambda expression it -> {}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // TODO
        // H2 Console CSRF 설정 확인이 필요 url /H2 에만 CSRF dsiable 설정 하기 !!!
        http
//                .authorizeHttpRequests((auth) ->
//                        auth.requestMatchers("/h2/**").permitAll()
//                )
                .csrf(url -> url.disable())
                .httpBasic(withDefaults());

//        http.authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/h2/**").permitAll()
//                        .anyRequest().authenticated())
//                .httpBasic(withDefaults());

        return http.build();
    }

}
