package com.example.kotlin_book.chapter_1

import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

class KotlinSingleton {

    // 어떤 클래스에 속한 객체를 단 하나만 만들어야 할 때가 종종 있음
    // 이런 인스턴스를 싱글톤이라고 함, 싱글톤 패턴은 클래스에 대해 인스턴스를 단 하나만 허용하는 디잔인 패턴
    // 자바 에서는 생성 되는 인스턴스가 하나 뿐임을 보장하기가 어려워 싱글톤 패턴에 관한 논란이 많지만
    // 코틀린에서는 Class 를 Object 라는 키워드로 바꾸기만 하면 쉽게 싱글톤 패턴 구현이 가능하다

    // Utility 클래스 인스턴스화 방지 - 자바 에서는 정적 메서드만 포함된 유틸리티 클래스를 만들어 사용하는 경우가 자주 있지만
    // 그런 경우는 보통은 클래스 인스턴스화를 금지한다. 클래스 인스턴스화를 금지하려면 자바에서는 일반적으로 생성자를 비공개로 만들고
    // 코틀린에서는 클래스 밖의 패키지 수준에서 함수를 만듦
    
    // 코틀린은 JVM 에서 돌아가므로 패키지 수준에서 정의한 코틀린 함수를 자바 쪽에서 호출할 방법이 있어야 함
    // Kotlin 에는 Primitive Type 이 없다. 최소한 프로그래머가 보는 관점에서는 그럼, 그 대신에 코틀린은 내부에서 자바 원시
    // 타입으로 계산을 빠르게 수행, 하지만 프로그래머는 오직 객체만 조작하게 됨
}

fun main(args: Array<String>) {

    // 원시 타입이 없으므로 int or boolean 값들로 이루어진 컬렉션을 boxing / unboxing 하기 위한 별도의 함수가 필요 없음
    val aInt: Int = 3
    val bInt: Long = 3L
    val cInt: Float = 3.2F
    val dInt: Double = 343.34234

}

object KotlinSingleTest: WindowAdapter() {
    override fun windowClosed(e: WindowEvent?) {
        super.windowClosed(e)
    }
}
