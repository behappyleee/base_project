package com.study.jwt.service

import com.study.jwt.entity.Authority
import com.study.jwt.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

// CustomUserDetailsService 를 Implements 를 하고 UserRepository 를 주입 받음, loadUserByUsername 메서드를 오버라이드를 함
@Component("userDetailsService")
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    // Login 시에 DB 에서 유저 정보와 권한 정보를 가져오게 됨, 해당 정보를 기반으로 UserDetail.User 객체를 생성하여 Return 하게 됨
    @Transactional
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findOneWithAuthoritiesByUsername(username)
            .map { user: com.study.jwt.entity.User -> createUser(username, user) }
            .orElseThrow { UsernameNotFoundException("$username -> 데이터베이스에서 찾을 수 없습니다.") }
    }

    private fun createUser(username: String, user: com.study.jwt.entity.User): User {
        if (!user.isActivated) {
            throw RuntimeException("$username -> 활성화되어 있지 않습니다.")
        }

        val grantedAuthorities = user.authorities.stream()
            .map { authority: Authority -> SimpleGrantedAuthority(authority.authorityName) }
            .collect(Collectors.toList())

        return User(
            user.username,
            user.password,
            grantedAuthorities
        )
    }
}