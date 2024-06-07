package com.canbe.libraryimport.service

// import com.canbe.libraryimport.controller.KotlinTestController
import com.canbe.libraryimport.controller.KotlinTestController
import org.springframework.stereotype.Service
// import test.check.KotlinClassTes

@Service
class KotlinLibraryService {

    fun serviceTest() {
//        println("[KOTLIN LIBRARY SERVICE CLASS TEST CHECK !!!!!!]")

        val aa = listOf("a", "b", "c")
        aa.run { println(this) }
        aa.forEach { println(it) }


        //
//        // TODO - 외부 파일 jar 파일 import TEST 해보기 !!!!
//
//        val cccc = KotlinClassTest(
//            name = "SDSD",
//            str = "asdasdasd",
//        )
//
//        cccc.printTest()

//        val ttt = KotlinClassTest (
//            name = "name TEST",
//            str = "STR TEST"
//        )

//        ttt.printTest()
//        val tccc = KotlinClassTest(
//            name = "asdasdsd",
//            str = "sdasdasdasd",
//        )

//        tccc.printTest()
    }

//    fun check(aa: KotlinInterfaceTest) {
//        aa.interfaceTest()
//    }
}
