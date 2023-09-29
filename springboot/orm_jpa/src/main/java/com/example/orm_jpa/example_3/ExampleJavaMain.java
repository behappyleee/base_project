package com.example.orm_jpa.example_3;

import com.example.orm_jpa.example_3.entity.java.Member;
import com.example.orm_jpa.example_3.entity.java.Team;

public class ExampleJavaMain {

    public static void main(String[] args) {

        // 생성자(id, 이름)
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team1 = new Team ("team1", "팀1");

        // JPA 사용 하지 않고 순수 자바 코드로 meber1 과 member2 를 team1 에 소속 시킴
        member1.setTeam(team1);
        member2.setTeam(team1);

    }

}
