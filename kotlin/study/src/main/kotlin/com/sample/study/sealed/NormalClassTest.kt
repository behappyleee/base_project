package com.sample.study.sealed

interface Animal

class Dog(val name: String): Animal

class Cat(val name: String, val age: Int): Animal

class Fish(val name: String): Animal

class NormalClassTest {

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

}
