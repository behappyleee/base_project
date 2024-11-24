package com.study.demospring

import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
) {

}