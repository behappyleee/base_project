package com.sample.data.rest.controller;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    // 하나의 서비스 되는 웹 어플리케이션에서 하나의 엔티티 타입만을 이용하는 경우는 많지 않음
    // ex) Member 와 Team 엔티티가 있을 시 하나의 Team 은 여러 Member 를 갖는 관계를 가짐
    // 이렇게 엔티티들이 서로 어떤 연관 관계를 갖는 지 파악하는 것은 매우 중요
    // 연관 관계 매핑이란 객체의 참조와 테이블의 외래 키를 매핑하는 것을 의미
    // JPA 에서는 연관 관계에 있는 상대 테이블의 pk 를 멤버 변수로 갖지 않고, 엔티티 객체 자체를 통쨰로 참조
    // 단방향 관계 : 두 엔티티가 관계를 맺을 때 한 쪽의 엔티티만 참조하고 있는 것을 의미
    // 양방향 관계 : 두 엔티티가 관계를 맺을 때, 양 쪽이 서로 참고 하고 있는 것을 의미

    // ManyToOne  : 다대일 (N : 1)
    // OneToMany  : 일대다 (1 : N)
    // OneToOne   : 일대일 (1 : 1)
    // ManyToMany : 다대다 (N : N)

    // ex) 하나의 Team 은 여러 Member 를 구성원으로 갖고 있으므로 Team 입장에서는 Member 와 일대다 관계
    //     Member 입장 에서는 하나의 Team 에 속하므로 다대일 관계
    // 즉, 어떤 엔티티를 중심으로 상대 엔티티를 바라보느냐에 따라 다중성이 다르게 됨
    




}
