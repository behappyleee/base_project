package com.sample.study.annotation.custom

import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class CustomAnnotationTest {

    // Annotation Custom 하기 !
    // can use '@CustomAnnotationTest' on classes, and they will be treated as Spring components.
    

}

@CustomAnnotationTest
class CustomAnnotationCheck {

}