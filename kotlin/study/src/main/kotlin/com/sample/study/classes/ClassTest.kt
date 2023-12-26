package com.sample.study.classes

fun main() {

    val cla1 = GetSetCheck(20)
    println("GET NUM 1 : " + cla1.num)

    cla1.setNum = 3
    println("SET NUM 2 : " + cla1.num)

    val cla2 = GetSetCheck(7)
    println("CLA 2 GET NUM : " + cla2.num)

    cla2.setNum = 3
    println("CLA 2 AFTER SET NUM : " + cla2.setNum)
    println("CLA 2 AFTER SET FIELD : " + cla2.num)

}

class ClassTest {

}

class GetSetCheck(num: Int) {
    val num = num
        get() = field + 20

    var setNum: Int = 0
        set(value) {
            field = if(num > 10) {
                num + 12
            } else {
                0
            }
        }

}