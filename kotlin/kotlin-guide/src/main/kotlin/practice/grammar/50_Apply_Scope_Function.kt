package practice.grammar

data class Person50(
    var name: String = "",
    var age: Int = 21,
)

fun main() {
    /*
    *   Scope Function
    *   Property 1 : Refer to context object by using 'this'
    *   Property 2 : The return value is the 'context object'
    * */
    val per1 = Person50()
    per1.apply {
        name = "This is Value"
        age = 24
    }

    with(per1) {
        println(name)
        println(age)
    }

    // Perform some other operations on 'person' object
    per1.also {
        it.name = "Changed by also scope"
        println("NEW NAME 1 : " + per1.name)    // Prints New Name
        println("NEW NAME 2 : ${it.name}")      // Prints New Name
        it.age = 23     // prints New name
    }

}