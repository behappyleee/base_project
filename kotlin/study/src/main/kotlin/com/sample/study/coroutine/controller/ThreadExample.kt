package com.sample.study.coroutine.controller

var playMusic = false

fun main() {
    asyncLinedUp {
        stopMusic()
        ticketing()
        asyncTakeTheBus {
            stopMusic()
        }
    }

    asyncPlayMusic()

}

fun testString(): String {
    return "TEST: STRTING"
}

fun testUnit() : String {
    return "test"
}

fun paramFun(testChek: () -> String) {
}

fun asyncLinedUp(myTum: () -> Unit) {
    Thread {
        println("Waiting for a line ...")
        Thread.sleep(2000)
        myTum.invoke()
    }.start()
}

fun asyncTakeTheBus(onTime: () -> Unit) {
    Thread {
        println("Waiting the bus ...")
        Thread.sleep(2000)
        onTime.invoke()
        println("Take a bus ....")
    }.start()
}

fun stopMusic() {
    playMusic = false
    println("Stop the music ....")
}

fun ticketing() {
    println("Buy a ticket ....")
}

fun asyncPlayMusic() {
    Thread {
        println("Play the music ...")
        playMusic = true
        while(playMusic) {
            println("Listening ....")
            Thread.sleep(500)
        }
    }.start()
}



fun takeBus() {
    println("Ride a Bus !")
}


class ParallelExample {



}