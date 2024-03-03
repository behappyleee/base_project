package com.book.cleancode.chapter_3;

public class AbstractFactory_Switch {


}


//abstract class Employee {
//    public abstract boolean isPayday();
//    public abstract Money calculatePay();
//    public abstract void deliverPay(Money pay);
//}

// 추상화로 숨겨 둔다. 일반적으로 switch 문을 한번만 참아준다. 다형적 객체를 생성하는 코드 안에서다.
// 이렇게 상속 관계로 숨긴 후에는 절대로 다른 코드에서는 노출 시키지 않는다.
// switch 문을 추상 팩토리 Abstract Factory 에 꽁꽁 숨긴다.
//public interface EmployeeFactory {
//    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
//}
//

// 팩토리는 switch 문을 사용하여 적절한 Employee 파생 클래스의 인스턴스를 생성
// isPayday, deliveryPay, calculatePay 등 과 같은 함수는 Employee 인터페이스를 거쳐서 호출이 됨
// 그러면 다형성으로 인해 실제 파생 클래스의 함수가 실행이 됨
//class EmployyFactoryImpl implements EmployeeFactory {
//
//    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
//        switch(r.type) {
//            case COMMISSIONED:
//                return new CommissionedEmployee(r);
//            case HOURLY:
//                return new HourlyEmployee(r);
//            case SALARIED:
//                return new SalariedEmployee(r);
//            default:
//                throw new InvalidEmployeeType(r.type);
//        }
//    }
//}