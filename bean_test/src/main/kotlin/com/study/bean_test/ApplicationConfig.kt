package com.study.bean_test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [BeanTestApplication::class])
class ApplicationConfig {

//    @Bean
//    fun bookRepository(): BookRepository {
//        return BookRepository()
//    }
//
//    @Bean
//    fun bookService(repository: BookRepository): BookService {
//        val bookService = BookService()
//        bookService.bookRepository = repository
//        return bookService
//    }
}