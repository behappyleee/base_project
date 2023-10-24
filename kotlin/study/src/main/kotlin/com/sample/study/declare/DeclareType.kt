package com.sample.study.declare


// 초기화 미루기
// 1. lateinit
// lateInit 은 선언만 한 후 할당은 나중에 한다는 의미
// 로컬 변수로는 사용이 불가 전역 변수로만 사용 이 가능
lateinit var lateVar1: String   // val 은 선언 불가

lateinit var lateVar2: String;

// 2. lazy keyword
// 소스에서 변수가 최초로 이용되는 순간 중괄호로 묶은 부분이 자동으로 실행되어 그 결과값이
// 변수의 초기값 으로 할당
val testVal:String by lazy {
    "test"
}

val testVal2: Int by lazy {
    27
}

fun main() {
    // lateinit 변수 할당
    lateVar1 = "check late var";

    println(lateVar1);
    println(testVal);
    println(testVal2 + 32);
    // Kotlin Declare Type

    val declareVal: String = "test";
    var declareVar: String = "test";

    // val 은 재 할당 할 수 없는 상수
//    declareVal = "test1";
    
    declareVar = "test1";   // var 는 재할당이 가능
    
    // var 타입이지만 같은 이름의 변수로 선언이 불가능
//    var declareVar: Int = 3;

  // 초기화 미루기
    // lateinit 키워드
    var test: String = "test";


}