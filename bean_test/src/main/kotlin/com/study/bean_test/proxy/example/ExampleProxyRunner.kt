package com.study.bean_test.proxy.example

import com.happy.enojilogger.logger.EmojiLoggerFactory
import com.happy.enojilogger.type.EmojiPrintMode
import com.study.bean_test.proxy.example.proxy.DynamicProxyHandlerTest
import com.study.bean_test.proxy.example.proxy.MemberRepositoryProxyTest
import com.study.bean_test.proxy.example.repository.AdminMemberRepository
import com.study.bean_test.proxy.example.repository.MemberRepository
import com.study.bean_test.proxy.example.repository.NormalMemberRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.reflect.Proxy


class ExampleProxyRunner

fun main() {
    val emojiLogger = EmojiLoggerFactory(
        logger = LoggerFactory.getLogger(ExampleProxyRunner::class.java),
        emojiMode = EmojiPrintMode.ICON,
    )


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