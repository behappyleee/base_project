package com.book.cleancode.chpt_1;

public class ConstructorClean {

    public static void main(String[] args) {

        // 생성자를 중복 정의 할 때 에는 정적 팩토리 메서드를 사용하는게 낫다.
        ConstructorCheck cc = ConstructorCheck.FromRealNumber(3.0);
        ConstructorCheck cc1 = new ConstructorCheck(3.0);

    }

}

class ConstructorCheck {

    public ConstructorCheck(Double num) {

    }

    public static ConstructorCheck FromRealNumber(Double num) {
        return new ConstructorCheck();
    }

}
