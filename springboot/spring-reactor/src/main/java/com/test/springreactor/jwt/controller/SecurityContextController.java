package com.test.springreactor.jwt.controller;

import com.test.springreactor.jwt.service.SecurityContextService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityContextController {

    Logger logger = LoggerFactory.getLogger(SecurityContextController.class);

    // RequestContextHolder 는 Spring 에서 전역적으로 Request 에 대한 정보를 가져오자고 할 떄
    // 사용하는 유틸성 클래스

    // 주로 Business Layer 등에서 Request 객체를 참고하려고 할 떄 사용
    // HttpRequest 가 오는 시점에 생성 및 초기화가 되어지고 Business Layer를 거친 뒤 Servlet 이 destroy 될 떄 clean 이 된다.

    final SecurityContextService securityContextService;

    @GetMapping("/securityTest")
    public String securityTest(HttpServletRequest request) {
        final String test = securityContextService.securityTest(request);
        return "SECURITY_TEST";
    }


}
