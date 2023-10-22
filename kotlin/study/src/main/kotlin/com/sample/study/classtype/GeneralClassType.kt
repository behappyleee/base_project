package com.sample.study.classtype

fun main() {
    // Kotlin 은 Class 에 본문 내용이 없으면 {} 생략이 가능
    // 생성자는 constructor() 키워드로 선언하는 함수
    // 클래스 안에 다른 클래스 선언 가능
    // 클래스의 멤버는 생성자, 변수, 함수 클래스로 구성
    // 클래스는 객체를 생성하여 객체의 클래스 멤버로 접근
    // 코틀린에서는 객체를 생성 시 new 키워드를 사용하지 않고 클래스 이름과 같은 함수로 객체 생성


}

// Kotlin 은 클래스 생성 시 주 생성자 / 보조 생성자로 구분하여 생성이 가능
// 주 생성자 선언은 필수는 아니며 한 클래스에 하나만 가능
// 주 생성자를 선언 시 constructor 키워드는 생량이 가능
// 주 생성 자를 선언 하지 않으면 컴파일러가 매개변수가 없는 주 생성자를 자동으로 추가함
// 주 생성자를 선언 시 필요에 따라 매개 변수 선언이 가능

// 주 생성자는 클래스에 선언부에 있기 때문에 {} 를 추가하여 본문을 구현이 불가
// 클래스 안에서 init 키워드로 지정한 영역에서 주 생서자의 본문을 구현이 가능
// 생성자의 매개변수는 생성자 에서만 사용할 수 있는 지역 변수이다.
// 매개 변수를 val/var 키워드로 선언하면 클래스의 멤버 변수가 된다.

// Kotlin 클래스 주 생성 자 선언 시 (constructor 키워드 사용 안 함)
class User2() {}

// Kotlin 클래스 주 생성 자 선언 시 (constructor 키워드 사용 안 함)
class User3 constructor () {}

class User5 (name: String) {
    init {
        // 생성자의 매개변수를 init 영역에서 사용
        println("[PRINT PARAMETER : $name]");
    }
    fun someFun() {
    // 사용이 불가 생성자의 매개변수는 생성자 영역안에서만 사용이 가능
    //     println("[PRINT PARAMETER $name]");
    }
    
}


// Kotlin 생성자의 매개변수를 init 영역외에도 사용하기 위하여 서는 val/var 변수를 사용
class User6(val name: String) {
    fun someFun() {
        println("[STRING PARAMETER USER $name]");
    }

}


class User {
    // 멤버 변수
    var name: String = "kim";

    // 생성자
    constructor(name: String) {
        this.name = name;
    }

    // 함수
    fun namePrint() {
        println("[User Name $name]");
    }

    // 다른 클래스
    class SomeClass{}
}