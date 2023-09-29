package com.example.orm_jpa.example_3;

import com.example.orm_jpa.example_3.entity.jpa.Member;
import com.example.orm_jpa.example_3.entity.jpa.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ExampleJpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        
        // JPA 에서 엔티티를 저장할 떄 연관된 모든 엔티티는 영속 상태이여야 함

        // 조회
        // 연관 관계가 있는 엔티티를 조회하는 방법은 크게 2가지
        // 1. 객체 그래프 탐색 (객체 연관관계를 사용한 조회)
        // 2. 객체지향 쿼리 사용 JPQL

        // 팀1 저장
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        em.persist(team1);

        // 회원1 저장
        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.setTeam(team1);
        em.persist(member1);

        // 회원2 저장
        Member member2 = new Member();
        member1.setId("member2");
        member1.setUsername("회원2");
        member1.setTeam(team1);
        em.persist(member2);

        // 객체 그래프 탐색으로 조회
        // 이처럼 객체를 통하여 연관 된 엔티티를 조회하는 것을 객체 그래프 탐색이라 함
        Member member = em.find(Member.class, "member1");
        Team team = member.getTeam();
        System.out.println("TEAM 이름 조회 : " + team.getName());

    }

    private static void updateRelation(EntityManager em) {
        // 새로운 팀 2
        Team team2 = new Team();
        team2.setId("team2");
        team2.setName("팀2");

        // 회원 1에 새로운 팀2 설정
        Member member = em.find(Member.class, "member1");
        // JPA 에는 update 같은것을이 없고 참조하는 대상만 변경하면 나머지는 JPA 가 자동으로 처리
        member.setTeam(team2);
    }

    private static void queryLogicJoin(EntityManager em) {
        // : 로 시작하는 것은 파라미터를 바인딩 하는 문법
        String jpql = "SELECT m FROM Member m JOIN m.team t WHERE t.name=:teamName";

        // Query 를 통하여 Member 들을 조회
        List <Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        // 모든 조회 한 멤버를 조회
        for(Member member : resultList) {
            System.out.println("[QUERY member username = ]" + member.getUsername());
        }

    }



}
