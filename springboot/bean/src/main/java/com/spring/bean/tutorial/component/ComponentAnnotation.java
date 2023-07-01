package com.spring.bean.tutorial.component;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ComponentAnnotation {

    // we can use them to hook into the pre-initialization and destroy phases:
    @PostConstruct
    public void postConstruct() {}

    @PreDestroy
    public void preDestroy() {}





}
