package com.example.jpa_project.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by holyeye on 2014. 3. 11..
 */

// Entity 어노테이션은 필수 (Entity 만 어노테이션 사용 시 DB 와 연결 시 테이블 명은 클래스 명과 동일하게 설정 됨)
// 반면 @Table 어노테이션은 외부에서 호출하는 용도가 아닌 실제 DB 에 붙을 테이블명 어노테이션명 을 말함 (실제 table 명을 지정) @Table 어노테이션은 생략이 가능

@Entity // Entity 어노테이션은 데이터 베이스의 테이블과 일대일로 매칭하는 객체 단위이며 Entity 객체의 인스턴스 하나가 테이블에서 하나의 레코드 값을 의미
// JPA NamedQuery 는 어노테이션을 사용하여 쿼리를 직접 정의가 가능 (어노테이션으로 @NamedQuery 관리하는 방법과 XML 파일로 관리하는 방법이 있음)
// JPA Named 쿼리 처럼 애플리케이션 실행 시점에 문법 오류를 발견 할 수 있는 장점이 있다.
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
