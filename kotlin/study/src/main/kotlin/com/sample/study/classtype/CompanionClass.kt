package com.sample.study.classtype

import com.sample.study.basic.Student

fun main() {

    // Companion Class Type
    // 멤버 변수나 함수를 클래스 이름으로 접근 시 사용
    // 객체를 생성하지 않고 클래스의 이름으로 특정 멤버를 이용 가능
    // 클래스 내부에 companion object { ... } 형태로 선언 하면 이 클래스를 감싸는 클래스
    // 이름으로 멤버에 접근이 가능

    // 접근 시 클래스명.변수명으로 접근
    println(CompanionTest.intData);
    println(CompanionTest.stringData);
    println(CompanionTest.some());

    var objectMake = CompanionTest();

    // objectMake.intData; // 해당 처럼 접근 시 에러가 발생

}

class CompanionTest {
    companion object {
        var intData:Int = 7;
        var stringData: String = "companionTest";

        fun some() {
            println("[Companion Some Method Execute !!]")
        }
    }
}