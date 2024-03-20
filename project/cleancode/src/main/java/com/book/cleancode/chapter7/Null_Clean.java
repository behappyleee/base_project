package com.book.cleancode.chapter7;

public class Null_Clean {

    // 절대 NULL 을 반환하지마라
    // NULL 을 반환하는 코드는 일거리를 늘릴 뿐 아니라 호출자에게 문제를 떠넘기는 것이다.
    // 누구 하나라도 NULL 을 뺴먹는 다면 어플리케이션이 통제 불능에 빠진다.
    // NULL 을 반환하고픈 유혹이 든다하면 그 대신 예외를 던지거나 특사 사례 객체를 반환한다.
    // 사용하려는 외부 API 가 NULL 을 반환 한다면 감싸기 메서드를 구현하여 예외를 던지거나 특수 사례 객체를 반환하는 방식을 고려한다.

    // 대부분의 경우 특수 사례 감싸기가 가장 쉬운 방법이다.


}