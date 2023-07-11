package com.spring.bean;

import com.spring.bean.domain.BeanDomainTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class BeanLifeCycleTest {

    @Test
    public void beanLifeCycle() {

    }

    @Bean
    public BeanDomainTest beanMake() {
        return new BeanDomainTest();
    }


}
