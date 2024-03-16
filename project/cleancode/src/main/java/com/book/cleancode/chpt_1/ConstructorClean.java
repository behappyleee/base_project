package com.book.cleancode.chpt_1;

public class ConstructorClean {

    // Push Test !!

    public static void main(String[] args) {
        // 생성자를 중복 정의 할 때 에는 정적 팩토리 메서드를 사용하는게 낫다.
        // 재미난 이름보다는 명료한 이름을 항상 선택하여라 !
        // 프로그래머는 코드를 최대한 이해하기 쉽게 짜야한다
        ConstructorCheck cc = ConstructorCheck.FromRealNumber(3.0);
        ConstructorCheck cc1 = new ConstructorCheck(3.0);
    }

}

class ConstructorCheck {

    public ConstructorCheck(Double num) {

    }

    public static ConstructorCheck FromRealNumber(Double num) {
        return new ConstructorCheck(num);
    }

}
