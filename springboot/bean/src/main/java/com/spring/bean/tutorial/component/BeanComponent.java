package com.spring.bean.tutorial.component;

import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    // Bean 등록을 위한 Component Class
    // if we have a public method named close() or shutdown() in our bean, this is automatically
    // triggered with a destruction callback by default
    public void close() {

    }




}
