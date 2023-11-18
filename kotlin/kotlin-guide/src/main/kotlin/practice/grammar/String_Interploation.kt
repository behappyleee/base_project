package practice.grammar

/*
*  Exploer String Interploation in Kotlin
*
* */
fun main(args: Array<String>) {

    var rect = Rectangle()
    rect.length = 10
    rect.breath = 12

    println("The length of the rectangle is ${rect.length} and breadth is ${rect.breath}.")
    println("The area is ${rect.length * rect.breath}")

}

class Rectangle {

    var length: Int = 0
    var breath: Int = 0

}


