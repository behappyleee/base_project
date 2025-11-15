package be.com.asyncdemo

import java.util.Collections
import java.util.Properties
import kotlin.contracts.contract
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class AsyncTest {

    @GetMapping("/test")
    fun test(): Mono<String> {
        val measureTime = measureTimeMillis {

        }

        val strTest: String.() -> Int = {
            this.length
            "TEST".length
        }

        return Mono.just("Hello World!")
    }
}

fun main() = runBlocking {
    val launch1 = launch {
        println("Thread Name in Coroutine ${Thread.currentThread().name}")
        delay(1000L)
        println("Test Non Blocking !")
    }

    launch(Dispatchers.IO) {

    }

    "" to 3
    3 testInfix ""

    print("Thread Name in Coroutine ${Thread.currentThread().name}")
    println("Hello 1 ~~ !")
    launch1.join()
    println("Hello 2 ~~ !")
}


infix fun <A, B> A.testInfix(that: B): B {
    return that
}