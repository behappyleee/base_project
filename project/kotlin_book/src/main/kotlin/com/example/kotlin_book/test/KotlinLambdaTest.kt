package com.example.kotlin_book.test

class KotlinLambdaTest {


}

fun main() {

    te1 { "Test Check !" }
    te2 { true }
    te3 { s, i ->
        println("TE1 $s")
        println("TE2 $i")
        3
    }

    val tt: (String, Int) -> Int = { str, count -> 3 }

    val tttt = tt("Lambda Call !", 7)
    println("RESULT TTTT : $tttt")

    te3(tt)
    te3({a, b -> 3})

    val liTest = listOf(1, 2, 3)
    liTest.forEach {  }
    // liTest.find {  }
    liTest.let {  }

}

fun <T, R> List<T>.te7(te: () -> R) {

}

fun te1(te: () -> String) {
    println(te())
}

fun te2(te: () -> Boolean) {
    println(te())
}

fun te3(te: (String, Int) -> Int) {
    println(te("Str1", 7))
}