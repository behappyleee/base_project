package be.study.loginsample.user.entity

import be.study.loginsample.type.Gender
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @Column(name = "emp_no", nullable = false)
    val empNo: Int,

    @Column(name = "birth_date", nullable = false)
    val birthDate: LocalDate,

    @Column(name = "first_name", nullable = false, length = 14)
    val firstName: String,

    @Column(name = "last_name", nullable = false, length = 16)
    val lastName: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, columnDefinition = "enum('M','F')")
    val gender: Gender,

    @Column(name = "hire_date", nullable = false)
    val hireDate: LocalDate
)


