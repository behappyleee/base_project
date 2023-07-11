package com.spring.bean.beans;

import com.spring.bean.domain.BeanDomainTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigTest {

    @Bean
    public BeanDomainTest beanMake() {
        return new BeanDomainTest();
    }

}
