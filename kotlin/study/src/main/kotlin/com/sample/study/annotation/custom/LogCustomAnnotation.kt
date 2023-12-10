package com.sample.study.annotation.custom

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class LogCustomAnnotation

    // This annotation is used to log the execution time of methods.
    // logs the execution time.

    // This annotation can be placed on methods to indicate that
    // their execution time should
    // be logged.

