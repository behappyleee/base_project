package com.study.jpasample

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
class Account(
    // TODO : JPA 를 코틀린에서 사용할 떄 BEST Practice 를 고민해 보기 ... !
    // JPA 는 반드시 No-Args 생성자를 가져야 한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val userName: String= "",
    @Column
    val password: String = "",
) {}

//@Entity
////@Table(name = "ACCOUNT")
//class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    var id: Long? = null
//
//    @Column
//    var userName: String? = null
////    var name: String
////
////    private lateinit var password: String
//}
//
//fun main() {
//
//    data class Test(
//        val name: String,
//    ) {
//        var age:Int = 0
//    }
//
//    val t1 = Test("1")
//    t1.age = 10
//
//    val t2 = Test("1")
//    t2.age = 20
//
//    println(t1 == t2)
//}