package com.sample.study.classtype

fun main() {

    // Kotlin 은 기본적으로 다른 클래스가 상속이 안됨
    // 다른 클래스에서 상속하게 하려면 Open 을 선언하여야 함
    // 상위 클래스를 상속받은 하위 클래스의 생성자에서는 상위 클래스의 생성자를 호출하여야 함

    // 매개 변수가 없는 생성자
    var sub1 = Sub1();

    // 객체 생성 시 매개 변수 전달 (상속한 클래스에 매개 변수가 존재)
    var sub2 = Sub2("Test");
    
    // 생성자에 주입
    var sub3 = Sub3("test");


}

// Kotlin 에서 상속이 가능하게 하려면 open 으로 선언
open class Super1 {}    // Sub1 의 상위 클래스 Super1

// 클래스의 매개변수가 없는 생성자 호출
class Sub1: Super1() {}

// Sub2, Sub3 의 상위 클래스 Super2
open class Super2(name: String) {}

// 매개변수가 있는 상위 클래스의 생성자를 호출할 때는 매개변수 구성에 맞게 인자를 전달
class Sub2(name: String): Super2(name){}

class Sub3: Super2 {
    constructor(name: String): super(name)
}





