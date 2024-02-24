package com.example.kotlin_book.chapter_1

import java.time.Instant

class KotlinCompanionCheck {




}

fun main(args: Array<String>) {

    // 동반 객체를 지정해 명시적으로 create 를 호출할 수 도 있지만 하지만 이런 방식은 낭비임
    // 동반 객체가 들어있는 외부 클래스의 정적 멤버로 이 함수를 호출하고 싶으면 이 코틀린 함수 앞에 @JvmStatic 을 사용
    CompanionTest.Companion.create("")
    CompanionTest.create("")
    
}

class CompanionTest(
    val name: String,
    val registered: Instant = Instant.now(),
) {
    // 코틀린 클래스에는 정적 멤버가 없음, 그 대신 동반 객체 (Companion Object) 라는 특별한 요소를 사용
    companion object {
        @JvmStatic
        fun create(xml: String): CompanionTest {
            return CompanionTest(
                name = "test !"
            )
        }
    }
}
