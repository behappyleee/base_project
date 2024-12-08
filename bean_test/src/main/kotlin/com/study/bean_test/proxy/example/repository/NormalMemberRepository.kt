package com.study.bean_test.proxy.example.repository

class NormalMemberRepository: MemberRepository {
    override fun save(): String {
        println("Normal Member Repository save !!")
        return  "Normal Member Repository save Success!!"
    }
}
