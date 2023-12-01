package com.sample.study.beans

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class BeanTestController(
    private val beanTest: BeanTest,
    private val mapper: ObjectMapper,
    // private val noBeanTest: NoBeanTest,  // bean 으로 등록 되지 않아 Compile Error 가 발생 !
) {

    @GetMapping("/test/bean")
    fun beanTest(): String {
        println("[THIS IS CONTROLLER BEAN TEST CONTROLLER !!]")
        beanTest.beanTestFunc()
        return "This is bean Test Check !!!"
    }

}