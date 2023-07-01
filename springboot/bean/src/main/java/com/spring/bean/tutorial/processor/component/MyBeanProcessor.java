package com.spring.bean.tutorial.processor.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
*   we can make use of the BeanPostProcessor interface to be able to run any custom operation 
*   before or after a Spring bean initializes and even return a modified bean:
*   
*   BeanPostProcessor 인터페이스를 Spring Bean 이 생성 되거나 소멸 전에 Method 를 Customizing 하여 사용이 가능
*
* */

// @Component  // Bean 으로 등록을 시켜주어야 함 !!
public class MyBeanProcessor implements BeanPostProcessor {
    // We should pay attention that Spring's BeanPostProcessors
    // are executed for each bean defined in the spring context.

    // 모든 Bean 들이 생성 후에 해당 Method 들을 실행
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        //...
        System.out.println("THIS IS postProcessBeforeInitialization Bean 생성 후 실행 !!!" + beanName);
        return bean;
    }

    // 모든 메서들이 생성 되기 전 실행 !
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        //...
        System.out.println("THIS IS postProcessAfterInitialization Bean 소멸 전 실행 !!!" + beanName);
        return bean;
    }

}
