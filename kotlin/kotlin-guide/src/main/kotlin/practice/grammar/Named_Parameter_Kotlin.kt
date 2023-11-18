package practice.grammar

// Named Parameter Kotlin
fun main(args: Array<String>) {

    val result = findTheVolume(breadth = 3, length = 7)
    println(result)

    var resul2 = findTheVolume(breadth = 2, length = 6, height = 3)
    println(resul2)
}

fun findTheVolume(length: Int, breadth: Int, height: Int = 10): Int {
    return length * breadth * height
}