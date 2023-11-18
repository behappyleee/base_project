package practice.grammar

fun main(args: Array<String>) {

    val dog = Dog()
    dog.bread = "labra"
    dog.color = "black"
    dog.bark()
    dog.eat()

    val cat = Cat()
    cat.age = 12
    cat.color = "brown"
    cat.meow()
    cat.eat()

    val animal = Animal()
    animal.color = "white"
    animal.eat()

}

open class Animal {     // Super Class / Parent Class / Base Class
    var color: String = ""

    fun eat() {
        println("Eat")
    }
}

class Dog: Animal() {   // Sub Class / Child Class / Derived Class

    var bread: String = ""

    fun bark() {
        println("Dog Bark !!")
    }
}

class Cat: Animal() {

    var age: Int = 13

    fun meow() {
        println("Cat Meow ~ !")
    }
}

