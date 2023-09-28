package com.example.orm_jpa;

import com.example.orm_jpa.example_1.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

public class DetachTest {

    // Detach 가 엔티티 하나만 준영속 상태로 만들었다면 clear() 는 모든 영속성 컨텍스트를 초기화 한다.

    @Test
    public void detachTest() {
        // Entity Manager Factory 생성 (생성 비용이 아주 비싸다.)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // Entity Manager 생성 (생성 비용이 거의 안든다.)
        EntityManager em = emf.createEntityManager();

        // 회원 엔티티 생성, 비영속 상태
        Member member = new Member();
        member.setId("memberA");
        member.setUsername("회원A");

        Member member2 = new Member();
        member2.setId("memberB");
        member2.setUsername("회원B");

        // 회원 엔티티 영속 상태
        em.persist(member);
        em.persist(member2);

        // 회원 엔티티를 영속성 컨텍스트에 분리, 준영속 상태
        em.detach(member);

        // 트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();     // 트랜잭션 시작
            tx.commit();    // 트랜잭션 커밋 (해당 commit() 에서 실제로 INSERT 쿼리 가 작동을 함)
        } catch(Exception e) {}
        }

}
