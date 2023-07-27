package com.sample.data.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class User {

    // ex) 한 유저는 한 개의 블로그만 만들 수 있는 블로그 서비스가 있다고 가정 한다면 유저와 블로그는 1:1 관계
    // 유저 엔티티 입장에서 블로그의 @Id 를 외래 키로 가져서 블로그를 참조할 수 있고
    // 그 반대 경우인 블로그가 외래키를 가져서 유저를 참조 하는 것도 가능
    // 여기서 외래 키를 갖고 있는 테이블을 주 테이블이라고 함


    public static void main(String[] args) {

        DataTest dt = new DataTest(1L, "TEST", DataEnumTest.MALE);

    }

}

@Data
@Getter
@Setter
@AllArgsConstructor
class DataTest {

    private Long id;
    private String name;
    private DataEnumTest test;

}

@Getter
enum DataEnumTest {
      FEMALE("WOMAN")
    , MALE("MAN");

    private String text;

    DataEnumTest(String text) {
        this.text = text;
    }
}

