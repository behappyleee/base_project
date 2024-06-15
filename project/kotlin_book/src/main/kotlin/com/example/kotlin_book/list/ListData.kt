package com.example.kotlin_book.list

import com.example.kotlin_book.chapter_2.ObjectTest
import java.util.Objects

class ListData {

}

fun main() {
    // 코틀린은 불변 리스트와 가변 리스트를 제공, 데이터 컬렉션은 데이터 구조의 한 분
    // 단일 연결 리스트 - 리스트 맨 앞에 있는 원소에만 접근이 가능
    // 이중 연결 리스트 - 양 끝에 있는 원소에 접근이 가능

    // O(1) - 연산에 필요한 시간이 상수, 상수라는 말은 원소가 1개이든 n 개의 원소를 처리하던 간에 걸리는 시간은 동일하다는 의미
    // O(log(n)) - 길이가 n 인 리스트를 처리하려면 길이가 1 인 리스트를 처리하는데 걸리는 시간의 log(n) 배가 걸린다.
    // O(n) - 길이가 n 인 리스트를 처리하려면 길이가 1인 리스트를 처리하는데 걸리는 시간의 n 배
    // O(n제곱) - 길이가 n 인 리스트를 처리하려면 길이가 1인 리스트를 처리하는데 걸리는 시간의 n제곱 배가 걸림

    // 모든 유형의 O(1) 의 성능을 제공하는 데이터 구조를 만드는 것이 가장 이상적 .

    // 코틀린은 불변 리스트와 가변 리스트를 제공, 두 리스트 모두 자바 리스트를 바탕으로 하되 코틀린의 확장 함수 시스템을 활용해 다양한 함수를 추가 제공
    // 방어적 복사 - 다른 스레드가 현재 스레드의 데이터를 동시에 변이하는 일을 방지하고자 복사본을 만드는 것을 의미, 자기 자신이 데이터를 변이하고 싶은데
    // 다른 스레드를 그 변이로부터 보호하고 싶을 때도 사용

    // List 의 첫번째 부분 머리, List 의 마지막 부분 꼬리
    // 타입이 다른 두 원소로 이루어진 Generic
    // first 와 second 를 프로퍼티를 가지는 Pair 를 사용하는 대신 head 와 tail 이라는 프로퍼티를 가지는 구체적인 List 를 만들어야 함




}

// sealed class 는 하위 타입을 제한하기 위하여 이를 활용해 추상적 데이터 타입 정의가 가능, 봉인된 클래스는 암묵적으로 추상적인 클래스이며
sealed class SealedList<A> {

    abstract fun isEmpty(): Boolean

    // 빈 리스트를 표현하는 Nil 하위 클래스, List 클래스 안에서 확장 클래스를 정의하고 비공개로 선언
    private object Nil:List<Nothing>() {
        override fun isEmpty() = true
        override fun toString()= "[Nil]"
    }

    private class Cons<A>(
        internal val head: A,
        internal val tail: List<A>
    ): List<A>() {

    }
}

sealed class TestCC {

}

open class TestCheck

class ImportTest: TestCheck() {

}











