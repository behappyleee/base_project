package be.com.graphqldemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlDemoApplication

fun main(args: Array<String>) {
    runApplication<GraphqlDemoApplication>(*args)
}

class LambdaTestClass {

    data class Person(val name: String) {}

    fun dslTest(aa : Person.() -> Unit) {
        aa.invoke(Person("John Doe"))
    }

    fun dslTestCheck(bb: Person.() -> Int) {
        bb.invoke(Person("John Doe"))
    }

    val number: Int = 3

    fun check() {
        dslTest {
            println(this.name)
            this.name.length
        }

        val a = 3
        test {
            println("Test Check")
            val str: String = number.toString()
            str.length > 0
        }
    }

    fun test(blocK: (Int) -> Boolean) {
        blocK(number)
    }
}



