package com.sample.study.basic

import kotlin.random.Random

fun main() {
    // Scope Function 은 함수들을 람다식을 이용해서 호출하면 일시적인 Scope (범위) 가 생기게 되고
    // 이 범위 안에서 전달 된 객체에 대해 it 또는 this 라는 Context Object 를 통해서 접근이 가능
    // Scope Function 에는 서로 다른 두 가지 주요 차이점이 있음
    // Context Object 를 참조 하는 방법 (it / this), Return value

    val per1 = Person("테스트1", 22);
    val per2 = Person("테스트2" ,23);

    // it or this 로 접근
    // run 일시에는 this 로 참조 (생략도 가능)
    per1.run {
            println("이름 : " + this.name);
        // this 를 생략도 가능
        println("나이 : " + age);
    }

    // let 은 it 으로 접근
    per1.let {
        println("이름 : " + it.name);
        println("나이 : " + it.age);
    }

    // let 에서는 따로 이름 지정도 가능
    per1.let {
        // check 로 이름 지정도 가능
        check ->
            println(check.name);
    }

    // also 또한 it 으로 참조가 가능
    per1.also {
        println(it.name);
    }

    // also 도 마찬가지로 따로 참조 변수 지정이 가능
    per1.also {
        check1 ->
            println(check1.name);
    }

    // Return Value
    
    // apply / also 의 반환 값은 Context Object 객체 자체임 그렇기에 체인 형식으로 계속 호출이 가능
    val numberList = mutableListOf<Double>();

    numberList.also { println("This is Also method numberList") }
            .apply {
                add(2.71)
                add(3.7)
                add(4.2)
            }
            .also { println("This is Sorting list") }
            .sort();

}

// Context Object 를 반환 하는 함수의 return 문에도 사용이 가능
fun getRandomInt(): Int {
    return Random.nextInt(100).also {
        println("this is random next Int RANDOM NUMBER : " + it);
    }
}

class Person(var name: String, var age:Int)