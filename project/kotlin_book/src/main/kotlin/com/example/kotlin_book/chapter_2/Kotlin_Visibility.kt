package com.example.kotlin_book.chapter_2

class Kotlin_Visibility {
    // 코틀린 가시성
    // 코틀린의 가시성은 자바와 약간 다르다. 함수와 프로퍼티를 클래스 내부는 물론 패키지 수준에서도 정의가 가능
    // 패키지 수준에서 정의한 모든 대상은 기본적으로 공개 Public 가시성, 어떤 대상이 비공개 Private 이라면
    // 같은 파일 내에서만 이 대상을 볼 수가 있다. 대상을 내부 (internal) 가시성으로도 선언이 가능, 내부 가시성은
    // 같은 Module 안에서만 볼 수 있다는 뜻이다.
    // private / protected / internal / public
    // 자바와 달리 코틀린에는 패키지 내 공개 package private 가시성이 없음, 자바에서는 패키지 내 공개가 기본 가시성
    // 반대로 internal 가시성은 코틀린에만 있는 가시성으로 같은 모듈안에 있는 어떤 코드에서나 internal 선언 된 대상을 볼 수 있음



}