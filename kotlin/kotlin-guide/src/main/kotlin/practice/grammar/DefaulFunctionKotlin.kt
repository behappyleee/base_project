package practice.grammar

fun main(args: Array<String>) {

    var result = findVolume(2, 3)
    println(result)

}

fun findVolume(length: Int, breadth: Int, height: Int = 10): Int {

    return length * breadth * height

}