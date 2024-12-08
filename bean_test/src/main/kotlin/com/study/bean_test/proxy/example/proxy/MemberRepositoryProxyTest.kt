package com.study.bean_test.proxy.example.proxy

import com.study.bean_test.proxy.example.repository.MemberRepository

// 직접 생성 된 클래스마다 프록시를 구현해주기에는 중복이 너무 많아지고 비효율 적이다,
class MemberRepositoryProxyTest(
    private val memberRepository: MemberRepository,
) {

    fun callSaveProxy() {
        println("Proxy Start !!! Class Name : ${memberRepository.javaClass.simpleName}")
        memberRepository.save()
        println("Proxy End!!!")
    }
}
