package com.example.orm_jpa.sample.domain;

public abstract class Item {

    // 객체와 데이터 베이스느 서로 지향하는 패러다임이 불일치 하여 상속 관계에 있는 객체를
    // 데이터 베이스에 저장하기는 매우 까다롭다.

    // 객체 모델 코드
    Long id;
    String name;
    int price;

}

class Album extends Item {
    String artist;
}

class Movie extends Item {
    String director;
    String actor;
}

class Book extends Item {
    String author;
    String isbn;
}
