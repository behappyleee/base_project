package com.example.kotlin_book.chapter_2

import java.io.File

class Kotlin_Resource {

    // 자바에서 자원을 사용하는 try 로 할 수 있는 것처럼 코틀린도 자원을 자동으로 닫을 수 있다.
    // 이때 자원은 Closable 이나 AutoClosable 중 하나를 구현하여야 함, 자바와 코틀린의 가장 큰 차이점은
    // 코틀린에서는 use 라는 함수를 사용

    // use 함수 블록을 벗어나면 입력 스트름이 자동으로 닫힘, 더 이상 스트림 사용이 불가
    val a = File("test.txt").inputStream()
        .use {
            it.bufferedReader()
                .lineSequence()
                .forEach(::println)
        }
    

}

fun main(args: Array<String>) {

    // use 함수 블록을 벗어나면 입력 스트름이 자동으로 닫힘, 더 이상 스트림 사용이 불가
    val a = File("test.txt").inputStream()
        .use {
            it.bufferedReader()
                .lineSequence()
                .forEach(::println)
        }


    // IOException 이 발생, stream 은 이미 닫혔기에
    println(a)

    // use 함수 블록을 벗어나면 입력 스트름이 자동으로 닫힘, 더 이상 스트림 사용이 불가
    // useLines 를 사용 시 앞의 예제와 같은 기능을 함
    val b = File("test.txt").useLines { 
        it.forEach(::println)
    }
    
}