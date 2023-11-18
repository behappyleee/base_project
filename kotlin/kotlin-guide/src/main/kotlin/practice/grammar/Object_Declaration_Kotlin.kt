package practice.grammar

/**
 *   Object Declaration
 */

fun main() {
    CustomerData.count = 20
    CustomerData.typeOfCustomers()

    println(CustomerData.typeOfCustomers())

    CustomerData.count = 37
    println(CustomerData.count)

    CustomerData.myMethod("Hello World Test Customer Data !")
}

open class MySuperClass {

    open fun myMethod(str: String) {
        println("My Super Class !")
    }

}

object CustomerData: MySuperClass() {   // Object Declaration

    var count: Int = 12                 // Behaves like a STATIC Variables

    fun typeOfCustomers(): String {     // Behaves like a STATIC Method
        return "Indian"
    }

    override fun myMethod(str: String) {
        super.myMethod(str)
        println("This is Object Customer Data : $str")
    }

}