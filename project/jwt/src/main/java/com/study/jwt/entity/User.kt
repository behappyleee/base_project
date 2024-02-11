package com.study.jwt.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

// Kotlin 에서 JPA 사용하기 위하여서는 kotlin.plugin.jpa plugin 추가가 필요 !
// Springboot 시작 시 resource 밑에 data.sql 이 자동실행이 됨 !
@Entity
@Table(name = "users")
data class User (
    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long,

    @Column(name = "username", length = 50, unique = true)
    val username: String,

    @JsonIgnore
    @Column(name = "password", length = 100)
    val password: String,

    @Column(name = "nickname", length = 50)
    val nickname: String,

    @JsonIgnore
    @Column(name = "activated")
    val isActivated: Boolean,

    // ManyToMany Join 테이블 어노테이션은 회원 객체와 권한 객체를 1:다 다:1 관계를 서로 맵핑
    @ManyToMany
    @JoinTable(
        name = "user_authority",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "user_id")],
        inverseJoinColumns = [JoinColumn(name="authority_name", referencedColumnName = "authority_name")]
    ) val authorities: Set<Authority>
)

