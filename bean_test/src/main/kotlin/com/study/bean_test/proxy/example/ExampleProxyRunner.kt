package com.study.bean_test.proxy.example

import com.study.bean_test.proxy.example.proxy.DynamicProxyHandlerTest
import com.study.bean_test.proxy.example.proxy.MemberRepositoryProxyTest
import com.study.bean_test.proxy.example.repository.AdminMemberRepository
import com.study.bean_test.proxy.example.repository.MemberRepository
import com.study.bean_test.proxy.example.repository.NormalMemberRepository
import java.lang.reflect.Proxy


class ExampleProxyRunner

fun main() {
    // 클래스를 직접 구현한 프록시 들은 중복 코드도 많아 비효율 적이다.
    val normal = NormalMemberRepository()
    val admin = AdminMemberRepository()

    println(normal.save())
    println(admin.save())

    val normalProxyTest = MemberRepositoryProxyTest(normal)
    val adminProxyTest = MemberRepositoryProxyTest(admin)

    println(normalProxyTest.callSaveProxy())
    println(adminProxyTest.callSaveProxy())

    val adminRepository = AdminMemberRepository()
    val dynamicHandlerTest = DynamicProxyHandlerTest(adminRepository)

    val proxyTest = Proxy.newProxyInstance(MemberRepository::class.java.classLoader,
        arrayOf(MemberRepository::class.java), dynamicHandlerTest) as MemberRepository


    proxyTest.save()
}