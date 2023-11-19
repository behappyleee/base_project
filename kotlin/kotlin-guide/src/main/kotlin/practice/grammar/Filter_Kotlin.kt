package practice.grammar

fun main(args: Array<String>) {

    val myNumbers: List<Int> = listOf(3, 7, 12, 15, 18, 37, 21)

    val mySmallNums = myNumbers.filter { it < 10 }

    for(num in mySmallNums) {
        println("MySellNums num : $num")
    }

    val mySquareNums = myNumbers.map { it * it }
    for(num in mySquareNums) {
        println("Square Num : $num")
    }

    val per1 = listOf<Per2>(Per2(23, "Test1"), Per2(24, "Test2"))
    var per2 = listOf<Per3>(Per3("test1", 27), Per3("test2", 25), Per3("test2", 26))

    val names = per1.filter { person -> person.name.startsWith("T") }

    for(name in names) {
        println("NAME OBJECT : $name")
    }

    // 객체 중 Name Field 만 Filter 걸러 줌 !
    val onlyName = names.map { it.name }

    for(name in onlyName) {
        println("ONLY NAME FIELD : $name")
    }

}



class Per2(val age:Int, val name: String)

data class Per3(val name: String, val age: Int)


class Filter_Kotlin {
}