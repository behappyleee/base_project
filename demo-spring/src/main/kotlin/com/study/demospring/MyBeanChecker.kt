package com.study.demospring

import org.apache.catalina.core.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MyBeanChecker: ApplicationRunner {
    @Autowired
    private lateinit var applicationContext: ApplicationContext

    override fun run(args: ApplicationArguments?) {
//        // 모든 빈 이름 가져오기
//        val beanNames = applcationContext.attributeNames
//        println("=== Registered Beans (${beanNames.size}) ===")
//
//        // 빈 이름과 타입 출력
//        beanNames.sorted().forEach { beanName ->
//            val beanType = applcationContext.getType(beanName)?.name ?: "Unknown Type"
//            println("Bean Name: $beanName, Bean Type: $beanType")
//        }
    }
}