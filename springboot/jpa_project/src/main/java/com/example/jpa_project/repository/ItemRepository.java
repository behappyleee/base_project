package com.example.jpa_project.repository;

import com.example.jpa_project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오후 9:48
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    // TODO
    // 실행 시 해당 Entity 때문에 compile 이 안 됨 확인이 필요 !!!
    // abstract class 여서 compile 시 에러가 발생
    // ItemRepository 에서 findByOne 타입이 반환이 안 됨 !! (확인 필요 !!!)

    // 참고로 단건으로 지정 한 메서드를 호출하면 spring-data-jpa 는 내부에서 JPQL Query.getStringResult() 메서드를 호출 함
    // 이 메서드를 호출 시 조회 결과가 없으면 NoResultException 에러가 발생 함, 2건 이상이면 NonUniqueResultException 에러가 발생
    // 개발자 입장에서는 다루기 상당히 불편 하므로 spring-data-jpa 는 단건을 조회 할 때 이 예외가 발생하면 예외를 무시하고 대신에 null 을 반환
    // Item findOne(Long itemId);

    Item findByOne(Long itemId);

}
