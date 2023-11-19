package practice.grammar

/*
*   Closure
*
*   Kotlin Closure Function ... !
*
* */

fun main() {

    val pro1 = TheProgram_Closure()
    var result = 0

    pro1.addTwoNumbers(3,7, { x, y, str  ->
        println("This is Str Test Check ! " + str)
        result = x + y
    })

    println(result)
}

class TheProgram_Closure {

    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int, String) -> Unit) {
        val a = action(a, b, "Test")
        println(a)
    }

}