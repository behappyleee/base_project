package practice.grammar

fun main(args: Array<String>) {

    // Mutable READ and WRITE both No Fixed Size
    var myMap = hashMapOf<Int, String>()

    myMap.put(3 , "Yog i")
    myMap.put(7, "Test")
    myMap.put(2, "Check")

    for(key in myMap.keys) {
        println("Map Element : KEY : $key + ${myMap[key]}")
    }

}

class Map_HashMap_Kotlin {
}