package com.spring.bean.tutorial.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycle {

    // Hooking into the bean life cycle is a good way to extend our application in most cases.

    Logger logger = LoggerFactory.getLogger(BeanLifeCycle.class);
    
    // Bean Name 설정    
    public void setBeanName(String name) {
        logger.debug("BEAN NAME : {} ", name);
    }



    public static void main(String[] args) {




    }

}
