package com.spring.bean.tutorial.component;

import com.spring.bean.tutorial.processor.component.MyBeanProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  @Component 해당 어노테이션을 통하여 Bean 으로 등록
 *  component scanning 이 가능 할 때 해당 객체는 Application Context 에 Bean 으로 등록 될 것이다.
 *
 */

@Configuration
public class MySpringInitialBean implements InitializingBean {

    // Bean을 Customizing 을 할 수 있다 in afterPropertiesSet() 단계에
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    // Bean 어노테이션을 사용
    // hen we define our Spring beans we can set the initMethod and destroyMethod attributes of
    // the @Bean annotation in Java configuration:
    @Bean(initMethod = "onInitialize", destroyMethod = "onDestroy")
    public MyCustomBean myCustomBean() {
        return new MyCustomBean();
    }
    // Class Bean 등록 방법
//    @Bean
//    public MyBeanProcessor myBeanProcessor() {
//        return new MyBeanProcessor();
//    }

}
