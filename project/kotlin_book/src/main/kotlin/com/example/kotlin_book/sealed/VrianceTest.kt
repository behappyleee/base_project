package com.example.kotlin_book.sealed

class VrianceTest {

    val test1 = object: BoxTest1<Super1> {}

    val test2 = object: BoxTest1<Child1> {}

    val test3 = object: BoxTest1<Child2> {}

    private fun isInvariance(boxTest: BoxTest1<Child1>) {

    }

    // 공변 !
    private fun invarianceTest(boxTest: BoxTest1<out Child1>) {}

    private fun invarianceTest1(boxTest: BoxTest1<in Child1>) {}


    fun testFun() {
        // Compile Error 가 발생 무공변 상태임 !
        //isInvariance(test1)
        isInvariance(test2)
        // isInvariance(test3)

//        invarianceTest(test1) Compile Error 가 발생 상위 타입은 불가 !
        invarianceTest(test2)
        invarianceTest(test3)

        // 3개가 다 됨 ...  !
        invarianceTest1(test1)
        invarianceTest1(test2)
        invarianceTest(test3)
    }
}


// 무공변
interface BoxTest1<T>

open class Super1

open class Child1: Super1()

class Child2 : Child1()

// 공변 out 키워드 사용
interface BoxTest2<out T>

open class Super2

open class Child3: Super2()

open class Child4: Child3()
