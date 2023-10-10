package com.example.jpa_project.repository;

import com.example.jpa_project.domain.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    // spring-data-jpa 를 이용하여 Repository 를 구현하면 인터페이스만 정의를 하고 구현체는 만들지 않는다.
    // 하지만 다양한 이유로 Repository 를 직접 구현해야 할 때도 있다.
    // 그렇다고 Repository 를 직접 구현하면 공통 인터페이스가 제공하는 기능까지 모두 구현 하여야 한다.
    // spring-data-jpa 는 이런 문제를 우회하여 필요한 메서드만 구현할 수 있는 방법을 제공

    // 1. Interface 이름은 자유롭게 명명 (MemberRepositoryCustom 으로 명명)

    // 2. Class 를 생성하여 인터페이스를 구현

    public List<Member> findMemberCustom();

}
