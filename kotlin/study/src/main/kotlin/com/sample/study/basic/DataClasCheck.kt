package com.sample.study.basic

class DataClasCheck {
}

data class DataCheck(
    val name: String,
    val age: Int,
)

fun main() {
    val dt1 = DataCheck(
        name = "NAME",
        age = 21,
    )

    val dt2 = DataCheck(
        name = "NAME",
        age = 21,
    )

    println("DataClass 값 비교 : ${dt1 == dt2}")
    println("DataClass Reference Comapre : ${dt1 === dt2}")

    // 해당 변수로 할당이 가능 !
    val (te1, te2) = dt1
    // val com1 =

    val (pa1, pa2) = Pair<Any, Any>(first = "KEY1", second = "KEY2")
    println(pa1)
    println(pa2)

    val pa3 = Pair<Any, Any>(first = "KEY1", second = "KEY2")
    pa3.let { (p1, p2) ->
        println(p1)
        println(p2)
    }
}