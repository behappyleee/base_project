package com.sample.study.bean.test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class BeanMakeTest(
    val beanTest: TestNoBean,
) {


}