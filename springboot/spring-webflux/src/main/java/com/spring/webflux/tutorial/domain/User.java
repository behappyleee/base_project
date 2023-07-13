package com.spring.webflux.tutorial.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@EqualsAndHashCode(of= {"id", "name", "departmentf"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value="users")    // Document 어노테이션 사용 to mark it as a Mongo DB Entity
public class User {

    @Id
    private String id;
    private String name;
    private int age;
    private double salary;
    private String department;

}
