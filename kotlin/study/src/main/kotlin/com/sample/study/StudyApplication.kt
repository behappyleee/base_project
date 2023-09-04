package com.sample.study

import com.sample.study.basic.KotlinClassTest
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.sample.study.basic.makeStr
import com.sample.study.basic.makeStr2

@SpringBootApplication
class StudyApplication

fun main(args: Array<String>) {
	makeStr();
	makeStr2();

	val kotlinObjTest = KotlinClassTest();
	kotlinObjTest.makeClassFunctionTest();
	kotlinObjTest.makeClassFunctionTest2();


	runApplication<StudyApplication>(*args)
}
