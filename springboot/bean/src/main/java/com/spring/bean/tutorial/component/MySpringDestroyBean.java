package com.spring.bean.tutorial.component;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class MySpringDestroyBean implements DisposableBean {

    // Initial 때와 마찬가지로 Destroy 도 afterPropertiesSet() 단계를 Customizing 이 가능하다.
    @Override
    public void destroy() throws Exception {




    }


}
