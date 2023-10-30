package com.sample.study.scope

fun main() {

    scopeFunction();


}

fun scopeFunction() {
    // Kotlin 표준 라이브러리에는 객체 내부에서 코드를 실행 할 수 있는 여러 함수가 제공 된다
    // 그들 중 일부는 람다 표현식이 제공 되고 임시 스코프가 형성 된다.
    // 이 스코프에서는 객체의 이름을 사용하지 않고 객체의 접근이 가능
    // it / this 를 활용
    
    // Scope Function 에는 let / run / with / apply / also 등이 있음
    var per1 = Person("per1", 20, true);
    var per2 = Person("per2", 21, true);
    var per3 = Person("per3", 22, false);
    var per4 = Person("per4", 23, true);
    var per5 = Person("per5", 24, false);

    var perList = arrayListOf(per1, per2, per3, per4, per5);

    perList.let {
        // Scope Function it / this 등으로 객체 내부를 접근을 가능
        println(it);
    }

}

class Person(var name:String?, var age:Int?
    , var isKorean: Boolean?)