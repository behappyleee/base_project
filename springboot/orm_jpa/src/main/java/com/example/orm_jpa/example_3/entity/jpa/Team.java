package com.example.orm_jpa.example_3.entity.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {

    // JPA 로 객체 연관 관계를 표현
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    // JPA는 Collection / Set / Map 같은 다양한 컬렉션을 지원

    // mappedBy 속성 사용 이유 !!!
    // mappedBy 속성은 양방향 매핑일 시 사용하는데 반대쪽 매핑의 필드 이름을 값으로 주면 됨
    // 테이블은 외래키 하나로 두 테이블의 연관관계를 관리하지만 엔티티를 단방향으로 매핑하면 참조를 하나만 사용 이 참조뢰 외래키를 관리
    // 엔티티를 양방향 연관 관계로 설정 시 객체의 참조는 둘인데 외래키는 하나이다.
    // 이러한 차이로 인하여 JPA 에서는 두 객체 연관 관계중 하나를 정해서 테이블의 외래키를 관리하여야 하는데 이것을 연관 관계 주인 (Owner) 이라 한다.
    // 연관 관계의 주인만이 데이터 베이스 연관 관계와 매핑 되고 외래 키를 관리 (등록, 수정, 삭제) 할 수 있으며 반면에 주인이 아닌 쪽은 읽기만 가능
    // 연관 관계 주인을 정하는 것은 mappedBy 속성을 사용 (주인은 mappedBy 속성을 사용하지 않음)

    // 연관관계의 주인을 선택한다는 것은 사실 외래 키 관리자를 선택하는 것
    // 연관 관계의 주인은 사실 외래키가 있는 곳 (Foreign Key 를 가지고 있는 곳이 연관 관계의 주인이 됨, 여기서는 회원 테이블이 외래키를 가지고 있음)
    // 보통 일대다 관계 및 다대일 관계에서 다쪽이 연관관계에 주인임 (일쪽은 연관 관계의 주인이 아닐때가 많음)
    // 주인의 반대편은 mappedBy 속성을 사용하여 지정을 해주고 주인의 반대편은 Read 만 가능함
    @OneToMany(mappedBy = "team")   // 주인이 아니면 mappedBy 속성을 사용 하여 속성의 값으로 연관 관계의 주인을 지정
    private List<Member> members = new ArrayList<Member>();

//    @OneToMany
//    private List <Member> members;  // 제네릭으로 타입 정보를 알 수 있음

//    @OneToMany(targetEntity = Member.class) // 제네릭 사용 안할 시
//    private List members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
