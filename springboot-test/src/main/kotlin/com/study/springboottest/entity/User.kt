package com.study.springboottest.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

// TODO : Entity JPA Kotlin 해결이 필요 ... !
@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private val id: Int? = null
        get() = field

    @Column(name = "user_name")
    private val name: String? = null
        get() = field

//    @Column(name = "user_passwd")
//    val password: String
//        get() = field

    @Column(name = "user_email")
    private val email: String? = null
        get() = field

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "user_role")
    private val roles: List<String>? = null
        get() = field
}
