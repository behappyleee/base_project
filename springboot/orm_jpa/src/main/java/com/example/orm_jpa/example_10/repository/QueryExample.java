package com.example.orm_jpa.example_10.repository;

import jakarta.persistence.TypedQuery;

public class QueryExample {

    public static void main(String[] args) {

        // 1. 반환 타입 명확할 시 TypedQuery 를 사용
        // 반환 타입이 Member 라 타입이 명확
        // TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        // List<Member> resultList = query.getResultList();

        // 2. 반환 타입이 명확하지 않을 시 Query 를 사용
        // 반환 타입이 username, age String 과 int 이므로 반환 타입이 명확하지 않아 Query 객체를 사용
        // Query query = em.createQuery("SELECT m.username, m.age FROM Member m");
        // List resultList = query.getResultList();

        // 파라미터 바인딩
        // 1. 이름 기준 바인딩
        // 이름 앞에 : 콜론을 붙여주어 이름으로 구분할 수 있도록 설정
        //  List<Member> members = em.createQuery("SELECT m FROM Member m WHERE m.username=:username", Member.class)
        // query.setParameter("username", usernameParam).getResultList();

        // 2. 위치 기준 바인딩
        // 위치 기준 Positional Parameters 를 사용하려면 ? 다음에 위치 값을 지정해 주면 됨
        // List<Member> members = em.creat  eQuery("SELECT m FROM Member m WHERE m.username = ?1").setParameter(1, usernameParam).getResultList();


    }

}
