package com.spring.bean.beans;

import com.spring.bean.domain.BeanInitTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfigTest  {

    @Bean(initMethod = "makeInit", destroyMethod = "makeDestroy")
    public BeanInitTest beanInit() {
       return new BeanInitTest();
    }

}
