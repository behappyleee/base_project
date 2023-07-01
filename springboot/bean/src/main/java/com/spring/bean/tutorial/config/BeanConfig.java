package com.spring.bean.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*   @Configuration
*   스프링 설정 클래스를 의미 하는 어노테이션
*   이 어노테이션을 붙여야 스프링 설정 클래스로 사용이 가능
*/

@Configuration
public class BeanConfig {

    // Bean 등록을 위한 Config 클래스

    /**
     *  @Bean
     *  스프링 Bean(Spring Bean) 을 만드는 메서드에 @Bean 어노테이션을 붙임
     *  그러면 이 메서드가 생성하는 객체를 Spring Bean 에 등록
     */
    @Bean
    public String registerBean() {
        return "This is Bean Test";
    }




}
