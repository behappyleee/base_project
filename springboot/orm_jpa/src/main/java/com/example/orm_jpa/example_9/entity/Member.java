package com.example.orm_jpa.example_9.entity;

import com.example.orm_jpa.example_9.embeded.Address;
import com.example.orm_jpa.example_9.embeded.Period;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {

    // 가장 Entity 에서 기본 값 타임
    // Long / String / int

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    // 값 타입 Collection
    // 값 타입을 하나 이상 저장하려면 컬렉션에 보관하고 @ElementCollection, @CollectionTable 어노테이션을 사용하면 된다.
    @ElementCollection
    @CollectionTable(name="FAVORITE_FOODS"
        , joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoritedFodds = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS"
        , joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<Address>();

    // 임베디드 타입 (새로운 값 타입을 지정하여 사용이 가능, 이것은 JPA 임베디드 타입이라고 한다.)
    // 중요한 것은 직접 정의한 임베디드 타입도 int, String, 처럼 값 타입 이라는 점이다.

    // 회원이 상세한 데이터를 그대로 가지고 있는 것은 객체 지향적이지 않으며 응집력만 떨어뜨린다.
    // 회원 엔티티가 더욱 더 의미 있고 응집력이 있게 사용이 가능하다.
    // 새로 정의한 갑 타입들은 재 사용이 가능하고 응집도도 아주 높다.
    // 임베디드 타입은 엔티티의 값일 뿐이다. 따라서 값이 속한 엔티티의 테이블에 매핑 한다.임베디드 타입을 사용하기 전과 후에 매핑하는 테이블은 같다.
    // 임베디드  타입 덕분에 객체와 테이블을 아주 세밀하게 매핑하는 것이 가능하다.
    // 임베디드 컬럼 값이 null 이면 매핑한 컬럼 값도 모두 null 이다.

    // @Embeddable : 값 타입을 정의한 곳에 표시
    // @Embedded : 값을 사용 하는 곳에 표시

    @Embedded
    Period workPeriod;  // 근무 기간

    @Embedded
    Address address;    // 집 주소

    // @AttributeOverrides 는 엔티티에 설정을 하여야 한다.
    // @AttributeOverride 를 사용하여 Embedded 속성도 재정의 가 가능핟.
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY"))
            , @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET"))
            , @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
    })
    Address companyAddress;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

}
