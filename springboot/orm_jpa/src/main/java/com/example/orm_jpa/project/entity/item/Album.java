package com.example.orm_jpa.project.entity.item;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("A")    // 구분 컬럼 DTYPE 에 들어갈 값
public class Album extends Item {

    private String artist;
    private String etc;

}
