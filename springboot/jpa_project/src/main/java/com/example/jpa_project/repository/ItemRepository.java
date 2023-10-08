package com.example.jpa_project.repository;

import com.example.jpa_project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 9:48
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findOne(Long itemid);

}
