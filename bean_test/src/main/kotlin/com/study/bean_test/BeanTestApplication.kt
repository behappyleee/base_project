package com.study.bean_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

//@SpringBootApplication
class BeanTestApplication

fun main(args: Array<String>) {
    // bean 을 직접 xml 로 등록을 해서 사용 해 봄
    val context = ClassPathXmlApplicationContext("classpath:application.xml")
    val names = context.beanDefinitionNames
    names.forEach { println(it) }

    val bookService = context.getBean(BookService::class.java)
    println(bookService.bookRepository)

    val applicationContext = AnnotationConfigApplicationContext { ApplicationConfig::class.java }


//    runApplication<BeanTestApplication>(*args)
}
