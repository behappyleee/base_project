package com.spring.bean.tutorial.service;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class IpLocationService implements BeanFactoryAware {
    
    // 이것은 실용적인 해결책이다 우리가 Bean 을 실행시에 재 생산을 해야할 떄.
    
    DefaultListableBeanFactory listableBeanFactory;
        
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        listableBeanFactory = (DefaultListableBeanFactory) beanFactory;

    }
}
