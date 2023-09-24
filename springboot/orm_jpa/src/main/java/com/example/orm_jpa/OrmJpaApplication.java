package com.example.orm_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class OrmJpaApplication {

    // 패러다임의 불일치
    // 객체와 관계형 데이터 베이스는 서로 지향하는 목적이 다르므로 둘의 기능과 표현 방법도 다르다
    // 따라서 객체 구조를 테이블 구조에 저장하는 데는 한계가 있음
    // Application 은 자바라는 객체지향 언어로 개발을 하고 데이터는 관계형 데이터 베이스에 저장을 해야 한다면 패러다임의 불일치 문제를 
    // 개발자가 중간에서 해결을 해주어야 함

    // JPA -> JPA 는 상속과 관련 된 패러다임의 불일치 문제를 개발자 대신 해결하여준다.
    // 개발자는 마치 자바 컬렉션에 객체를 저장하듯이 JPA 에 객체를 저장하면 된다.

    // 객체는 참조를 사용하여 다른 객체와 연관 관계를 가지고 참조에 접근해서 연관 된 객체를 조회를 하지만 반변에 테이블은 외래 키를 사용하여
    // 다른 테이블과 연관 관계를 가지고 조인을 사용하여 연관 된 테이블들을 조회를 함

    // 객체와 데이터베이스 비교에도 차이가 있다. 데이터베이스는 기본 값으로 각 Row 를 구분 하지만 객체는 동일 성 (Identity) 와 동일성 (Equality) 비교 2가지 방법이 있음
    // 동일성비교는 == 로 객체 인스턴스의 주소값을 비교한다. 동등성 비교는 equals() 메서드를 사용하여 객체 내부의 값을 비교

    // 겍체 모델과 관계형 데이터베이스 모델은 지향하는 패러다임이 서로 다르다. 문제는 이 패러다임의 차이를 극복하려고 개발자가 너무 많은 시간과 코드를 소비한다.
    // 더 어려운 문제는 객체지향 어플리케이션 답게 정교한 객체 모델링을 할수록 패러다임의 불일치 문제가 더 커진다는 점이다.
    // 자바 진영에서는 오랜 기간 이 문제에 대하여 숙제를 안 고 있었고 패러다임의 불일치 문제를 해결하기 위하여 많은 노력과 시간을 기울여
    // 탄생한 것이 바로 JPA 이다.

    // ORM 프레임워크는 단순히 SQL 을 단순히 개발자 대신 생성해서 데이터베이스에 전달 해주는 것뿐만 다양한 패러다임의 불일치 문제들도 해결해 준다.
    // 자바 진영에는 다양한 ORM 프레임 워크들이 잇지만 그 중에 하이버 네이트 프레임 워크가 가장 많이 사용 됨

    // JPA 사용 시 장점은 어플리케이션과 데이터 베이스 사이에 추상화 된 데이터 접근 계층을 제공하여 어플리케이션 특정 데이터 베이스가 기술에 종속되지 않도록 한다.
    // 만약 데이터 베이스를 변경을 하게 되면 JPA 에게 다른 데이터 베이스를 사용한다고 알려주기만 하면 된다. (JPA 는 자바 진영의 ORM 기술 표준 이다.)

    // JPA 를 이해하는 데 가장 중요한 용어는 영속성 컨텍스트 (Persistence Context) -> 엔티티를 영구적으로 저장하는 환경 이다.


    public static void main(String[] args) {
        SpringApplication.run(OrmJpaApplication.class, args);
    }

}
