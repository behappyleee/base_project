package com.example.orm_jpa.example_9.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// 임베디드 타입은 기본 생성자가 필수임
@Embeddable
public class Address {

    // 객체를 불변하게 만들면 값을 수정할 수 없으므로 부작용을 원천 차단이 가능하다.
    // 따라서 값 타입은 될 수 있으면 불변 객체 (Immutable Onject) 로 설계를 하여야 한다.
    // 한 번 만들면 절대 변경할 수 없는 객체인 불변 객체로 설계를 해야한다. 불변 객체의 값은 조회할 수 있지만 수정할 수 없다.
    // 불변 객체도 결국 객체이다. 따라서 인스턴스의 참조 값 공유를 피할 수 없다. 하지만 참조 값을 공유 하여도 인스턴스의 값을 수정할 수 없으므로
    // 부작용이 발생하지 않는다.

    // 불변 객체를 구현하는데 여러가지 방법이 있지만 가장 간단한 방법으로는 생성자로만 값을 설정을 하고 수정자를 만들지 않으면 된다.

    // 기존 Address 객체
//    @Column(name = "city")
//    private String city;
//
//    private String street;
//
//    private String zipcode;

    // 불변 객체이므로 값을 수정할 수 없으므로 공유하여도 부작용이 발생하지 않는다.
    // 기존 Address 객체를 불변 객체로 변경
    private String city;

    protected Address() {}  // JPA 에서 기본 생성자는 필수이다.

    public Address(String city) {
        this.city = city;
    }

    // 접근자 Getter 는 노출
    public String getCity() {
        return city;
    }

    // 수정자 setter 는 만들지 않는다.

}
