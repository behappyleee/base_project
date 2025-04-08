package be.study.loginsample.employee.controller.response

import be.study.loginsample.employee.entity.Employee
import be.study.loginsample.type.Gender
import java.time.LocalDate

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

