package com.book.cleancode.chapter_6;

public class DemeterRule {

    // 디미터 법칙은 잘 알려진 휴리스틱으로 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙.
    // 객체는 자료를 숨기고 함수를 공개한다. 즉 객체는 조회 함수로 내부 구조를 공개하면 안된다는 의미

    // 디미터 법칙은 클래스 C 의 메서드 f 는 다음과 같은 객체의 메서드만 호출해야 한다.
    // 클래스 C, f 가 생성한 객체, f 인수로 넘어온 객체, C 인스턴스 변수에 저장 된 객체

    // 자료 구조체의 전형적인 형태는 공개 변수만 있고 함수가 없는 클래스다.
    // 이런 자료 구조체를 떄로는 자료 전달 객체 (Data Transfer Object) 라고 한다.


}

// DTO 예제
class AddressTest {
    private String street;
    private String streetExtra;
    private String city;
    private String state;
    private String zip;

    public AddressTest(String street, String streetExtra,
                       String city, String state, String zip) {
        this.state = state;
        this.streetExtra = streetExtra;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStret() {
        return street;
    }

    public String getStreetExtra() {
        return streetExtra;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}

