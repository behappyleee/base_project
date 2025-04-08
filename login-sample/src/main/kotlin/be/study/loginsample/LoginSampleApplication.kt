package be.study.loginsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoginSampleApplication

fun main(args: Array<String>) {
    runApplication<LoginSampleApplication>(*args)
}
