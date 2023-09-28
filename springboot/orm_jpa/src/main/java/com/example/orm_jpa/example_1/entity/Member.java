package com.example.orm_jpa.example_1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                 // 이 클래스를 테이블과 맵핑 한다고 JPA 에게 알려 줌 (@Entity 가 사용 된 클래스를 엔티티 클래스라고 함)
@Table(name="MEMBER")   // JPA 에서 제공하는 맵핑 어노테이션을 추가를 해 줌  (엔티티 클래스에 매핑할 테이블 정보를 알려 준다.) 이 어노테이션을 생략 시 클래스 이름을 테이블 이름으로 맵핑 함
public class Member {
    // JPA 를 사용하기 위하여서는 가장 먼저 회원 클래스와 회원 테이블을 맵핑하여야 함

    @Id     // 엔티티 클래스의 필드를 테이블의 기본 키 Primary Key 에 맵핑 (@Id 가 사용 된 필드를 식별자 라고 함)
    @Column(name = "ID")
    private String id;          // 아이디

    @Column(name = "NAME")  // 필드를 Column 에 맵핑 함 여기서는 name 속성을 사용하여 Member 엔티티의 username 필드를 Member 테이블에 name 컬럼에 매핑 함
    private String username;    // 이름

    // age 필드에는 매핑 어노테이션이 없음, 이렇게 맵핑 어노테이션을 생략 시 필드명을 사용하여 컬럼명으로 매핑함
    // 맵핑 정보가 없는 필드 (Table 과 기본적으로 Mapping 이 됨)
    private Integer age;        // 나이

    // Getter, Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
