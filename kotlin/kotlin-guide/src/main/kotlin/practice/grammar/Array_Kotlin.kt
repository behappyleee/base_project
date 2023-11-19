package practice.grammar

// 1. Arrays

fun main(args: Array<String>) {

    // Elements : 32    0    0   54    0
    // Index    : 0     1    2   3     4

    val myArray = Array<Int>(5) {0}
    myArray[0] = 32
    myArray[1] = 21
    myArray[2] = 11

    for(element in myArray) {
        println(element)
    }

    println()

    for(index in 0 .. (myArray.size-1)) {
        println(myArray[index])
    }

}

