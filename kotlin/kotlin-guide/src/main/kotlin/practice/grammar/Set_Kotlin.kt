package practice.grammar

fun main(args: Array<String>) {

    // Set Contains unique Elements
    // HashSet also contains unique elements but sequence is not guaranteed

    val mySet = mutableSetOf<Int>(2, 53, 7, 37)

    mySet.remove(3)
    mySet.add(100)

    for(elem in mySet) {
        println("MySet Elem : $elem ")
    }

}


class Set_Kotlin {
}