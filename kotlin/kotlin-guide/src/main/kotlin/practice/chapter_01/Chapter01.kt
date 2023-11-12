package practice.chapter_01

fun main() {

    var a = 1000
    var b = 1000

    println(a == b)         // true
    println(a.equals(b))    // true
    println(a === b)        // true

   greet(getGreeting())

}

fun greet(greeting: String) {
    println(greeting)
}

fun getGreeting(): String {
    return "Hello Kotlin !"
}