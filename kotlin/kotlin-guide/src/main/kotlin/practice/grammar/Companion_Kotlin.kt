package practice.grammar

fun main(args: Array<String>) {

    MyClass.count

    MyClass.typeOfCustomers()
}

class MyClass {
    companion object {
        
        val count = 1   // Behaves like STATIC variable

        @JvmStatic
        fun typeOfCustomers(): String {     // Behaves like STATIC method
            return "Indian"
        }
    }
}
