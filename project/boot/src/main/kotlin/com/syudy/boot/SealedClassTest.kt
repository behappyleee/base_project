package com.syudy.boot

// Sealed Clsss 는 자기 자신이 추상 클래스임 자신을 상속 받는 서브 클래스를 가질 수 있다
// Sealed Class 는 Enum Class 와 비슷한 특징을 가지지만 더 많은 기능을 제공
// Sealed Class 를 사용하면 상속 관계를 표현 가능
// 각 하위 클래스마다 고유한 동작 수행이 가능

// Superr class 를 상속받는 child 클래스의 종류를 제한 하는 특성을 가짐

interface Fruit

class Apple(): Fruit
class Banana(): Fruit

fun main() {
    val fruits = arrayListOf(Apple(), Banana())
    val someFruit = when(fruits[0]) {
        is Apple -> "Apple"
        is Banana -> "Banana"
        else -> "No Fruit"
    }

    println(someFruit)
}


sealed class SealedClassTest {

    object success: SealedClassTest()

    object failure: SealedClassTest()

}