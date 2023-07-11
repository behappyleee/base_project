package com.spring.bean.domain;

public class BeanDomainTest {

    public BeanDomainTest() {
        System.out.println("THIS IS BEAN DOMAIN TEST CONSTRUCT CLASS !!!!");
    }

    // close or shutdown method 가 존재 시 자동으로 Bean 이 Close 될 떄 사용 !!!
    public void close() {
        System.out.println("THIS IS AUTOMATICALL BEAN CLOSE METHOD !!! ");
    }

}
