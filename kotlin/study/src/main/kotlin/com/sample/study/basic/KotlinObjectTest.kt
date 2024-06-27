package com.sample.study.basic

class KotlinObjectTest {

}

data class KotlinUser(
    val name: String,
    var age: Int,
)

class KotlinUserClass {
    var name: String = ""
        get() = field
        set(value) {
            field = value + "SET VALYE !!"
        }
    var age: Int = 21
}

fun <T> T.makeObject(block: T.() -> Unit): T {
    this.block()

    return this
}

fun main() {

    val aaa = KotlinUser(name = "NAME11", age = 22).makeObject {
        this.name
        this.age = 17
    }
    println(aaa)

    aaa.run {  }
    aaa.let {  }

    val lll = listOf(1, 2, 3, 4)
    lll.map {  }
    lll.apply {  }


    val ccc = KotlinUserClass().makeObject {
        this.name = "Make Name !!"
        this.age = 22
    }
    println(ccc.name + "  " + ccc.age)
}