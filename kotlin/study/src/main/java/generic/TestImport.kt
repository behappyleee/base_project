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

}


class TestImport {
}