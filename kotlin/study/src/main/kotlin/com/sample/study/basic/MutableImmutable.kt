package com.sample.study.basic

// 코틀린은 가변을 허용하지만 불변성을 권장
// Immutability 란 함수형 프로그래밍에서 중요하게 다루는 부분으로 보통의 의미는 상태를 변경하지 않는 것

fun main() {

    // 불변성을 지켜야 하는 이유
    // Thread-safe 쓰레드 안전성
    // 캐시가 쉬움
    // 방어적 복사본이나 깊은 복사를 하지 않아도 됨
    // 사이드 이펙트를 줄임

    var per1 = PersonTest("test1", 20);
    var per2 = PersonTest("test2", 21);
    var per3 = PersonTest("test3", 22);
    var per4 = PersonTest("test4", 23);
    var per5 = PersonTest("test5", 24);

    val immuList = listOf(per1, per2, per3)
    var immuList2 = listOf(per4, per4)
    
    // listOf 는 기본적으로 immutableList 인 케이스이므로 객체 추가가 불가
    // 같은 타입의 객체끼리 더하는 것은 가능 (새로운 객체를 반환 해 줌)
    val newLIst = immuList + immuList2
    immuList.plus(immuList2)

    // mutableList 는 새로운 객체를 추가가 가능
    val mutableList = mutableListOf(per1, per2, per3);
    mutableList.add(per4);


}

class PersonTest(var name: String, var age: Int)