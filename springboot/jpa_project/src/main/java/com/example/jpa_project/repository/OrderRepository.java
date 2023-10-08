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
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CustomOrderRepository {

    Order findOne(Long orderId);

    List<Order> findAll(OrderSearch orderSearch);

}
