package be.study.loginsample.employee.controller

import be.study.loginsample.employee.controller.response.EmployeeResponse
import be.study.loginsample.employee.controller.response.toEmployeeResponse
import be.study.loginsample.employee.service.EmployeeService
import java.util.concurrent.atomic.AtomicInteger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

interface TestInter {
    fun hello(): String
}

class AAA (val test: TestInter): TestInter by test {
    val aa: AtomicInteger = AtomicInteger(0)
}

@JvmInline
value class TestValue(val name: String) {
    init {
        require(name.isNotBlank()) {
            "Name must not be blank"
        }
    }

    val length
        get() = name.length

//    var test = name.toUpperCase()
    fun test(): Int {
        return name.length
    }
}


@RestController
class EmployeeController(
    private val employeeService: EmployeeService,
) {
    @GetMapping("/users/{id}")
    fun getUser(
        @PathVariable("id") id: Int
    ): EmployeeResponse = employeeService.findUserById(userId = id).toEmployeeResponse()

    @GetMapping("/hello")
    fun hello(): String = "Hello World !"

    @GetMapping("/test")
    fun testCheck() {
        println("Test Check !")
    }

    data class PersonTest(
        val age: Int,
        val retry: RetryTest,
    )

    data class RetryTest(
        val name: String,
    )
}
