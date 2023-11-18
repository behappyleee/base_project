package practice.grammar

fun main(args: Array<String>) {

    val a = 2
    val b = 5

    val maxValue: Int = if(a > b)  {
                            println("a is greater")
                            a
                        } else {
                            println("b is greater")
                            b
                        }

    println(maxValue)

    // Use When Expression
    val x = 100
    val str: String = when(x) {
        1 -> "x is 1"
        2 -> "x is 2"
        100 -> "x is 100"
        else -> {"x values is unknown x is an ailen"}
    }

    println(str)
}