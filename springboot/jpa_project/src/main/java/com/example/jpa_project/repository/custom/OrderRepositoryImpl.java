package com.example.jpa_project.repository.custom;

// import com.mysema.query.jpa.JPQLQuery;

import com.example.jpa_project.domain.Order;
import com.example.jpa_project.domain.OrderSearch;
//import com.example.jpa_project.domain.QMember;
//import com.example.jpa_project.domain.QOrder;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author holyeye
 */

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    // spring-data-jpa 는 2가지 방법으로 QueryDSL 을 적용한다.
    // org.springframework.data.querydsl.QueryDslPredicateExecutor
    // org.springframework.data.querydsl.QueryDslRepositorySupport
    @Override
    public List<Order> search(OrderSearch orderSearch) {
        // TODO
        // Error 해결 하기 !!

        return null;

//        QOrder order = QOrder.order;
//        QMember member = QMember.member;
//
//        JPQLQuery query = from(order);
//
//        if (StringUtils.hasText(orderSearch.getMemberName())) {
//            query.leftJoin(order.member, member)
//                    .where(member.name.contains(orderSearch.getMemberName()));
//        }
//
//        if (orderSearch.getOrderStatus() != null) {
//            query.where(order.status.eq(orderSearch.getOrderStatus()));
//        }
//
//        return query.list(order);
    }
}
