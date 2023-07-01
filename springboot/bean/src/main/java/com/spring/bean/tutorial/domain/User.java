package com.spring.bean.tutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 기본 User 정보
    private String name;
    private String email;
    private int age;
    private int phone;

}
