package practice.grammar

import kotlin.concurrent.thread

fun main() {    // Execute Main Thread .. !

    println("Maing Program Starts : ${Thread.currentThread().name}")

    thread {
        println("Fake WOrkd Starts : ${Thread.currentThread().name}")
        Thread.sleep(1000)  // Pretend doing some work ....
        println("Fake Work Finished : ${Thread.currentThread().name}")
    }

    println("Main Program Ends : ${Thread.currentThread().name}")
}