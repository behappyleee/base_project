package com.study.bean_test.proxy.example.repository

class NormalMemberRepository: MemberRepository {
    override fun save() {
        println("Normal Member Repository save !!")
    }
}
