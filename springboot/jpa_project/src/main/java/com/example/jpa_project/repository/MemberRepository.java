package com.example.jpa_project.repository;

import com.example.jpa_project.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:08
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    // spring-data-jpa 는 쿼리 메서드에 의하여 페이징과 정렬 기능을 사용할 수 있도록 2가지 특별한 파라미터를 제공
    // org.springframework.data.domain.Sort (정렬 기능)
    // org.springframework.data.domain.Pageable (페이징 기능 내부에 sort 포함) Pageable 사용 시 타입으로 List 나 (org.springframework.data.domain.Page) 반환

    List<Member> findByName(String name);

    Member findOne(Long memberId);

    // Paging 사용 (count 쿼리 사용)
    Page<Member> findByName(String name, Pageable pageable);

    // Paging 사용 (count 쿼리 사용 안 함)
    // List<Member> findByName(String name, Pageable pageable);

    // 스프링 데이터 JPA 는 도메인 클래스.메서드이름 으로 쿼리를 찾아서 실행 함
    // Member 엔티티에서 정의한 @NamedQuery 를 사용 (Parameter 로 username 을 넘겨줌)
    List<Member> findByUsername(@Param("username") String username);

    // Repository 에 직접 명시 하는 방법 @Query 어노테이션을 통하여 Repository 에 직접 명시
    // @Query("SELECT m FROM Member m where m.address= :address") // Parameter Name 기반 (사용하도록 권장)
    @Query("SELECT m FROM Member m where m.address = ?1") // Parameter 위치 기반 (기본값은 위치 기반으로 작동)
    List<Member> findByAddress(String address);

    // Spring data JPA 를 활용한 벌크성 JPA Update 쿼리 (spring-data-jpa 에서 bulk 성 수정/삭제 쿼리는 @Modifying 어노테이션을 사용)
    @Modifying(clearAutomatically = true) // clearAutomatically = true 해당 옵션값을 주면 벌크성 쿼리를 수정하고 나서 영속성 컨텍스트를 초기화
    @Query("UPDATE Member m SET m.address = m.address")
    int bulkModifyAddress(@Param("address") String address);

    // spring-data-jpa 는 유연한 반환 타입을 지원, 결과가 한 건 이상이면 컬렉션 인터페이스를 사용 단건 이면 반환 타입을 지정하여 사용

}
