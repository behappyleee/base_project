package com.spring.bean.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanAwareTest implements BeanFactoryAware {

    DefaultListableBeanFactory defaultListableBeanFactory;

    // BeanFactory 에 메서드 접근 가능
    // BeanFactory 인스턴스는


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {


    }


}
