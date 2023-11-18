package practice.grammar

fun main(args: Array<String>) {
    // Kotlin Basic Function
    val sum = add(3, 5)
    println("Total Sum is : " + sum)

    // Kotlin Function Expression

    val maxNum = max(3 ,7)
    println(maxNum)

}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun max(a: Int, b: Int): Int = if(a > b) {
                                    println("$a is greater than $b")
                                    a
                                } else {
                                    println("$b is greater than ${a}")
                                    b
                                }









