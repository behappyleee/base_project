package practice.grammar

fun main() {
    /*
    *   Scope Function
    *   Property 1 : Refer to context object by using 'it'
    *   Property 2 : The return value is the 'lambda result'
    * */

    // Use let function to avoid NullPointerException
    val name: String? = "Hello World !!"
    val stringLength = name?.let {
        println(it.reversed())
        println(it.capitalize())
        println(it.length)
        it.length
    }

    println(name)
    println(stringLength)
}