package com.sample.study.basic

class InterfaceFunctionCompaer {

}

interface SingleAbstractMethodd {
    fun methodTest()
}

fun check1(aa : SingleAbstractMethodd) {

}

// 하나의 function 만 있는 interface 를 넘기는 것보다는 람다를 파라미터로 넘기면 훨씬 더 큰 자유도가 생긴다 !
fun check2(aa: () -> Unit) {
    aa()
}

fun test3(): String {
    return "This is !!"
}


fun main() {

    check1(object : SingleAbstractMethodd {
        override fun methodTest() {
            println("This is Method Test !!!!")
        }
    })

    check2 {
        println("Free !!")
    }

    check2 {
        println(::test3.invoke())
    }

    check2(fun() {

    })
}