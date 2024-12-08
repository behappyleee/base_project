package com.study.bean_test.proxy.example.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

// Dynamic Proxy 구현 테스트 !!, 동적으로 생성 된 클래스를 받음
class DynamicProxyHandlerTest(
    private val targetObject: Any,
): InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        println("Dynamic Proxy Start !!!")
        println("Run Proxy Name ${proxy?.javaClass?.simpleName}")
        println("Run Method Name : ${method?.name}")

        val methodResultInvoke = method?.invoke(targetObject, args)
        println("Dynmic Proxy Method Result !! $methodResultInvoke")
        println("Dynamic Proxy End !!!")


        return methodResultInvoke ?: ""
    }
}
