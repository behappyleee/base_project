package com.spring.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanProcessTest {

    static class BeanClassTest {

        @PreDestroy
        public void preDestroyMethod() {
            System.out.println("THIS IS PRE DESTROY ANNOTATION METHOD !!");
        }

        @PostConstruct
        public void postConstructMethod() {
            System.out.println("THIS IS POST CONSTRUCT ANNOTATION METHOD !!");
        }
    }

    @Test
    public void beanProcessTest() {
        BeanClassTest bb = new BeanProcessTest.BeanClassTest();

    }

}
