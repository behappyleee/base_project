package com.sample.study.basic

class KotlinInnerFunctionTest {

}

fun innerFun1(): String {
    return "This is innerFun 1 !!"
}

fun innerFun2(): String {
    return "This is innerFun 2 !!!"
}


fun main() {

    //fun innerFun3() = "This is innerFun 3 !!"

    val test1 = {
        "This is String !!"
    }


    println(::innerFun1.invoke())
    println(::innerFun2)
   // println(::innerFun3)
    println(test1())

}