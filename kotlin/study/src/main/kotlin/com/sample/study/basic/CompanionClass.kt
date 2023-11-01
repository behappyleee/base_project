package com.sample.study.basic

fun main() {

    // Companion Object
    // 자바의 static 을 없애고 kotlin 에서는 Companion Object 라는 동반 객체를 사용하여 정적 멤버를 정의
    // 또한 Companion 에 이름을 설정하여 커스텀한 Companion Object 를 만들 수 있음

    // Companion Object 이기에 static 이므로 접근이 가능
    Student.printNational();

    // 해당 방식으로도 접근이 가능
    val stuComp = Student.Companion;    
    stuComp.printNational();


}

// 하나의 클래스에서는 하나의 Companion Object 만 생성이 가능
// 자바의 static 과는 조금 차이점이 존재 하지만 Companion Object 객체이다 보니 변수에 할당이 가능

// Companion Object 내부의 변수는 클래스 안에서 사용이 가능
// 하지만 class 변수는 Companion Object 안에서는 사용이 불가
class Student {
    var name: String? = null
    var age: Int? = null

    companion object {
        val national = "Korea"
        fun printNational() {
            println(national)
        }
    }
    
    fun test() {
        println("This is Test !!!!")
        println(national);
    }
    
}


