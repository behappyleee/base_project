package be.com.sqsdemo

import java.security.KeyPairGenerator
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
//@EnableAutoConfiguration
//@SpringBootConfiguration
class SqsDemoApplication

fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger(SqsDemoApplication::class.java)
    logger.info("This is Log Test !!")
    runApplication<SqsDemoApplication>(*args)
}

