package com.example.orm_jpa.example_9;

import com.example.orm_jpa.example_9.embeded.Address;
import com.example.orm_jpa.example_9.entity.Member;

public class ExampleMain {

    public static void main(String[] args) {

        // 불변 객체 전 Address 사용 시 (객체가 공유가 되면 위험한 상황이 발생 될 수 있음)
//        Address address1 = new Address();
//
//        Member member1 = new Member();
//        member1.setId(7777L);
//        member1.setName("멤버1");
//        member1.setAddress(address1);
//
//        Member member2 = new Member();
//        member2.setAddress(address1);
//
//        // 만약 Member2 에 주소 설정을 위하여 address1 의 값을 변경하여 저장 시 address1 에 값이 바뀌게 되므로 기존에 저장하였던 member1 에 address 값도
//        // 변하게 된다. 객체를 공유하게 되므로 값이 수정 시 부작용이 발생하게 된다. 이러한 오류 사항은 찾아내기가 매우 까다롭다. 이러 한 부작용을 피하기 위하여서는
//        // 불변로 만들어서 사용을 한다.
//        address1.setCity("New York");
//        member2.setAddress(address1);

        Address address1 = new Address("Seoul");
        Member member1 = new Member();
        member1.setAddress(address1);

//        address.setCity("New York"); 불변 객체에는 set 메서드가 없으므로 값 변경이 불가능하다.
        Address address2 = new Address("New York");
        Member member2 = new Member();
        member2.setAddress(address2);   // 객체를 새로 생성하여 값을 저장해 주므로 상당히 안전하다 (객체 공유를 막을 수 있다)

    }

}
