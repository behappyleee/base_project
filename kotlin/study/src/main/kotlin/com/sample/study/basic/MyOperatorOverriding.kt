package com.sample.study.basic

class MyOperatorOverriding {

    // 코틀린 연산자 오버라이딩
    val mon1 = Money(100);
    val mon2 = Money(200);
    
    // plus 메서드를 오버라이딩 함
    val sum = mon1.plus(mon2);
    val sum1 = mon1 + mon2;
}

data class Money(
        val value: Int
) {
    
    // plus 라는 연산자를 오버로딩 한 Money 클래스
    operator fun plus(money: Money) : Money = Money(value + money.value)
}