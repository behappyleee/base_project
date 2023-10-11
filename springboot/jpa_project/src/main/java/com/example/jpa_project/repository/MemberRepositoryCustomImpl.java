package com.example.jpa_project.repository;

import com.example.jpa_project.domain.Member;

import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    // 이때 클래스 이름을 짓는 규칙이 있는 데 (Repository Interface 이름 + Impl) 로 클래스 이름을 명명하여야 한다.
    // -> 이렇게 명명하면 JPA가 사용자 정의 구현 클래스로 인식을 한다.

    // 3. Interface 를 구현한 Class 에서 해당 Method 를 구현
    @Override
    public List<Member> findMemberCustom() {
        // 사용자 정의 구현 ....

        return null;
    }

}
