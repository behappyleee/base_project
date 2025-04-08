package be.study.loginsample.employee.controller

import be.study.loginsample.employee.controller.response.EmployeeResponse
import be.study.loginsample.employee.controller.response.toEmployeeResponse
import be.study.loginsample.employee.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

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
}
