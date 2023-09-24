package com.example.orm_jpa.example_1.main;

import com.example.orm_jpa.example_1.domain.Member;
import jakarta.persistence.*;
import org.slf4j.Logger;

import java.util.List;

public class ExampleMain {

    // TODO
    // 해당 main 클래스 실행 시 에러 해결 하기 !!!
    // 16:21:23.227 [main] WARN org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator -- HHH000342: Could not obtain connection to query metadata
    //java.lang.IllegalStateException: Cannot get a connection as the driver manager is not properly initialized
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl.getConnection(DriverManagerConnectionProviderImpl.java:262)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:316)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:152)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:34)
    //	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:119)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:264)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:239)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
    //	at org.hibernate.engine.jdbc.internal.JdbcServicesImpl.configure(JdbcServicesImpl.java:45)
    //	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.configureService(StandardServiceRegistryImpl.java:125)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:248)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
    //	at org.hibernate.engine.jdbc.connections.internal.BasicConnectionCreator.convertSqlException(BasicConnectionCreator.java:121)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverConnectionCreator.makeConnection(DriverConnectionCreator.java:43)
    //	at org.hibernate.engine.jdbc.connections.internal.BasicConnectionCreator.createConnection(BasicConnectionCreator.java:61)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections.addConnections(DriverManagerConnectionProviderImpl.java:501)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections.<init>(DriverManagerConnectionProviderImpl.java:367)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections$Builder.build(DriverManagerConnectionProviderImpl.java:552)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl.buildPool(DriverManagerConnectionProviderImpl.java:105)
    //	at org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl.configure(DriverManagerConnectionProviderImpl.java:81)
    //	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.configureService(StandardServiceRegistryImpl.java:125)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:248)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.buildJdbcConnectionAccess(JdbcEnvironmentInitiator.java:283)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:150)
    //	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:34)
    //	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:119)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:264)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:239)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
    //	at org.hibernate.boot.model.relational.Database.<init>(Database.java:45)
    //	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:231)
    //	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:199)
    //	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:169)
    //	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1380)
    //	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1451)
    //	at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:55)
    //	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:80)
    //	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:55)
    //	at com.example.orm_jpa.example_1.main.ExampleMain.main(ExampleMain.java:27)
    //16:21:23.326 [main] WARN org.hibernate.engine.jdbc.spi.SqlExceptionHelper -- SQL Error: 90067, SQLState: 90067
    //16:21:23.328 [main] ERROR org.hibernate.engine.jdbc.spi.SqlExceptionHelper -- Connection is broken: "unexpected status 1213486160" [90067-214]
    //Exception in thread "main" org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment] due to: Error calling Driver#connect [Connection is broken: "unexpected status 1213486160" [90067-214]] [null]
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:277)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:239)
    //	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:216)
    //	at org.hibernate.boot.model.relational.Database.<init>(Database.java:45)
    //	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.getDatabase(InFlightMetadataCollectorImpl.java:231)
    //	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:199)
    //	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:169)
    //	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1380)
    //	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1451)
    //	at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:55)
    //	at jakarta.persistence.Persistence.createEntityManagerFactory(Persistence.java:80)


    // 코드는 크게 3 가지 부분
    // 1. 엔티티 매니저 설정
    // EntityManagerFactory 를 생성하여 JPA 를 사용할 수 있게 해줌, 엔티티 매니저 팩토리는 어플리케이션 전체에서 딱 한번만 생성이 되고 공유하여 사용하여야 함
    // EntityManager 를 사용하여 엔티티를 데이터 베이스에 등록/수정/삭제 조회 할 수 있다. 엔티티 매니저는 데이터 베이스 커넥션과 밀접한 관계가 있으므로 스레드 간에 공유를 하거나 재서용이 되면 안됨
    // EntityManager 는 내부에 데이터 베이스를 유지하면서 데이터 베이스와 통신을 함 따라서 어플리케이션 개발자는 엔티티 매니저를 가상의 데이터 베이스로 생각 할 수 있음

    // 2. 트랜잭션 관리
    // JPA 를 사용하면 항상 트랜잭션 안에서 데이터를 변경하여야 함, 트랜잭션 없이 데이터를 변경하면 예외가 발생 함

    // 3. 비즈니스 로직

    public static void main(String[] args) {
        // Entity Manager Factory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // Entity Manager 생성
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();     // 트랜잭션 시작
            logic(em);
            tx.commit();    // 트랜잭션 커밋

        } catch(Exception e) {
            tx.rollback();  // 예외가 발생하면 항상 트랜잭션은 롤백을 함
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        // ... 로직 실행 코드 ....
        String id= "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("테스트 네임");
        member.setAge(21);

        // Entity 를 저장하려면 EntityManager 에 persist() 메서드의 저장할 엔티티를 넘겨주면 됨

        // 등록
        em.persist(member);
            
        // 수정
        // 수정 부분을 보면 조금 이상하다 엔티티를 수정한 후에 내용을 반영 하려면 해당 값만 set 을 다시 해주면 된다.
        // JPA 는 어떤 엔티티가 변경 되었는 지 추적하느 기능이 있어 값만 set 을 다시 해주면 UPDATE 쿼리가 자동으로 실행이 된 다.
        member.setAge(22);

        // 한 건 조회
        // find() 메서드는 조회 할 엔티티 타입과 @id 로 데이터 베이스 테이블의 기본 키와 매핑 한 식별자 값으로 엔티티 하나를 조회 하는 가장 단순한 조회 메서드
        // SELECT * FROM Member WHERE id="id1"; 와 똑같음
        Member findMember = em.find(Member.class, id);
        System.out.println("[findMember username = " + member.getUsername() + ", age = " + member.getAge() + "]");

        // 모든 Member 목록 조회
        // JPA 를 사용 시 어플리케이션 개발자는 엔티티 객체를 중심으로 개발하고 데이터 베이스에 대한 처리는 JPA 에 맡겨야 한다.
        // 바로 앞에서 살펴 본 등록, 수정, 삭제 단순한 한 건 조회 예를 보면 SQL 을 전혀 사용하지 않는다. 문제는 검색 쿼리임
        // JPA 는 엔티티 객체를 중심으로 개발을 하므로 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색을 하여야 함

        // 하지만 테이블이 아닌 엔티티 객체를 대상으로 검색을 하기 위하여서는 데이터 베이스의 모든 데이틀 어플리케이션으로 불러와서  엔티티 객체로 변경한 다음
        // 검색하여야 하지만 이는 사실상 불가능하다. 어플리케이션이 필요한 데이터만 데이터 베이스에서 불러오려면 결국 검색 조건이 포함 된 SQL 을 사용하여야 함
        // JPA 는 SQL 을 추상화 한 JPQL 이라는 객체지향 쿼리 언어를 제공 함 JPQL 은 SQL 과 거의 문법이 유사
        // JPQL 과 SQL 가장 큰 차이점은 JPQL 은 엔티티 객체를 대상으로 쿼리 쉽게 클래스와 필드를 대상으로 쿼리 (JPQL 은 데이터 베이스 테이블을 전혀 알지 못 함)
        // SQL 은 데이터 베이스 테이블을 대상으로 쿼리
        
        // JPQL 은 대소문자를 명확하게 구분하지만 SQL 은 관례상 대소문자를 구별하지 않음
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);  // JPQL 은 FROM member 는 Entity 객체를 말하는 것임 Member 테이블이 아님
        List<Member> queryResult = query.getResultList();

        // 위에 JPQL 을 합쳐서 작성 시
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();

        System.out.println("[Member Size] : " + members.size());

        // 삭제
        em.remove(member);

    }


}
