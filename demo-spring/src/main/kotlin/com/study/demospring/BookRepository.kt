package com.study.demospring

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import java.util.logging.Logger

@Repository
class BookRepository {

    fun test() {
        val loggerTest = LoggerFactory.getLogger(BookRepository::class.java)

        loggerTest.debug()

    }
}