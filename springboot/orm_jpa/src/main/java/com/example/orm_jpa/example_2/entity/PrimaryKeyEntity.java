package com.example.orm_jpa.example_2.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PrimaryKeyEntity {

    // 엔티티가 영속 상태가 되기 위하여서는 식별자 값이 반드시 필요
    // JPA 가 제공하는 기본 키 생성 전략
    // 직접 할당 -> 기본 키를 어플리케이션에 직접 할당
    // GeneratedValue 에 기본 값은 AUTO 임 (ex) 오라 클은 SEQUENCE, MySQL 은 IDENTITY 를 선택)

    // 자동 생성 전략이 다양 한 이유는 데이터 베이스 벤더마다 지원하는 방식이 다름
    // 자동 생성 -> 대리 키 사용 방식

    // 개발자가 엔티티에 직접 식별자를 지정 시 @Id 어노테이션만 있으면 되지만 식별자가 생성되는 경우에는 @GeneratedValue 어노테이션을 사용
    // GenerationType.IDENTITY 전략을 사용 시 JPA 는 기본 키 값을 얻어오기 위하여 데이터 베이스를 추가로 조히
    // IDENTITY : 기본 키 생성을 데이터 베이스에 위임 (ex MY_SQL 에 AUTO_INCREMENT 같은 기능을 사용)

    // !!!!!!!!! 주의 !!!!!!!!!!!!!!!
    // 엔티티가 영속 상태가 되려면 식별자 값이 반드시 필요한데 그런데 IDENTITY 식별자 생성 전략은 엔티티를 데이터 베이스에 저장해야 식별자를 구할 수 있으므로
    // persist() 메서드를 호출 하는 순산 즉시 INSERT SQL 이 전달이 되어 이 전략은 트랜 잭션을 지원하는 쓰기 지연이 동작하지 않음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    // ex Identity 전략 사용 시
//    Board board = new Board();
//    em.persist(board);    // persist() 메서드를 호출 하여 엔티티를 저장 한 직 후에 할당 된 식별자 값을 출력
//    board.getId();  // ex) 1

    // SEQUENCE : 데이터 베이스 시퀀스를 사용해서 기본 키를 할당
    // 데이터 베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터 베이스 오브젝트 이 시퀀스를 사용하여 기본 키를 생성
    // 우선 이 전략을 사용하기 위하 여서는 데이터 베이스 시퀀스와 매핑을 시켜주어야 함
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ")
    private String id_seq;
    // 시퀀스 사용 코드는 IDENTITY 전략과 같지만 내부 동작 방식은 다르다. SEQUENCE 전략은 em.persist() 를 호출 시 먼저 데이터 베이스 시퀀스를 사용하여 식별자를 조회
    // 그리고 조회 한 식별자를 엔티티에 할당 후 엔티티를 영속성 컨텍스트 에 저장, 반대로 IDENTITY 전략은 먼저 엔티티를 데이터 베이스에 저장 후 식별자를 조회하여 엔티티 식별자에 할당

    // ex Sequence 전략 사용 시
//    Board board = new Board();
//    em.persist(board);    // persist() 메서드를 호출 하여 엔티티를 저장 한 직 후에 할당 된 식별자 값을 출력
//    board.getId();  // ex) 1



    // TABLE : 키 생성 테이블을 사용




}
