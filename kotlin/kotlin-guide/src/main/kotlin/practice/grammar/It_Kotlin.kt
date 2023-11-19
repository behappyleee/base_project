package practice.grammar

/*
*   Kotlin It Keyword
*
* */

fun main(args: Array<String>) {

    val pro1 = ItProgram()
//    program.reservAndDisplay("This is String", (str) -> {
//        "This is Retrun String"
//    })

    pro1.reservAndDisplay("str Test 1 ! ", {it.reversed()})

//    pro1.reservAndDisplay("str Test 2 ! ") {
//        "test return" ->
//        "sdsd11 "
//    }

    pro1.reservAndDisplay("check", { str ->
        println("This is param str : " + str);
        str
    })

}

class ItProgram {

    // High Level Function with Lambda as Parameter
    fun reservAndDisplay(str: String, myFunc: (String) -> String) {
        val result = myFunc(str)
        println("This is retrun str data : " + result)
    }

}