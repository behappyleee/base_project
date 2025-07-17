package be.com.filedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileDemoApplication

fun main(args: Array<String>) {
    runApplication<FileDemoApplication>(*args)
}
