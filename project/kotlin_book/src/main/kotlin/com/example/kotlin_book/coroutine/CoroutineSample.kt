package com.example.kotlin_book.coroutine

class CoroutineSample {

}

// 일반적으로 프로그램들은 메인 루틴과 서브 루틴으로 이루어져 있음
// 보통 프로그램을 시작하는 곳이 메인 루틴이고, 메인 루틴은 다양한 서브 루틴으로 이루어져 있음
// 여기서 시작 루틴은 main() 이 메인 루틴임, 이 안에서 호출 되는 함수각 각 서브 루틴임!, 서브 루틴은 진입 시점과 종료 시점을 가짐
fun main() {
    linedUp()
    ticketing()
    takeTheBus()
}

fun linedUp() {
    println("Lined Up !")
    Thread.sleep(2000)
}

fun ticketing() {
    println("Ticketing .... !")
    Thread.sleep(2000)
}

fun takeTheBus() {
    println("Take The Bus !!")
    Thread.sleep(2000)
}