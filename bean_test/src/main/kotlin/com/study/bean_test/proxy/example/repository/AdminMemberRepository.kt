package com.study.bean_test.proxy.example.repository

// TODO : OnecPerRequest 테스트 해보기 !!!
class AdminMemberRepository: MemberRepository {
    override fun save(): String {
        println("Admin Member Repository Save !!!")
        return "Admin Member Repository Save Success !!!"
    }
}
