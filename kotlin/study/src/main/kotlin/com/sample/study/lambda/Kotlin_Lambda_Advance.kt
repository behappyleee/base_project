package com.sample.study.lambda

fun main() {

    val lam1 = kotlin_lambda(7, {a , b -> a + b})
    println(lam1)

}

fun kotlin_lambda(a: Int, action:(Int, Int) -> Int): Int {
    return action(a ,3)
}