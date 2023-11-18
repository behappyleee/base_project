package practice.grammar

/*
*   Inheritance with Primary and Secondary Constructors
*
* */

fun main() {

    val dog = TheDog("Black", "Pug")

}

open class TheAnimal {  // Super Class / Parent Class / Base Class
    var color: String = ""

    constructor(color: String) {
        this.color = color
        println("From Animal : $color")
    }
}

class TheDog : TheAnimal { // Sub Class / Child Class / Derived Class

    var bread: String = ""

    constructor(color: String, breed: String): super(color) {
        this.bread = bread

        println("From DOog : $color and $breed")
    }
}



