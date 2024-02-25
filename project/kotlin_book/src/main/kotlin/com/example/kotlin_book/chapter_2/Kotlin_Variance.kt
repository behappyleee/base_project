package com.example.kotlin_book.chapter_2

class Kotlin_Variance {

    // 자바에서는 파라미터화한 타입이 파라미터 타입에 대해 무공변성 이다.
    // 즉 A 가 B 의 부모 타입이라 하더라도 List<A>, List<B> 와 사이에는 아무런 부모 자식 타입 관계가 성립 하지 않음
    // List<A> 와 List<B> 는 컴파일 시점에 전혀 다른 두 가지 타입이다.

}

fun main(args: Array<String>) {
    val ls = mutableListOf("A String")
    val la: MutableList<Any> = mutableListOf()

    // addAllTest(la, ls)  // Compile 되지 않음
    addAllCompile(la, ls)  // Compile 이 가능하게 만듦    
    
    
    // Kotlin 에서는 MutableList<Any> 와 MutableList<String> 을 동시에 MutableList<T> 라는 제네릭 타입에
    // 일치 시킬 수 없음
    // 여기서 MutableList<String> 의 상위 타입 처럼 쓰일 수 있음을 컴파일러에게 알려주어야 한다

}

fun <T> addAllTest(list1: MutableList<T>,
               list2: MutableList<T>) {
    for (elem in list2) list1.add(elem)
}

// MutableList<Any> 가 MutableList<String> 의 상위 타입처럼 쓰일 수 있음을 컴파일러에게 알려주어야 함
// 여거시 MutableList<Any> 가 MutableList<String> 상위 타입으로 쓰일 수 있는 이유는 la 에서 값을 가져오기만 (out) 하고
// 값을 넣는 (in) 일은 없기 때문

// in 이나 out 을 하나도 지정하지 않으면 파라미터 타입은 무공변성이다. out 과 in 중 어떤 것을 선택할지는 타입을
// 오직 출력 (반환 값에만 쓰면) out 을, 오직 입력 (인자 값) 에 쓰면 in 을 사용한다고 기억하면 간단

fun <T> addAllCompile(list1: MutableList<T>,
                   list2: MutableList<out T>) { // T 를 공변성으로 만듦
    for (elem in list2) list1.add(elem)
}