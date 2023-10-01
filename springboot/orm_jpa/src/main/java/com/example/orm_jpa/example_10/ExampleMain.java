package com.example.orm_jpa.example_10;

public class ExampleMain {

    // JPQL - JPA 는 복잡한 검색 조건을 사용하여 엔티티 객체를 조회할 수 있는 다양한 쿼리 기술을 지원
    // JPQL 은 가장 중요한 객체지향 쿼리 언어이다. Criteria 나 QueryDSL 도 결국 JPQL 을 편리하게 사용하도록 도와주는 기술이다.
    // JPQL 은 필수적으로 학습을 해야한다.

    // SQL 은 데이터 베이스 테이블을 대상으로 하는 데이터 중심의 쿼리라면 JPQL 은 엔티티 객체를 대상으로 하는 쿼리이다.
    // JPQL 은 SQL 보다 훨씬 간편하다.

    public static void main(String[] args) {
        // JPQL - Java Persistence Query Language (엔티티 객체를 조회하는 객체지향 쿼리)

        // JPA 에서 공식 지원 기능
        // 1. Criteria Query - JPQL 을 편하게 작성하도록 도와주는 API, 빌더 클래스 모음
        // 2. Native SQL - JPA 에서 JPQL 대신 직접 SQL 을 사용할 수 있음
        // 3. JPQL
        
        // JPA 가 공식 지원은 아님
        // 1. QueryDSL
        // 2. JDBC 직접 사용. Mybatis 같은 SQL 매퍼 프레임 워크 사용

        // QUERY ex
        // 1. JPQL 사용
        // String jpql = "SELECT m from Member as m WHERE m.username='kim'";
        // List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();

        // 2. Criteria 사용
        // Criteria 의 장점은 문자가 아닌 코드로 JPQL 을 작성할 수 있다는 점이다. (컴파일 시점에 오류 파악을 할 수 있다.)

        // 루트 클래스 (조회를 시작할 클래스)
        // Root<Member> m = query.from(Member.class);

        // 쿼리 생성 (문자가 아닌 코드로 쿼리를 작성)
        // CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
        // List<Member> resultList = em.createQuery(cq).getResultList();

//        3. QueryDSL 사용
//        QueryDSL 도 Criteria 처럼 JPQL 빌더 역할을 한다. QueryDSL 장점은 코드 기반이면서 단순하고 사용하기 쉽다.
//        QueryDSL 도 어노테이션 프로세서를 사용해서 쿼리 전용 클래스를 만들어야 한다. QMember Member 엔티티 클래스를 기반으로 생성한 QueryDSL 쿼리 전용 클래스이다.
//        JPAQuery query = new JPAQuery(em);
//        QMember member = QMember.member;
//        List<Member> members = query.from(member).where(member.username.eq("kim"))
//                .list(member);

        // 4. Native SQL 사용
        // JPA 는 SQL 을 직접 사용할 수 있는 기능을 지원
        // em.createNativeQuery() 메서드를 사용하면 직접 작성한 SQL 을 데이터 베이스에 전달한다.
        // String sql = "SELECT ID, AGE, TEAM_ID, NAME FROM Member WHERE NAME = 'kim";
        // List<Member> resultList = em.createNativeQuery(sql, Member.class).getResultList();



    }

}
