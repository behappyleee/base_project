package com.example.kotlin_book.chapter_6

import java.util.Optional

class Kotlin_Option {



}

fun main() {

}


// KotlinOptionTest 는 A 에 대하여 공변 적이다 !
// Option 과 List 는 매우 유사하다. 둘 다 추상 클래스이며 두 가 지 구현이 들어있다.
sealed class KotlinOptionTest <out A> {
    abstract fun isEmpty(): Boolean

    internal object None: KotlinOptionTest<Nothing>() {  // None 은 모든 타입에 대해 사용할 수 있는 싱글톤 객체

        override fun isEmpty(): Boolean {
            return true
        }

        override fun toString(): String {
            return "None !"
        }

        override fun equals(other: Any?): Boolean {
            return other === None   // 데이터가 없는 경우 모두 다 같다고 취급
        }

        override fun hashCode(): Int {
            return 0
        }
    }


    // Some 의 인스턴스의 경ㅇ value 에 저장 된 값이 같은 경우에만 동등하며 데이터 클래스이기 때문에 이런 동등성 비교
    // 함수를 컴파일러가 자동으로 제공
    internal data class Some1 <out A>(internal val value: A):
        KotlinOptionTest<A>() {
        override fun isEmpty(): Boolean {
            return true
        }
    }

    companion object {
        // Operator 키워드로 invoke 함수를 정의 !
        operator fun <A> invoke(a: A? = null): KotlinOptionTest<A> {
            return when(a) {
                null -> None
                else -> Some1(a)
            }
        }
    }

}
