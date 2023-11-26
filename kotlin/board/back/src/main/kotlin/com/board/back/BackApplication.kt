package com.board.back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackApplication

fun main(args: Array<String>) {
	println("CURRENT THREAD : ${Thread.currentThread().name}")
	val t1 = Thread();
	println("NEW THREAD NAME : ${t1.name}")
	t1.start();
	runApplication<BackApplication>(*args)
}


