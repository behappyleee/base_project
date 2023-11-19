package practice.grammar

/*
*   1. Lambda Expression
*   2. Higher-Order Function
*
* */

fun main(args: Array<String>) {
    val program = Program()
    program.addTwoNumbers(3, 7)

    program.addTwoNumbers(3, 7, object : MyInterface {
        override fun execute(sum: Int) {
            println("This is Interface Execute : " + sum)
        }
    })

    val test: String = "Hello !!"

    // 직접 Lambda 함수 생성
    val myLambda: (Int) -> Unit = {s: Int -> println(s) }
    program.addTwoNumbers(2, 7, myLambda)

    // 직접 Lambda 생성 TEST
    val myLambdaTest: (String, Int) -> String = {
        str: String, num: Int -> println("STR : " + str + ". NUM : " +num)
        "TEST"
    }
    myLambdaTest("test", 7)

}



class Program {

    // High Level Function with Lambda as Parameter
    fun addTwoNumbers(a: Int, b: Int, action: (Int) -> Unit) {
        val sum = a + b
        action(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, action: MyInterface) {
        val sum = a + b
        action.execute(sum)
    }

    fun addTwoNumbers(a: Int, b:Int) {
        val sum = a +b
        println("No Action Parameter Sum : " + sum)
    }
}

interface MyInterface {
    fun execute(sum: Int)
}


class Lambda_Kotlin {


}