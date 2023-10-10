package com.sample.study

import com.sample.study.basic.KotlinClassTest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.sample.study.basic.makeStr
import com.sample.study.basic.makeStr2

@SpringBootApplication
class StudyApplication

// Kotlin 공식 문서 사이트 !
// https://kotlinlang.org/docs/home.html

fun main(args: Array<String>) {
	makeStr();
	makeStr2();

	val kotlinObjTest = KotlinClassTest();
	kotlinObjTest.makeClassFunctionTest();
	kotlinObjTest.makeClassFunctionTest2();


	runApplication<StudyApplication>(*args)
}
