package com.example.jpa_project.repository;

import com.example.jpa_project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItemRepositoryQueryDsl extends JpaRepository<Item, Long>
        , QuerydslPredicateExecutor<Item> {





}
