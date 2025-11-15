package be.study.loginsample.employee.controller.response

import be.study.loginsample.employee.entity.Employee
import be.study.loginsample.type.Gender
import java.time.LocalDate
import org.springframework.scheduling.TaskScheduler

data class EmployeeResponse(
    val id: Int,
    val birthDate: LocalDate,
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val hireDate: LocalDate,
)

fun Employee.toEmployeeResponse() = EmployeeResponse(
    id = this.empNo,
    birthDate = this.birthDate,
    firstName = this .firstName,
    lastName = this.lastName,
    gender = this.gender,
    hireDate = this.hireDate,
)

fun main() {
    Thread.startVirtualThread {

    }

    data class Person(
        val name: String,
        val age: Int,
    )
    val person = Person(name = "Test", age = 21)
    person.let {
        val name = it.name
        val age = it.age

        println("Person name  $name")
        println("Person age $age")
    }
}