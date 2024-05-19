package com.example.kotlin_book.coroutine

class CoroutineSample {

}

// 일반적으로 프로그램들은 메인 루틴과 서브 루틴으로 이루어져 있음
// 보통 프로그램을 시작하는 곳이 메인 루틴이고, 메인 루틴은 다양한 서브 루틴으로 이루어져 있음
// 여기서 시작 루틴은 main() 이 메인 루틴임, 이 안에서 호출 되는 함수각 각 서브 루틴임!, 서브 루틴은 진입 시점과 종료 시점을 가짐
// 서브 루틴은 보통 진입점과 종료점을 가지는데 진입점은 호출 시점임 종료점은 return 을 가지는 부분이 종료점임
// 서브 루틴은 진입점 부터 종료 시점까지 중단 없이 실행이 되기 때문에 각각의 서브 루틴들 사이의 관계는 계층적, 직렬적, 관계가 된다.
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