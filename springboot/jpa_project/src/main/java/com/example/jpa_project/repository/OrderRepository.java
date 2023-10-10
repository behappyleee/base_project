package com.example.jpa_project.repository;

import com.example.jpa_project.domain.OrderSearch;
import com.example.jpa_project.repository.custom.CustomOrderRepository;
import com.example.jpa_project.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 10:28
 */

// 책 DDD (Domain Driven Development) 에서는 명세 SPECIFICATION 이라는 개념을 소개하는데 spring-data-jpa 는 Criteria 로 이 개념을 사용 할 수 있도록 설정
// SPECIFICATION 을 이해하기 위한 핵심 단어는 술어 predicate 인데 이것은 단순히 참이나 거짓으로 평가된다.
// 이것은 AND OR 같은 연산자로 조합도 가능하다. 예를 들어 데이터를 검색하기 위한 제약 조건 하나하나를 술어라 할 수 있다.
// spring-data-jpa 는 org.springframework.data.jpa.domain.Specification 으로 정의하였다. (다양한 검색조건을 조립해서 새로운 검색조건을 쉽게 만들 수 있다.)
// 명세 기능을 사용하기 위하여서는 JpaSpecificationExecutor 인터페이스를 상속받으면 된다.
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CustomOrderRepository {

    Order findOne(Long orderId);

    List<Order> findAll(OrderSearch orderSearch);

}
