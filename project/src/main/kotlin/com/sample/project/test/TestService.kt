package com.sample.project.test

class TestService(
    testBeanConfig: TestBeanConfig
) {

    init {
        println("THIS IS TEST SERVICE BEAN !")
    }


    fun testService(): String {
        return "Test Bean Service Check !!"
    }

}