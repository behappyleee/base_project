package com.example.jpa_project.domain;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class OrderSpec {

    // 명세를 정의하기 위하여서는 Specification 인터페이스를 구현하면 된다.
    // JPA Criteria 의 Root, CriteriaQuery, CriteriaBuilder 클래스가 모두 파라미터로 주어진다.

    // 명세 적용 (Specification 로 검색하는 기능을 사용하기 위하여서는 org.springframework.data.jpa.repository.JpaSpecificationExecutor 를 추가로 상속 받아야 한다.

    public static Specification<Order> memberNameLike(final String memberName) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root
                    , CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if(StringUtils.isEmpty(memberName)) return null;

                Join<Order, Member> m =
                        root.join("member", JoinType.INNER);    // 회원과 조인

                return criteriaBuilder.like(m.get("name")
                        , "%" + memberName + "%");
            }
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                if(orderStatus == null) return null;

                return criteriaBuilder.equal(root.get("status"), orderStatus);

            }
        };
    }

    public static Specification<Order> memberName(final String memberName) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root
                    , CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                if(ObjectUtils.isEmpty(memberName)) return null;
                    
                // 회원과 조인
                Join<Order, Member> m = root.join("member", JoinType.INNER);

                return  criteriaBuilder.equal(m.get("name"), memberName);
            }
        };
    }

    public static Specification<Order> isOrderStatus() {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query
                    , CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("status")
                        , OrderStatus.ORDER);
            }
        };
    }

}
