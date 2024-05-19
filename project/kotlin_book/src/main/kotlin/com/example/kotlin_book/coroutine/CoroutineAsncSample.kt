package com.example.kotlin_book.coroutine



class CoroutineAsncSample {
}


// 비동기 처리를 적용, 줄을 서 있는 동안 그리고 버스를 기다리는 동안 음악을 들음
fun main() {

}

fun linedUpCo(myTurn: () -> Unit) {
    Thread {
        println("Lined Up !!")
        Thread.sleep(2000)
        myTurn.invoke()
    }.start()
}

fun ticketingCo() {

}

fun takeBusCo() {

}

class FunctionTest {

    fun callTest() {
        val listTest = listOf(1, 2, 3, 4, 5)
        listTest.run {  }
        

        InterImpl {
            println("Test Run !")
        }.runTest()
    }
}

class InterImpl(
    test: InterTest
) {
    fun runTest() : InterImpl {
        return InterImpl(
            test = {


            }
        )
    }
}

@FunctionalInterface
fun interface InterTest {
    fun run(): Unit

//    fun addFun()
}

