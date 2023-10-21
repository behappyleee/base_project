package com.sample.study.classtype

fun main() {
    // Object 클래스
    // 익명 클래스를 만들 목적으로 사용
    // 클래스 이름이 없으므로 클래스를 선언하면서 동시에 객체를 생성
    // 선언과 동시에 객체를 생성한다는 의미 => object 키워드 사용

    // 클래스를 선언하자마자 객체가 생성되며 그 객체를 obj1 변수에 저장함
    // object 키워드로 클래스를 선언하였지만 타입을 명시하지 않아 kotlin 의 최상위 타입인
    // Any 로 취급
    var obj1 = object {
        var data = 10;
        fun some() {
            println("obj 1 > some() - data : $data ");
        }
    }
    
    // 타입을 지정 한 익명 클래스
    // Super 클래스를 상속 받음
    // obj2 객체를 이용하여 Super 클래스에 선언 된 멤버에 접근 가능
    var obj2 = object: Super() {
        override var data: Int = 27;
    }

    println(obj2.data);

    obj2.data = 25;
    obj2.some();

}

open class Super {
    open var data = 10;

    open fun some() {
        println("Super > some() - data $data ");
    }
    
}