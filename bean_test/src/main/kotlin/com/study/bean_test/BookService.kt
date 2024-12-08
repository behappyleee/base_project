package com.study.bean_test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

//@Service
class BookService{

 //   @Autowired
    lateinit var bookRepository: BookRepository

}