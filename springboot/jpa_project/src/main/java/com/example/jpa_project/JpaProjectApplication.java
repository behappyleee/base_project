package com.example.jpa_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaProjectApplication {

    // TODO
    // 564 페이지 학습 필요 !!!!!!!!!
    // jpa-shop 변환 하기 !!!!
    // TODO
    // 학습 필요 !!!


    // spring-data-jpa 도 동작 가능하도록 변경 하기 !!
    // spring-data-jpa 는 스프링 프레임워크에서 JPA 를 편리하게 사용할 수 있도록 지원하는 프로젝트이다.
    // 해당 프로젝트는 데이터 접근 계층을 개발할 떄 지루하게 반복 되는 CRUD 문제를 세련 된 방법으로 해결
    // 데이터 접근 계층을 개발할 때 구현 클래스 없이 인터페이스만 작성해도 개발을 완료가 가능

    // 일반적으로 CRUD 메서드는  JpaRepository 가 제공하므로 큰 문제가 없다.
    // 쿼리 Method 기능 QueryMethod 기능은 spring-data-jpa 가 제공해주는 마법같은 기능이다. 대표적으로는 메서드 이름만으로 쿼리를 생성하는
    // 기능이 있는 데 인터페이스에 메서드만 선언하면 해당 메소드의 이름으로 적절한 JPQL 을 생성해서 실행 된다.
    // Query Method 기능
    // 1. 메서드 이름으로 쿼리 생성
    // 2. 메서드 이름으로 JPA NamedQuery 호출
    // 3. @Query 어노테이션을 사용해서 리포지토리 인터페이스에 쿼리를 직접 정의

    // TODO
    // spring-data-jpa 도 동작 가능하도록 구현 하기 !!!
    // spring-data-jpa 에서 제공하는 공통 인터페이스는 org.springframework.data.jpa.repository.support.SimpleJpaRepository 이다

    // @Repository ===> JPA 예외를 스프링이 추상화한 예외로 변환을 함
    // @Transactional 트랜잭션 적용 ===> JPA 의 모든 변경은 트랜잭션 안에서 이루어져야 한다. 스프링 데이터 JPA 가 제공하는 공통 인터페이스를 사용 시
    // 데이터를 변경 (등록,수정,삭제) 하는 메서드리 @Transactional 트랜잭션 처리가 되어 있다. 따라서 서비스 계층에서 트랜잭션을 시작하지 않으면
    // Repository 에서 트랜잭션을 시작한다.

    // @Transactional(readonly=true) ===> 데이터를 조회하는 메서드에는 readOnly => true 옵션이 적용되어 있음, 데이터를 변경하지 않는
    // 트랜잭션에서 readOnly = true 옵션을 사용하면 플러시를 생략하여 약간의 성능을 얻을 수 있다.

    // save() 메서드 : 이 메서드는 저장할 엔티티가 새로운 엔티티면 저장 (persist) 하고 이미 있는 엔티티면 병합을 한다.

    // TODO ====>  564 페이지 학습 필요 !!!!!! 564 페이지 학습 필요 ~~ !!!!!

    // JPA 프로젝트 기능 목록
    // Entity 정리

    // 회원 기능
    // 1. 회원 등록
    // 2. 회원 조회

    // 상품 기능
    // 1. 상품 등록
    // 2. 상품 수정
    // 3. 상품 조회

    // 주문 기능
    // 1. 상품 주문
    // 2. 주문 내역 조회
    // 3. 주문 취소

    // 기타 요구 사항
    // 1. 상품의 종류는 도서,음반,영화가 있다
    // 2. 삼품을 카테고리 별 로 구분할 수 있다.
    // 3. 상품 주문 시 배송 정보를 입력할 수 있다.

    public static void main(String[] args) {
        SpringApplication.run(JpaProjectApplication.class, args);
    }

}
