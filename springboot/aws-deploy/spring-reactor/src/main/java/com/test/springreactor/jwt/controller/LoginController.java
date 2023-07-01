package com.test.springreactor.jwt.controller;

import com.test.springreactor.jwt.domain.JwtResponse;
import com.test.springreactor.jwt.domain.LoginRequest;
import com.test.springreactor.jwt.util.JwtUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProviderManager providerManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.createToken(loginRequest.getUserName());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @GetMapping("/login2")
    public String login2() {
        return "login";
    }

    @PostMapping("/login2")
    public String doLogin(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        // 사용자 아이디와 비밀번호를 검증하는 로직
        if("user".equals(userName)) {
            // 인증 성공 시 세션에 사용자 정보를 저장
            session.setAttribute("userName", userName);
            return "redirect:/home";
        } else {
            // 인증 실패 시 로그인 화면으로 이동
            return "redirect:/login";
        }
    }

}
