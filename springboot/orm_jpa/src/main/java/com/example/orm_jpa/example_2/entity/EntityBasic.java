package com.example.orm_jpa.example_2.entity;

import com.example.orm_jpa.example_2.enums.RoleType;
import jakarta.persistence.*;

@Entity
@Table(name = "EntityBasic")
public class EntityBasic {

    // JPA 를 사용 시 가장 중요한 것은 엔티티와 테이블을 정확히 맵핑하는 것
    // 객체와 테이블 맵핑 @Entity @Table
    // 기본 키 맵핑 @Id
    // 필드와 컬럼 매핑 @Column
    // 연관 관계 매핑 @ManyToOne @JoinColumn

    // @Entity - JPA 가 관리하는 것으로 엔티티라고 불림 (name JPA 에서 사용할 엔티티 이름을 지정, 속성 사용 설정 하지 않을 시 기본 클래스 이름을 사용)
    // @Table - 테이블 어노테이션은 엔티티와 맵핑할 테이블을 지정, 생략하면 매핑한 엔티티 이름을 테이블 이름으로 사용 (name 은 매핑 할 테이블 이름)

    // JPA 는 데이터 베이스 스키마를 자동으로 생성하는 기능을 지원
    // 클래스의 매핑 정보를 보면 어떤 테이블에 어떤 컬럼을 사용하는 지 알 수 있음, JPA 는 이 매핑 정보와 데이터 베이스 방언을 사용하여 데이터 베이스 스키마를 생성

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    // Column 어노테이션 옵션에 회원 이름은 필수로 입력 되어야 하고 10자를 초과하면 안 된다는 제약 조건을 추가, nullable 속성을 false 로 지정 시 해당 값은 필수 값
    @Column(name = "NAME", nullable = false, length = 10)
    private String userName;

    // 데이터 베이스는 주로 관례 상 언더바를 많이 사용하고 자바는 카멜 케이스를 많이 사용하므로 매핑을 해 줌
    @Column(name = "role_type")
    // @Enumerated(EnumType.ORDINAL)   // Enum 에 정의 된 Index 를 저장 (사용 하기 위험)
    @Enumerated(EnumType.STRING)    // Enum 값에 String 을 저장 (사용 권장)
    private RoleType roleType;

}
