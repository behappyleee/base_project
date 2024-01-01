package com.sample.study.instance

fun main() {

    // Of 메서드는 Person 클래스의 Companion 객체 내부에 정의되어 있으며
    // 객체 생성 로직을 클래스 내부에서 캡슐화를 할 수 있으며 생성자에 직접 접근 하는 것보다는
    // 더 유연한 객체 생성 방법을 제공 또한 이러한 팩토리 메서드는 코드의 가독성과 유지보수성을
    // 향상시키는데 도움을 줌

    // TODO : Factory Method Code 공부 필요 !!

    val p1 = Person.of("TEST", 21)

}

class Person(
    val name: String,   // val 이다 보니 value 수정도 불가능 !
    private val age:Int // private 이라 getter 로 접근도 불가능
) {

    companion object {

        // Of 메서드를 사용하여
        fun of(name: String, age: Int): Person {
            return Person(
                name = name,
                age = age,
            )
        }

    }
}

class OfInstance {

}

data class Test11 (
    private val name: String,
) {

    fun ofTest() {

    }
}