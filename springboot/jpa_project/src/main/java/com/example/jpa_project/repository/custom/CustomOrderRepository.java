package com.example.jpa_project.repository.custom;

import com.example.jpa_project.domain.Order;
import com.example.jpa_project.domain.OrderSearch;

import java.util.List;

/**
 * @author holyeye
 */
public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);

}
