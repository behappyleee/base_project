package com.example.orm_jpa.mapping;

import com.example.orm_jpa.example_5.entity.jpa.Member;
import com.example.orm_jpa.example_5.entity.jpa.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class TwoWayMappingTest {

    // JPA 를 이용한 양방향 테스트 코드
    @Test
    public void twoWayMappingTest() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

        // 팀1, 회원1 저장
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        em.persist(team1);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 양방향 연관 관계 설정 (이렇게 설정 시 양방향 연관 관계로 설정이 가능)
        member1.setTeam(team1);     // 연관 관계의 주인
        
        // 해당 방식처럼 설정 시 양방향 연관 관계에서 실수 발생 가능성이 있으 Member 클래스이 setTeam 할 시 아예 연관 관계설정으로 해 버림
        // team1.getMembers().add(member1);    // 연관 관계의 주인이 아니다. 저장 시 사용이 되지 않음

        // Member.team -> 연관 관계의 주인, 이 값으로 외래키를 관리
        // Team.members -> 연관 관계의 주인이 아님, 저장 시 사용되지 않음

    }


}
