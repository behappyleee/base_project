package com.test.springreactor.jwt.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtController {

    // 기존의 시스템에서는 서버 기반의 인증 방식을 사용하였지만 시트템의 규모가 커짐에 따라 서버 기반의 인증 방식은 한계점을 보임
    // 토큰 기반의 인증 방식이 등장, 현대 웹 서비스에서 API 를 이용한 웹 서비스를 개발 할 떄, 토큰 기반의 인증 방식이 등장

    // 기존의 인증 방식인 서버 기반의 인증 방식은 서버 측에서 사용자들의 정보를 기억하고 있어야 함, 사용자의 정보를 기억하기 위하여서는 세션을 유지하여야 함
    // 서버 인증 방식은 Stateful 한 구조이다.

    // 토큰 기반 인증 시스템은 인증 받은 사용자 들에게 토큰을 발급하고, 서버에 요청을 할 때 헤더에 토큰을 함께 보내도록
    // 하여 유효성 검사를 한다. 상태를 유지하지 않으므로 Stateless 한 구조를 갖는다.


    // JWT (Json Web Token) - JSON 포맷을 이용하여 사용자에 대한 속성을 저장하는 Claim 기반의 Web Token
    // JWT 는 토큰 자체를 정보로 사용하는 Self-Contained 방식으로 정를 안전하게 전달한다.
    // 주로 회원 인증이나 정보 전달에 사용 되는 JWT 를 사용

    // JWT 로직
    // 어플 실행 -> 로컬 스토리지에 값이 존재 -> 로컬 스토리지 값을 이용하여 로그인
    // 어플 실행 -> 로컬 스토리지에 값이 없음 -> 서버에서 JWT 발행 및 응답 헤더에 담아서 보냄 -> 모바일에서 JWT 를 로컬 스토리지와 static 변수에 저장
    // 로그인

    // JWT 를 static 변수에 저장하는 이유는 HTTP 통신을 할 떄 마다 JWT 를 헤더에 담아서 보내주어야 하는데
    // 이를 로컬 스토리지에서 계속 불러오면 오버헤드가 발생함

    // 실제 서비스 경우에는 로그아웃 시 사용했던 토큰을 blacklist 라는 DB 테이블에 넣어 해당 토큰의 접근을 막는다.

    // JWT 구조 - JWT 는 Header / Payload / Signature 3 부분으로 이루어짐 각 부분은 Base64Url 로 인코딩이 되어 있음

    // 생성 된 토큰 은 HTTP 통신 시 Authorization 이라는 key 와 value 로 사용
    // 일반적으로 value 에는 Bearer 이 앞에 붙는 다
    
    /*
        {
            "Authorization" : "Bearer {생성 된 토큰 값}",
        }
     */

    // 인증 된 사용자만 접근을 허용 할 /home 경로로 이동시킴
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "User Content . ";
    }

}
