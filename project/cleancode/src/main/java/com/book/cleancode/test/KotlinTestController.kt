package com.book.cleancode.test

import com.book.cleancode.CleancodeApplication
import org.apache.tomcat.util.threads.ThreadPoolExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Thread.currentThread
import java.lang.Thread.sleep

@RestController
class KotlinTestController {

    @GetMapping("/kotlin/test")
    fun kotlinTest(): Number {
        CleancodeApplication.numTest++

        val ve = ThreadPoolTaskScheduler()
        val pszie = ve.poolSize

        println("PoolSize = $pszie")

        // Thread.sleep(1000)
        val t1 = Thread {
            println("Start T1 Thread !!!")
            CleancodeApplication.getSyncNumTest()

            sleep(5000)
            println("Test Num : ${CleancodeApplication.numTest}")
            println("Current Thread ID ${currentThread().threadId()}")
            println("Sleep End !! ThreadName ${currentThread().name}")
        }

        // sleep(2000)
        t1.start()

        println("After PoolSize = ${ve.poolSize}")

        return CleancodeApplication.numTest
    }
}
