package com.sample.study.classtype

fun main() {

    // Data 클래스는 주 생성자에 선언한 멤버 변수의 데이터만 비교대상으로 삼음
    var mydata1 = MyDataClass("lee", 3, 5, "School", "Seoul");
    var mydata2 = MyDataClass("lee", 3, 5, "School");

    println(mydata1 == mydata2);        // true
    println(mydata1.equals(mydata2));   // true

    var myclass1 = MyClass("class", 7);
    var myclass2= MyClass("class", 7);

    println(myclass1.equals(myclass2)); // false
    println(myclass1 == myclass2);      // false


}

// 일반 클래스
class MyClass(name: String, age: Int) {}


// Data 클래스
data class KotlinDataClass(val name: String, val age:Int) {}

// 데이터 클래스 equals() 함수 사용 시 객체 자체를 비교하는 것이 아닌 객체의 데이터를 비교
data class MyDataClass(
     val name1: String
   , val age: Int
   , val grade: Int
   , val school: String
) { // 주 생성자에 선언 한 멤버 변수의 데이터만 비교 대상으로 삼는다.
    lateinit var address: String
    constructor(name: String, age: Int, grade:Int, school: String, address:String): this (
            name, age, grade, school
    ) {
        this.address = address;
    }
}