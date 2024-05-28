package com.canbe.libraryimport.service

import org.springframework.stereotype.Service
import service.KotlinClassTest
import service.KotlinInterfaceTest

@Service
class KotlinLibraryService {

    fun serviceTest() {
        println("[KOTLIN LIBRARY SERVICE CLASS TEST CHECK !!!!!!]")

        val tccc = KotlinClassTest(
            name = "asdasdsd",
            str = "sdasdasdasd",
        )

        tccc.printTest()
    }

    fun check(aa: KotlinInterfaceTest) {
        aa.interfaceTest()
    }
}
