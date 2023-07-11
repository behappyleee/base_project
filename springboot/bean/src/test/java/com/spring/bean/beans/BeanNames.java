package com.spring.bean.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanNames implements BeanNameAware {

    @Override
    public void setBeanName(String beanName) {
        System.out.println("BEAN NAMES CLASS THIS IS BEAN NAME : " + beanName);
    }

}
