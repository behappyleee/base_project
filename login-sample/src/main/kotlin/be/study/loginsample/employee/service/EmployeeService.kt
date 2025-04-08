package be.study.loginsample.employee.service

import be.study.loginsample.employee.entity.Employee
import be.study.loginsample.employee.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
) {
    fun findUserById(userId: Int): Employee {
        return employeeRepository.findById(userId).orElseThrow {
            throw RuntimeException("Not Found User")
        }
    }
}
