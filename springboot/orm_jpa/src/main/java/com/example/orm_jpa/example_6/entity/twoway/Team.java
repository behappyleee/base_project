package com.example.orm_jpa.example_6.entity.twoway;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Team {

    // Team 과 Member 모두 서로 참조 할 수 있는 필드 값이 존재 하므로 Team 과 Member 는 양방향 관계
    // 양방향은 항상 외래키가 있는 곳이 주인임 (주인이 아닌 곳은 mappedBy 속성을 사용하여 표시를 해 줌)

    // 일대다 (1 : N) 관계는 Collection / List / Set / Map / 중에 하나를 사용 하여야 함 !

    // 하나의 팀은 여러 회원을 참조가 가능 이러한 관계를 일대다 관계라고 함 (일대다 1:N 단방향 관계는 JPA 2.0 관계 부터 지원)

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    @JoinColumn(name = "MEMBER_ID")
    private List <Member> members = new ArrayList<Member>();

    public void addMembers(Member member) {
        this.members.add(member);
        if(member.getTeam() != this) {  // 무한 루프에 빠지지 않도록 체크
            member.setTeam(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
