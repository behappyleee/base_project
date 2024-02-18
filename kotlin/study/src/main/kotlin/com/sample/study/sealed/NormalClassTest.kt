package com.sample.study.sealed

interface Animal

class Dog(val name: String): Animal

class Cat(val name: String, val age: Int): Animal

class Fish(val name: String): Animal

class NormalClassTest {

    // Sealed Class abstract 클래스여서 객체로 만들수가 없음
    // 데이터를 받아서 상태가 변하지 않고 한번만 객체가 생성되는 타입일 경우 object 키워드를 붙여서 사용
    // data 클래스도 사용이 가능
    // Sealed 클래스는 자체적으로 abstract 이며 직접적으로 인스턴스 생성이 불가 abstract 멤버를 가질 수 있음
    // Sealed Class 는 When expression 과 같이 사용할 시 강력한 성능을 제공
    // When 과 같이 사용 시 모든 Type 커버가 가능 하므로 else 를 추가하지 않아도 됨
    // Sealed Class 의 생성자는 private 이며 public 으로 생성이 불가

    fun printAnimalTest(animal: Animal) {
        when (animal) {
            is Dog -> println("This is Dog ${animal.name}")
            is Cat -> println("This is Cat ${animal.age}")
            is Fish -> println("This is Fish ${animal.name}")
            else -> println("This is not animal")
        }
    }

    fun strTest(animal: Animal): String {
        return when (animal) {
            is Dog -> "This is Dog !!"
            else -> "TEST !!"
        }
    }


    fun printSealedAnimalTest(animal: SealedAnimalTest) {
        println(animal.getInfo())
    }
}

sealed class SealedAnimalTest {

    // Sealed Class 는 추상 클래스
    
    abstract fun getInfo(): String

    data class Dog(val name: String) : SealedAnimalTest() {
        override fun getInfo(): String {
            return "This is Test Class Dog $name !!"
        }
    }

    data class Cat(val name: String): SealedAnimalTest() {
        override fun getInfo(): String {
            return "This is Cat Class $name !!"
        }
    }

    data class Fish(val name: String) : SealedAnimalTest() {
        override fun getInfo(): String {
            return "This is Fish Class $name"
        }
    }
}

fun main() {

    val normal = NormalClassTest()
    normal.printAnimalTest(Dog("Dog Test"))

    normal.printSealedAnimalTest(SealedAnimalTest.Dog("Dog Sealed Test"))

    val test = KotlinClassTest()
    // val kotlinPrivateClass = KotlinPrivateClass()
    val sealedTest = SealedAnimalTest.Dog("Sealed Dog Test !")

}
