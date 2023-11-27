package practice.grammar

fun main(args: Array<String>) {

    // Mutable READ and WRITE both No Fixed Size
    var myMap = hashMapOf<Int, String>()

    myMap.put(3 , "Yog i")
    myMap.put(7, "Test")
    myMap.put(2, "Check")

    // myMap to 도 사용이 가능
    val aa = mapOf(2 to "check11", "test11" to 3)

    println(aa)

    for(key in myMap.keys) {
        println("Map Element : KEY : $key + ${myMap[key]}")
    }

}

class Map_HashMap_Kotlin {
}