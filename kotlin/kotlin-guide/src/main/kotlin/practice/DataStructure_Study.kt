package practice

import java.util.TreeMap

fun main() {

    lists()
    sets()
    maps()
    arrays()

}

fun arrays() {
    val musketeers: Array<String> = arrayOf("Athos", "Porthos", "Aramis")

    println(musketeers)

    listOf(1, 2, 3, 4, 5).toTypedArray()

}

fun maps() {
    val movieBatmans= mapOf(
        "Batman Returns" to "Michael Keaton",
        "Batman Forever" to "Val Kilmer",
        "Batman & Robin" to "George Clooney",
    )

    println(movieBatmans["Batman Returns"])
    println("Batman Begins" !in movieBatmans)   // true

    // Mutable map that is sorted by its keys
    val treeMap = TreeMap(
        mapOf(
            "Practical Pig" to "bricks",
            "Fifer" to "straw",
            "Fiddler" to "sticks"
        )
    )

    // treemap keys
    println(treeMap.keys)


}

// Sets
fun sets() {
    val footballChampoions = setOf("France", "Germany", "Spain", "Italy", "Brazil")

    println(footballChampoions)

    println("[Israel in footballChampions : ] " + "Israel" in footballChampoions)   // false
    println("[Italy in footballChampions : ] " + "Italy" in footballChampoions) // true
}

// List
fun lists() {
    val hobby = listOf("Tennis", "Golf", "Soccer", "Basketball", "Baseball")
    println(hobby[1])

    // Won't be compile
    // hobby[0] = "Pingpong Table" // Unresolved reference immutable list

    // Mutable 이기에 변경이 가능
    val mutableHobby = mutableListOf("Hocky", "Game", "Crockket")
    mutableHobby[0] = "TestChange"

}
