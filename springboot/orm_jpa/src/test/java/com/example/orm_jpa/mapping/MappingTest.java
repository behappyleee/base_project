package com.example.orm_jpa.mapping;



import com.example.orm_jpa.example_3.entity.jpa.Member;
import com.example.orm_jpa.example_3.entity.jpa.Team;
import org.junit.jupiter.api.Test;

public class MappingTest {

    @Test
    public void mappingTest() {
        // 양방향 테스트
        // 양방향 연관관계를 설정 시 가장 흔하게 하는 실수는 연관 관계의 주인에는 값을 입력 하지 않고
        // 주인이 아닌 곳에만 입력을 하는 것이다. (가장 흔하게 하는 실수)

        Member member1 = new Member();
        member1.setId("member1");

        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        
        // 이렇게 연관 관계의 주인이 아닌 곳에만 값을 입력 흔하게 하는 실수
        team1.getMembers().add(member1);


    }


}
