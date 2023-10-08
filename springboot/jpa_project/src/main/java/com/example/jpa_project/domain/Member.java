package com.example.jpa_project.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by holyeye on 2014. 3. 11..
 */

@Entity
// JPA NamedQuery 는 어노테이션을 사용하여 쿼리를 직접 정의가 가능
@NamedQuery(name = "Member.findByUsername", query = "SELECT m FROM Member m WHERE m.name= :username")
public class Member {

    // 테이블의 기본 키 컬럼 이름은 해당 테이블 이름을 포함하도록 설계
    // 테이블의 기본 키 이름은 MEMBER_ID 이런 식으로 네이밍을 하였으며
    // 엔티티 식별자 자체의 ID 는 ID 로 사용할 수 있도록 하였다.

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
