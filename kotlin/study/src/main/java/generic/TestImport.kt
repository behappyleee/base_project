package generic

import com.sample.study.`fun`.KotlinFunctionTest
import com.sample.study.`fun`.getTestKotlinInt
import com.sample.study.`fun`.getTestKotlinString

fun main() {
    // Kotlin 에서 일반 함수를 import 할 수 있을 까 .. ?!
    getTestKotlinString()
    getTestKotlinInt()

    val getObject = KotlinFunctionTest()
    getObject.getObjectStringTest()

    val a = 3;
    println(a)

    val b = 7;
    println(b)

    val c = 81;
    println(c)

    val p1 = PersonCheck(
        name = "na",
        age = 21,
    )

    println(p1)

    val p2 = PersonCheck(
        name = "na1",
        age = 23,
    )

    println(p2)

}

class PersonCheck(
    val name: String,
    val age: Int,
)
