package com.sample.study.coroutine.service

class RoutineCoroutine {
    
    // Routine - Routine 에 진입하는 곳이 한 군데이며 종료 되면 해당 루틴의 정보가 초기화 됨
    // Coroutine - 협력하는 루틴 이라는 뜻 임
    
    
}


fun main() {
    println("A")
    newRoutine()
    println("B")
}

fun newRoutine() {
    val num1 = 1
    val num2 = 2
    println(num1 + num2)
}