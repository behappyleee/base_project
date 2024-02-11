package com.study.jwt.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JwtController {

    // Jwt 는 RFC 7519 웹 표준으로 지정이 되어있고
    // JSON 객체를 사용하여 토큰 객체 정보들을 저장하고 있는 Web Token
    // 특히 JWT 를 이용하는 방식은 헤비하지 않고 아주 간편하고 쉽게 적용이 가능하여 사이드 프로젝트에 적합
    // JWT - Header / Payload / Signature 로 구성이 되어 있음,
    // Header - Signature 를 Hashing 하기 위한 정보
    // Payload - 서버와 클라이언트가 주고 받는 시스템에서 실제로 사용 될 정보에 대한 내용을 담고 있음
    // Signature - 토큰의 유효성 검증을 위한 문자열
    // JWT 장점 - 중앙의 인증 서버, 데이터 스토어에 대한 의존성 없음, 시스템 수평 확장 유리
    @RequestMapping("/jwt/test")
    fun testJwt(): String {
        return "Hello This is Jwt Controller !"
    }

}


fun main() {

        println("TEST KOTLIN !!")
}