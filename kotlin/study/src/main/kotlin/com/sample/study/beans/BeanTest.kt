package com.sample.study.beans

import org.springframework.stereotype.Service

@Service
class BeanTest() {

    init {
        println("[THIS IS BEAN TEST CLASSS BEAN BEAN TEST CHECK !!!!]")
    }

    fun beanTestFunc() {
        println("THIS IS BEAN FUNCTION CHECK TEST !!!!")
    }

}