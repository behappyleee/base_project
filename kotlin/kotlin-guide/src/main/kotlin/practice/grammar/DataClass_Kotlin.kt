package practice.grammar


fun main(args: Array<String>) {

    var data1 = DataClass_Kotlin("TEST1", 10)
    var data2 = DataClass_Kotlin("TEST1", 10)

    println(data1.toString())
    println(data2.toString())
    println(data1.equals(data2))

    if(data1 == data2) {
        println("Data Class Object Equal !")
    } else {
        println("Data Class Not Equal !")
    }

    val newUser = data1.copy(id = 20)
    println(newUser)
}

// Data Class In Kotlin !!!
data class DataClass_Kotlin(
    val name: String,
    val id: Int
)
