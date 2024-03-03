package com.book.cleancode.chapter_3;

public class SwitchJava {

    // switch 문은 작게 만들기 어렵다. 한 가지 작업만 하는 swith 문도 만들기가 어렵다.
    // 본질적으로 switch 문은 N 가지를 처리한다.
    // 직원 유형에 따라 다른 값을 계산해 반환하는 함수

    // 해당 아래 함수에는 몇 가지 문제점이 있다.
    // 첫 째. 함수가 길다. 새 직원 유형을 추가하면 더 길어 진다.
    // 둘 째. 한 가지 작업만 수행하지 않는다.
    // 셋 째. SRP(Single Responsibility Principle) 을 위반한다.
    // 네 째. OCP (Open and Closed Principle) 울 위반한다. -> 새 직원 유형을 추가할 때 마다 코드를 변경하기 때문
    // 가장 심각한 문제라면 위 함수와 구조가 동일한 함수가 무한 정 존재한다는 사실
    // isPayday(Employee e, Date date); or deliver(Employee e, Money pay) 등 무한정으로 생성이 될 수 있다.

    // 함수에서 이상적인 인수의 갯수는 0개이다. 다음은 1개, 다음은 2개, 3개는 피하는 편이 좋으며,4개 이상은 특별한 경우가 필요하다.

    // switch 문을 추상 팩토리 Abstract Factory 에 숨긴다. 팩토리는 switch 문을 사용하여 적절한 Employee
    // 파생 클래스의 인스턴스를 생성한다.

//    public Money calculatePay(Employee e) throws InvalidEmployeeType {
//        switch(e.type) {
//            case COMMISIONED:
//                return calculateCommissionedPay(e);
//            case HOURLEY:
//                return cacluateHourlyPay(e);
//            case SALARIED:
//                return calculateSalariedPay(e);
//            default:
//                throw new InvalidEmployeeType(e.type);
//        }
//    }

}

