package com.sample.study.type

class KotlinTypeTest {

}


open class ParentTestClass

class ChildClass1: ParentTestClass()

class ChildClass2: ParentTestClass()

fun main() {

    var c1 = ChildClass1()

    // 타입을 직접 명시 안하여 할당이 불가
    // 타입 추론은 부모 클래스까지 불가
    //c1 = ParentTestClass()

    // 타입을 직접 명시를 해주어야 함
    var c2: ParentTestClass = ChildClass1()
    c2 = ParentTestClass()

}