package com.sample.study.delegate

class DelegateTest {

}

interface DelegateInterface {
    fun testFun()
}

class DeleImpl: DelegateInterface {
    override fun testFun() {
        println("This is Test Fun !!")
    }
}

class GetDeleClass(
    val cl: DeleImpl
) : DelegateInterface by cl {

}

class GetDeleCl (
    var aa: Int
) {
    var cc: Int by this::aa

    // val sd: Int by this.aa

}


fun deleFun(aa: Int, bb: Int) {

    // val cc: Int by ::aa


}


fun main() {

}