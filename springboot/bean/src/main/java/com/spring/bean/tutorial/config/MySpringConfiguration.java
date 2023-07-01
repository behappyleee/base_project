package com.spring.bean.tutorial.config;

import com.spring.bean.tutorial.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration
 * 해당 어노테이션을 통하여 Bean 으로 등록
 * 
 */
@Configuration
public class MySpringConfiguration {

    /**
     * @Bean
     * 해당 어노테이션을 통하여 Bean 으로 등록을 시켜준다.
     */
    @Bean
    public User createUser() {
        return new User();
    }


}
