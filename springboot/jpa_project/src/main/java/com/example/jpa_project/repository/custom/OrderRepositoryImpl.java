package com.example.jpa_project.repository.custom;

import com.mysema.query.jpa.JPQLQuery;

import com.example.jpa_project.domain.Order;
import com.example.jpa_project.domain.OrderSearch;
import com.example.jpa_project.domain.QMember;
import com.example.jpa_project.domain.QOrder;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author holyeye
 */

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {

    // TODO
    // spring-data-jpa 도 동작 가능하도록 구현 하기 !!!

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> search(OrderSearch orderSearch) {
        QOrder order = QOrder.order;
        QMember member = QMember.member;


        JPQLQuery query = from(order);

        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.leftJoin(order.member, member)
                    .where(member.name.contains(orderSearch.getMemberName()));
        }

        if (orderSearch.getOrderStatus() != null) {
            query.where(order.status.eq(orderSearch.getOrderStatus()));
        }

        return query.list(order);
    }
}
