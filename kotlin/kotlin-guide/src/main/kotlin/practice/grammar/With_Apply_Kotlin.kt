package practice.grammar

fun main(args: Array<String>) {
    var per1 = Person1()

    println("ORIGIN PER NAME 1 : " + per1.name)
    println("ORIGIN PER AGE 1 : " + per1.age)

    with(per1) {
        name = "Mike"
        age = 23
    }

    println("AFTER WITH NAME 1 : " + per1.name)
    println("AFTER WITH AGE 1 : " + per1.age)

    per1.apply {
        name = "Steve"
        age = 24
    }.startRun()

    println("AFTER APPLY NAME : " + per1.name)
    println("AFTER APPLY AGE : " + per1.age)

    println("TOTAL NAME : " + per1.name)
    println("TOTAL AGE : " + per1.age)

    // with 는 apply 와 달리 객체 내부에 함수 접근이 불가
    with(per1) {
        name = "tt1"
        age = 21
    }
    
    // let 도 apply 와 달리 Person1 객체 내부에 함수 접근이 불가
    per1.let { 
        it.name = "ttt"
        it.age = 18
    }

}

class Person1 {

    var name: String = ""
    var age: Int = -1

    fun startRun() {
        println("Now I am ready to Run !")
    }

}


class With_Apply_Kotlin {


}