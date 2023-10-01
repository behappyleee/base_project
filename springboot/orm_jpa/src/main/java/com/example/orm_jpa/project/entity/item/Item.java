package com.example.orm_jpa.project.entity.item;

import com.example.orm_jpa.project.entity.Category;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
// 상속 관계를 매핑하기 위하여 부모 클래스인 Item 에 @Inheritance 어노테이션을 사용
// strategy 속성에 SINGLE_TABLE 전략을 사용하여 단일 테이블 전략을 선택 함, 단일 테이블 전략은 구분 컬럼을 필수로 선택하여야 함
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")    // DTYPE 이라는 구분 컬럼으로 사용할 이름을 지정하여 줌
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;            // 이름
    private int price;              // 가격
    private int stockQuantity;      // 재고 수량

    // 다대다 관계는 연결 테이블을 JPA 가 알아서 처리해주어서 편리하지만 연결 테이블에 필드가 추가 되면은 더는 사용할 수 없으므로 실무에서는 활용하기가
    // 무리가 있다. 따라서 CategoryItem 이라는 연결 엔티티를 만들어서 일대다, 다대일 관계로 매핑하여 사용 하는 것을 권장한다.
    @ManyToMany(mappedBy = "ITEMS")
    private List<Category> categories = new ArrayList<Category>();

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

}
