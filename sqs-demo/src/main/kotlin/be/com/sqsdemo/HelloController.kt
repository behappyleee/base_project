package be.com.sqsdemo

import kotlin.reflect.KClass
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World!"
    }
}

class TestClass(
    private val testName: String,
    val publicNameTest: String,
) {
    fun testPublicMethod(): String {
        return "This is a test method !"
    }
}

fun main() {
    val testClass: KClass<TestClass> = TestClass::class


}


