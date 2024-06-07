import modern.LambdaTest

class KotlinMainClass

fun main(args: Array<String>) {

    val aaa = LambdaTest {
        println("This is Kotlin Lambda !!!")
        "Return String !!!"
    }

    aaa.lambdaTest()
    println("[BUILD SUCCESS TEST CODE !!]")
    println("[BUILD START KOTLIN MAIN CLASS TEST CHEK !!!]")
}