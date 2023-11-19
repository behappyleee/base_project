package practice.grammar

/*
*     Example Two
*     1. Lambda Expression
*     2. Higher-Order Function
*
* */

fun main(args : Array<String>) {

    // Lambda Function Expression
    val pro1 = MyProgram();
    val myCustomLambda: (Int, Int) -> Int = { a: Int, b: Int ->
        // println("A : " + a " , " + " B : " + b)
        a * b
    }

    pro1.addTwoNumbers(3, 7, myCustomLambda)
    // pro1.addTwoNumbers(3, 6, a: Int, b: Int -> {a * b})

    pro1.addTwoNumbers(3, 7) {x, y -> x * y}

}

class MyProgram {

    // High Level Function with Lambda as Parameter
    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int) -> Int) {
        val result = action(a, b)
        println(result)
    }

}