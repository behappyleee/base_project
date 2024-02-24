package com.example.kotlin_book.chapter_1

import java.io.Serializable
import java.time.Instant

class KotlinClassInterface {

    // 코틀린 클래스는 자바와 상당히 다른 구분을 사용,
    // 코틀린 클래슨느 기본적으로 public, 따라서 public 단어를 사용할 필요가 없음
    // 클래스를 공개하지 않으려면 private / protected / internal 변경자를 지정
    
    // internal 변경자는 Class 가 정의 된 모둘 안에서만 접근이 가능
    // 코틀린 클래스는 기본적으로 상속 불가임 final 상태임, 코틀린 클래스에서 상속 있게 하려면 open 변경자를 사용

    val person1 = PersonSample(name = "Test Person")
    val test = person1.name // name 을 변수에 직접 접근하는 것처럼 보이지만 실제로는 컴파일러가 생성한 게터를 사용

    // Person 클래스가 데이터를 표현한다면 hashCode 와 equals 메서드도 필요, 자바에서는 이런 메서드를 작성하는 일은
    // 지겹고 실수하기도 쉬움

}

// Kotlin 에서 여러개의 Interface 를 구현하고 싶을 시 여러개를 이어 붙임
class PersonSample(
    val name: String,
    val register: Instant = Instant.now()   // 자바에서는 이를 구현하려면 소스 양이 많아짐
):  Serializable,
    Comparable<PersonSample> {
    override fun compareTo(other: PersonSample): Int {
        // TODO

        return 3
    }
}
