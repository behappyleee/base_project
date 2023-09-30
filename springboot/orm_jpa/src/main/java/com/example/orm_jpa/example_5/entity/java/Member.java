package com.example.orm_jpa.example_5.entity.java;

public class Member {

    // 순수 Java 로 연관 관계 표현

    // 엔티티들은 대부분 다른 엔티티들과 연관이 있다.
    // 객체는 참조를 사용하여 관계를 맺고 테이블은 외래키를 사용하여 관계를 맺는다.
    // 객체 관계 매핑에서 가장 어려운 부분이 바로 객체 연관 관계와 테이블 연관 관계를 매핑하는 일이다.

    // 연관 관계 중에서 다대일(N:1) 관계를 가장 먼저 이해하여야 한다.
    // ex) 회원과 팀이 있다. 회원은 하나의 팀에만 소속될 수 있다. 회원과 팀은 다대일 관계다.

    // 객체 연관 관계와 테이블 연관 관계의 차이점을 파악하여야 한다.
    // 객체는 참조로 연관 관계를 맺고 테이블은 외래키로 연관 관계를 맺는다.
    // 참조를 통한 연관관계는 언제나 단방향이다. (객체간에 연관관계를 양방향으로 만들고 싶으면 반대쪽에도 필드를 추가하여 참조를 보관하여야한다.)

    private String id;
    private String userName;

    private Team team;

    public Member () {}

    public Member(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

// 단방향
class A {
    B b;
}

class B {

}

// 양방향
class C {
    D d;
}

class D {
    C c;
}

